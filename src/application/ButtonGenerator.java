package application;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.effect.DropShadow;

public class ButtonGenerator extends Button {
	
	// use only calibrate size
		ScreenSizeCalibrator sc = new ScreenSizeCalibrator();	

	// Size controller
		private final double BUTTON_WIDTH = sc.setPinSize(372);
		private final double BUTTON_HEIGHT = sc.setPinSize(90);
		private final double FONT_SIZE = sc.setPinSize(36);
		
	// resource ClassLoader and const elements
		private final String NORM_BUTTON_PATH = ClassLoader.getSystemResource("images/butt_norm.png").toString();
		private final String PRESSED_BUTTON_PATH = ClassLoader.getSystemResource("images/butt_pressed.png").toString();
		private final String BUTTON_NORM_STYLE = "-fx-background-color: transparent; " 
							+ "-fx-background-image: url(" + NORM_BUTTON_PATH + "); " 
							+ "-fx-background-size: cover; "
							+ "-fx-font-family: 'Joystix Monospace'; "
							+ "-fx-font-size: " + FONT_SIZE + "; ";
		private final String BUTTON_ONPRESS_STYLE = "-fx-background-color: transparent; " 
							+ "-fx-background-image: url(" + PRESSED_BUTTON_PATH + "); " 
							+ "-fx-background-size: cover; "
							+ "-fx-font-family: 'Joystix Monospace'; "
							+ "-fx-font-size: " + FONT_SIZE + "; ";

	
	// constructor
	public ButtonGenerator(String name) {
		super(name);
		setButtonSize();

		// set initial style 
		setNormStyle();

		// set initial action from mouse
		setActionFromMouse();

	}
	
	// methods : 
		
	// set button size
	public void setButtonSize() {
		setPrefHeight(BUTTON_HEIGHT);
		setPrefWidth(BUTTON_WIDTH);
	}
	
	// set button's style
	public void setNormStyle() {
		setPrefHeight(90);
		setLayoutY(getLayoutY() -10 );
		setStyle(BUTTON_NORM_STYLE);
	}
	public void setPressedStyle() {
		setPrefHeight(80);
		setLayoutY(getLayoutY() +10 );
		setStyle(BUTTON_ONPRESS_STYLE);
		
	}
	
	// setOn mouse : entered, exited, pressed, released
	public void setActionFromMouse() {
		
		setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setEffect(new DropShadow());
				arg0.consume();
			}
		});
		
		setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setEffect(null);
				arg0.consume();
			}
		});
		
		setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getButton().equals(MouseButton.PRIMARY)) {
					setPressedStyle();
					System.out.println("press");
				}
				arg0.consume();
			}
		});
		
		setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getButton().equals(MouseButton.PRIMARY)) {
					setNormStyle();
					System.out.println("exit");
				}
				arg0.consume();
			}
		});
	}
	
	
}