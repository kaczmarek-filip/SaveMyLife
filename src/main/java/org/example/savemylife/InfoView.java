package org.example.savemylife;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.savemylife.data.Task;
import org.example.savemylife.interfaces.StandardElement;
import org.example.savemylife.newView.InfoLayout;

public class InfoView extends Stage implements StandardElement {

    private static InfoView instance;
    private final InfoLayout infoLayout = new InfoLayout(this);

    public InfoView() {
        setTitle("Create task");
        setupConfig();
        setupLayout();

        instance = this;
    }

    @Override
    public void setupConfig() {
        setWidth(400);
//        setHeight(400);
        centerOnScreen();
        setResizable(false);
    }

    @Override
    public void setupLayout() {
        Scene scene = new Scene(infoLayout);

        setScene(scene);
        show();
    }

    public static InfoView getInstance() {
        if (instance == null) {
            instance = new InfoView();
        }
        return instance;
    }

    public void setFields(Task task) {
        infoLayout.getFieldFactory().getNameField().setText(task.getName());
        infoLayout.getFieldFactory().getFrequencyField().setText(String.valueOf(task.getFrequency()));
        infoLayout.getFieldFactory().getFrequencyComboBox().setValue(task.getFrequencyEnum().getLabel());

        infoLayout.getFieldFactory().getFromField().setText(task.getFrom().getAbsolutePath());
        infoLayout.getFieldFactory().getFromSelectedLabel().setText(task.getFrom().getName());

        infoLayout.getFieldFactory().getToField().setText(task.getTo().getAbsolutePath());
        infoLayout.getFieldFactory().getToSelectedLabel().setText(task.getTo().getName());
    }
}
