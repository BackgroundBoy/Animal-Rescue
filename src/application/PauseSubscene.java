package application;

import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.SubScene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.util.Duration;

public class PauseSubscene extends SubScene {

	// load Background
	// need to find new panel image (this one seem to be too small)
	private final String BACKGROUND_PATH = ClassLoader.getSystemResource("images/pause_scene.png").toString();
	private AnchorPane root;
	private VBox box;
	private ButtonGenerator replayButton;
	private ButtonGenerator menuButton;
	private ButtonGenerator exitButton;
	
	// constructor
	public PauseSubscene() {
		// TODO Auto-generated constructor stub
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