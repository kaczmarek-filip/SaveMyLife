package org.example.savemylife.newView;

import javafx.geometry.HPos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import lombok.Getter;
import org.example.savemylife.NewView;
import org.example.savemylife.data.FrequencyEnum;
import org.example.savemylife.data.Task;
import org.example.savemylife.data.TaskJSON;


public class CreateComponent extends Control {

    @Getter
    private final MainLayout gridPane;
    static int rowIndex = 0;
    private final FieldsFactory fieldsFactory = new FieldsFactory(this);


    static TextField frequencyField = new TextField();
    static TextField nameField = new TextField();
    static TextField fromTextField = new TextField();
    static TextField toTextField = new TextField();


    public CreateComponent(FieldsEnum fieldsEnum, MainLayout gridPane) {
        this.gridPane = gridPane;

        switch (fieldsEnum){
            case NAME -> name();
            case FROM -> from();
            case TO -> to();
            case FREQUENCY -> frequency();
            case BUTTON -> submitButton();
        }

    }

    private void frequency() {
        Label label = new Label("Frequency");
        frequencyField.setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) {
                return change;
            }
            return null;
        }));

        ComboBox<String> comboBox = new ComboBox<>();
        for (FrequencyEnum frequency : FrequencyEnum.values()) {
            comboBox.getItems().add(frequency.getLabel());
        }
        comboBox.setValue(FrequencyEnum.DAYS.getLabel());

        fieldsFactory.add(label, frequencyField, comboBox);
    }

    private void from() {
        Label label = new Label("From");
        fieldsFactory.directoryChooser(label, fromTextField);
    }
    private void to() {
        Label label = new Label("To");
        fieldsFactory.directoryChooser(label, toTextField);
    }

    private void name() {
        Label label = new Label("Name");
        fieldsFactory.add(label, nameField);
    }

    private void submitButton() {
        Button button = new Button("Submit");
        button.setOnAction(e -> {
            Task task = new Task();
            task.setName(nameField.getText());
            task.setFrom(fromTextField.getText());
            task.setTo(toTextField.getText());
            String frequency = frequencyField.getText().trim();
            if (!frequency.isEmpty()) {
                task.setFrequency(Integer.parseInt(frequency));
            }
            //TODO: Jeśli puste

            try {
                TaskJSON.getInstance().add(task);
                NewView.getInstance().close();
            } catch (Exception ex) {
                ex.printStackTrace();
                //TODO: błąd
            }
        });

        gridPane.add(button, 2, gridPane.getColumnCount() + 2);
        GridPane.setHalignment(button, HPos.RIGHT);
    }
}
