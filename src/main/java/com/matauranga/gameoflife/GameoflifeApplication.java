package com.matauranga.gameoflife;

import com.matauranga.gameoflife.controller.GameController;
import com.matauranga.gameoflife.services.GridService;
import com.matauranga.gameoflife.services.GridServiceImpl;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameoflifeApplication extends Application {

    @Override
    public void start(Stage stage) {
        GridService gridService = new GridServiceImpl();
        GameController gameController = new GameController(gridService);
        gameController.constructSceneToGame(stage);
    }

    public static void main(String[] args) {
        launch();
    }

}
