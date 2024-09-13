package com.matauranga.gameoflife.controller;

import com.matauranga.gameoflife.models.Cell;
import com.matauranga.gameoflife.models.Grid;
import com.matauranga.gameoflife.services.GridService;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class GameController {

    private final GridService gridService;

    public GameController(GridService gridService) {
        this.gridService = gridService;
    }



    /**********************************************************/

    /**
     * grid liee a cet objet graphique
     */
    static Grid grid;
    /**
     * elements graphiques représentant les cellules
     */
    public static Circle[][] circles;
    /**
     * taille d'une cellule en pixel
     */
    static int espace = 20;
    /**
     * taille de la grid
     */
    static int taille = 200;
    /**
     * pourcentage de cellules initialement actives
     */
    static double nb = 0.1;
    /**
     * délai en ms entre chaque évolution
     */
    public static final int tempo = 100;



    /**
     * construit le theatre des opérations, les acteurs (elements graphiques), et le tempo
     * */
    public void constructSceneToGame(Stage primaryStage) {
        int largeur = 800;
        int hauteur = 900;

        espace = largeur / taille;

        //definir la scene principale
        Group root = new Group();
        Scene scene = new Scene(root, largeur, hauteur, Color.BLACK);
        primaryStage.setTitle("Life...");
        primaryStage.setScene(scene);

        //definir les acteurs
        grid = new Grid(taille, nb);

        //definir les costumes
        circles = new Circle[taille][taille];

        //habiller les acteurs
        drawGrid(root);

        //afficher le theatre
        primaryStage.show();

        //-----lancer le timer pour faire vivre la grid
        Timeline littleCycle = new Timeline(new KeyFrame(Duration.millis(tempo),
                event -> {
                    gridService.move(grid);
                    gridService.calculate(grid);
//                    grid.move();
//                    grid.calculate();
                }));
        littleCycle.setCycleCount(Timeline.INDEFINITE);
        littleCycle.play();
        scene.setOnKeyTyped(e -> System.out.println(e));
        scene.setOnMouseClicked(e -> System.out.println(e));

    }

    /**
     * creation des cellules et de leurs habits
     *
     * @param root racine
     */
    static void drawGrid(Group root) {
        Cell[][] grille = grid.getGrid();
        int rayon = espace / 2;
        for (int i = 0; i < taille; i++)
            for (int j = 0; j < taille; j++) {
                Cell cell = grille[i][j];
                circles[i][j] = new Circle((j * espace + rayon), (i * espace + rayon), rayon);
                if (cell.isVivante()) circles[i][j].setFill(Cell.coulActive);
                else circles[i][j].setFill(Cell.coulDesactive);
                cell.setCircle(circles[i][j]);
                root.getChildren().add(circles[i][j]);
            }
    }


    /************************************************************/


}
