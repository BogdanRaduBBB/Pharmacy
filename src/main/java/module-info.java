module com.example.drugstorev2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires lombok;

    exports pojo;
    opens pojo to javafx.fxml;
    exports interfaces;
    opens interfaces to javafx.fxml;
    exports main;
    opens main to javafx.fxml;
    exports gui.controllers;
    opens gui.controllers to javafx.fxml;
}