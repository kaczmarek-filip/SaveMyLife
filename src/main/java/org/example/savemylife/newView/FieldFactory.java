package org.example.savemylife.newView;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import org.example.savemylife.interfaces.FieldCreator;

import static org.example.savemylife.newView.FieldHelper.*;

public class FieldFactory implements FieldCreator {

    private final MainLayout grid;

    TextField nameField = new TextField();
    TextField frequencyField = new TextField();
    TextField fromField = new TextField();
    TextField toField = new TextField();
    ComboBox<String> frequencyComboBox = new ComboBox<>();

    public FieldFactory(MainLayout grid) {
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
        Label selected = new Label("");

        fileChooser(grid, choose, selected, fromField);

        add(1, label, choose, selected);
    }

    private void to() {
        Label label = new Label("To");
        Button choose = new Button("Choose directory");
        Label selected = new Label("");

        fileChooser(grid, choose, selected, toField);

        add(2, label, choose, selected);
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
}
