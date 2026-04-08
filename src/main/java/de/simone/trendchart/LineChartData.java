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
 * Data class for the LineTrendChart.
 */
public class LineChartData extends ChartData {
    public double min = 0;
    public double weight = 2;
    public Double point; // undefined -> null
    public boolean inside = false;

    /**
     * new instance
     * @param values - the values
     */
        public LineChartData(List<Number> values) {
        super(values);
    }

}
