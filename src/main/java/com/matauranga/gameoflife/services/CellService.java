package com.matauranga.gameoflife.services;

import com.matauranga.gameoflife.models.Cell;
import com.matauranga.gameoflife.models.Grid;

public interface CellService {

    void calculateNextCellState(Grid grid, Cell cell);

    void switchCellColor(Cell cell);

    void changeCellStateToNextState(Cell cell);

}
