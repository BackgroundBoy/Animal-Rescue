package application;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class LabelGenerator extends Label{

	// Load font and color
	private final String FONT_LOGO_PATH = ClassLoader.getSystemResource("fonts/Blox2.ttf").toString();
	// text color, probably think later. Due to not having real background
	private final String TEXT_YELLOW = "-fx-text-fill: #ffff00; "; 
	
	//constructor
	public LabelGenerator(String text) {
		super(text);
		setWrapText(true);
	}
	
	//set font for logo
	protected void setLogoFont() {
		setFont(Font.loadFont(FONT_LOGO_PATH, 172));
		setTextColor(TEXT_YELLOW);
	}
	
	// set text color
	protected void setTextColor(String textColor) {
		setStyle(textColor);
	}
	
}
