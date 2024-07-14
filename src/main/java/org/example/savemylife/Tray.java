package org.example.savemylife;

import javafx.stage.Stage;
import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class Tray {

    private final Stage stage;
    private TrayIcon trayIcon;
    private SystemTray systemTray;

    public Tray(Stage stage) {
        this.stage = stage;

        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray not supported");
            return;
        }

        closeRequest();
        trayIcon();
        popupMenu();
        clickListener();


        try {
            systemTray.add(trayIcon);
        } catch (AWTException e) {
            e.printStackTrace();
            System.out.println("Unable to add Tray Icon");
        }

    }

    private void clickListener() {
        trayIcon.addActionListener(e ->
                javafx.application.Platform.runLater(stage::show));
    }

    private void popupMenu() {
        PopupMenu popupMenu = new PopupMenu();

        MenuItem showItem = new MenuItem("Show");
        showItem.addActionListener(e ->
                javafx.application.Platform.runLater(stage::show));


        MenuItem exitItem = new MenuItem("Exit");
        exitItem.addActionListener(e -> {
            systemTray.remove(trayIcon);
            System.exit(0);
        });

        popupMenu.add(showItem);
        popupMenu.add(exitItem);
        trayIcon.setPopupMenu(popupMenu);

        //TODO: przycisk wymuszający backupy
    }

    @SneakyThrows
    private void trayIcon() {
        systemTray = SystemTray.getSystemTray();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("savemylife_16.png")) {
            if (inputStream != null) {
                Image image = ImageIO.read(inputStream);
                trayIcon = new TrayIcon(image, "SaveMyLife");
            } else {
                System.err.println("Resource not found: savemylife.png");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeRequest() {
        stage.setOnCloseRequest(event -> {
            event.consume();
            stage.hide();
        });
    }
}
