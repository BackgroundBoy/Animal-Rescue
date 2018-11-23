package application;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import logic.Balloon;
import logic.BalloonArray;

public class GameManager {
	
	private Scene game;
//	private int level;
	private AnchorPane root;
	private GameTimer gameTimer;
	private HBox timerBox;
	private BalloonArray bArray;
	
	private ScreenSizeCalibrator sc = new ScreenSizeCalibrator();
	
	// CONSTRUCTOR
	public GameManager() {
		System.out.println("--------------- Game Stage ---------------");
		root = new AnchorPane();
		game = new Scene(root);
		setKeyPress();
		createTimer();
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
	
	
	// Thread
	public void createGameplay() {
		
		System.out.println("GAME START");
		
		bArray = new BalloonArray();

		Thread t = new Thread(() -> {
			
			while (true) {				
				try {
					Thread.sleep(1000);	
					Balloon l = new Balloon();
					bArray.addBalloon(l);
					Platform.runLater(() -> {
						root.getChildren().add(l);				
					});	
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		t.start();
	}
		
	public void setKeyPress() {
		game.setOnKeyPressed(e -> {
			if (bArray.contains(e.getCode().toString()))
				bArray.popAlpha(e.getCode().toString());
		});
	}
	
	public void start() {
		createGameplay();
		gameTimer.start();
	}
}
