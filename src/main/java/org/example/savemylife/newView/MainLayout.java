package org.example.savemylife.newView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import lombok.Getter;
import org.example.savemylife.NewView;
import org.example.savemylife.interfaces.StandardElement;

public class MainLayout extends GridPane implements StandardElement {

    @Getter
    private final NewView newView;

    public MainLayout(NewView newView) {
        this.newView = newView;
        setupConfig();
        setupLayout();
    }

    @Override
    public void setupConfig() {
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(20));

        setAlignment(Pos.CENTER);
    }

    @Override
    public void setupLayout() {
        new FieldFactory(this);
    }


}
