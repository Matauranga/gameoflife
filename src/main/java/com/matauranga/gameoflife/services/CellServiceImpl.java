package com.matauranga.gameoflife.services;

import com.matauranga.gameoflife.models.Cell;
import com.matauranga.gameoflife.models.Grid;
import javafx.scene.paint.Color;
import org.springframework.stereotype.Service;

import static com.matauranga.gameoflife.constants.GridColor.COULACTIVE;
import static com.matauranga.gameoflife.constants.GridColor.COULDESACTIVE;
import static com.matauranga.gameoflife.constants.ThresholdPopulation.*;

@Service
public class CellServiceImpl implements CellService {

    /**
     * determine le prochain etat de la cellule en fonction des cellules voisines
     */
    @Override
    public void evoluer(Grid grid, Cell cell) {

        int nbAliveCells = getNbAliveCells(grid, cell);
        cell.setPreviousState(cell.isAlive());

        //verifie si la cellule doit se desactiver (en sous population, ou surpopulation)
        //on peut remplacer les constantes par des valeurs
        if (cell.isAlive() && (nbAliveCells <= SUBPOPULATIONS || nbAliveCells >= OVERPOPULATION)) {
            cell.setNextState(false);
        } else
            //verifie si la cellule doit etre active ou reactivée (population idéale)
            //on peut remplacer les constantes par des valeurs
            if (nbAliveCells == IDEALTHRESHOLDFORCELLLIFE) {
                cell.setNextState(true);
            }
    }

    /**
     *  Compter le nb de cellules actives dans les 8 cases autours (la grid est considérée sphérique)
     *
     */
    private static int getNbAliveCells(Grid grid, Cell cell) {

        int nbAliveCells = 0;

        for (int i = -1; i < 2; i++) {
            int x = ((cell.getAbscissa() + i) + grid.getGridSize()) % grid.getGridSize();
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) continue;
                {
                    int y = ((cell.getOrdinate() + j) + grid.getGridSize()) % grid.getGridSize();
                    if (grid.getGrid()[x][y].isAlive()) {
                        nbAliveCells++;
                    }
                }
            }
        }
        return nbAliveCells;
    }

    /**modifie la couleur de la représentation graphique associee selon l'etat*/
    @Override
    public void switchColor(Cell cell) {
        Color color = null;
        if (cell.isAlive() != cell.isNextState()) {
            if (cell.isNextState()) {
                color = COULACTIVE;
            } else {
                color = COULDESACTIVE;
            }
        }
        if (color != null) {
            cell.getCircle().setFill(color);
        }

    }

    /**change l etat courant vers l etat suivant*/
    @Override
    public void avancer(Cell cell) {
        cell.setAlive(cell.isNextState());
    }
}
