package org.example.savemylife.topBar;

import javafx.scene.control.Button;
import org.example.savemylife.InfoView;
import org.example.savemylife.data.Task;
import org.example.savemylife.displayElement.Element;
import org.example.savemylife.interfaces.ElementListener;
import org.example.savemylife.interfaces.Trigger;
import org.example.savemylife.mainView.ScrollList;

import java.util.ArrayList;

public class EditButton extends Button implements ElementListener, Trigger {

    private static EditButton instance;
    private Task task;

    private EditButton() {
        super("Edit");
        instance = this;
        oneClick();
    }

    public static EditButton getInstance() {
        if (instance == null) {
            instance = new EditButton();
        }
        return instance;
    }

    @Override
    public void oneClick() {
        setOnMouseClicked(mouseEvent -> {
            ScrollList.getInstance().getSelectionModel().getSelectedItems().forEach(item -> {
                InfoView.getInstance().setFields(task);
            });
        });
    }

    @Override
    public void doubleClick() {

    }

    @Override
    public void trigger() {
        ArrayList<Element> selectedElements = new ArrayList<>(ScrollList.getInstance().getSelectionModel().getSelectedItems());

        if (selectedElements.size() == 1) {
            setVisible(true);
            task = selectedElements.getFirst().getTask();
        } else {
            setVisible(false);
        }
    }
}
