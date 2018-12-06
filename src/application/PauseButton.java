package application;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;

public class PauseButton extends Button {
	
	private boolean isPause = false;
	private boolean isEnable = true;
	
	// use only calibrate size
		ScreenSizeCalibrator sc = new ScreenSizeCalibrator();	

	// Size controller
		private final double BUTTON_WIDTH = sc.setTongSize(49);
		
	// resource ClassLoader and const elements
		private final String NORM_PAUSE_PATH = ClassLoader.getSystemResource("images/pause_norm.png").toString();
		private final String PRESSED_PAUSE_PATH = ClassLoader.getSystemResource("images/pause_pressed.png").toString();
		private final String NORM_PLAY_PATH = ClassLoader.getSystemResource("images/play_norm.png").toString();
		private final String PRESSED_PLAY_PATH = ClassLoader.getSystemResource("images/play_pressed.png").toString();
		private final String PAUSE_NORM_STYLE = "-fx-background-color: transparent; " 
				+ "-fx-background-image: url(" + NORM_PAUSE_PATH + "); " 
				+ "-fx-background-size: cover; ";
		private final String PAUSE_ONPRESS_STYLE = "-fx-background-color: transparent; " 
				+ "-fx-background-image: url(" + PRESSED_PAUSE_PATH + "); " 
				+ "-fx-background-size: cover; ";
		private final String PLAY_NORM_STYLE = "-fx-background-color: transparent; " 
				+ "-fx-background-image: url(" + NORM_PLAY_PATH + "); " 
				+ "-fx-background-size: cover; ";
		private final String PLAY_ONPRESS_STYLE = "-fx-background-color: transparent; " 
				+ "-fx-background-image: url(" + PRESSED_PLAY_PATH + "); " 
				+ "-fx-background-size: cover; ";
		
	// constructor
	public PauseButton() {
		setButtonSize();
		setNormStyle();
		setActionFromMouse();
	}
	
	// methods : 
		
	// set button size
	public void setButtonSize() {
		setPrefWidth(BUTTON_WIDTH);
	}
	
	// set button's style
	public void setNormStyle() {
		setPrefHeight(sc.setTongSize(49));
		setLayoutY(getLayoutY() - sc.setTongSize(10) );
		if (isPause) setStyle(PLAY_NORM_STYLE);
		else setStyle(PAUSE_NORM_STYLE);
	}
	
	public void setPressedStyle() {
		setPrefHeight(sc.setTongSize(45));
		setLayoutY(getLayoutY() + sc.setTongSize(10) );
		if (isPause) setStyle(PLAY_ONPRESS_STYLE);
		else  setStyle(PAUSE_ONPRESS_STYLE);
	}
	
	// setOn mouse : entered, exited, pressed, released
	public void setActionFromMouse() {
		
		setOnMouseEntered(e -> {
				setEffect(new DropShadow());
				e.consume();
		});
		
		setOnMouseExited(e -> {
				setEffect(null);
				e.consume();
		});
		
		setOnMousePressed(e -> {
				if(e.getButton().equals(MouseButton.PRIMARY) && isEnable) {
					setPressedStyle();
					System.out.println("press");
				}
				e.consume();
		});
		
		setOnMouseReleased(e -> {
				if(e.getButton().equals(MouseButton.PRIMARY) && isEnable) {
					if (isPause) isPause = false;
					else isPause = true;
					setNormStyle();
					System.out.println("exit");
				}
				e.consume();
		});
		
	}
	

	public void setDisable() {
		isEnable = false;
	}
	
	public void setEnable() {
		isEnable = true;
	}
}
