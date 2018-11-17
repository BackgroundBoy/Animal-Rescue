package application;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class LabelGenerator extends Label{

	// Load font and color
	private final String FONT_PATH_1 = ClassLoader.getSystemResource("fonts/Blox2.ttf").toString();
//	private final String FONT_STYLE_1 = "";
	
	//constructor
	public LabelGenerator(String text) {
		super(text);
		
	}
	
	//set font for logo
	protected void setLogoFont() {
		setFont(Font.loadFont(FONT_PATH_1, 48));
	}
	
	protected void setTextColor() {
		
	}
	
}
