package com.matauranga.gameoflife.models;

import javafx.scene.shape.Circle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Cell {

    boolean previouslyAlive;

    boolean alive;

    boolean thereafterAlive;

    int abscissa;

    int ordinate;

    Cell[][] grid;

    Circle circle;

    public Cell(Cell[][] grid, int abscissa, int ordinate, boolean alive) {
        this.grid = grid;
        this.alive = previouslyAlive = thereafterAlive = alive;
        this.abscissa = abscissa;
        this.ordinate = ordinate;
    }

}