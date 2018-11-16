package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class ButtonGenerator extends Button {

	private String buttonName;
	
	// resource ClassLoader
	private final String TEXT_FONT = ClassLoader.getSystemResource("fonts/pixFont.TTF").toString();

	
	// constructor
	public ButtonGenerator(String name) {
		super(name);
		setButtonFont();
	}
	
	// methods : 
	
	// method for set button's font
	public void setButtonFont() {
		try {
			setFont(Font.loadFont(new FileInputStream(TEXT_FONT), 25));
		}catch(FileNotFoundException e) {
			setFont(new Font(25));
		}
	}
	
	// method for set button style
	
}
