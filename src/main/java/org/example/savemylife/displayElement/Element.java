package org.example.savemylife.displayElement;

import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import lombok.Getter;
import org.example.savemylife.data.Task;
import org.example.savemylife.interfaces.StandardElement;

public class Element extends GridPane implements StandardElement {

    @Getter
    private final Task task;

    public Element(Task task) {
        this.task = task;
        setupConfig();
        setupLayout();
    }

    @Override
    public void setupConfig() {
        setPadding(new Insets(10));

        setHgap(10);
        setVgap(10);

        setColumns(5, 25, 25, 25);
    }

    @Override
    public void setupLayout() {
        add(new CheckBox(), 0, 0);
        add(new Label(task.getName()), 1, 0);
        add(new Label(task.getFrom()), 2, 0);
        add(new Label(task.getTo()), 3, 0);
    }

    private void setColumns(int ... colWidth) {
        for(int i : colWidth) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(i);

            getColumnConstraints().add(col);
        }
    }
}
