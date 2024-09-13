package com.matauranga.gameoflife.services;

import com.matauranga.gameoflife.models.Grid;

public interface GridService {

    void calculate(Grid grid);

    void move(Grid grid);


}
