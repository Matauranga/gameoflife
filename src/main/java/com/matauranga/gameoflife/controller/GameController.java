package com.matauranga.gameoflife.controller;

import com.matauranga.gameoflife.models.Grid;
import com.matauranga.gameoflife.services.GridService;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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

    // Graphical elements representing the grid
    static Grid grid;
    // Graphical elements representing the cells
    public static Circle[][] circles;

    public void constructSceneToGame(Stage stage) {

        grid = new Grid(GRIDSIZE, INITIALPERCENTOFACTIVECELLS);
        circles = new Circle[GRIDSIZE][GRIDSIZE];

        Group root = new Group();
        Scene scene = new Scene(root, SCENEWIDTH, SCENEHEIGHT, Color.BLACK);
        stage.setTitle("The Game of Life ... (Conway 1970)");
        stage.setScene(scene);

        gridService.drawGrid(root, GRIDSIZE, INITIALPERCENTOFACTIVECELLS, grid, CELLSIZEINPIXELS, circles);
        stage.show();

        //-----lancer le timer pour faire vivre la grid
        Timeline littleCycle = new Timeline(new KeyFrame(Duration.millis(DELAYBETWEENEACHEVOLUTION),
                event -> {
                    gridService.move(grid);
                    gridService.calculate(grid);
                }));

        littleCycle.setCycleCount(Timeline.INDEFINITE);
        littleCycle.play();

        scene.setOnKeyTyped(System.out::println);
        scene.setOnMouseClicked(System.out::println);

    }

}
