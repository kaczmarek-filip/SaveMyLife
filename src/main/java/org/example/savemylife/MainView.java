package org.example.savemylife;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.savemylife.interfaces.ElementConfig;
import org.example.savemylife.interfaces.ElementLayout;
import org.example.savemylife.mainView.MainVBox;

public class MainView extends Stage implements ElementConfig, ElementLayout {

    public MainView() {
        setupLayout();
        setupConfig();
    }


    @Override
    public void setupConfig() {
        setWidth(800);
        setHeight(600);
        centerOnScreen();
    }

    @Override
    public void setupLayout() {
        Scene scene = new Scene(new MainVBox());

        setScene(scene);
        show();
    }
}
