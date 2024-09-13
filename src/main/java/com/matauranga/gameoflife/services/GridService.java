package com.matauranga.gameoflife.services;

import com.matauranga.gameoflife.models.Grid;
import javafx.scene.Group;
import javafx.scene.shape.Circle;

public interface GridService {

    //    void drawGrid(Group root);
    void drawGrid(Group root, int gridSize, double nb, Grid grid, int espace, Circle[][] circles);

    void calculate(Grid grid);

    void move(Grid grid);


}
