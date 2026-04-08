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

import java.util.List;

/**
 * Data class for the BarTrendChart.
 */
public class BarChartData extends ChartData {
    /**
     * Optional - Number to change the min scale of the chart
     */
    public double min = 0;

    /**
     * Optional - Number for the radius of the bars
     */
    public double radius = 2;

    /**
     * Optional - Number for the gap between the bars
     */
    public double gap = 2;

    /**
     * Optional - Boolean to change the orientation to horizontal
     */
    public boolean horizontal = false;

    /**
     * new instance
     * @param values - the values
     */
    public BarChartData(List<Number> values) {
        super(values);
    }
}
