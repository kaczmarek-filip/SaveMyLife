package org.example.savemylife;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.savemylife.data.Task;
import org.example.savemylife.data.TaskJSON;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();

        new MainView();


//        Task task = new Task("name", "From", "to");
//
//        TaskJSON.getInstance().add(task);
//        TaskJSON.getInstance().add(new Task("name2", "From", "to"));
    }

    public static void main(String[] args) {
        launch();
    }
}