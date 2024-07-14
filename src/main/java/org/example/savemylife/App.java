package org.example.savemylife;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.example.savemylife.backup.Backup;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        new MainView();
        Platform.setImplicitExit(false);

//        Backup.main(new String[0]);

    }

    public static void main(String[] args) {
        launch();
    }
}