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
package de.simone;

import java.util.List;

import org.vaadin.lineawesome.LineAwesomeIcon;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import de.simone.trendchart.CssVariable;
import de.simone.trendchart.PieChartData;
import de.simone.trendchart.PieTrendChart;

public class Donut extends HorizontalLayout {

    public Donut(double max, double value, String label, LineAwesomeIcon icon, String color) {
        super();
        PieChartData chartData = new PieChartData(List.of(value));
        chartData.donut = 6.0;
        chartData.max = max;

        PieTrendChart stepsChart = new PieTrendChart(chartData);
        stepsChart.addClassNames("donutExample");
        stepsChart.setCssVariable(CssVariable.shape_color, color);

        Span runText = new Span();
        runText.getStyle().set("align-content", "center");
        runText.getElement().setProperty("innerHTML", label);

        SvgIcon icon2 = icon.create();
        icon2.addClassNames("donutExample-icon");
        icon2.getStyle().set("color", color);

        Div div = new Div(icon2, stepsChart);
        div.addClassName("donutSticker");

        add(div, runText);
        setSpacing(false);
        setPadding(false);
    }
}
