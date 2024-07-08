package org.example.savemylife.mainView;

import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.example.savemylife.interfaces.StandardElement;


public class MainVBox extends VBox implements StandardElement {

    public MainVBox() {
        setupConfig();
        setupLayout();
    }


    @Override
    public void setupConfig() {
        setStyle("-fx-fill-height: 100%");
    }

    @Override
    public void setupLayout() {
        ScrollList scrollList = new ScrollList();
        VBox.setVgrow(scrollList, Priority.ALWAYS);
        getChildren().addAll(
                new TopBar(),
                scrollList
        );
    }
}
