package com.matauranga.gameoflife.models;

import javafx.scene.shape.Circle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Cell {
    /*** nature de la cellule */
    boolean previousState;
    /*** nature de la cellule */
    boolean alive;
    /** nature de la cellule */
    boolean nextState;
    /*** coordonnee de la cellule dans la grille */
    int abscissa;
    int ordinate;
    /*** reference a la grille des cellules */
    Cell[][] grille;
    /*** sa representation graphique associee */
    Circle circle;

    public Cell(Cell[][] grille, int abscissa, int ordinate, boolean alive) {
        this.grille = grille;
        this.alive = previousState = nextState = alive;
        this.abscissa = abscissa;
        this.ordinate = ordinate;
    }

}