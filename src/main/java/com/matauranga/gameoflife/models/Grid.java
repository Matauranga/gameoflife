package com.matauranga.gameoflife.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

/**
 * Grid for the game of life
 */
@Getter
@Setter
public class Grid {

    Cell[][] grid;

    int gridSize;

    double percentCellsAliveInit;

    public Grid(int gridSize, double percentCellsAliveInit) {
        this.gridSize = gridSize;
        grid = new Cell[gridSize][gridSize];
        this.percentCellsAliveInit = percentCellsAliveInit;
        init();
    }


    /**
     * initialise les grilles a l'instant t et t-1
     * Une cellule n'est liée qu'à la grille au temps t-1
     * un clone de chaque cellule est placée dans la grille au temps t (la grille qui est affichée)
     * L'ajout de cellules  actives se fait par appel de la fonction initHasard
     */
    void init() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = new Cell(grid, i, j, false);
            }
        }
        initRandom();
    }

    /**
     * place au hasard des cellulles vivantes dans les grilles a l'instant t et t-1
     * pour chaque cellule, on tire un réel au hasard entre 0 et 1.
     * si le réel < densité, alors la cellule est activée
     * (il y a donc densité% de chance que la cellule en (i,j) soit activée)
     */
    void initRandom() {
        Random r = new Random();
        for (Cell[] ligne : grid)
            for (Cell c : ligne)
                if (r.nextDouble() < percentCellsAliveInit)
                    c.vivante = c.etatSuivant = true;
    }

}
