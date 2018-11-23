package logic;

import java.util.Random;

import application.ScreenSizeCalibrator;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Balloon extends Label {
	
	// Element
	protected double speed;
	protected boolean isPoped;
	protected double position;
	private double leftBoarder;
	private double rightBoarder;
			
	// Size controller
	ScreenSizeCalibrator sc = new ScreenSizeCalibrator();
	
	private final double DEADLINE = sc.setTongSize(700);
	
	// constructor

	public Balloon() {
		setText(getRandomChar());
		position = 0;
		speed = 0;
		isPoped = false;
		setLeftandRightBoarder();
//		setPrefSize(40, 40);
		getRandomChar();
		fall();
	}
	
	// methods
	
	public void fall() {
		setTranslateX(getRandomPos());
		TranslateTransition t = new TranslateTransition();
		t.setNode(this);
		t.setToY(DEADLINE);
		t.setDuration(new Duration(10000 - 10000*speed));
		t.play();
	}
	
	public void setLeftandRightBoarder() {
		leftBoarder = sc.setTongSize(200);
		rightBoarder = ScreenSizeCalibrator.WIDTH - leftBoarder;
	}
	
	public double getRandomPos() {
		return (int)(Math.random() * (rightBoarder) + leftBoarder);
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