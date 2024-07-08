package org.example.savemylife.mainView;

import javafx.scene.control.ToolBar;
import org.example.savemylife.interfaces.StandardElement;

public class TopBar extends ToolBar implements StandardElement {

    public TopBar() {
        setupConfig();
        setupLayout();
    }

    @Override
    public void setupLayout() {
        getItems().add(new TopBarButton("New"));
    }

    @Override
    public void setupConfig() {

    }
}
