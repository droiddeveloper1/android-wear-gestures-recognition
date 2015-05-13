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

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Bean representing a point in 3D space
 */
public class Coord3D implements Parcelable
{
    private double x, y, z;
    public static final int DIMENSIONALITY = 3;

    /**
     * Regular constructor
     *
     * @param x
     * @param y
     * @param z
     */
    public Coord3D(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Special constructor for Parcelling
     *
     * @param in
     */
    public Coord3D(Parcel in)
    {
        this.x = in.readDouble();
        this.y = in.readDouble();
        this.z = in.readDouble();
    }

    public double getX()
    {
        return(x);
    }

    public double getY()
    {
        return y;
    }

    public double getZ()
    {
        return z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeDouble(x);
        parcel.writeDouble(y);
        parcel.writeDouble(z);
    }

    public static final Parcelable.Creator<Coord3D> CREATOR = new Parcelable.Creator<Coord3D>(){

        public Coord3D createFromParcel(Parcel in) {
            return new Coord3D(in);
        }

        public Coord3D[] newArray(int size) {
            return new Coord3D[size];
        }
    };

}
