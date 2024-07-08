package org.example.savemylife;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.savemylife.interfaces.StandardElement;
import org.example.savemylife.newView.MainLayout;

public class NewView extends Stage implements StandardElement {

    private static NewView instance;

    public NewView() {
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
        Scene scene = new Scene(new MainLayout(this));

        setScene(scene);
        show();
    }

    public static NewView getInstance() {
        if (instance == null) {
            instance = new NewView();
        }
        return instance;
    }
}
