module org.example.savemylife {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.desktop;
    requires static lombok;
    requires com.fasterxml.jackson.databind;

    opens org.example.savemylife to javafx.fxml;
    exports org.example.savemylife;
    exports org.example.savemylife.displayElement;
    exports org.example.savemylife.data;
    opens org.example.savemylife.displayElement to javafx.fxml;
}