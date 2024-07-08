package org.example.savemylife;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        new MainView();
//        new NewView();


    }

    public static void main(String[] args) {
        launch();
    }
}