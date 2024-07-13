package org.example.savemylife.topBar;

import javafx.scene.control.Button;
import org.example.savemylife.InfoView;
import org.example.savemylife.interfaces.ElementListener;

public class CreateButton extends Button implements ElementListener {

    public CreateButton(String s) {
        super(s);

        oneClick();
    }

    @Override
    public void oneClick() {
        setOnMouseClicked(mouseEvent -> {
            InfoView.getInstance();
        });
    }

    @Override
    public void doubleClick() {

    }
}
