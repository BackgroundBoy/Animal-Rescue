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

	
	// resource ClassLoader and const elements
	private final String TEXT_FONT = ClassLoader.getSystemResource("fonts/joystix_monospace.TTF").toExternalForm();
	private final String NORM_BUTTON_PATH = ClassLoader.getSystemResource("images/butt_norm.png").toString();
	private final String PRESSED_BUTTON_PATH = ClassLoader.getSystemResource("images/butt_pressed.png").toString();
	private final String BUTTON_NORM_STYLE = "-fx-background-color: transparent; " + "-fx-background-image: url(" + NORM_BUTTON_PATH + "); " + "-fx-background-size: cover; -fx-font-family: 'Joystix Monospace'; -fx-font-size: 36; ";
	private final String BUTTON_ONPRESS_STYLE = "-fx-background-color: transparent; " + "-fx-background-image: url(" + PRESSED_BUTTON_PATH + "); " + "-fx-background-size: cover; -fx-font-family: 'Joystix Monospace'; -fx-font-size: 36; ";
	private final double BUTTON_WIDTH = 372;
	private final double BUTTON_HEIGHT = 90;

	
	// constructor
	public ButtonGenerator(String name) {
		super(name);
		setButtonSize();

		// set initial style 
		setNormStyle();
		//setButtonFont();
		// set initial action from mouse
		setActionFromMouse();

	}
	
	// methods : 
	
	// method for set button's font
//	public void setButtonFont() {
//		Font buttFont = Font.loadFont(TEXT_FONT, 36);
//		setFont(buttFont);
//		this.setStyle("-fx-font-size: 36; "); 
//	}
	
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
