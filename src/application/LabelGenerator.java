package application;

/*
	Deleted some function not in use
*/

import javafx.scene.control.Label;

public class LabelGenerator extends Label{

	// Text style, including COLOR, FONT and SIZE. Probably background later.
	private final String TEXT_STYLE = "-fx-text-fill: #ffff00;"
			+ "-fx-background-size: cover; "
			+ "-fx-font-family: 'Blox (BRK)'; "
			+ "-fx-font-size: 172; ";
	
	//constructor
	public LabelGenerator(String text) {
		super(text);
		setWrapText(true);
		setStyle(TEXT_STYLE);
	}
	
}
