package org.example.savemylife.topBar;

import javafx.scene.control.Button;
import org.example.savemylife.displayElement.Element;
import org.example.savemylife.interfaces.Trigger;
import org.example.savemylife.mainView.ScrollList;

import java.util.ArrayList;

public abstract class TopBarButton extends Button implements Trigger {

    protected static ArrayList<Element> selectedElements;

    public TopBarButton(String s) {
        super(s);
    }

    public static void parentTrigger() {
        selectedElements = new ArrayList<>(ScrollList.getInstance().getSelectionModel().getSelectedItems());

        EditButton.getInstance().trigger();
        DeleteButton.getInstance().trigger();
    }

}
