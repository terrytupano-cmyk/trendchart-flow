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
 * PieTrendChart is a trend chart that displays the values as a pie. It can be
 * used to display the distribution of values in a single pie. The chart can be
 * a donut and it can have a gap between the slices.
 */
@Tag("tc-pie")
@JsModule("@weblogin/trendchart-elements/dist/tc-pie.js")
public class PieTrendChart extends TrendChart {

    /**
     * new instance
     * @param chartData - the chart data
     */
    public PieTrendChart(PieChartData chartData) {
        setData(chartData);
    }

    /**
     * Sets the chart data.  
     * @param chartData - the chart data
     */
    public void setData(PieChartData chartData) {
        super.setData(chartData);

        if (chartData.donut != null) {
            getElement().setProperty("donut", chartData.donut);
        }

        getElement().setProperty("rotate", chartData.rotate);
        getElement().setProperty("gap", chartData.gap);
    }
}