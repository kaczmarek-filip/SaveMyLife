package org.example.savemylife.displayElement;

import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import lombok.Getter;
import org.example.savemylife.data.Task;
import org.example.savemylife.interfaces.ElementListener;
import org.example.savemylife.interfaces.StandardElement;

public class Element extends GridPane implements StandardElement, ElementListener {

    @Getter
    private final Task task;

    public Element(Task task) {
        this.task = task;
        setupConfig();
        setupLayout();

        doubleClick();
    }

    @Override
    public void setupConfig() {
        setPadding(new Insets(10));

        setHgap(10);
        setVgap(10);

        setColumns(5, 25, 30, 30, 10);
    }

    @Override
    public void setupLayout() {
        add(new CheckBox(), 0, 0);
        add(new Label(task.getName()), 1, 0);
        add(new Label(task.getFrom().getName()), 2, 0);
        add(new Label(task.getTo().getName()), 3, 0);
        add(new Label(String.valueOf(task.getFrequency())), 4, 0);
    }

    private void setColumns(int ... colWidth) {
        for(int i : colWidth) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(i);
            col.setMaxWidth(i);

            getColumnConstraints().add(col);
        }
    }

    @Override
    public void oneClick() {

    }

    @Override
    public void doubleClick() {
        setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                System.out.println("Clicked");
            }
        });
    }
}
