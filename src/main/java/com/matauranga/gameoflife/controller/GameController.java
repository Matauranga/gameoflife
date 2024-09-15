package com.matauranga.gameoflife.controller;

import com.matauranga.gameoflife.models.Grid;
import com.matauranga.gameoflife.services.GridService;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.springframework.stereotype.Controller;

import static com.matauranga.gameoflife.constants.GridFeatures.*;

@Controller
public class GameController {
    private final GridService gridService;

    public GameController(GridService gridService) {
        this.gridService = gridService;
    }

    public void constructSceneToGame(Stage stage) {

        Grid grid = new Grid();
        Group root = new Group();
        Scene scene = new Scene(root, SCENEWIDTH, SCENEHEIGHT, Color.BLACK);
        stage.setTitle("The Game of Life ... (Conway 1970)");
        stage.setScene(scene);

        gridService.drawGrid(root, grid);
        stage.show();

        //----- Run Timer
        Timeline littleCycle = new Timeline(new KeyFrame(Duration.millis(DELAYBETWEENEACHEVOLUTION),
                event -> gridService.calculateNextGridFrame(grid)));

        littleCycle.setCycleCount(Timeline.INDEFINITE);
        littleCycle.play();

        //TODO :
        scene.setOnKeyTyped(System.out::println);
        scene.setOnMouseClicked(System.out::println);
    }
}
