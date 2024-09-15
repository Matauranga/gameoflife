package com.matauranga.gameoflife.models;

import lombok.Getter;
import lombok.Setter;

import static com.matauranga.gameoflife.constants.GridFeatures.GRIDSIZE;

@Getter
@Setter
public class Grid {

    Cell[][] grid;

    public Grid() {
        this.grid = new Cell[GRIDSIZE][GRIDSIZE];
    }
}
