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

import android.content.Intent;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

import java.util.ArrayList;
import java.util.List;

public class ListenerServiceFromWear extends WearableListenerService {

    private static final String REMOTE_WEAR_PATH = "/sensor-data-wear";
    private static final String DELIMITER = ",";
    private static final String LINE_DELIMITER = "!";
    public final static String INITIALIZATION = "init";

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {

        /*
         * Receive the message from wear
         */
        if (messageEvent.getPath().equals(REMOTE_WEAR_PATH)) {

            Intent localIntent = new Intent();

            localIntent.setAction("sensordata_transmission");

            String sensor_data = new String(messageEvent.getData());
            if(INITIALIZATION.equals(sensor_data))
            {
                localIntent.putExtra(INITIALIZATION,"");
            }
            else
            {
                /*
                String[] sensor_datum = sensor_data.split(DELIMITER);

                localIntent.putExtra("x_acceleration", sensor_datum[0]);
                localIntent.putExtra("y_acceleration", sensor_datum[1]);
                localIntent.putExtra("z_acceleration", sensor_datum[2]);
                */

                ArrayList<Coord3D> vectors = new ArrayList<Coord3D>();
                String[] sensor_lines = sensor_data.split(LINE_DELIMITER);
                String[] sensor_datum;
                for(String line_of_data : sensor_lines)
                {
                    sensor_datum = line_of_data.split(DELIMITER);
                    vectors.add(new Coord3D(Double.parseDouble(sensor_datum[0]),    // X acceleration vector
                                            Double.parseDouble(sensor_datum[1]),    // Y acceleration vector
                                            Double.parseDouble(sensor_datum[2])));  // Z acceleration vector
                }
                localIntent.putParcelableArrayListExtra("vectors", vectors);
            }

            localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            this.sendBroadcast(localIntent);
        }

    }

}
