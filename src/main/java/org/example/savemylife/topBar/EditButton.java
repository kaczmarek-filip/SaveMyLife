package org.example.savemylife.topBar;

import org.example.savemylife.InfoView;
import org.example.savemylife.data.Task;
import org.example.savemylife.interfaces.ElementListener;
import org.example.savemylife.interfaces.Trigger;
import org.example.savemylife.mainView.ScrollList;

public class EditButton extends TopBarButton implements ElementListener, Trigger {

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

        if (selectedElements.size() == 1) {
            setDisable(false);
            task = selectedElements.getFirst().getTask();
        } else {
            setDisable(true);
        }
    }
}
