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
    TextField fromField = new TextField();
    Label fromSelectedLabel = new Label("");
    TextField toField = new TextField();
    Label toSelectedLabel = new Label("");
    ComboBox<String> frequencyComboBox = new ComboBox<>();

    public FieldFactory(InfoLayout grid) {
        this.grid = grid;

        name();
        from();
        to();
        frequency();
        submitButton();
    }

    private void name() {
        Label label = new Label("Name");

        add(0, label, nameField);
    }

    private void from() {
        Label label = new Label("From");
        Button choose = new Button("Choose directory");

        fileChooser(grid, choose, fromSelectedLabel, fromField);

        add(1, label, choose, fromSelectedLabel);
    }

    private void to() {
        Label label = new Label("To");
        Button choose = new Button("Choose directory");

        fileChooser(grid, choose, toSelectedLabel, toField);

        add(2, label, choose, toSelectedLabel);
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

        fromField.setText(task.getFrom().getAbsolutePath());
        fromSelectedLabel.setText(task.getFrom().getName());

        toField.setText(task.getTo().getAbsolutePath());
        toSelectedLabel.setText(task.getTo().getName());
    }
}
