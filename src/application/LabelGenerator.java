package application;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class LabelGenerator extends Label{

	public LabelGenerator(String text, int size) {
		super(text);
		setWrapText(true);
		setAlignment(Pos.TOP_CENTER);
		setFont(new Font("Joystix Monospace", size));
	}	
	
}
