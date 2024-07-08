package org.example.savemylife.displayElement;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import org.example.savemylife.data.Task;
import org.example.savemylife.interfaces.StandardElement;

public class Element extends HBox implements StandardElement {

    private final Task task;

    public Element(Task task) {
        this.task = task;
        setupConfig();
        setupLayout();
    }

    @Override
    public void setupConfig() {
        setPadding(new Insets(10));
    }

    @Override
    public void setupLayout() {
        getChildren().add(new Label(task.getName()));
    }
}
