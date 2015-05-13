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
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.RadioButton;

import com.orsoncharts.android.Chart3D;
import com.orsoncharts.android.ChartSurfaceView;
import com.orsoncharts.android.graphics3d.ViewPoint3D;

/**
 * A simple activity for displaying a selected chart.
 */
public class testActivity extends Activity {

    /** A key for saving activity state. */
    static final String CHART_INDEX_KEY = "chartIndex";

    /** A key for saving the current view point. */
    static final String VIEW_POINT_KEY = "viewPoint";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initChart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Initialises the chart and sets the correct radio button.  This is 
     * called from onCreate() as well as from onRadioButtonClicked().
     *
     */
    private void initChart()
    {
        final ChartSurfaceView csv
                = (ChartSurfaceView) findViewById(R.id.chartView);
        Chart3D chart = null;
        chart = Charts.createDemoScatterChart(-1.0, -1.0, -1.0);
        csv.setChart(chart);

        // here we add a listener that will zoom-to-fit the new chart when
        // the layout changes...
        csv.addOnLayoutChangeListener(new OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right,
                                       int bottom, int oldLeft, int oldTop, int oldRight,
                                       int oldBottom) {
                csv.zoomToFit(right - left, bottom - top);
            }
        });

    }


    /**
     * Saves the activity state so it can be restored, for example after
     * a device rotation.  For the demo we save the chart type and view point
     * which is enough to put the chart back as it was (since the data
     * cannot be edited in the demo).
     *
     * @param savedInstanceState  the bundle to store data into.
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(CHART_INDEX_KEY, 0);

        final ChartSurfaceView csv
                = (ChartSurfaceView) findViewById(R.id.chartView);
        ViewPoint3D vp = csv.getChart().getViewPoint();
        savedInstanceState.putParcelable(VIEW_POINT_KEY, vp);
        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * Handles restoring the activity to its previous state, for example after
     * a device rotation.  
     *
     * @param savedInstanceState  the bundle to retrieve data from.
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        initChart();
        final ChartSurfaceView csv
                = (ChartSurfaceView) findViewById(R.id.chartView);
        ViewPoint3D viewPoint
                = savedInstanceState.getParcelable(VIEW_POINT_KEY);
        csv.getChart().setViewPoint(viewPoint);
    }


}