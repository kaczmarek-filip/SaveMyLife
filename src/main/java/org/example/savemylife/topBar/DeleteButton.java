package org.example.savemylife.topBar;

import org.example.savemylife.data.TaskJSON;
import org.example.savemylife.displayElement.Element;
import org.example.savemylife.interfaces.ElementListener;
import org.example.savemylife.interfaces.Trigger;
import org.example.savemylife.mainView.ScrollList;

public class DeleteButton extends TopBarButton implements ElementListener, Trigger {
    private static DeleteButton instance;

    private DeleteButton() {
        super("Delete");
        instance = this;
        oneClick();
    }

    public static DeleteButton getInstance() {
        if (instance == null) {
            instance = new DeleteButton();
        }
        return instance;
    }


    @Override
    public void oneClick() {
        setOnMouseClicked(event -> {
            for (Element element : selectedElements) {
                TaskJSON.getInstance().delete(element.getTask());
            }
            ScrollList.getInstance().refresh();
        });
    }

    @Override
    public void doubleClick() {

    }

    @Override
    public void trigger() {
        if (!selectedElements.isEmpty()) {
            setDisable(false);
        } else {
            setDisable(true);
        }
    }
}
