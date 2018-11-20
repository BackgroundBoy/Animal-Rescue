package application;

import java.util.Timer;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class GameManager {
	
	private Scene game;
	private int level;
	private AnchorPane root;
	private GameTimer gameTimer;

	// CONSTRUCTOR
	public GameManager() {
		root = new AnchorPane();
		game = new Scene(root);
		createTimer();
		gameTimer.start();
		root.getChildren().add(gameTimer.getTimeBox());
		
	}
	
	// For switch Scene between mainUI and GameUI
	public Scene getGameManager() {
		return game;
	}
	
	public void createTimer() {
		gameTimer = new GameTimer();
	}
}
