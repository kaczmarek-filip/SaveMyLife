package org.example.savemylife.mainView;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.example.savemylife.MainView;
import org.example.savemylife.displayElement.Element;
import org.example.savemylife.interfaces.StandardElement;

public class Scroll extends ScrollPane implements StandardElement {

    public Scroll() {
        setupConfig();
        setupLayout();
    }

    @Override
    public void setupConfig() {
//        setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }

    @Override
    public void setupLayout() {
        VBox vbox = new VBox();
        vbox.setPrefWidth(MainView.SCREEN_WIDTH);

        for (int i = 0; i < 50; i++) {
            vbox.getChildren().add(new Element("Element" + i));
        }

        setContent(vbox);
    }
}
