package com.matauranga.gameoflife.services;

import com.matauranga.gameoflife.models.Cell;
import com.matauranga.gameoflife.models.Grid;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

import static com.matauranga.gameoflife.constants.GridColor.COULACTIVE;
import static com.matauranga.gameoflife.constants.GridColor.COULDESACTIVE;
import static com.matauranga.gameoflife.constants.GridFeatures.*;

@Service
public class GridServiceImpl implements GridService {

    private final CellService cellService;

    public GridServiceImpl(CellService cellService) {
        this.cellService = cellService;
    }

    @Override
    public void drawGrid(Group root, Grid grid) {

        initGrid(grid);

        Cell[][] grille = grid.getGrid();

        int rayon = CELLSIZEINPIXELS / 2;
        for (int i = 0; i < GRIDSIZE; i++) {
            for (int j = 0; j < GRIDSIZE; j++) {
                Cell cell = grille[i][j];
                Circle circle = createCircle(i, j, rayon);
                setCircleColor(circle, cell.isAlive());
                cell.setCircle(circle);
                root.getChildren().add(circle);
            }
        }
    }

    private Circle createCircle(int i, int j, int rayon) {
        return new Circle((j * CELLSIZEINPIXELS + rayon), (i * CELLSIZEINPIXELS + rayon), rayon);
    }

    private void setCircleColor(Circle circle, boolean isAlive) {
        if (isAlive) {
            circle.setFill(COULACTIVE); // Si la cellule est vivante
        } else {
            circle.setFill(COULDESACTIVE); // Si la cellule est morte
        }
    }

    @Override
    public void calculateNextGridFrame(Grid grid) {

        Arrays.stream(grid.getGrid())
                .flatMap(Arrays::stream)
                .forEach(cellService::changeCellStateToNextState);

        Arrays.stream(grid.getGrid())
                .flatMap(Arrays::stream)
                .forEach(cell -> {
                    cellService.calculateNextCellState(grid, cell);
                    cellService.switchCellColor(cell);
                });
    }

    void initGrid(Grid grid) {
        for (int i = 0; i < GRIDSIZE; i++) {
            for (int j = 0; j < GRIDSIZE; j++) {
                grid.getGrid()[i][j] = new Cell(grid.getGrid(), i, j, false);
            }
        }
        randomInitOfLivingCells(grid);
    }

    void randomInitOfLivingCells(Grid grid) {
        Random r = new Random();
        for (Cell[] line : grid.getGrid()) {
            for (Cell cell : line) {
                if (r.nextDouble() < INITIALPERCENTOFACTIVECELLS) {
                    cell.setAlive(true);
                    cell.setThereafterAlive(true);
                }
            }
        }
    }

}
