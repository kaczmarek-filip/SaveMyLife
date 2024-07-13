package org.example.savemylife.mainView;

import javafx.scene.control.Button;
import org.example.savemylife.InfoView;
import org.example.savemylife.interfaces.ElementListener;

public class TopBarButton extends Button implements ElementListener {

    public TopBarButton(String s) {
        super(s);

        oneClick();
    }

    @Override
    public void oneClick() {
        setOnMouseClicked(mouseEvent -> {
            new InfoView();
        });
    }

    @Override
    public void doubleClick() {

    }
}
