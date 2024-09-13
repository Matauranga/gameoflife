package com.matauranga.gameoflife.services;

import com.matauranga.gameoflife.models.Cell;
import com.matauranga.gameoflife.models.Grid;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import org.springframework.stereotype.Service;

@Service
public class GridServiceImpl implements GridService {

    @Override
    public void drawGrid(Group root, int gridSize, double nb, Grid grid, int espace, Circle[][] circles) {

        Cell[][] grille = grid.getGrid();
        int rayon = espace / 2;
        for (int i = 0; i < gridSize; i++)
            for (int j = 0; j < gridSize; j++) {
                Cell cell = grille[i][j];
                circles[i][j] = new Circle((j * espace + rayon), (i * espace + rayon), rayon);
                if (cell.isVivante()) circles[i][j].setFill(Cell.coulActive);
                else circles[i][j].setFill(Cell.coulDesactive);
                cell.setCircle(circles[i][j]);
                root.getChildren().add(circles[i][j]);
            }

    }

    @Override
    public void calculate(Grid grid) {
        for (Cell[] ligne : grid.getGrid())
            for (Cell c : ligne) {
                c.evoluer();
                c.switchColor();
            }

    }

    @Override
    public void move(Grid grid) {
        for (Cell[] ligne : grid.getGrid())
            for (Cell c : ligne)
                c.avancer();

    }
}
