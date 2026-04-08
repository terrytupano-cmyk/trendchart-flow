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

import com.vaadin.flow.component.Svg;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.FlexLayout.FlexWrap;

import de.simone.trendchart.CssVariable;
import de.simone.trendchart.StackChartData;
import de.simone.trendchart.StackTrendChart;

public class LanguagesSticker extends Sticker {

    public LanguagesSticker() {
        H4 title = new H4("Languages");

        StackChartData chartData = new StackChartData(List.of(64, 48, 16, 12));
        chartData.horizontal = true;
        chartData.radius = 20;
        chartData.gap = 3;
        StackTrendChart trendChart = new StackTrendChart(chartData);
        trendChart.setHeight("1rem");
        trendChart.setWidth("90%");
        trendChart.setCssVariable(CssVariable.shape_color_1, "#b07219");
        trendChart.setCssVariable(CssVariable.shape_color_2, "#ff9f40");
        trendChart.setCssVariable(CssVariable.shape_color_3, "#ff6384");
        trendChart.setCssVariable(CssVariable.shape_color_4, "#4bc061");

        FlexLayout legend = new FlexLayout(getItem("Java", "#b07219"), getItem("JavaScript", "#ff9f40"),
                getItem("HTML", "#ff6384"), getItem("CSS", "#4bc061"));
        legend.setWidth("80%");
        legend.getStyle().set("spacing", "10px");
        legend.setFlexWrap(FlexWrap.WRAP);
        legend.setAlignItems(Alignment.STRETCH);
        legend.setJustifyContentMode(FlexLayout.JustifyContentMode.CENTER);

        setAlignItems(Alignment.CENTER);
        add(title, trendChart, legend);
    }

    private Span getItem(String text, String color) {
        Svg mark = new Svg();
        mark.setSvg(
                "<svg viewBox=\"0 0 10 10\" xmlns=\"http://www.w3.org/2000/svg\"><circle cx=\"5\" cy=\"5\" r=\"5\" fill=\""
                        + color + "\"/></svg>");
        mark.getStyle().set("width", "10px");
        mark.getStyle().set("margin-right", "5px");

        Span textComponent = new Span(text);
        textComponent.getStyle().set("font-weight", "bold");
        textComponent.getStyle().set("color", "gray");
        textComponent.getStyle().set("margin-right", "15px");

        Span span = new Span(mark, textComponent);
        span.getStyle().set("display", "flex");
        span.getStyle().set("align-items", "center");
        span.getStyle().set("justify-content", "center");
        span.getStyle().set("text-align", "center");
        return span;
    }
}
