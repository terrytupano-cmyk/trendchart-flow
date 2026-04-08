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

import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import de.simone.trendchart.CssVariable;
import de.simone.trendchart.LineChartData;
import de.simone.trendchart.LineTrendChart;

public class RepositoriesSticker extends Sticker {

    public RepositoriesSticker() {
        H4 h31 = new H4("Lorem ipsum dolor sit amet");
        HorizontalLayout ev1 = new HorizontalLayout(getSpan(LineAwesomeIcon.STAR, "123"),
                getSpan(LineAwesomeIcon.ARCHIVE_SOLID, "35"),
                getSpan(LineAwesomeIcon.CHART_LINE_SOLID, "1,876"),
                getSpan(LineAwesomeIcon.CALENDAR, "1 week ago"));

        VerticalLayout v1 = new VerticalLayout(h31, ev1);
        v1.setSpacing(false);
        v1.setWidth("60%");

        LineTrendChart trendChart = getTrendChart(
                List.of(6, 16, 20, 11, 13, 16, 14, 0, 14, 11, 18, 10, 0, 15, 19, 11, 20, 18, 12, 14), "#54C430");
        HorizontalLayout line1 = new HorizontalLayout(v1, trendChart);
        line1.setSpacing(false);
        line1.setWidthFull();
        line1.setAlignItems(Alignment.CENTER);

        // ---

        H4 h32 = new H4("Ullam ex deleniti adipisci quod");
        HorizontalLayout ev2 = new HorizontalLayout(getSpan(LineAwesomeIcon.STAR, "25"),
                getSpan(LineAwesomeIcon.ARCHIVE_SOLID, "124"),
                getSpan(LineAwesomeIcon.CHART_LINE_SOLID, "172"),
                getSpan(LineAwesomeIcon.CALENDAR, "2 month ago"));

        VerticalLayout v2 = new VerticalLayout(h32, ev2);
        v2.setSpacing(false);
        v2.setWidth("60%");

        LineTrendChart trendChart2 = getTrendChart(
                List.of(0, 0, 0, -2, 0, -5, -8, 0, 0, 0, 0, -2, -2, -4, -5, 0, 0, 0, -2, -4), "#E60706");

        HorizontalLayout line2 = new HorizontalLayout(v2, trendChart2);
        line2.setSpacing(false);
        line2.setWidthFull();
        line2.setAlignItems(Alignment.CENTER);
        line2.getStyle().set("border-top", "1px solid var(--lumo-contrast-20pct)");

        setPadding(false);
        setSpacing(false);
        add(line1, line2);
    }

    private Span getSpan(LineAwesomeIcon icon, String text) {
        SvgIcon svgIcon = icon.create();
        svgIcon.setSize("1.2rem");
        svgIcon.getStyle().set("color", "gray");
        Span textComponent = new Span(text);
        textComponent.getStyle().set("color", "gray");
        Span span = new Span(svgIcon, textComponent);
        span.getStyle().set("spacing", "5px");
        span.getStyle().set("align-items", "center");
        return span;
    }

    private LineTrendChart getTrendChart(List<Number> data, String color) {
        LineChartData chartData = new LineChartData(data);
        chartData.weight = 1.6;
        chartData.tooltipFormat = "@V";
        LineTrendChart trendChart = new LineTrendChart(chartData);
        trendChart.setCssVariable(CssVariable.shape_color, color);
        trendChart.setHeight("2.5em");
        trendChart.setWidth("40%");
        trendChart.getStyle().set("padding", "var(--lumo-space-m)");
        return trendChart;
    }
}
