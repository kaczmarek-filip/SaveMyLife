package org.example.savemylife.mainView;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import org.example.savemylife.data.Task;
import org.example.savemylife.data.TaskJSON;
import org.example.savemylife.displayElement.Element;
import org.example.savemylife.interfaces.StandardElement;
import org.example.savemylife.topBar.TopBarButton;

import java.util.List;

public class ScrollList extends ListView<Element> implements StandardElement {

    private ObservableList<Element> items = FXCollections.observableArrayList();
    private static ScrollList instance;

    private ScrollList() {
        instance = this;
        getTasks();

        setItems(items);
        setStyle("-fx-fit-to-height: 100%");

        setupConfig();
        TopBarButton.parentTrigger();
    }

    @Override
    public void setupConfig() {
        getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        getSelectionModel().getSelectedItems().addListener((ListChangeListener<Element>) change -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    for (Element element : change.getAddedSubList()) {
                        element.getCheckBox().setSelected(true);
                    }
                }
                if (change.wasRemoved()) {
                    for (Element element : change.getRemoved()) {
                        element.getCheckBox().setSelected(false);
                    }
                }
            }

            TopBarButton.parentTrigger();
        });
    }

    @Override
    public void setupLayout() {

    }

    private void getTasks() {
        List<Task> tasks = TaskJSON.getInstance().getTaskList();

        tasks.forEach(task -> {
            Element element = new Element(task);
            items.add(element);
        });
    }

    public static ScrollList getInstance() {
        if (instance == null) {
            instance = new ScrollList();
        }
        return instance;
    }
    public void refresh() {
        items.clear();
        getTasks();
        setItems(items);
    }
}
