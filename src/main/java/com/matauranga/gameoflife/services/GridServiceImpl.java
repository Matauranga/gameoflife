package com.matauranga.gameoflife.services;

import com.matauranga.gameoflife.models.Cell;
import com.matauranga.gameoflife.models.Grid;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import org.springframework.stereotype.Service;

import static com.matauranga.gameoflife.constants.GridColor.COULACTIVE;
import static com.matauranga.gameoflife.constants.GridColor.COULDESACTIVE;

@Service
public class GridServiceImpl implements GridService {

    private final CellService cellService;

    public GridServiceImpl(CellService cellService) {
        this.cellService = cellService;
    }

    @Override
    public void drawGrid(Group root, int gridSize, double nb, Grid grid, int space, Circle[][] circles) {

        Cell[][] grille = grid.getGrid();
        int rayon = space / 2;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                Cell cell = grille[i][j];
                circles[i][j] = new Circle((j * space + rayon), (i * space + rayon), rayon);
                if (cell.isAlive()) {
                    circles[i][j].setFill(COULACTIVE);
                } else {
                    circles[i][j].setFill(COULDESACTIVE);
                }
                cell.setCircle(circles[i][j]);
                root.getChildren().add(circles[i][j]);
            }
        }

    }

    @Override
    public void calculate(Grid grid) {
        for (Cell[] line : grid.getGrid())
            for (Cell cell : line) {
                cellService.calculateNextCellState(grid, cell);
                cellService.switchCellColor(cell);
            }

    }

    @Override
    public void move(Grid grid) {
        for (Cell[] line : grid.getGrid()) {
            for (Cell cell : line) {
                cellService.changeCellStateToNextState(cell);
            }
        }
    }
}
