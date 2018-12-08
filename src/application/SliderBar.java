package application;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;

public class SliderBar extends HBox {

	private Slider slider;
	private Label number;
	private final String SLIDE_STYLE = "-fx-background-color: transparent; " 
			+ "-fx-background-image: url(" + ClassLoader.getSystemResource("images/bar.png").toString() + "); " 
			+ "-fx-background-size: cover; "
			+ "-fx-control-inner-background : #ffcc00;";

	/*
	 * the line above cause program error and idk why
	 */
	
	private final String LAB_STYLE = "-fx-text-fill: #000000;"
			+ "-fx-font-family: 'Joystix Monospace'; "
			+ "-fx-font-size: " + 20 + "; ";

	public SliderBar(String string) {
		super(10);
		Label label = new Label(string);
		label.setStyle(LAB_STYLE);
		createSlider();
		createLabel();
		getChildren().addAll(label, slider, number);
	}
	
	private void createSlider() {
		slider = new Slider();
		slider.setMin(0);
		slider.setMax(100);
		slider.setValue(50);
		slider.setPrefSize(296, 16);
		slider.setStyle(SLIDE_STYLE);
	}
	
	private void createLabel() {
		number = new Label();
		number.setStyle(LAB_STYLE);
		number.textProperty().bind(slider.valueProperty().asString("%.0f"));
	}
	
}
