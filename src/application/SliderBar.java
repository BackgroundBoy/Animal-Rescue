package application;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import application.MediaManager;

public class SliderBar extends HBox {

	private static Slider slider;
	private static Label number;
	private static final String SLIDE_STYLE = "-fx-background-color: transparent; " 
			+ "-fx-background-image: url(" + ClassLoader.getSystemResource("images/bar.png").toString() + "); "
			+ "-fx-control-inner-background : #ffcc00;";
	private static final String LAB_STYLE = "-fx-text-fill: #000000;"
			+ "-fx-font-family: 'Joystix Monospace'; "
			+ "-fx-font-size: 20; ";

	public SliderBar() {
		super(10);
		Label label = new Label("VOLUME");
		label.setStyle(LAB_STYLE);
		createSlider();
		createLabel();
		getChildren().addAll(label, slider, number);
	}
	
	private void createSlider() {
		slider = new Slider();
		slider.setMin(0);
		slider.setMax(100);
		slider.setValue(MediaManager.volume * 100);
		slider.setPrefSize(296, 16);
		slider.setStyle(SLIDE_STYLE);
	}
	
	private void createLabel() {
		number = new Label();
		number.setStyle(LAB_STYLE);
		number.textProperty().bind(slider.valueProperty().asString("%.0f"));
		Thread t = new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(50);
					MediaManager.volume = Double.parseDouble(number.getText()) / 100;
					MediaManager.getInstance().update();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t.start();
	}
	
	public Label getLabel() {
		return number;
	}
}
