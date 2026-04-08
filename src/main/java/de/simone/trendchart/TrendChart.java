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

import java.util.Objects;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.dependency.NpmPackage;

import elemental.json.Json;
import elemental.json.JsonArray;

/**
 * Base class for all trend charts. It provides the common method to set the chart data and css variables.
 */
@NpmPackage(value = "@weblogin/trendchart-elements", version = "2.0.3")
public abstract class TrendChart extends Component implements HasSize {

    /**
     * Sets the chart data. The chart will be updated with the new data.
     * @param chartData - the data
     */
    public void setData(ChartData chartData) {
        Objects.requireNonNull(chartData, "chartData can't be null");

        JsonArray values = Json.createArray();
        for (int i = 0; i < chartData.values.size(); i++) {
            values.set(i, chartData.values.get(i).doubleValue());
        }
        getElement().setPropertyJson("values", values);

        if (chartData.labels != null) {
            JsonArray labels = Json.createArray();
            for (int i = 0; i < chartData.labels.size(); i++) {
                labels.set(i, chartData.labels.get(i));
            }
            getElement().setPropertyJson("labels", labels);
        }

        getElement().setProperty("max", chartData.max);
        getElement().setProperty("static", chartData.isStatic);
        getElement().setProperty("tooltipDisabled", chartData.tooltipDisabled);
        getElement().setProperty("tooltipFormat", chartData.tooltipFormat);
    }

    /**
     * Sets a css variable for the chart. The available css variables are defined in the {@link CssVariable} enum.
     * @param variable - the variable
     * @param value - the value
     */
    public void setCssVariable(CssVariable variable, Object value) {
        getStyle().set(variable.getCssVariable(), value.toString());
    }
}