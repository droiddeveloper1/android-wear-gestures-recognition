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

import com.orsoncharts.android.Chart3D;
import com.orsoncharts.android.Chart3DFactory;
import com.orsoncharts.android.data.StandardPieDataset3D;
import com.orsoncharts.android.data.category.StandardCategoryDataset3D;
import com.orsoncharts.android.data.xyz.XYZSeries;
import com.orsoncharts.android.data.xyz.XYZSeriesCollection;

/**
 * Static methods to create charts for display in the demo.  You would not 
 * normally hard-code the datasets, of course, but here it helps to make the
 * demo simple and self-contained.
 */
public class Charts {

    /**
     * Creates and returns a simple pie chart for demo purposes.
     *
     * @return A pie chart.
     */
    public static Chart3D createDemoPieChart() {
        StandardPieDataset3D dataset = new StandardPieDataset3D();
        dataset.add("A", 60.0);
        dataset.add("B", 30.0);
        return Chart3DFactory.createPieChart("Pie Chart", "Subtitle...",
                dataset);
    }

    /**
     * Creates and returns a simple bar chart for demo purposes.
     *
     * @return A bar chart.
     */
    public static Chart3D createDemoBarChart() {
        StandardCategoryDataset3D dataset = new StandardCategoryDataset3D();
        dataset.addValue(5.0, "Series 1", "Row 1", "Column 1");
        dataset.addValue(7.0, "Series 1", "Row 1", "Column 2");
        dataset.addValue(9.0, "Series 1", "Row 1", "Column 3");
        dataset.addValue(11.0, "Series 2", "Row 2", "Column 1");
        dataset.addValue(7.0, "Series 2", "Row 2", "Column 2");
        dataset.addValue(3.0, "Series 2", "Row 2", "Column 3");
        return Chart3DFactory.createBarChart("Bar Chart", "Subtitle...",
                dataset, "Row Axis", "Column Axis", "Value Axis");
    }

    /**
     * Creates and returns a simple scatter chart for demo purposes.
     *
     * @return A scatter chart.
     */
    public static Chart3D createDemoScatterChart(double x, double y, double z) {
        XYZSeries series1 = new XYZSeries("Series 1");
        series1.add(x,y,z);
        series1.add(x+2.4,y+2.2,z+6.4);
/*
       // XYZSeries series2 = new XYZSeries("Series 2");
        for (int i = 0; i < 2; i++) {
            series1.add(x+i, y+i, z+i);
         //   series2.add(Math.random() * 10, Math.random() * 5, Math.random() * 20);
        }
*/
        XYZSeriesCollection dataset = new XYZSeriesCollection();
        dataset.add(series1);
        //dataset.add(series2);

        return Chart3DFactory.createScatterChart("Scatter Chart", "Subtitle...", dataset, "X", "Y", "Z");
    }
}