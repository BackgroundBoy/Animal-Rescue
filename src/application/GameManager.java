package application;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import logic.Balloon;
import logic.BalloonArray;
import logic.ScoreCount;

public class GameManager {
	
	private Scene game;
	private AnchorPane root;
	private GameTimer gameTimer;
	private HBox timerBox;
	private BalloonArray bArray;
	private PauseButton pauseButton;
	private Thread t;
	private boolean isPause = false;
	private ScoreCount scoreCount;
	
	// size controller
	private ScreenSizeCalibrator sc = new ScreenSizeCalibrator();
	
	private final String BACKGROUND_PATH = ClassLoader.getSystemResource("images/c.jpg").toString();
	private final String BACKGROUND_STYLE = "-fx-background-image: url(" + BACKGROUND_PATH + "); " 
												+ "-fx-background-size: cover;";
	
	// CONSTRUCTOR
	public GameManager() {
		System.out.println("--------------- Game Stage ---------------");
		root = new AnchorPane();
		game = new Scene(root);
		createBackground();
		createTimer();
		createPauseButton();
		createScoreCount();
		setKeyPress();
		start();
	}
	
	// For switching Scene between mainUI and GameUI
	public Scene getGameManager() {
		return game;
	}
	
	public void createBackground() {
		root.setStyle(BACKGROUND_STYLE);
	}
	
	public void createPauseButton() {
		pauseButton = new PauseButton();
		AnchorPane.setRightAnchor(pauseButton, sc.setTongSize(30));
		AnchorPane.setTopAnchor(pauseButton, sc.setTongSize(20));
		root.getChildren().add(pauseButton);		
	}
	
	public void createTimer() {
		gameTimer = new GameTimer();
		timerBox = gameTimer.getTimerBox();
		AnchorPane.setRightAnchor(timerBox, sc.setTongSize(90));
		AnchorPane.setTopAnchor(timerBox, sc.setTongSize(25));
		root.getChildren().add(timerBox);
	}
	
	public void createScoreCount() {
		scoreCount = new ScoreCount();
		AnchorPane.setRightAnchor(scoreCount, sc.setTongSize(30));
		AnchorPane.setTopAnchor(scoreCount, sc.setTongSize(70));
		root.getChildren().add(scoreCount);
	}
	
	// Thread
	public void createGameplay() {
		
		System.out.println("GAME START");
		
		bArray = new BalloonArray();

		t = new Thread(() -> {
			
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
			if (bArray.contains(e.getCode().toString()) && !isPause)
				scoreCount.setScoreCount(scoreCount.getScoreCount() 
						+ 10 * bArray.popAlpha(e.getCode().toString()));
			else if (!isPause)
				scoreCount.setScoreCount(scoreCount.getScoreCount() - 5);
		});

		pauseButton.setOnMouseClicked(e -> {
			if (e.getButton().equals(MouseButton.PRIMARY)) {
				if (isPause) unpause();
				else pause();
			}
		});
	}
	
	public void pause() {
		isPause = true;
		t.suspend();
		bArray.pause();
		gameTimer.pause();
	}
	
	public void unpause() {
		isPause = false;
		t.resume();
		bArray.unpause();
		gameTimer.unpause();
	}
	
	public void start() {
		createGameplay();
		gameTimer.start();
		scoreCount.start();
	}
}
