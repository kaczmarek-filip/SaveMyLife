package org.example.savemylife.mainView;

import javafx.scene.layout.VBox;
import org.example.savemylife.interfaces.StandardElement;


public class MainVBox extends VBox implements StandardElement {

    public MainVBox() {
        setupConfig();
        setupLayout();
    }


    @Override
    public void setupConfig() {
        setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }

    @Override
    public void setupLayout() {
        getChildren().addAll(
                new TopBar(),
                new Scroll()
        );
    }
}
