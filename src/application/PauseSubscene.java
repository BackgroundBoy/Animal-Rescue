package application;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.util.Duration;

public class PauseSubscene extends SubScene {

	private final String BACKGROUND_PATH = ClassLoader.getSystemResource("images/pause_scene.png").toString();
	private AnchorPane root;
	
	public PauseSubscene() {
		super(new AnchorPane(), 0, 0);
		setWidth(730);
		setHeight(449);
		root = (AnchorPane) this.getRoot();
		root.setStyle("-fx-background-color: transparent; " 
						+ "-fx-background-image: url(" + BACKGROUND_PATH + "); "
						+ "-fx-background-size: cover; ");
		setLayoutX((Screen.getPrimary().getBounds().getWidth() - getWidth()) / 2);
		setLayoutY(-getHeight());
	}
	
	public void transitionIn() {
		TranslateTransition t = new TranslateTransition();
		t.setNode(this);
		t.setToX(0);
		t.setToY(getHeight() + (Screen.getPrimary().getBounds().getHeight() - getHeight()) / 3);
		t.setDuration(new Duration(300));
		t.play();
	}
	
	public void transitionOut() {
		TranslateTransition t = new TranslateTransition();
		t.setNode(this);
		t.setToX(0);
		t.setToY(-getHeight() - (Screen.getPrimary().getBounds().getHeight() - getHeight()) / 3);
		t.setDuration(new Duration(300));
		t.play();
	}
	
	public AnchorPane getSubScenePane() {
		return (AnchorPane) this.getRoot();
	}
	
}