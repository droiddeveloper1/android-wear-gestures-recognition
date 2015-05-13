/*
 * Copyright (c) 2014-2015, Oke Uwechue. All Rights Reserved.
 *
 * This file is part of Android Wear Gesture Recognizer.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dmt.gestureproject_1;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.orsoncharts.android.Chart3D;
import com.orsoncharts.android.Chart3DFactory;
import com.orsoncharts.android.ChartSurfaceView;
import com.orsoncharts.android.data.xyz.XYZSeries;
import com.orsoncharts.android.data.xyz.XYZSeriesCollection;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainActivityMobile extends Activity
{
    IntentFilter mesgFilter = new IntentFilter();
    BroadcastReceiver updateUIReceiver;
    private MediaPlayer mp=null;

    private final double RESCALER = 6.0;
    private final int NUM_DESCRIPTORS = 8;

    private XYZSeriesCollection dataCollection = new XYZSeriesCollection();
    private XYZSeriesCollection dataCollection2D = new XYZSeriesCollection();
    private Chart3D scatterPlot = null, scatterPlot2D = null;
    private List<Coord3D> data3D= new ArrayList<Coord3D>();
    private List<Coord2D> data2D= new ArrayList<Coord2D>();
    private boolean toggler = false;
    private ChartSurfaceView chartPane = null;
    private Button shapeAnalyzerBtn = null;
    private boolean firstTime = true;
    int count =0;
    private String outputFileName = "unselectedShape.txt";

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            shapeAnalyzerBtn = (Button)findViewById(R.id.btnShapeEllipticFourier);
            chartPane = (ChartSurfaceView)findViewById(R.id.chartView);

            chartPane.setVisibility(View.GONE);
            shapeAnalyzerBtn.setVisibility(View.GONE);

            mesgFilter.addAction("sensordata_transmission");

            mp = MediaPlayer.create(this, R.raw.bleep1);

            updateUIReceiver = new BroadcastReceiver() {

                @Override
                public void onReceive(Context context, Intent intent) {
                    if(intent.getStringExtra(ListenerServiceFromWear.INITIALIZATION)!=null) {
                        mp.start();       // audio click to indicate start of measurements
                        dataCollection = new XYZSeriesCollection();
                        count=0;
                    }
                    else {
                        data3D = intent.getParcelableArrayListExtra("vectors");
                        renderScatterPlot3D(data3D);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // hide the EFD button
                                shapeAnalyzerBtn.setVisibility(View.GONE);
                            }
                        });

                    }
                }
            };

            registerReceiver(updateUIReceiver, mesgFilter);

        }

    /**
     * Compute shape descriptors for sub-dimensioned scatter plot shape (via elliptic fourier analysis), and print out numeric results
     * @param v
     */
    public void doEllipticFourierShapeAnalysis(View v)
    {
        List<List<Double>> harmonics = displayEllipticFourierDescriptor(data2D);
        classifyShape(harmonics);
    }


    /**
     * Compute Elliptic Fourier(EF) descriptors for the current shape
     *
     * @param points    set of points in 2D space
     *
     * @return list of 4-tuples each representing one level of EF descriptor harmonic
     */
    private List<List<Double>> displayEllipticFourierDescriptor(List<Coord2D> points)
    {
        List<List<Double>> harmonics = new ArrayList<List<Double>>();
        List<Double> harmonic = null;

        int extent = points.size();
        double[] x = new double[extent];
        double[] y = new double[extent];

        for(int idx = 0; idx < extent; idx++){
            x[idx] = points.get(idx).getA();
            y[idx] = points.get(idx).getB();
        }

        EllipticFourierDesc efd = new EllipticFourierDesc(x,y,NUM_DESCRIPTORS);
        StringBuilder buff = new StringBuilder();
        for(int idx = 0; idx < NUM_DESCRIPTORS; idx++)
        {
            buff.append(efd.efd_ax[idx] + ",");
            buff.append(efd.efd_ay[idx] + ",");
            buff.append(efd.efd_bx[idx] + ",");
            buff.append(efd.efd_by[idx] + "\n");

            // cache this harmonic
            harmonic = new ArrayList<Double>(Arrays.asList(efd.efd_ax[idx],
                                                           efd.efd_ay[idx],
                                                           efd.efd_bx[idx],
                                                           efd.efd_by[idx]));
            harmonics.add(harmonic);
        }

        // Toast.makeText(this,buff.toString(),Toast.LENGTH_SHORT).show();      // --uncomment this if you want to display the set of 8 Elliptic Fourier descriptors

        writeToFile("\nVEE:\n"+buff.toString(), outputFileName);   // comment this out if you don't need to write the EFD data to external storage

        return(harmonics);

    }

    private void classifyShape(List<List<Double>> descriptors)
    {
        final CopyOnWriteArrayList<EllipticFourierDistanceMeasure.Distance> combinedMetricsConcurrent = new CopyOnWriteArrayList<EllipticFourierDistanceMeasure.Distance>();

        try {

            final List<List<Double>> descriptorsForThread = descriptors;
            int MAX_CONCURRENT = 5;
            ExecutorService executor = Executors.newFixedThreadPool(MAX_CONCURRENT);
            Callable<Void> callableCircle = new Callable<Void>() {
                @Override
                public Void call()
                {
                    try {
                        EllipticFourierDistanceMeasure comparator_circle = new EllipticFourierDistanceMeasure(descriptorsForThread, Constants.SHAPE_TYPE.CIRCLE);
                        final List<EllipticFourierDistanceMeasure.Distance> distanceToCircle = comparator_circle.computeDistanceMetric();
                        combinedMetricsConcurrent.addAll(distanceToCircle);

                    }catch(Exception ex)
                    {
                        // @ToDo --
                    }

                    return(null);
                }
            };
            Callable<Void> callableSquare = new Callable<Void>() {
                @Override
                public Void call()
                {
                    try {
                        EllipticFourierDistanceMeasure comparator_square = new EllipticFourierDistanceMeasure(descriptorsForThread, Constants.SHAPE_TYPE.SQUARE);
                        final List<EllipticFourierDistanceMeasure.Distance> distanceToSquare = comparator_square.computeDistanceMetric();
                        combinedMetricsConcurrent.addAll(distanceToSquare);

                    }catch(Exception ex)
                    {
                        // @ToDo --
                    }
                    return(null);
                }
            };
            Callable<Void> callableTriangle = new Callable<Void>() {
                @Override
                public Void call()
                {
                    try {
                        EllipticFourierDistanceMeasure comparator_triangle = new EllipticFourierDistanceMeasure(descriptorsForThread, Constants.SHAPE_TYPE.TRIANGLE);
                        final List<EllipticFourierDistanceMeasure.Distance> distanceToTriangle = comparator_triangle.computeDistanceMetric();
                        combinedMetricsConcurrent.addAll(distanceToTriangle);

                    }catch(Exception ex)
                    {
                        // @ToDo --
                    }
                    return(null);
                }
            };
            Callable<Void> callableVee = new Callable<Void>() {
                @Override
                public Void call()
                {
                    try {
                        EllipticFourierDistanceMeasure comparator_vee = new EllipticFourierDistanceMeasure(descriptorsForThread, Constants.SHAPE_TYPE.VEE);
                        final List<EllipticFourierDistanceMeasure.Distance> distanceToVee = comparator_vee.computeDistanceMetric();
                        combinedMetricsConcurrent.addAll(distanceToVee);

                    }catch(Exception ex)
                    {
                        // @ToDo --
                    }

                    return(null);
                }
            };
            Callable<Void> callableLine = new Callable<Void>() {
                @Override
                public Void call()
                {
                    try {
                        EllipticFourierDistanceMeasure comparator_line = new EllipticFourierDistanceMeasure(descriptorsForThread, Constants.SHAPE_TYPE.LINE);
                        final List<EllipticFourierDistanceMeasure.Distance> distanceToLine = comparator_line.computeDistanceMetric();
                        combinedMetricsConcurrent.addAll(distanceToLine);

                    }catch(Exception ex)
                    {
                        // @ToDo --
                    }

                    return(null);
                }
            };

            // spawn worker threads
            //
            Future<Void> future1 = executor.submit(callableCircle);
            Future<Void> future2 = executor.submit(callableSquare);
            Future<Void> future3 = executor.submit(callableTriangle);
            Future<Void> future4 = executor.submit(callableVee);
            Future<Void> future5 = executor.submit(callableLine);

            // a rendezvous barrier to wait for all threads to complete
            //
            future1.get();
            future2.get();
            future3.get();
            future4.get();
            future5.get();

            // all threads have completed their computations, so now attempt to classify the user's gesture
            // by identifying the best match in the predefined gestures set
            //
            Constants.SHAPE_TYPE classification = EllipticFourierDistanceMeasure.findBestMatch(combinedMetricsConcurrent);
            Toast.makeText(this,"CLASSIFICATION : "+classification,Toast.LENGTH_LONG).show();

        }catch(Exception ex){
            String mesg = ex.getMessage();
            System.out.println(mesg);
        }
    }

    /**
     * Switches views between original 3D data and the dimensionality-reduced data
     * @param v
     */
    public void toggleViews(View v)
    {
        if(data3D.isEmpty()) {
            Toast.makeText(MainActivityMobile.this, "You must first generate motion data from wearable.",Toast.LENGTH_SHORT).show();
            return;
        }

        if(firstTime) {
            chartPane.setVisibility(View.VISIBLE);
            firstTime = false;
        }

        toggler = !toggler;

        if(toggler) {
            renderScatterPlot3D(this.data3D);
            return;
        }

        shapeAnalyzerBtn.setVisibility(View.VISIBLE);   // now enable Shape Descriptor button

        PCA pca = new PCA();
        pca.setup(this.data3D.size(), Coord3D.DIMENSIONALITY);

        for(Coord3D point : this.data3D)
        {
            double[] vector = new double[]{point.getX(), point.getY(), point.getZ()};
            pca.addSample(vector);
        }

        pca.computeBasis(2);    // compress data from 3D to 2D

        data2D.clear();
        for(Coord3D point : this.data3D)
        {
            double[] vector = pca.sampleToEigenSpace(new double[]{point.getX(), point.getY(), point.getZ()});
            Coord2D p = new Coord2D(vector[0], vector[1]);
            data2D.add(p);
        }

        renderScatterPlot2D(data2D);
    }

    /**
     * Plots set of points in a 3D space
     *
     * @param pointsIn3space
     */
    private void renderScatterPlot3D(List<Coord3D> pointsIn3space)
    {
        final ChartSurfaceView csv = chartPane;

        XYZSeries dataset = new XYZSeries("dimensionality_flattener");
        for(Coord3D point : pointsIn3space)
            dataset.add(point.getX(), point.getY(), point.getZ());

        dataCollection = new XYZSeriesCollection();
        dataCollection.add(dataset);

        scatterPlot = Chart3DFactory.createScatterChart("Accelerometer Scatter Plot", "original gravity-filtered deltas", dataCollection, "X_delta", "Y_delta", "Z_delta");

        csv.setChart(scatterPlot);

        // here we add a listener that will zoom-to-fit the new chart when
        // the layout changes...
        csv.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right,
                                       int bottom, int oldLeft, int oldTop, int oldRight,
                                       int oldBottom) {
                csv.zoomToFit(right - left, bottom - top);
            }
        });

    }


    /**
     * Plots a set of points on a 2D hyperplane
     *
     * @param pointsOnPlane
     */
    private void renderScatterPlot2D(List<Coord2D> pointsOnPlane)
    {
        final ChartSurfaceView csv = chartPane;

        XYZSeries dataset = new XYZSeries("dimensionality_flattener");
        for(Coord2D point : pointsOnPlane)
            dataset.add(point.getA(), point.getB(), 0.0);

        // add two out-of-plane points to ensure 3D structure -- scatterplot REQUIRES 3D data else chart won't render
        dataset.add(0.0,0.0,-3.0);
        dataset.add(0.0,0.0,3.0);

        dataCollection2D = new XYZSeriesCollection();
        dataCollection2D.add(dataset);

        scatterPlot2D = Chart3DFactory.createScatterChart("Accelerometer Scatter Plot", "after PCA(SVD) 2D data compression", dataCollection2D, "X_delta", "Y_delta", "Z_delta");

        csv.setChart(scatterPlot2D);

        // here we add a listener that will zoom-to-fit the new chart when
        // the layout changes...
        csv.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right,
                                       int bottom, int oldLeft, int oldTop, int oldRight,
                                       int oldBottom) {
                csv.zoomToFit(right - left, bottom - top);
            }
        });

    }

    @Override
    public void onResume()
    {
        super.onResume();
        try {
            registerReceiver(updateUIReceiver, mesgFilter);
        } catch (IllegalArgumentException e) {
        }  // catch exception in the case of a re-registration attempt
    }

    @Override
    public void onStop() {
        unregisterReceiver(updateUIReceiver);
        super.onStop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            case R.id.action_circle:
                outputFileName = "CIRCLE_ShapeAnalysis_harmonics.txt";
                return true;
            case R.id.action_square:
                outputFileName = "SQUARE_ShapeAnalysis_harmonics.txt";
                return true;
            case R.id.action_triangle:
                outputFileName = "TRIANGLE_ShapeAnalysis_harmonics.txt";
                return true;
            case R.id.action_vee:
                outputFileName = "VEE_ShapeAnalysis_harmonics.txt";
                return true;
            case R.id.action_line:
                outputFileName = "LINE_ShapeAnalysis_harmonics.txt";
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Saves the activity state so it can be restored, for example after
     * a device rotation.  For the demo we save the chart type and view point
     * which is enough to put the chart back as it was (since the data
     * cannot be edited in the demo).
     *
     * @param savedInstanceState  the bundle to store data into.
     *//*
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(CHART_INDEX_KEY, 0);

        final ChartSurfaceView csv
                = (ChartSurfaceView) findViewById(R.id.chartView);
        ViewPoint3D vp = csv.getChart().getViewPoint();
        savedInstanceState.putParcelable(VIEW_POINT_KEY, vp);
        super.onSaveInstanceState(savedInstanceState);
    }
*/
    /**
     * Handles restoring the activity to its previous state, for example after
     * a device rotation.
     * For this application, I've constrained the display to Portait mode in the manifest, so no need for this method.
     *
     * @param savedInstanceState  the bundle to retrieve data from.
     */
    /*
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        updateScatterPlot(0,0,0);
        final ChartSurfaceView csv
                = (ChartSurfaceView) findViewById(R.id.chartView);
        ViewPoint3D viewPoint
                = savedInstanceState.getParcelable(VIEW_POINT_KEY);
        csv.getChart().setViewPoint(viewPoint);
    }
  */

    /**
     * Writes the EFD harmonics information to external storage for later analysis
     *
     * @param data      the EFD harmonics info (4-tuples)
     * @param filename  name of output file
     */
    private void writeToFile(String data, String filename) {
        try {
            String root= Environment.getExternalStorageDirectory().toString();
            File myDir = new File(root+"/GESTURES");
            if(!myDir.exists())
            {
                myDir.mkdir();
            }

            FileOutputStream  outputStream = new FileOutputStream (new File(myDir.getAbsolutePath().toString()+"/"+filename), true);
            outputStream.write(data.getBytes());
            outputStream.close();

        }
        catch (IOException e) {
            android.util.Log.e("Exception", "******* File write failed: "+e.toString());
        }
    }

}
