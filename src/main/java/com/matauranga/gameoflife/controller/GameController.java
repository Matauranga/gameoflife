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
    // Grid size
    static int gridSize = 200;
    // Initial percent of active cells
    static double nb = 0.1;
    // Delay between each evolution
    public static final int tempo = 100;
    // Scene dimensions
    static int width = 800;
    static int height = 900;
    // Cell size in pixels
    static int space = width / gridSize;

    public void constructSceneToGame(Stage stage) {

        grid = new Grid(gridSize, nb);
        circles = new Circle[gridSize][gridSize];

        Group root = new Group();
        Scene scene = new Scene(root, width, height, Color.BLACK);
        stage.setTitle("Life...");
        stage.setScene(scene);

        gridService.drawGrid(root, gridSize, nb, grid, space, circles);
        stage.show();

        //-----lancer le timer pour faire vivre la grid
        Timeline littleCycle = new Timeline(new KeyFrame(Duration.millis(tempo),
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
