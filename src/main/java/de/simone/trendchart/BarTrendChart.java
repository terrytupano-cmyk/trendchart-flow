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
 * BarTrendChart is a trend chart that displays the values as bars. It can be
 * used to display the distribution of values in a single bar. The chart can be
 * horizontal or vertical and it can have rounded corners.
 */
@Tag("tc-bar")
@JsModule("@weblogin/trendchart-elements/dist/tc-bar.js")
public class BarTrendChart extends TrendChart {

    /**
     * new instance
     * @param chartData - the chart data
     */
    public BarTrendChart(BarChartData chartData) {
        setData(chartData);
    }

    /**
     * Sets the chart data. The chart will be updated with the new data.
     * @param chartData - the chart data
     */
    public void setData(BarChartData chartData) {
        super.setData(chartData);

        getElement().setProperty("min", chartData.min);
        getElement().setProperty("radius", chartData.radius);
        getElement().setProperty("gap", chartData.gap);
        getElement().setProperty("horizontal", chartData.horizontal);
    }
}