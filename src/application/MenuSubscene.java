package application;

import javafx.scene.layout.AnchorPane;
import javafx.scene.SubScene;
import javafx.util.Duration;
import javafx.animation.TranslateTransition;

public class MenuSubscene extends SubScene {

	private boolean show = false;
	
	// load Background
	// need to find new panel image (this one seem to be too small)
	private final String BACKGROUND_PATH = ClassLoader.getSystemResource("images/green.png").toString();
	
	
	// constructor
	public MenuSubscene() {
		// TODO Auto-generated constructor stub
		super(new AnchorPane(),600,600);
		
		AnchorPane root = (AnchorPane) this.getRoot();
		// set background
		root.setStyle("-fx-background-color: transparent; " + "-fx-background-image: url(" + BACKGROUND_PATH + "); "
						+ "-fx-background-size: cover; ");
		// set initial position
		setLayoutX(2000);
		setLayoutY(150);
		
	}
	
	// set transition in out
	public void transitionIn() {
		show = true;
		TranslateTransition t = new TranslateTransition();
		t.setNode(this);
		t.setToX(-1250);
		t.setToY(0);
		t.setDuration(new Duration(300));
		t.play();
	}
	public void transitionOut() {
		show = false;
		TranslateTransition t = new TranslateTransition();
		t.setNode(this);
		t.setToX(1250);
		t.setToY(0);
		t.setDuration(new Duration(300));
		t.play();
	}
	
	public boolean isShow() {
		return show;
	}
	
	
}
