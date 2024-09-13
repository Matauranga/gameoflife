module hellofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires lombok;
    requires spring.context;


    opens com.matauranga.gameoflife to javafx.fxml;
    exports com.matauranga.gameoflife;
    //exports com.matauranga.gameoflife.controller;
    //opens com.matauranga.gameoflife.controller to javafx.fxml;
}