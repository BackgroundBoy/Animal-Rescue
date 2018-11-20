package application;

/*
	Deleted some function not use
*/

import javafx.scene.control.Label;


public class LabelGenerator extends Label{

	// use only calibrate size
	ScreenSizeCalibrator sc = new ScreenSizeCalibrator();
	
	// Size controller
	private final double FONT_SIZE = sc.setPinSize(172);
	
	// Text style, including COLOR, FONT and SIZE. Probably background later.
	private final String TEXT_STYLE = "-fx-text-fill: #ffff00;"
			+ "-fx-background-size: cover; "
			+ "-fx-font-family: 'Blox (BRK)'; "
			+ "-fx-font-size: " + FONT_SIZE + "; ";
	
	//constructor
	public LabelGenerator(String text) {
		super(text);
		setWrapText(true);
		setStyle(TEXT_STYLE);
	}
	
}
