package logic;

import java.util.Random;

import application.ScreenSizeCalibrator;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class Balloon extends VBox {
	
	// Element
	private Label box;
	private Label balloon;
	private double speed; //  min 0, max 1
	private boolean isPoped;
	private double position;
			
	// Size controller
	ScreenSizeCalibrator sc = new ScreenSizeCalibrator();

	// set boarder
	private double leftBoarder = sc.setTongSize(200);
	private double rightBoarder = ScreenSizeCalibrator.WIDTH - leftBoarder;
	
	// PATH
	private final double DEADLINE = sc.setTongSize(700);
	private final double FONT_SIZE = sc.setTongSize(25);
	private final String BOX_PATH = ClassLoader.getSystemResource("images/metalPanel.png").toString();
	private final String BOX_STYLE = "-fx-background-image: url(" + BOX_PATH + "); " + "-fx-background-size: cover;";
	private final String BALLOON_PATH = ClassLoader.getSystemResource("images/balloon.png").toString();
	private final String BALLOON_STYLE = "-fx-background-image: url(" + BALLOON_PATH + "); " + "-fx-background-size: cover;";
	private final String TEXT_STYLE = "-fx-text-fill: #000000;"
			+ "-fx-font-family: 'Joystix Monospace'; "
			+ "-fx-font-size: " + FONT_SIZE + "; ";
	
	// constructor

	public Balloon() {
		position = 0;
		speed = 0.5;
		isPoped = false;
		setAlignment(Pos.CENTER);
		createBalloons();
		createBox();
		fall();
	}
	
	// methods
	
	public void createBalloons() {
		balloon = new Label();
		balloon.setStyle(BALLOON_STYLE);
		balloon.setPrefSize(sc.setTongSize(100), sc.setTongSize(70));
		getChildren().add(balloon);
	}
	
	public void createBox() {
		box = new Label();
		box.setText(getRandomChar());
		box.setStyle(TEXT_STYLE + BOX_STYLE);
		box.setPrefSize(sc.setTongSize(40), sc.setTongSize(40));
		box.setAlignment(Pos.CENTER);
		getChildren().add(box);
	}
	
	public void fall() {
		setTranslateX(getRandomPos());
		setTranslateY(-box.getPrefHeight() -balloon.getPrefHeight());
//		System.out.println();
		TranslateTransition t = new TranslateTransition();
		t.setNode(this);
		t.setToY(DEADLINE);
		t.setDuration(new Duration(20000 - 20000*speed));
		t.play();
	}
	
	public double getRandomPos() {
		return (int)(Math.random() * (rightBoarder - leftBoarder) + leftBoarder);
	}
	
	public String getRandomChar() {
		Random r = new Random();
	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    return Character.toString(alphabet.charAt(r.nextInt(alphabet.length())));
	}
	
	public void pop() {
		setPoped(true);
		setDisable(true);
		setVisible(false);
	}
	
	public void accelerated() {
	// TODO
	}

	public String getAlphabet() {
		return box.getText();
	}

	public void setAlphabet(String alphabet) {
		box.setText(alphabet);
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = Math.min(speed, 1);
	}

	public boolean isPoped() {
		return isPoped;
	}

	public void setPoped(boolean isPoped) {
		this.isPoped = isPoped;
	}

}