package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class ButtonGenerator extends Button {

	private String buttonName;
	
	// resource ClassLoader and const elements
	private final String TEXT_FONT = ClassLoader.getSystemResource("fonts/joystix_monospace.TTF").toString();
	private final double BUTTON_WIDTH = 300;
	private final double BUTTON_HEIGHT = 90;
	
	// constructor
	public ButtonGenerator(String name) {
		super(name);
		setButtonFont();
		setButtonSize();
	}
	
	// methods : 
	
	// method for set button's font
	public void setButtonFont() {
		setFont(Font.loadFont( TEXT_FONT, 36));
	}
	
	// set button size
	public void setButtonSize() {
		setPrefHeight(BUTTON_HEIGHT);
		setPrefWidth(BUTTON_WIDTH);
	}
	
	// method for set button style
	
}
