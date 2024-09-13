package com.matauranga.gameoflife.services;

import com.matauranga.gameoflife.models.Cell;
import com.matauranga.gameoflife.models.Grid;
import javafx.scene.shape.Circle;

public interface CellService {

    void evoluer(Grid grid, Cell cell);

    void switchColor(Cell cell);

    void avancer(Cell cell);

}
