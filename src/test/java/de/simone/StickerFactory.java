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

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import de.simone.trendchart.BarChartData;
import de.simone.trendchart.BarTrendChart;
import de.simone.trendchart.LineChartData;
import de.simone.trendchart.LineTrendChart;
import de.simone.trendchart.PieChartData;
import de.simone.trendchart.PieTrendChart;

public class StickerFactory {

    /**
     * blue sticker with a bar chart showing orders trend, title and subtitle
     * @return - the sticker 
     */
    public static VerticalLayout createBarChartExample() {
        BarChartData chartData = new BarChartData(
                List.of(120, 100, 120, 110, 130, 160, 140, 100, 120, 110, 170, 180, 160, 170, 200, 140, 150, 130));
        chartData.labels = List.of("05/05/23", "06/05/23", "07/05/23", "08/05/23", "09/05/23", "10/05/23", "11/05/23",
                "12/05/23", "13/05/23", "14/05/23", "15/05/23", "16/05/23", "17/05/23", "18/05/23", "19/05/23",
                "20/05/23", "21/05/23", "22/05/23");
        chartData.tooltipFormat = "@L : (@V)";

        Component title = getTitleComponent("3,275€", "Orders (18 days)", "white", "lightblue");

        BarTrendChart trendChart = new BarTrendChart(chartData);
        trendChart.setWidthFull();
        trendChart.setHeight("5rem");

        Sticker sticker = new Sticker();
        sticker.add(title, trendChart);
        sticker.setPadding(false);
        sticker.setSpacing(false);
        sticker.setMargin(false);
        sticker.setWidthFull();
        sticker.setBackgroundColor("#0066E4");
        sticker.setAlignItems(FlexComponent.Alignment.CENTER);

        return sticker;
    }

    /**
     * Black sticker with a pie chart showing traffic sources, title and legend
     * @return - the sticker
     */
    public static Div createPieChartExample() {
        PieChartData chartData = new PieChartData(List.of(1200, 800, 400, 200));
        chartData.donut = 10.0;
        chartData.gap = 6;

        PieTrendChart trendChart = new PieTrendChart(chartData);
        trendChart.addClassName("pieChartExample-trend-chart");

        ListItem item1 = new ListItem("Search");
        item1.getStyle().set("color", "#A838FF");
        ListItem item2 = new ListItem("Direct");
        item2.getStyle().set("color", "#19D6BF");
        ListItem item3 = new ListItem("Referral");
        item3.getStyle().set("color", "#3C37FF");
        ListItem item4 = new ListItem("Social");
        item4.getStyle().set("color", "#FFBD3C");
        UnorderedList legend = new UnorderedList(item1, item2, item3, item4);

        Span label = new Span();
        label.getElement().setProperty("innerHTML", "Trafic<br>Sources<br><b>2,600</b>");
        label.addClassName("pieChartExample-label");

        Div donuts = new Div(label, trendChart);
        donuts.addClassName("pieChartExample-donuts");

        Div sticker = new Div(donuts, legend);
        sticker.addClassName("pieChartExample-sticker");
        return sticker;
    }

    /**
     * white sticker with 4 small donuts showing fitness data, title and legend
     * @return - the sticker
     */
    public static VerticalLayout createDonutsExample() {
        Component runDonut = new Donut(10000, 7652, "Steps<br><span style='font-weight: bold; color: #F17B32'>7,652</span>", LineAwesomeIcon.RUNNING_SOLID, "#F17B32");

        Component calsDonut = new Donut(2000, 1608, "Calories<br><span style='font-weight: bold; color: #2FCE71'>1,608</span>", LineAwesomeIcon.FIRE_SOLID, "#2FCE71");
        calsDonut.getStyle().set("margin-left", "var(--lumo-space-xl)");

        Component sleepsDonut = new Donut(540, 392, "Sleep<br><span style='font-weight: bold; color: #7247CF'>6h</span>", LineAwesomeIcon.MOON, "#7247CF");

        Component glassDonut = new Donut(6, 4, "Water<br><span style='font-weight: bold; color: #53A6E1'>4</span>", LineAwesomeIcon.GLASS_CHEERS_SOLID, "#53A6E1");
        glassDonut.getStyle().set("margin-left", "var(--lumo-space-xl)");

        HorizontalLayout l1 = new HorizontalLayout(runDonut, calsDonut);
        l1.setSpacing(false);
        HorizontalLayout l2 = new HorizontalLayout(sleepsDonut, glassDonut);
        l2.setSpacing(false);

        VerticalLayout layout = new VerticalLayout(l1, l2);
        layout.getStyle().set("border", "1px solid var(--lumo-contrast-10pct)");
        layout.getStyle().set("border-radius", "var(--lumo-border-radius-m)");

        return layout;
    }

    /**
     * lila sticker with a line chart showing visitors trend, title and subtitle
     * @return - the sticker
     */
    public static VerticalLayout createLineChartExample() {
        LineChartData chartData = new LineChartData(
                List.of(12, 10, 12, 11, 13, 16, 14, 10, 12, 11, 17, 18, 16, 17, 20, 14, 15, 13, 12, 14));
        chartData.tooltipFormat = "@V";

        VerticalLayout title = getTitleComponent("415", "Visitors (30 days)", "white", "#ad9edd");
        title.setAlignItems(FlexComponent.Alignment.START);

        SvgIcon icon = LineAwesomeIcon.USER_FRIENDS_SOLID.create();
        icon.addClassName("lineChartExample-icon");
        HorizontalLayout titleLayout = new HorizontalLayout(title, icon);
        titleLayout.setWidthFull();
        titleLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        titleLayout.setWidthFull();

        LineTrendChart trendChart = new LineTrendChart(chartData);
        trendChart.addClassName("lineChartExample-trendchart");
        trendChart.setWidthFull();
        trendChart.setHeight("5rem");

        Sticker sticker = new Sticker();
        sticker.add(titleLayout, trendChart);
        sticker.setPadding(false);
        sticker.setSpacing(false);
        sticker.setMargin(false);
        sticker.setWidthFull();
        sticker.setBackgroundColor("#6E4FCE");

        return sticker;
    }

    /**
     * Creates a title component with a title and subtitle.
     * @param title - the title text
     * @param subtitle - the subtitle text
     * @param titleTextColor - the color of the title text
     * @param subTitleTextColor - the color of the subtitle text
     * @return - the title component
     */
    public static VerticalLayout getTitleComponent(String title, String subtitle, String titleTextColor,
            String subTitleTextColor) {
        Span titleSpan = new Span(title);
        titleSpan.getStyle().set("color", titleTextColor);
        titleSpan.getStyle().set("font-size", "var(--lumo-font-size-xl)");
        titleSpan.getStyle().set("font-weight", "bold");

        Span subtitleSpan = new Span(subtitle);
        subtitleSpan.getStyle().set("color", subTitleTextColor);
        subtitleSpan.getStyle().set("font-size", "var(--lumo-font-size-s)");

        VerticalLayout layout = new VerticalLayout(titleSpan, subtitleSpan);
        layout.setPadding(false);
        layout.setSpacing(false);
        layout.setWidthFull();
        layout.getStyle().set("padding", "var(--lumo-space-m)");
        layout.setAlignItems(FlexComponent.Alignment.CENTER);

        return layout;
    }
}
