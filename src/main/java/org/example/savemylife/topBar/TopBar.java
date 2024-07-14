package org.example.savemylife.topBar;

import javafx.scene.control.ToolBar;
import org.example.savemylife.interfaces.StandardElement;

public class TopBar extends ToolBar implements StandardElement {

    public TopBar() {
        setupConfig();
        setupLayout();
    }

    @Override
    public void setupLayout() {
        getItems().add(new CreateButton("New"));
        getItems().add(EditButton.getInstance());
        getItems().add(DeleteButton.getInstance());
    }

    @Override
    public void setupConfig() {

    }
}
