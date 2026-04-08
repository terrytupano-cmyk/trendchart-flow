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

/**
 * Enum for the CSS variables that can be used to customize the charts.
 */
public enum CssVariable {
    // -----------------------------
    // available for all charts
    // -----------------------------
    shape_color,
    shape_opacity,
    residual_color,
    residual_opacity,
    tooltip_font_color,
    tooltip_font_size,
    tooltip_font_weight,
    tooltip_radius,
    tooltip_padding,
    tooltip_background,
    tooltip_shadow,

    // -----------------------------
    // Line chart
    // -----------------------------
    area_color,
    area_opacity,
    point_inner_color,
    point_border_color,
    point_opacity,
    point_opacity_active,

    // -----------------------------
    // Bar / Stack / Pie chart
    // -----------------------------
    /**
     * only 10 colors are supported for now, but it should be enough for most use
     * cases. if not. the user can always set custom properties like
     * getElement().getStyle().set("--shape-color-11", "value");
     * 
     */
    shape_color_1,
    shape_color_2,
    shape_color_3,
    shape_color_4,
    shape_color_5,
    shape_color_6,
    shape_color_7,
    shape_color_8,
    shape_color_9,
    shape_color_10,
    shape_opacity_active;

    /**
     * @return the css variable name in the format suitable for ts components
     * 
     * @return - the variable 
     */
    public String getCssVariable() {
        return "--" + name().replace("_", "-");
    }
}
