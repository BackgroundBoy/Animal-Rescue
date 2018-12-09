package application;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;

public class PauseButton extends Button {
	
	private final double BUTTON_WIDTH = 49;
	public static boolean isPause = false;		
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
		
	public PauseButton() {
		setButtonSize();
		setNormStyle();
		setActionFromMouse();
	}
	
	private void setButtonSize() {
		setPrefWidth(BUTTON_WIDTH);
	}
	
	public void restart() {
		setDisable(false);
		isPause = false;
		setNormStyle();
	}
	
	private void setNormStyle() {
		setPrefHeight(49);
		setLayoutY(getLayoutY() - 10);
		if (isPause) {
			setStyle(PLAY_NORM_STYLE);
		} else {
			setStyle(PAUSE_NORM_STYLE);
		}
	}
	
	private void setPressedStyle() {
		setPrefHeight(45);
		setLayoutY(getLayoutY() + 10);
		if (isPause) {
			setStyle(PLAY_ONPRESS_STYLE);
		} else {
			setStyle(PAUSE_ONPRESS_STYLE);
		}
	}
	
	private void setActionFromMouse() {
		
		setOnMouseEntered(e -> {
				setEffect(new DropShadow());
				e.consume();
		});
		
		setOnMouseExited(e -> {
				setEffect(null);
				e.consume();
		});
		
		setOnMousePressed(e -> {
				if(e.getButton().equals(MouseButton.PRIMARY)) {
					setPressedStyle();
					System.out.println("press");
				}
				e.consume();
		});
		
		setOnMouseReleased(e -> {
				if(e.getButton().equals(MouseButton.PRIMARY)) {
					isPause = (isPause) ? false : true;
					setNormStyle();
					System.out.println("exit");
				}
				e.consume();
		});
		
	}

}
