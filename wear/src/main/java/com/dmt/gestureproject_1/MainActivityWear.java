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
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.Wearable;


public class MainActivityWear extends Activity implements SensorEventListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private final static int SAMPLE_PERIOD = 750;  // 1-second sampling window
    private static final int SAMPLE_INTERVAL = 25; // sampling interval in millis
    private final static int NUMBER_OF_DATA_POINTS = 30;    // = SAMPLE_PERIOD÷SAMPLE_INTERVAL
    private final static float SENSOR_NOISE_LEVEL = 0.32f;
    private final static String INITIALIZATION = "init";
    private SensorManager sensorManager=null;
    private Sensor accelerometer=null;
    private float x_previous=0.0f, y_previous=0.0f, z_previous=0.0f,
                  delta_x, delta_y, delta_z;
    private long lastUpdate = System.currentTimeMillis();
    private TextView x_text, y_text, z_text;
    private Switch filterSwitch;
    private static final String DELIMITER = ",";
    private static final String LINE_DELIMITER = "!";
    private float[] x_history = new float[]{0.0f,0.0f,0.0f,0.0f},
                    y_history = new float[]{0.0f,0.0f,0.0f,0.0f},
                    z_history = new float[]{0.0f,0.0f,0.0f,0.0f};

    private StringBuilder dataBuffer = new StringBuilder();

    Node mNode; // the connected device to send the message to
    GoogleApiClient mGoogleApiClient;
    private static final String SENSOR_DATA_WEAR_PATH = "/sensor-data-wear";
    private boolean mResolvingError=false;
    private RelativeLayout parentLayout = null;
    private LinearLayout parentLayout_alt = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_wear);


        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                x_text = (TextView)stub.findViewById(R.id.x_accel);
                y_text = (TextView)stub.findViewById(R.id.y_accel);
                z_text = (TextView)stub.findViewById(R.id.z_accel);

                parentLayout = (RelativeLayout) stub.findViewById(R.id.round_activity_main_activity_wear);
                if(parentLayout==null)
                    parentLayout_alt = (LinearLayout) stub.findViewById(R.id.rect_activity_main_activity_wear);

                filterSwitch = (Switch) stub.findViewById(R.id.switch_filter);
                filterSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,  boolean isChecked) {
                        // TODO Auto-generated method stub

                    }
                });
            }
        });

        this.sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        this.accelerometer = this.sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //Connect the GoogleApiClient
        mGoogleApiClient = new GoogleApiClient.Builder(this).addApi(Wearable.API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
    }

    /**
     * Invoked directly from XML layout
     * @param v
     */
    public void send_data(View v)
    {
        //Log.w("SENSORS", "about to send data ...");

        // change screen colour to indicate start of data transmission
        if(parentLayout!=null)
            parentLayout.setBackgroundColor(Color.parseColor("#FF1111"));
        else if(parentLayout_alt!=null)
            parentLayout_alt.setBackgroundColor(Color.parseColor("#FF1111"));

        sendMessage(INITIALIZATION);
        startTimer(SAMPLE_PERIOD);

        //Log.w("SENSORS","sent data ...");
    }

    private void startTimer(int delay)
    {
        long interval = delay/(NUMBER_OF_DATA_POINTS+2);    // add small offset to reduce the delay
        dataBuffer.setLength(0);
        new CountDownTimer(delay, interval) {

            public void onTick(long millisUntilFinished) {

               // sendMessage(x_previous + DELIMITER + y_previous + DELIMITER + z_previous);        // old way. transmit per clock tick

                // instead of SENDING mesg per clock tick, simply accumulate the mesg data in a buffer
                // and filter out near-zero delta values
                if(Math.abs(delta_x)>SENSOR_NOISE_LEVEL || Math.abs(delta_y)>SENSOR_NOISE_LEVEL || Math.abs(delta_z)>SENSOR_NOISE_LEVEL)
                    dataBuffer.append(x_previous + DELIMITER + y_previous + DELIMITER + z_previous + LINE_DELIMITER);
                   // dataBuffer.append(delta_x + DELIMITER + delta_y + DELIMITER + delta_z + LINE_DELIMITER);
            }

            public void onFinish() {
                if(parentLayout!=null)
                    parentLayout.setBackgroundColor(Color.parseColor("#000000"));
                else if(parentLayout_alt!=null)
                    parentLayout_alt.setBackgroundColor(Color.parseColor("#000000"));

                sendMessage(dataBuffer.toString());
            }
        }.start();
    }

    /**
     * Send message to mobile handheld
     */
    private void sendMessage(String messageBody)
    {
        if (mNode != null && mGoogleApiClient!=null && mGoogleApiClient.isConnected())
        {
            byte[] byteData = null;
            if(messageBody!=null)
                byteData = messageBody.getBytes();

            Wearable.MessageApi.sendMessage(
                    mGoogleApiClient, mNode.getId(), SENSOR_DATA_WEAR_PATH, byteData).setResultCallback(

                    new ResultCallback<MessageApi.SendMessageResult>() {
                        @Override
                        public void onResult(MessageApi.SendMessageResult sendMessageResult) {

                            if (!sendMessageResult.getStatus().isSuccess()) {
                                Log.e("TAG", "Failed to send message with status code: "+ sendMessageResult.getStatus().getStatusCode());
                            }
                        }
                    }
            );
        }else{
            //Improve your code
        }

    }

    /*
     * Resolve the node = the connected device to send the message to
     */
    private void resolveNode() {

        Wearable.NodeApi.getConnectedNodes(mGoogleApiClient).setResultCallback(new ResultCallback<NodeApi.GetConnectedNodesResult>() {
            @Override
            public void onResult(NodeApi.GetConnectedNodesResult nodes) {
                for (Node node : nodes.getNodes()) {
                    mNode = node;
                }
            }
        });
    }

    @Override
    public void onConnected(Bundle bundle) {
        resolveNode();
    }

    @Override
    public void onConnectionSuspended(int i) {
        //Improve your code
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        //Improve your code
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!mResolvingError) {
            mGoogleApiClient.connect();
        }
    }

    protected void onResume() {
        super.onResume();

        Log.w("SENSORS","about to register listener...");
        boolean status = this.sensorManager.registerListener(this, this.accelerometer, SensorManager.SENSOR_DELAY_FASTEST);
        Log.w("SENSORS","registration result: ["+status+"]");
    }

    protected void onPause() {
        Log.w("SENSORS","about to UNREGISTER listener...");
        this.sensorManager.unregisterListener(this);
        Log.w("SENSORS","Listener unregistered.");
        super.onPause();
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event)
    {
        //Log.w("SENSORS","sensor data change detected...");
        if (event.sensor.getType() != Sensor.TYPE_ACCELEROMETER)
            return;
        //Log.w("SENSORS","accelerometer data change detected...");
        long curTime = System.currentTimeMillis();

        /*
         * quit if sampling period has not elapsed
         */
        if ((curTime - lastUpdate) > SAMPLE_INTERVAL) {
            lastUpdate = curTime;
        }
        else
            return;

        /*
         * process sensor data
         */
        final float x = event.values[0];
        final float y = event.values[1];
        final float z = event.values[2];

        x_history[3] = x_history[2];
        x_history[2] = x_history[1];
        x_history[1] = x_history[0];
        x_history[0] = x - x_previous;

        y_history[3] = y_history[2];
        y_history[2] = y_history[1];
        y_history[1] = y_history[0];
        y_history[0] = y - y_previous;

        z_history[3] = z_history[2];
        z_history[2] = z_history[1];
        z_history[1] = z_history[0];
        z_history[0] = z - z_previous;
        /*
        if(Math.abs(x_history[0]-x_history[1]) > SENSOR_NOISE_LEVEL)
            delta_x = x_history[0];
        else    // compute weighted mean
            delta_x = 0.5f*x_history[0] + 0.3f*x_history[1] + 0.1f*x_history[2] + 0.1f*x_history[3];
        */
        delta_x = computeDirectionalAcceleration(x_history);
        delta_y = computeDirectionalAcceleration(y_history);
        delta_z = computeDirectionalAcceleration(z_history);

        // cache actual sensor readings for next iteration
        x_previous = x;
        y_previous = y;
        z_previous = z;

        //updateDisplay(x, y, z);
        updateDisplay(delta_x, delta_y, delta_z);
    }

    /**
     * Update the wearable display with current accel vectors
     *
     * @param x     x-direction acceleration delta
     * @param y     y-direction acceleration delta
     * @param z     z-direction acceleration delta
     */
    public void updateDisplay(float x, float y, float z)
    {
        //Log.w("MainActivity_Wearable","IN UpdateDisplay()");
        try {
            x_text.setText("X : " + x);
            y_text.setText("Y : " + y);
            z_text.setText("Z : " + z);
        }catch(NullPointerException nex)
        {
            //
        }
    }

    /**
     * Computes new directional acceleration delta
     * @param dataWindow    array holding most recent 4 accelerometer deltas
     * @return either original delta(if delta is significant enough), or weighted mean of 4 most recent delta measurements(if delta
     */
    private float computeDirectionalAcceleration(float[] dataWindow)
    {
        if(Math.abs(dataWindow[0]-dataWindow[1]) > SENSOR_NOISE_LEVEL)
            return(dataWindow[0]);
        else    // compute weighted mean
            return(0.5f*dataWindow[0] + 0.3f*dataWindow[1] + 0.1f*dataWindow[2] + 0.1f*dataWindow[3]);
    }

}
