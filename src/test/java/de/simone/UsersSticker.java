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
import java.util.Map;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import de.simone.trendchart.CssVariable;
import de.simone.trendchart.StackChartData;
import de.simone.trendchart.StackTrendChart;

public class UsersSticker extends Sticker {

    private Map<String, String> users;

    public UsersSticker() {
        users = Map.of(
                "Ava Smith", "https://images.unsplash.com/photo-1530785602389-07594beb8b73?&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80",
                "Emma Johnson", "https://images.unsplash.com/photo-1553514029-1318c9127859?&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80",
                "Mia Williams", "https://images.unsplash.com/photo-1580489944761-15a19d654956?&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80");

        HorizontalLayout user1 = getChartItem(68, "Ava Smith", "#54C430");
        HorizontalLayout user2 = getChartItem(89, "Emma Johnson", "#54C430");
        HorizontalLayout user3 = getChartItem(24, "Mia Williams", "#FF416C");

        setAlignItems(Alignment.CENTER);
        add(user1, user2, user3);
    }

    private HorizontalLayout getChartItem(double value, String userName, String color) {

        // this object store the data for the StackTrendChart to draw
        StackChartData chartData = new StackChartData(List.of(value));
        chartData.max = 100;
        chartData.horizontal = true;
        chartData.radius = 4;
        chartData.gap = 3;

        // this is the actual trendchard element. a simple horizontal bar.
        StackTrendChart trendChart = new StackTrendChart(chartData);
        trendChart.setHeight("0.8rem");
        trendChart.setWidthFull();
        trendChart.setCssVariable(CssVariable.shape_color, color);
        trendChart.setCssVariable(CssVariable.residual_color, color);
        trendChart.setCssVariable(CssVariable.residual_opacity, 0.1);

        // colored text 
        Span name = new Span(userName);
        name.getStyle().set("font-size", "var(--lumo-font-size-s)");
        Div wrapper = new Div(name, trendChart);

        // user avatar
        String url = users.get(userName);
        Image image = new Image(url, userName);
        image.setWidth("2.2rem");
        image.setHeight("2.2rem");
        image.getStyle().set("border-radius", "50%");

        HorizontalLayout item = new HorizontalLayout(image, wrapper);
        item.setWidthFull();

        return item;
    }
}
