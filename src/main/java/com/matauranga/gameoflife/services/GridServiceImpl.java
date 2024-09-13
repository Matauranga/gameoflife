package com.matauranga.gameoflife.services;

import com.matauranga.gameoflife.models.Cell;
import com.matauranga.gameoflife.models.Grid;
import org.springframework.stereotype.Service;

@Service
public class GridServiceImpl implements GridService {

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
