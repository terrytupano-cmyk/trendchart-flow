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

public class ChartData {

    /**
     * Required - Array of numbers for the values, at least 2 for line and bar
     * charts.
     */
    public List<Number> values;

    /**
     * Optional - Array of strings for the labels corresponding to the values, it
     * needs to be the same length as values array.
     */
    public List<String> labels;

    /**
     * Optional - Number to change the max scale of the chart
     */
    public double max;

    /**
     * Optional - Boolean to disable tooltip and hover styling
     */
    public boolean isStatic = false;

    /**
     * Optional - Boolean to disable tooltip
     */
    public boolean tooltipDisabled = false;

    /**
     * Optional - String to format the tooltip text. Two placeholders are
     * available, @V for the current value and @L for the current label if present.
     * You can use &#10; to create a new line
     */
    public String tooltipFormat = "@L @V";

    /**
     * new instance
     * @param values - the values
     */
    public ChartData(List<Number> values) {
        this.values = values;
    }
}
