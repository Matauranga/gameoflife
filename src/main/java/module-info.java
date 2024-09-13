module hellofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires lombok;
    requires spring.context;
    requires spring.beans;


    opens com.matauranga.gameoflife to javafx.fxml;
    exports com.matauranga.gameoflife;
    exports com.matauranga.gameoflife.controller;
    opens com.matauranga.gameoflife.controller to javafx.fxml;

    exports com.matauranga.gameoflife.services;
    opens com.matauranga.gameoflife.services to javafx.fxml;
}