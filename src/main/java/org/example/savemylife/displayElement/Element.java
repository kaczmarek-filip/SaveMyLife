package org.example.savemylife.displayElement;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import org.example.savemylife.interfaces.StandardElement;

public class Element extends HBox implements StandardElement {

    private final String string;

    public Element(String string) {
        this.string = string;
        setupConfig();
        setupLayout();
    }

    @Override
    public void setupConfig() {
        setPadding(new Insets(10));
    }

    @Override
    public void setupLayout() {
        getChildren().add(new Label(string));
    }
}
