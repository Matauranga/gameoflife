package com.matauranga.gameoflife.services;

import com.matauranga.gameoflife.models.Grid;
import javafx.scene.Group;

public interface GridService {

    void drawGrid(Group root, Grid grid);

    void calculateNextGridFrame(Grid grid);
}
