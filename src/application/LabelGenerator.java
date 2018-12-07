package application;

import javafx.geometry.Pos;

/*
	Deleted some function not use
*/

import javafx.scene.control.Label;
import javafx.scene.text.Font;


public class LabelGenerator extends Label{

	// Size controller
	private final double HEAD_FONT_SIZE = 120.4;
	private final double NORM_FONT_SIZE = 33.6;
	
	// Text style, including COLOR, FONT and SIZE. Probably background later.
	
	private final String HEAD_STYLE = "-fx-text-fill: #ffff00;"
			+ "-fx-font-family: 'Animal Alphabet'; "
			+ "-fx-font-size: " + HEAD_FONT_SIZE + "; ";
	
	
	//constructor
	public LabelGenerator(String text) {
		super(text);
		setWrapText(true);
		setAlignment(Pos.TOP_CENTER);
		
		// this Joystix Monospace will be the default font :O 
		setFont(new Font("Joystix Monospace", 14));
	}
	
	// use this method to set to head(logo) font (head's font is Blox)
	public void setAsHeader() {
		setHeadStyle();
	}
	
	// set font :
	private void setHeadStyle() {
		setStyle(HEAD_STYLE);
	}
	
}
