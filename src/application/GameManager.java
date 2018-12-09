package application;

import Exception.NegativeScoreException;
import Input.IOmanager;
import draw.GameScreen;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.Animals;
import logic.FallableUnit;
import logic.Gamelogic;
import logic.Hunters;
import logic.ScoreCount;
import sharedObject.IRenderableHolder;

public class GameManager {
	
	private Stage mainStage;
	private Scene game;
	private AnchorPane root;
	private GameTimer gameTimer;
	private HBox timerBox;
	private Life life;
	private PauseButton pauseButton;
	private ScoreCount scoreCount;
	private PauseSubscene pauseSubscene;
	private AnimationTimer anime;
	private GameScreen gScreen;
	private Gamelogic gLogic;
	private static int animalPrevSec = 0;
	private static int hunterPrevSec = 0;
	private static int accelPrevSec = 0;
	private static boolean isGameOver = false;
	public static boolean isPause = false;
	private final String CURSOR_PATH = ClassLoader.getSystemResource("images/cursor.png").toString();
	
	// CONSTRUCTOR	
	public GameManager() {
		System.out.println("--------------- Game Stage ---------------");
		root = new AnchorPane();
		game = new Scene(root, 1366, 768);
		mainStage = new Stage();
		mainStage.setScene(game);
		mainStage.setTitle("Animal Rescue");
		mainStage.getIcons().add(new Image(ClassLoader.getSystemResource("images/icon.png").toString()));
		gScreen = new GameScreen(1366, 768);
		gLogic = new Gamelogic();
		root.getChildren().add(gScreen);
		createTimer();
		createPauseButton();
		createScoreCount();
		createSubscene();
		createLife();
		customCursor();
		setKeyPress();
		start();
		replay();
	}
	
	public Stage getMainStage() {
		return mainStage;
	}
	
	private void createLife() {
		life = new Life();
		AnchorPane.setRightAnchor(life, 30.0);
		AnchorPane.setTopAnchor(life, 110.0);
		root.getChildren().add(life);
	}
	
	private void createPauseButton() {
		pauseButton = new PauseButton();
		AnchorPane.setRightAnchor(pauseButton, 30.0);
		AnchorPane.setTopAnchor(pauseButton, 20.0);
		root.getChildren().add(pauseButton);		
	}
	
	private void createTimer() {
		gameTimer = new GameTimer();
		timerBox = gameTimer.getTimerBox();
		AnchorPane.setRightAnchor(timerBox, 90.0);
		AnchorPane.setTopAnchor(timerBox, 25.0);
		root.getChildren().add(timerBox);
	}
	
	private void createScoreCount() {
		scoreCount = new ScoreCount();
		AnchorPane.setRightAnchor(scoreCount, 30.0);
		AnchorPane.setTopAnchor(scoreCount, 70.0);
		root.getChildren().add(scoreCount);
	}
	
	private void createSubscene() {
		pauseSubscene = new PauseSubscene();
		ButtonGenerator replayButton = new ButtonGenerator("REPLAY");
		replayButton.setOnMouseClicked(e -> {
			if (e.getButton().equals(MouseButton.PRIMARY)) {
				hideSubscene();
				replay();
			}
		});
		ButtonGenerator menuButton = new ButtonGenerator("MENU");
		menuButton.setOnMouseClicked(e -> {
			if (e.getButton().equals(MouseButton.PRIMARY)) {
				Main.showMenuStage();
				Main.closeGameStage();
			}
		});
		ButtonGenerator exitButton = new ButtonGenerator("EXIT");
		exitButton.setOnMouseClicked(e -> {
			if (e.getButton().equals(MouseButton.PRIMARY)) {
				Platform.exit();
			}
		});
		VBox box = new VBox(10);
		box.getChildren().addAll(replayButton, menuButton, exitButton);
		box.setLayoutY(80);
		box.setLayoutX(400);
		SliderBar slide = new SliderBar();
		slide.setLayoutY(350);
		slide.setLayoutX(120);
		LabelGenerator pausing = new LabelGenerator("PAUSING", 50);
		pausing.setLayoutX(60);
		pausing.setLayoutY(80);
		pauseSubscene.getSubScenePane().getChildren().addAll(box, slide, pausing);
	}
	
	private void showSubscene() {
		root.getChildren().add(pauseSubscene);
		pauseSubscene.transitionIn();
	}
	
	private void hideSubscene() {
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
	
	public void createGameplay() {
		System.out.println("GAME START");
		anime = new AnimationTimer() {
			
			@Override
			public void handle(long arg0) {
				updateEntities(GameTimer.getSecond());
				gScreen.drawComponent();
				gLogic.logicUpdate();
				IRenderableHolder.getInstance().update();
				IOmanager.postupdate();
				try {
					scoreCount.update();
				} catch (NegativeScoreException e) {
					e.printStackTrace();
					scoreCount.resetScore();
				}
				if (isGameOver) { 
					gameOver();
				}
			}
			
		};
		anime.start();
	}
	
	private void updateEntities(int sec) {
		createHunters(sec);
		createAnimal(sec);
		accelerate(sec);
		if (sec%25 == 0 && sec != 0) {
			if (!FallableUnit.isGenRateIncreased) {
				FallableUnit.increaseGenRate();
				FallableUnit.isGenRateIncreased = true;
			}	
		} else {
			FallableUnit.isGenRateIncreased = false;
		}
		if (sec == 59) {
			animalPrevSec = 0;
			hunterPrevSec = 0;
			accelPrevSec = 0;
		}
	}
	
	private void createAnimal(int sec) {
		if (sec-animalPrevSec == 3) {
			for (int i = FallableUnit.fallUnitGenRate; i > 0; i--) {
				System.out.println("addAnimal");
				int posX = gScreen.createRamdonPosX();
				int posY = gScreen.createRandomPosY();
				String aKey = gScreen.createAnimalsKey();
				Animals a = new Animals(posX, posY , aKey, FallableUnit.fallUnitSpeed);
				System.out.println(posX + " " + aKey + " " + a.getZ());
				gLogic.addNewObj(a); 
			}
			animalPrevSec = sec;
		}
	}
	
	private void createHunters(int sec) {
		if(sec - hunterPrevSec == 2) {
			for(int i = FallableUnit.fallUnitGenRate; i > 0; i--) {
				System.out.println("addHunter");
				int posX = gScreen.createRamdonPosX();
				int posY = gScreen.createRandomPosY();
				String hKey = gScreen.createHuntersKey();
				Hunters h = new Hunters(posX, posY, hKey, FallableUnit.fallUnitSpeed);
				System.out.println(posX + " " + hKey + " " + h.getZ());
				gLogic.addNewObj(h);
			}
			hunterPrevSec = sec;
		}
	}
	
	private void accelerate(int sec) {
		if (sec - accelPrevSec == 5) {
			FallableUnit.accelerate();
			accelPrevSec = sec;
		}
	}
		
	private void setKeyPress() {
		game.setOnKeyPressed(e -> {
			String code = e.getCode().toString();
			System.out.println(code);
			if (!IOmanager.getpressed()) {
				IOmanager.setTriggered(code, true);
			}
			IOmanager.setPressed(true);
		});
		game.setOnKeyReleased(e -> {
			IOmanager.setPressed(false);
		});
		pauseButton.setOnMouseClicked(e -> {
			if (e.getButton().equals(MouseButton.PRIMARY)) {
				if (isPause) {
					unpause();
				}
				else pause();
			}
		});
	}
	
	private void pause() {
		isPause = true;
		anime.stop();
		gameTimer.pause();
		life.pause();
		MediaManager.getInstance().pauseGamePath();
		showSubscene();
	}
	
	private void unpause() {
		isPause = false;
		anime.start();
		gameTimer.unpause();
		life.unpause();
		MediaManager.getInstance().resumeGamePath();
		hideSubscene();
	}
	
	private void start() {
		createGameplay();
		gameTimer.start();
	}
	
	private void replay() {
		isPause = false;
		isGameOver = false;
		gLogic.clear();
		IRenderableHolder.getInstance().clear();
		animalPrevSec = 0;
		hunterPrevSec = 0;
		accelPrevSec = 0;
		anime.start();
		pauseButton.restart();
		gameTimer.unpause();
		gameTimer.reset();
		scoreCount.resetScore();
		FallableUnit.resetValues();
		Life.reset();
		MediaManager.getInstance().replayGamePath();
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
		LabelGenerator gO = new LabelGenerator("GAME OVER", 48);
		gO.setAlignment(Pos.CENTER);
		gO.setPrefWidth(gameOverSs.getWidth());
		gO.setLayoutY(49);
		LabelGenerator text_score = new LabelGenerator("Your Score Is", 40);
		LabelGenerator score = new LabelGenerator("" + scoreCount.getScoreCount(), 48);
		text_score.setAlignment(Pos.CENTER);
		score.setAlignment(Pos.CENTER);
		text_score.setPrefWidth(gameOverSs.getWidth());
		text_score.setLayoutY(140);
		score.setFont(new Font("Joystix Monospace", 72));
		score.setPrefWidth(gameOverSs.getWidth());
		score.setLayoutY(189);
		ButtonGenerator againBtn = new ButtonGenerator("Again"); 
		againBtn.setLayoutX((gameOverSs.getWidth() / 2) - 272);
		againBtn.setLayoutY(310);
		againBtn.setOnMouseClicked(e -> {
			if (e.getButton().equals(MouseButton.PRIMARY)) {
				gameOverSs.transitionOut();
				replay();
			}
		});
		ButtonGenerator menuBtn = new ButtonGenerator("Menu");
		menuBtn.setLayoutX((gameOverSs.getWidth() / 2) + 20);
		menuBtn.setLayoutY(310);
		menuBtn.setOnMouseClicked(e -> {
			if (e.getButton().equals(MouseButton.PRIMARY)) {
				Main.showMenuStage();
				Main.closeGameStage();
			}
		});
		gameOverSs.getSubScenePane().getChildren().addAll(gO, text_score, score, againBtn, menuBtn);
		anime.stop();
		gameTimer.pause();	
		pauseButton.setDisable(true);
	}
	
	private void customCursor() {
		Image customCur = new Image(CURSOR_PATH);
		game.setCursor(new ImageCursor(customCur));
	}
}
