package com.matauranga.gameoflife;

import com.matauranga.gameoflife.controller.GameController;
import com.matauranga.gameoflife.models.Cell;
import com.matauranga.gameoflife.models.Grid;

import com.matauranga.gameoflife.services.GridService;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameoflifeApplication extends Application {

//	/**
//	 * grid liee a cet objet graphique
//	 */
//	Grid grid;
//	/**
//	 * elements graphiques représentant les cellules
//	 */
//	public static Circle[][] circles;
//	/**
//	 * taille d'une cellule en pixel
//	 */
//	int espace = 20;
//	/**
//	 * taille de la grid
//	 */
//	private int taille;
//	/**
//	 * pourcentage de cellules initialement actives
//	 */
//	private double nb;
//	/**
//	 * délai en ms entre chaque évolution
//	 */
//	public static final int tempo = 100;
//
//
//	/**
//	 * construit le theatre des opérations, les acteurs (elements graphiques), et le tempo
//	 * */
//	void constructSceneToGame(Stage primaryStage) {
//		int largeur = 800;
//		int hauteur = 900;
//
//		espace = largeur / taille;
//
//		//definir la scene principale
//		Group root = new Group();
//		Scene scene = new Scene(root, largeur, hauteur, Color.BLACK);
//		primaryStage.setTitle("Life...");
//		primaryStage.setScene(scene);
//
//		//definir les acteurs
//		grid = new Grid(taille, nb);
//
//		//definir les costumes
//		GameoflifeApplication.circles = new Circle[taille][taille];
//
//		//habiller les acteurs
//		drawGrid(root);
//
//		//afficher le theatre
//		primaryStage.show();
//
//		//-----lancer le timer pour faire vivre la grid
//		Timeline littleCycle = new Timeline(new KeyFrame(Duration.millis(tempo),
//				event -> {
//					grid.move();
//					grid.calculate();
//				}));
//		littleCycle.setCycleCount(Timeline.INDEFINITE);
//		littleCycle.play();
//		scene.setOnKeyTyped(e -> System.out.println(e));
//		scene.setOnMouseClicked(e -> System.out.println(e));
//
//	}
//
//	/**
//	 * creation des cellules et de leurs habits
//	 *
//	 * @param root racine
//	 */
//	void drawGrid(Group root) {
//		Cell[][] grille = grid.getGrid();
//		int rayon = espace / 2;
//		for (int i = 0; i < taille; i++)
//			for (int j = 0; j < taille; j++) {
//				Cell cell = grille[i][j];
//				circles[i][j] = new Circle((j * espace + rayon), (i * espace + rayon), rayon);
//				if (cell.isVivante()) circles[i][j].setFill(Cell.coulActive);
//				else circles[i][j].setFill(Cell.coulDesactive);
//				cell.setCircle(circles[i][j]);
//				root.getChildren().add(circles[i][j]);
//			}
//	}


//	public static void main(String[] args) {
//		SpringApplication.run(GameoflifeApplication.class, args);
//	}

	@Override
	public void start(Stage primaryStage) {
		GameController.constructSceneToGame(primaryStage);
	}

	public static void main(String[] args) {
		launch();
	}

}
