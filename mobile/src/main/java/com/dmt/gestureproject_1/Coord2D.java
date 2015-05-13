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

/**
 * Bean that represents a point in 2D space.
 */
public class Coord2D {

    private double a, b;
    public static final int DIMENSIONALITY = 2;

    public Coord2D(double a, double b)
    {
        this.a = a;
        this.b = b;
    }

    public double getA()
    {
        return(a);
    }

    public double getB()
    {
        return b;
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Coord2D or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Coord2D)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Coord2D c = (Coord2D) o;

        // Compare the data members and return accordingly
        return (Double.compare(this.a, c.getA()) == 0
                && Double.compare(this.b, c.getB()) == 0);
    }

    @Override
    public int hashCode()
    {
        int hash = 13;

        hash = 17 * hash + Double.valueOf(this.a).hashCode();
        hash = 17 * hash + Double.valueOf(this.b).hashCode();

        return(hash);
    }

}
