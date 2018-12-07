package application;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import logic.Balloon;
import logic.BalloonArray;
import logic.ScoreCount;
import sharedObject.IRenderableHolder;
import javafx.scene.control.Button;
import draw.GameScreen;
import logic.*;
import Input.IOmanager;
import javafx.animation.AnimationTimer;


public class GameManager {
	
	private Scene game;
	private AnchorPane root;
	private GameTimer gameTimer;
	private HBox timerBox;
	//private BalloonArray bArray;
	private PauseButton pauseButton;
	private Thread t;
	private boolean isPause = false;
	private ScoreCount scoreCount;
	private PauseSubscene pauseSubscene;
	private static boolean isGameOver = false;
	private AnimationTimer anime;
	private static int animalPrevSec = 0;
	private static int hunterPrevSec = 0;
	private static int accelPrevSec = 0;
	private GameScreen gScreen;
	private Gamelogic gLogic;
	
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
		gScreen = new GameScreen(Screen.getPrimary().getBounds().getWidth(), Screen.getPrimary().getBounds().getHeight());
		gLogic = new Gamelogic();
		root.getChildren().add(gScreen);
		//createBackground();
		createTimer();
		createPauseButton();
		createScoreCount();
		createSubscene();
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
	
	public void createSubscene() {
		pauseSubscene = new PauseSubscene();
	}
	
	public void showSubscene() {
		root.getChildren().add(pauseSubscene);
		pauseSubscene.transitionIn();
	}
	
	public void hideSubscene() {
		Thread t = new Thread(() -> {
			try {
				pauseSubscene.transitionOut();
				Thread.sleep(300);
				Platform.runLater(() -> {
					root.getChildren().remove(pauseSubscene);					
				});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		});
		t.start();
	}
	
	// Thread
	public void createGameplay() {
		
		System.out.println("GAME START");
		anime = new AnimationTimer() {
			
			@Override
			public void handle(long arg0) {
				createAnimal(gameTimer.getSecond());
				createHunters(gameTimer.getSecond());
				accelerate(gameTimer.getSecond());
				gScreen.drawComponent();
				gLogic.logicUpdate();
				IRenderableHolder.getInstance().update();
				IOmanager.postupdate();
			}
		};
		anime.start();
		
	}
	
	private void createAnimal(int sec) {
		if(sec-animalPrevSec == 3) {
			System.out.println("addAnimal");
			double posX = gScreen.createRamdonPos();
			String aKey = gScreen.createRandomKey();
			Animals a = new Animals(posX, -(Animals.HEIGHT+20) , aKey);
			System.out.println(posX + " " + aKey + " " + a.getZ());
			gLogic.addNewObj(a); 
			animalPrevSec = sec;
		}
		if(sec == 59)
			animalPrevSec = 0;
	}
	
	private void createHunters(int sec) {
		if(sec - hunterPrevSec == 2) {
			System.out.println("addHunter");
			double posX = gScreen.createRamdonPos();
			String hKey = gScreen.createRandomKey();
			Hunters h = new Hunters(posX, -Hunters.HEIGHT, hKey);
			System.out.println(posX + " " + hKey + " " + h.getZ());
			gLogic.addNewObj(h);
			hunterPrevSec = sec;
		}
		if(sec == 59)
			hunterPrevSec = 0;
	}
	
	private void accelerate(int sec) {
		if(sec - accelPrevSec == 30) {
			
			accelPrevSec = sec;
		}
		if(sec == 59)
			accelPrevSec = 0;
	}
		
	public void setKeyPress() {
		
		game.setOnKeyPressed((KeyEvent e)->{
			String code = e.getCode().toString();
			System.out.println(code);
			if(!IOmanager.getpressed())
				IOmanager.setTriggered(code, true);
			IOmanager.setPressed(true);
		});
		
		game.setOnKeyReleased((KeyEvent e)->{
			IOmanager.setPressed(false);
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
		anime.stop();
		gameTimer.pause();
		showSubscene();
	}
	
	public void unpause() {
		isPause = false;
		anime.start();
		gameTimer.unpause();
		hideSubscene();
	}
	
	public void start() {
		createGameplay();
		gameTimer.start();
		scoreCount.start();
	}
	
	public static boolean getGameOver() {
		return isGameOver;
	}
	public static void setGameOver() {
		isGameOver = true;
	}
	
	private void gameOver() {
		PauseSubscene gameOverSs = new PauseSubscene();
		root.getChildren().add(gameOverSs);
		gameOverSs.transitionIn();
		LabelGenerator gO = new LabelGenerator("GAME OVER");
		gO.setFont(new Font("Joystix Monospace", 48));
		gO.setAlignment(Pos.CENTER);
		gO.setLayoutX(sc.setPinSize(290));
		gO.setLayoutY(sc.setPinSize(70));
		gameOverSs.getSubScenePane().getChildren().add(gO);
		LabelGenerator text_score = new LabelGenerator("Your Score Is");
		LabelGenerator score = new LabelGenerator("" + scoreCount.getScoreCount());
		text_score.setFont(new Font("Joystix Monospace", 40));
		text_score.setAlignment(Pos.CENTER);
		score.setAlignment(Pos.CENTER);
		text_score.setLayoutX(sc.setPinSize(250));
		text_score.setLayoutY(140);
		score.setFont(new Font("Joystix Monospace", 72));
		score.setLayoutX(sc.setPinSize(475));
		score.setLayoutY(sc.setPinSize(270));
		gameOverSs.getSubScenePane().getChildren().addAll(text_score,score);
		
		Button againBtn = new Button("Again"); 
		againBtn.setPrefHeight(sc.setPinSize(60));  againBtn.setPrefWidth(sc.setPinSize(180));
		againBtn.setLayoutX(sc.setPinSize(320));
		againBtn.setLayoutY(sc.setPinSize(420));
		Button menuBtn = new Button("Menu");
		menuBtn.setPrefWidth(sc.setPinSize(180));  menuBtn.setPrefHeight(sc.setPinSize(60));
		menuBtn.setLayoutX(sc.setPinSize(530));
		menuBtn.setLayoutY(sc.setPinSize(420));
		gameOverSs.getSubScenePane().getChildren().addAll(againBtn,menuBtn);
		
		anime.stop();
		gameTimer.pause();
		
	}
	
	
}
