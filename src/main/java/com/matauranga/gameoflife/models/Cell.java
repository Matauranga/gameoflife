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
    boolean etatPrecedent;
    /*** nature de la cellule */
    boolean vivante;
    /** nature de la cellule */
    boolean etatSuivant;
    /**en transition, utilisee lorsque l'on veut utiliser les 4 couleurs de la cellule et non seulement les 2 etats binaires active, desactive */
    boolean enTransition;
    /*** coordonnee de la cellule dans la grille */
    int abscissa;
    int ordinate;
    /*** reference a la grille des cellules */
    Cell[][] grille;
    /*** sa representation graphique associee */
    Circle circle;

    public Cell(Cell[][] grille, int abscissa, int ordinate, boolean vivante) {
        this.grille = grille;
        this.vivante = etatPrecedent = etatSuivant = vivante;
        enTransition = false;
        this.abscissa = abscissa;
        this.ordinate = ordinate;
    }

}