/*-
 * #%L
 * TrendChart Add-on for vaadin Flow
 * %%
 * Copyright (C) 2026 Terry Tupano
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package de.simone.trendchart;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

/**
 * LineTrendChart is a trend chart that displays the values as a line
 */
@Tag("tc-line")
@JsModule("@weblogin/trendchart-elements/dist/tc-line.js") 
public class LineTrendChart extends TrendChart {

    /**
     * new instance
     * @param chartData - the chart data
     */
    public LineTrendChart(LineChartData chartData) {
        setData(chartData);
    }

    /**
     * Sets the chart data. The chart will be updated with the new data.
     * @param chartData - the chart data
     */
    public void setData(LineChartData chartData) {
        super.setData(chartData);

        getElement().setProperty("min", chartData.min);
        getElement().setProperty("weight", chartData.weight);

        if (chartData.point != null) {
            getElement().setProperty("point", chartData.point);
        }
        getElement().setProperty("inside", chartData.inside);
    }
}