package org.example.savemylife;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.savemylife.data.Task;
import org.example.savemylife.interfaces.StandardElement;
import org.example.savemylife.newView.MainLayout;

public class InfoView extends Stage implements StandardElement {

    private static InfoView instance;
    private final MainLayout mainLayout = new MainLayout(this);

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
        Scene scene = new Scene(mainLayout);

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
        mainLayout.getFieldFactory().getNameField().setText(task.getName());
        mainLayout.getFieldFactory().getFrequencyField().setText(String.valueOf(task.getFrequency()));
        mainLayout.getFieldFactory().getFrequencyComboBox().setValue(task.getFrequencyEnum().getLabel());

        mainLayout.getFieldFactory().getFromField().setText(task.getFrom().getAbsolutePath());
        mainLayout.getFieldFactory().getFromSelectedLabel().setText(task.getFrom().getName());

        mainLayout.getFieldFactory().getToField().setText(task.getTo().getAbsolutePath());
        mainLayout.getFieldFactory().getToSelectedLabel().setText(task.getTo().getName());
    }
}
