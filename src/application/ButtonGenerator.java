package application;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class ButtonGenerator extends Button {
	
	private final double BUTTON_WIDTH = 252;
	private final double BUTTON_HEIGHT = 65;
	private final double FONT_SIZE = 26;		
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
		
	public ButtonGenerator(String name) {
		super(name);
		setButtonSize();
		setNormStyle();
		setActionFromMouse();
	}
			
	private void setButtonSize() {
		setPrefHeight(BUTTON_HEIGHT);
		setPrefWidth(BUTTON_WIDTH);
	}
	
	private void setNormStyle() {
		setPrefHeight(63);
		setLayoutY(getLayoutY() - 7);
		setStyle(BUTTON_NORM_STYLE);
	}
	
	private void setPressedStyle() {
		setPrefHeight(56);
		setLayoutY(getLayoutY() + 7);
		setStyle(BUTTON_ONPRESS_STYLE);
		
	}
	
	private void setActionFromMouse() {
		
		setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setEffect(new DropShadow());
				MediaManager.getInstance().playEntered();
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
					MediaManager.getInstance().playClick();
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