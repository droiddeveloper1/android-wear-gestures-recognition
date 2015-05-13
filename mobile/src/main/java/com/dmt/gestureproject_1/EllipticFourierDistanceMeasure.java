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

import android.util.Log;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Utility class for vector comparator (vector similarity calculations) on Elliptic Fourier datasets
 */
public class EllipticFourierDistanceMeasure
{

    private List<List<Double>> unclassifiedShapeDescriptors;    // set of unclassified descriptors
    private List<List<List<Double>>> referenceDescriptors;      // sets of known shape descriptors
    private Constants.SHAPE_TYPE referenceShapeType;

    public EllipticFourierDistanceMeasure(List<List<Double>> unclassifiedShapeDescriptors, Constants.SHAPE_TYPE referenceShapeType) throws Exception
    {
        this.unclassifiedShapeDescriptors = unclassifiedShapeDescriptors;
        this.referenceShapeType = referenceShapeType;

        switch(referenceShapeType){
            case CIRCLE:
                this.referenceDescriptors = Constants.DESCRIPTORS_CIRCLE;
                break;
            case SQUARE:
                this.referenceDescriptors = Constants.DESCRIPTORS_SQUARE;
                break;
            case TRIANGLE:
                this.referenceDescriptors = Constants.DESCRIPTORS_TRIANGLE;
                break;
            case VEE:
                this.referenceDescriptors = Constants.DESCRIPTORS_VEE;
                break;
            case LINE:
                this.referenceDescriptors = Constants.DESCRIPTORS_LINE;
                break;
            default:
                throw new Exception("undefined shape type");
        }
    }

    /**
     * Attempt to find the best match for the unclassified shape descriptors
     *
     * @param listOfDistanceMeasures
     *
     * @return
     */
    public static Constants.SHAPE_TYPE findBestMatch(CopyOnWriteArrayList<Distance> listOfDistanceMeasures)
    {
        Constants.SHAPE_TYPE classification = Constants.SHAPE_TYPE.UNKNOWN;

        // convert concurrent list into non-concurrent list prior to sort attempt
        ArrayList<Distance> nonConcurrentList = new ArrayList<Distance>();
        for(Distance d : listOfDistanceMeasures)
            nonConcurrentList.add(d);

        Collections.sort(nonConcurrentList);

        Distance closestMatch = nonConcurrentList.get(0);

        classification = closestMatch.getShape();

        return(classification);
    }

    /**
     * Computes a distance metric between descriptor vectors of unclassified shape and the vectors of the predefined reference shape.
     * Distance measure is determined by examining two properties:
     *      1. ANGLE between pair of vectors (a Zero angle corresponds to a distance multiplier of unity; 180 degree angle corresponds to some maximum distance multiplier(negative correlation)))
     *      2. difference in SCALED MAGNITUDE between pair of vectors
     *
     * @return an object encapsulating the distance metrics for each of the (8) Fourier harmonics
     */
    public List<Distance> computeDistanceMetric()
    {
        List<Distance> distances = new ArrayList<Distance>();

        for(List<List<Double>> reference_setOf8descriptors : this.referenceDescriptors)
        {
            Iterator<List<Double>> iterator_ref = reference_setOf8descriptors.iterator();
            Iterator<List<Double>> iterator_unknown = unclassifiedShapeDescriptors.iterator();

            double diffVector=0.0d;                         // accumulator for differences between an unclassified 8-descriptor EFD set and its counterpart reference EFD set

            while(iterator_ref.hasNext() && iterator_unknown.hasNext())
            {
                // initialize numerator and denominator of value of cosine(angle)
                double cosTheta_numerator = 0.0d;
                double cosTheta_denominator_multiplicand = 0.0d, cosTheta_denominator_multiplier = 0.0d;

                List<Double> R = iterator_ref.next();       // REFERENCE vector
                List<Double> U = iterator_unknown.next();   // UNCLASSIFIED vector

                Iterator<Double> iterator_R = R.iterator();
                Iterator<Double> iterator_U = U.iterator();

                double R_min = Double.MAX_VALUE,
                       U_min = Double.MAX_VALUE;            // represents the minimum vector components of each vector

                while(iterator_R.hasNext() && iterator_U.hasNext())
                {
                    double r = iterator_R.next(), u = iterator_U.next();
                    cosTheta_numerator += r * u;
                    cosTheta_denominator_multiplicand += u*u;
                    cosTheta_denominator_multiplier += r*r;

                    // identify and cache the minimum value AS LONG AS IT'S NOT ZERO-VALUED
                    R_min = r < R_min && Math.abs(r)>0.0d ? r : R_min;
                    U_min = u < U_min && Math.abs(u)>0.0d ? u : U_min;
                }

                // compute difference between vectors by:
                // dividing through all vector components by their minimum vector component in order to produce a new NORMALIZED vector,
                // compute absolute difference between the normalized vectors,
                // then scale this difference by the angle in between the vectors (multiplier = [1 .. 1+PI] ).
                //
                double cosTheta_denominator = Math.sqrt(cosTheta_denominator_multiplicand) * Math.sqrt(cosTheta_denominator_multiplier);
                double cosTheta=0.0d, theta=0.0d;
                try {
                    cosTheta = cosTheta_numerator / cosTheta_denominator;
                    theta = Math.acos(cosTheta);

                    iterator_R = R.iterator();
                    iterator_U = U.iterator();

                    double r_normalized,
                           u_normalized,
                           diffVectorComponent=0.0d;    // accumulator for differences between a single unclassified EFD and its counterpart reference EFD

                    while(iterator_R.hasNext() && iterator_U.hasNext())
                    {
                        r_normalized = iterator_R.next()/R_min;
                        u_normalized = iterator_U.next()/U_min;
                        diffVectorComponent += Math.abs(u_normalized - r_normalized) * (1+theta);
                    }
                    diffVector += diffVectorComponent;

                }catch(ArithmeticException arex)
                {
                    // @ToDo -- add handler here
                    Log.w("*** EFD", "***********\n********* ComputeDistanceMetric : "+arex.getMessage());
                }
            }

            distances.add(new Distance(this.referenceShapeType, diffVector));
        }

        return(distances);
    }

    /**
     * Class encapsulating the computed vector distance measures
     */
    public final class Distance implements Comparable<Distance>
    {
        private Map.Entry<Constants.SHAPE_TYPE,Double> distance;

        public double getDistance()
        {
            return(distance.getValue());
        }

        public Constants.SHAPE_TYPE getShape()
        {
            return(distance.getKey());
        }

        public Distance(Constants.SHAPE_TYPE st, double dist)
        {
            this.distance = new AbstractMap.SimpleEntry<Constants.SHAPE_TYPE,Double>(st,dist);
        }

        public int compareTo(Distance compareDistance)
        {
            double metric = compareDistance.getDistance();

            // sort in ascending order
            if(metric > this.distance.getValue())
                return(-1);
            else
            if(metric == this.distance.getValue())
                return(0);
            else
                return(1);
        }

    }

}
