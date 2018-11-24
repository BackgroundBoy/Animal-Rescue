package logic;

import java.util.Random;

import application.ScreenSizeCalibrator;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Balloon extends Label {
	
	// Element
	private double speed;
	private boolean isPoped;
	private double position;
			
	// Size controller
	ScreenSizeCalibrator sc = new ScreenSizeCalibrator();

	// set boarder
	private double leftBoarder = sc.setTongSize(200);
	private double rightBoarder = ScreenSizeCalibrator.WIDTH - leftBoarder;
	
	// PATH
	private final double DEADLINE = sc.setTongSize(700);
	private final double FONT_SIZE = sc.setTongSize(30);
	private final String BACKGROUND_PATH = ClassLoader.getSystemResource("images/metalPanel.png").toString();
	private final String BACKGROUND_STYLE = "-fx-background-image: url(" + BACKGROUND_PATH + "); " + "-fx-background-size: cover;";
	private final String TEXT_STYLE = "-fx-text-fill: #000000;"
			+ "-fx-font-family: 'Joystix Monospace'; "
			+ "-fx-font-size: " + FONT_SIZE + "; ";
	
	// constructor

	public Balloon() {
		setText(getRandomChar());
		position = 0;
		speed = 0;
		isPoped = false;
		setStyle(TEXT_STYLE + BACKGROUND_STYLE);
		setPrefSize(sc.setTongSize(50), sc.setTongSize(50));
		setAlignment(Pos.CENTER);
		getRandomChar();
		fall();
	}
	
	// methods
	
	public void fall() {
		setTranslateX(getRandomPos());
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
		return getText();
	}

	public void setAlphabet(String alphabet) {
		setText(alphabet);
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