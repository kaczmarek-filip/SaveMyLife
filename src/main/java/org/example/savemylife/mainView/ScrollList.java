package org.example.savemylife.mainView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import org.example.savemylife.displayElement.Element;
import org.example.savemylife.interfaces.StandardElement;

public class ScrollList extends ListView<Element> implements StandardElement {

    public ScrollList() {
        ObservableList<Element> items = FXCollections.observableArrayList(
                new Element("Test"),
                new Element("Test"),
                new Element("Test"),
                new Element("Test"),
                new Element("Test"),
                new Element("Test"),
                new Element("Test"),
                new Element("Test"),
                new Element("Test"),
                new Element("Test"),
                new Element("Test"),
                new Element("Test"),
                new Element("Test"),
                new Element("Test"),
                new Element("Test"),
                new Element("Test"),
                new Element("Test"),
                new Element("Test"),
                new Element("Test"),
                new Element("Test"),
                new Element("Test"),
                new Element("Test"),
                new Element("Test"),
                new Element("Test"),
                new Element("Test"),
                new Element("Test"),
                new Element("Test")
        );
        setItems(items);
        setStyle("-fx-fit-to-height: 100%");
    }

    @Override
    public void setupConfig() {

    }

    @Override
    public void setupLayout() {
    }
}
