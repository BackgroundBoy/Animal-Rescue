package application;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import logic.BalloonArray;

public class GameManager {
	
	private Scene game;
//	private int level;
	private AnchorPane root;
	private GameTimer gameTimer;
	private Gameplay gameplay;
	private HBox timerBox;
	private ScreenSizeCalibrator sc = new ScreenSizeCalibrator();
	private BalloonArray barray;
	
	// CONSTRUCTOR
	public GameManager() {
		System.out.println("--------------- Game Stage ---------------");
		root = new AnchorPane();
		game = new Scene(root);
		createTimer();
		createBalloonArray();
		createGameplay();
		start();
	}
	
	// For switching Scene between mainUI and GameUI
	public Scene getGameManager() {
		return game;
	}
	
	public void createTimer() {
		gameTimer = new GameTimer();
		timerBox = gameTimer.getTimerBox();
		root.getChildren().add(timerBox);
		AnchorPane.setRightAnchor(timerBox, sc.setPinSize(40));
		AnchorPane.setTopAnchor(timerBox, sc.setPinSize(40));
	}
	
	public void createBalloonArray() {
		barray = new BalloonArray();
	}
	
	
	// Thread
	public void createGameplay() {
		gameplay = new Gameplay();
	}
	
	public void start() {
		gameplay.start();
		gameTimer.start();
	}
}
