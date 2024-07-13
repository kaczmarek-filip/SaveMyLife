package org.example.savemylife.displayElement;

import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import lombok.Getter;
import org.example.savemylife.InfoView;
import org.example.savemylife.data.Task;
import org.example.savemylife.interfaces.ElementListener;
import org.example.savemylife.interfaces.StandardElement;
import org.example.savemylife.mainView.ScrollList;
import org.example.savemylife.topBar.EditButton;

import java.io.File;
@Getter
public class Element extends GridPane implements StandardElement, ElementListener {


    private final Task task;
    private CheckBox checkBox = new CheckBox();;

    public Element(Task task) {
        this.task = task;
        setupConfig();
        setupLayout();

        doubleClick();
//        mouseEntered();
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
        Label fromLabel = new Label(task.getFrom().getName());
        Label toLabel = new Label(task.getTo().getName());

        setTooltip(fromLabel, task.getFrom());
        setTooltip(toLabel, task.getTo());

        checkBox.setOnAction(event -> {
            ScrollList.getInstance().getSelectionModel().clearSelection();
            if (checkBox.isSelected()) {
                ScrollList.getInstance().getSelectionModel().select(this);
            } else {
                ScrollList.getInstance().getSelectionModel().clearSelection(ScrollList.getInstance().getSelectionModel().getSelectedIndex());
            }
            EditButton.getInstance().trigger();
            System.out.println(ScrollList.getInstance().getSelectionModel().getSelectedItems());
        });

        add(checkBox, 0, 0);
        add(new Label(task.getName()), 1, 0);
        add(fromLabel, 2, 0);
        add(toLabel, 3, 0);
        add(new Label(task.getFrequencyWithUtil()), 4, 0);
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
                InfoView.getInstance().setFields(task);
            }
        });
    }
    private void setTooltip(Label label, File file) {
        Tooltip tooltip = new Tooltip(file.getAbsolutePath());
        tooltip.setShowDelay(new Duration(500));
        Tooltip.install(label, tooltip);
    }
}
