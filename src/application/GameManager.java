package application;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.Balloon;
import logic.BalloonArray;
import logic.ScoreCount;


public class GameManager {
	
//	private Stage primaryStage;
	private Scene game;
	private AnchorPane root;
	private GameTimer gameTimer;
	private HBox timerBox;
	private BalloonArray bArray;
	private PauseButton pauseButton;
	private Thread t;
	private boolean isPause = false;
	private static boolean isGameOver = false;	
	private ScoreCount scoreCount;
	private PauseSubscene pauseSubscene;
	
	// size controller
	private ScreenSizeCalibrator sc = new ScreenSizeCalibrator();
	private MediaManager mm = new MediaManager();
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
		createSubscene();
		setKeyPress();
		start();
	}
	
	public Scene getScene() {
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
		bArray = new BalloonArray();
		t = new Thread(() -> {
		while (!isGameOver) {				
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
			Platform.runLater( ()-> {
				gameOver();
			});
		});
		t.start();
	}
		
	public void setKeyPress() {

		game.setOnKeyPressed(e -> {
			if (bArray.contains(e.getCode().toString()) && !isPause && !isGameOver) {
				mm.playGetScore();
				scoreCount.setScoreCount(scoreCount.getScoreCount() 
						+ 10 * bArray.popAlpha(e.getCode().toString()));
			}
			else if (!isPause && !isGameOver) {
				mm.playQuack();
				scoreCount.setScoreCount(scoreCount.getScoreCount() - 5);
			}
		});
		
		pauseButton.setOnMouseClicked(e -> {
			if (e.getButton().equals(MouseButton.PRIMARY) && !isGameOver) {
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
		showSubscene();
	}
	
	public void unpause() {
		isPause = false;
		t.resume();
		bArray.unpause();
		gameTimer.unpause();
		hideSubscene();
	}
	
	public void start() {
		createGameplay();
		gameTimer.start();
		scoreCount.start();
		mm.playGamePath();
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
		gO.setFont(new Font("Joystix Monospace", sc.setPinSize(48)));
		gO.setAlignment(Pos.CENTER);
		gO.setPrefWidth(gameOverSs.getWidth());
		gO.setLayoutY(sc.setPinSize(70));
		gameOverSs.getSubScenePane().getChildren().add(gO);
		LabelGenerator text_score = new LabelGenerator("Your Score Is");
		LabelGenerator score = new LabelGenerator("" + scoreCount.getScoreCount());
		text_score.setFont(new Font("Joystix Monospace", sc.setPinSize(40)));
		text_score.setAlignment(Pos.CENTER);
		score.setAlignment(Pos.CENTER);
		text_score.setPrefWidth(gameOverSs.getWidth());
		text_score.setLayoutY(140);
		score.setFont(new Font("Joystix Monospace", sc.setPinSize(72)));
		score.setPrefWidth(gameOverSs.getWidth());
		score.setLayoutY(sc.setPinSize(270));
		gameOverSs.getSubScenePane().getChildren().addAll(text_score,score);
		ButtonGenerator againBtn = new ButtonGenerator("Again"); 
		againBtn.setLayoutX(gameOverSs.getWidth()/2-sc.setPinSize(397));
		againBtn.setLayoutY(sc.setPinSize(420));
		againBtn.setOnMouseClicked(e -> {
			if(e.getButton().equals(MouseButton.PRIMARY)) {
				restart();
				root.getChildren().remove(gameOverSs);
			}
		});
		ButtonGenerator menuBtn = new ButtonGenerator("Menu");
		menuBtn.setLayoutX(gameOverSs.getWidth()/2+sc.setPinSize(25));
		menuBtn.setLayoutY(sc.setPinSize(420));
		menuBtn.setOnMouseClicked(e -> {
			if(e.getButton().equals(MouseButton.PRIMARY)) {
//				UIManager ui = new UIManager();
//				game.
			}
		});
		gameOverSs.getSubScenePane().getChildren().addAll(againBtn,menuBtn);
	
		t.suspend();
		bArray.pause();
		gameTimer.pause();
		pauseButton.setDisable();
	}
	
	public void restart() {
		bArray.clear();
		isGameOver = false;
		scoreCount.setScoreCount(0);
		gameTimer.reset();
		gameTimer.unpause();
		createGameplay();
		pauseButton.setEnable();
	}
}
