package org.example.savemylife;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.savemylife.interfaces.StandardElement;
import org.example.savemylife.mainView.MainVBox;

public class MainView extends Stage implements StandardElement {

    public static final double SCREEN_WIDTH = 800;
    public static final double SCREEN_HEIGHT = 600;

    public MainView() {
        setupLayout();
        setupConfig();
    }


    @Override
    public void setupConfig() {
        setWidth(SCREEN_WIDTH);
        setHeight(SCREEN_HEIGHT);
        centerOnScreen();
    }

    @Override
    public void setupLayout() {
        Scene scene = new Scene(new MainVBox());

        setScene(scene);
        show();
    }
}
