package org.example.savemylife.infoView;

import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import org.controlsfx.control.Notifications;
import org.example.savemylife.InfoView;
import org.example.savemylife.data.FrequencyEnum;
import org.example.savemylife.data.Task;
import org.example.savemylife.data.TaskJSON;
import org.example.savemylife.mainView.ScrollList;

import java.io.File;

public class FieldHelper {
    static void fileChooser(InfoLayout grid, Button button, Label label, TextField field) {
        button.setOnAction(e -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();

            File selectedDirectory = directoryChooser.showDialog(grid.getInfoView());
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
            FrequencyEnum frequencyEnum = FrequencyEnum.fromString(f.frequencyComboBox.getValue());


            if (name.isEmpty() || from.isEmpty() || to.isEmpty() || frequency.isEmpty()) {
                Notifications.create().title("Warning").text("Some fields are empty").showWarning();
            } else {
                try {
                    Task task = new Task(
                            name,
                            new File(from),
                            new File(to),
                            Integer.parseInt(frequency),
                            frequencyEnum
                    );



                    if (f.getTask() == null) {
                        TaskJSON.getInstance().add(task);
                        System.out.println("Created new task");
                    } else {
                        TaskJSON.getInstance().update(f.getTask().getId(), task);
                        System.out.println("Updated task");
                    }



                    InfoView.getInstance().close();
                    ScrollList.getInstance().refresh();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Notifications.create().title("Error").text(ex.getMessage()).showError();
                }
            }

        });
    }
}
