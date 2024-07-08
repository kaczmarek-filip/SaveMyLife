package org.example.savemylife.newView;

import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;

import java.io.File;

public class FieldsFactory {
    private final CreateComponent createComponent;

    public FieldsFactory(CreateComponent createComponent) {
        this.createComponent = createComponent;
    }


    void directoryChooser(Label label, TextField textField) {
        Button chooseButton = new Button("Choose Directory");

        Label selectedLabel = new Label("");

        chooseButton.setOnAction(e -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();

            File selectedDirectory = directoryChooser.showDialog(createComponent.getGridPane().getNewView());
            if (selectedDirectory != null) {
                selectedLabel.setText(selectedDirectory.getName());
                textField.setText(selectedDirectory.getAbsolutePath());
            }
        });

        add(label, chooseButton, selectedLabel);
    }


    void add(Control... controls) {

        for (int i = 0; i < controls.length; i++) {
            createComponent.getGridPane().add(controls[i], i, CreateComponent.rowIndex);
        }
        CreateComponent.rowIndex++;
    }
}