package org.example.savemylife.newView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import lombok.Getter;
import org.example.savemylife.InfoView;
import org.example.savemylife.interfaces.StandardElement;

@Getter
public class MainLayout extends GridPane implements StandardElement {

    private final InfoView infoView;
    private FieldFactory fieldFactory;

    public MainLayout(InfoView infoView) {
        this.infoView = infoView;
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
        fieldFactory = new FieldFactory(this);
    }


}
