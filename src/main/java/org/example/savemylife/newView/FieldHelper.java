package org.example.savemylife.newView;

import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import org.controlsfx.control.Notifications;
import org.example.savemylife.NewView;
import org.example.savemylife.data.FrequencyEnum;
import org.example.savemylife.data.Task;
import org.example.savemylife.data.TaskJSON;
import org.example.savemylife.mainView.ScrollList;

import java.io.File;

public class FieldHelper {
    static void fileChooser(MainLayout grid, Button button, Label label, TextField field) {
        button.setOnAction(e -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();

            File selectedDirectory = directoryChooser.showDialog(grid.getNewView());
            if (selectedDirectory != null) {
                label.setText(selectedDirectory.getName());
                field.setText(selectedDirectory.getAbsolutePath());
            }
        });
    }

    static void frequencyFormatter(TextField field) {
        field.setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) {
                return change;
            }
            return null;
        }));
    }

    static void frequencyEnumComboBox(ComboBox<String> comboBox) {
        for (FrequencyEnum frequency : FrequencyEnum.values()) {
            comboBox.getItems().add(frequency.getLabel());
        }
        comboBox.setValue(FrequencyEnum.DAYS.getLabel());
    }

    static void buttonActionListener(Button button, FieldFactory f) {
        button.setOnAction(e -> {
            String name = f.nameField.getText();
            String from = f.fromField.getText();
            String to = f.toField.getText();
            String frequency = f.frequencyField.getText().trim();


            if (name.isEmpty() || from.isEmpty() || to.isEmpty() || frequency.isEmpty()) {
                Notifications.create().title("Warning").text("Some fields are empty").showWarning();
            } else {
                try {
                    Task task = new Task(
                            name,
                            new File(from),
                            new File(to),
                            Integer.parseInt(frequency)
                    );
                    TaskJSON.getInstance().add(task);
                    NewView.getInstance().close();
                    ScrollList.getInstance().refresh();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Notifications.create().title("Error").text(ex.getMessage()).showError();
                }
            }

        });
    }
}
