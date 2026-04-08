package de.simone;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Sticker extends VerticalLayout {

    public Sticker() {
        super();

        getStyle().set("border", "1px solid var(--lumo-contrast-20pct)");
        getStyle().set("border-radius", "var(--lumo-border-radius-m)");
    }

        void setBackgroundColor(String color) {
        getStyle().set("background-color", color);
    }
}
