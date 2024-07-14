package org.example.savemylife.infoView;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import lombok.Getter;
import org.example.savemylife.data.Task;
import org.example.savemylife.interfaces.FieldCreator;

import static org.example.savemylife.infoView.FieldHelper.*;
@Getter
public class FieldFactory implements FieldCreator {

    private final InfoLayout grid;
    private Task task;

    TextField nameField = new TextField();
    TextField frequencyField = new TextField();
    TextField sourceField = new TextField();
    Label sourceSelectedLabel = new Label("");
    TextField targetField = new TextField();
    Label targetSelectedLabel = new Label("");
    ComboBox<String> frequencyComboBox = new ComboBox<>();

    public FieldFactory(InfoLayout grid) {
        this.grid = grid;

        name();
        source();
        target();
        frequency();
        submitButton();
    }

    private void name() {
        Label label = new Label("Name");

        add(0, label, nameField);
    }

    private void source() {
        Label label = new Label("Source");
        Button choose = new Button("Choose directory");

        fileChooser(grid, choose, sourceSelectedLabel, sourceField);

        add(1, label, choose, sourceSelectedLabel);
    }

    private void target() {
        Label label = new Label("Target");
        Button choose = new Button("Choose directory");

        fileChooser(grid, choose, targetSelectedLabel, targetField);

        add(2, label, choose, targetSelectedLabel);
    }

    private void frequency() {
        Label label = new Label("Frequency");


        frequencyFormatter(frequencyField);

        frequencyEnumComboBox(frequencyComboBox);

        add(3, label, frequencyField, frequencyComboBox);
    }

    private void submitButton() {
        Button button = new Button("Submit");

        buttonActionListener(button, this);

        grid.add(button, 0, 5, grid.getColumnCount(), 3);

        button.setPrefWidth(400);

        GridPane.setHalignment(button, HPos.CENTER);
        GridPane.setValignment(button, VPos.BOTTOM);
    }

    @Override
    public void add(int row, Control... controls) {
        for (int i = 0; i < controls.length; i++) {
            grid.add(controls[i], i, row);
        }
    }
    public void setFields(Task task) {
        this.task = task;

        nameField.setText(task.getName());
        frequencyField.setText(String.valueOf(task.getFrequency()));
        frequencyComboBox.setValue(task.getFrequencyEnum().getLabel());

        sourceField.setText(task.getSource().getAbsolutePath());
        sourceSelectedLabel.setText(task.getSource().getName());

        targetField.setText(task.getTarget().getAbsolutePath());
        targetSelectedLabel.setText(task.getTarget().getName());
    }
}
