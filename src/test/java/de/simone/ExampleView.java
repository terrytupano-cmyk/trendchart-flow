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

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("")
@CssImport("./trend-chart.css")
@PageTitle("TrendChart add-on for Vaadin Flow Demo")
public class ExampleView extends VerticalLayout {

    public ExampleView() {
        // the sticker to show in the main grid
        Component barChar = StickerFactory.createBarChartExample();
        Component donutsChart = StickerFactory.createDonutsExample();
        Component lineChart = StickerFactory.createLineChartExample();
        Component pieChart = StickerFactory.createPieChartExample();
        Component langChart = new LanguagesSticker();
        Component usersChart = new UsersSticker();
        Component repos = new RepositoriesSticker();
        repos.getStyle().set("grid-column", "1 / span 2");
        
        // the main grid layout to show the stickers
        Div charts = new Div(repos, pieChart, lineChart, langChart, barChar, donutsChart, getTodo(), usersChart);
        charts.getStyle().set("display", "grid");
        charts.getStyle().set("grid-template-columns", "auto auto auto");
        charts.getStyle().set("gap", "1rem");

        // the title
        H2 header = new H2("TrendChart Elements for Vaadin Flow");

        // the footer
        String description = """
                This is a demo view showcasing the TrendChart Elements for Vaadin Flow.
                <p style='color: gray; margin-left: 1rem; margin-right: 1rem;'><i>TrendChart Elements are web components to generate simple, light and responsive charts representing trends.
                <br>It is often useful to display some simple charts to represent a data visualization trend without the need of a big chart library.</i></p>
                <p>This implementation is a wraper from the original web component found <a href='https://github.com/WebLogin/trendchart-elements'>here</a>.
                """;
        Span footerSpan = new Span();
        footerSpan.getElement().setProperty("innerHTML", description);
        footerSpan.getStyle().set("font-size", "0.8rem");
        footerSpan.getStyle().set("text-align", "center");

        
        // add the title, the main layout and the footer to the view
        add(header, charts, footerSpan);
        setAlignItems(FlexComponent.Alignment.CENTER);
    }

    private static Component getTodo() {
        Span span = new Span();
        span.getElement().setProperty("innerHTML", "<p style='color: gray;'>TODO<br>Implement more examples</p>");
        span.getStyle().set("border", "1px solid var(--lumo-contrast-20pct)");
        span.getStyle().set("padding", "1rem");
        span.getStyle().set("border-radius", "var(--lumo-border-radius-m)");
        return span;
    }
}
