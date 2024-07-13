package org.example.savemylife;

import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.savemylife.data.Task;
import org.example.savemylife.interfaces.StandardElement;
import org.example.savemylife.infoView.InfoLayout;

public class InfoView extends Stage implements StandardElement {

    private static InfoView instance;
    private final InfoLayout infoLayout = new InfoLayout(this);

    private InfoView() {
        setTitle("Create task");
        setupConfig();
        setupLayout();

        instance = this;
    }

    @Override
    public void setupConfig() {
        setWidth(400);
        centerOnScreen();
        setResizable(false);

        initModality(Modality.APPLICATION_MODAL);

        setOnCloseRequest(event -> {
            instance = null;
        });
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
        infoLayout.getFieldFactory().setFields(task);
    }

    @Override
    public void close() {
        super.close();
        instance = null;
    }
}
