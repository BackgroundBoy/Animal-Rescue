package application;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class GameManager {
	
	private Scene game;
	private int level;
	private AnchorPane root;
	private GameTimer gameTimer;
	private HBox timerBox;
	private ScreenSizeCalibrator sc = new ScreenSizeCalibrator();
	
	// CONSTRUCTOR
	public GameManager() {
		System.out.println("--------------- Game Stage ---------------");
		root = new AnchorPane();
		game = new Scene(root);
		createTimer();
	}
	
	// For switch Scene between mainUI and GameUI
	public Scene getGameManager() {
		return game;
	}
	
	public void createTimer() {
		gameTimer = new GameTimer();
		timerBox = gameTimer.getTimerBox();
		root.getChildren().add(timerBox);
		AnchorPane.setRightAnchor(timerBox, sc.setPinSize(40));
		AnchorPane.setTopAnchor(timerBox, sc.setPinSize(40));
		gameTimer.start();
	}
}
