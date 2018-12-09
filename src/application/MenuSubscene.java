package application;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class MenuSubscene extends SubScene {

	private boolean show = false;
	private ButtonGenerator subSceneBtn;
	
	// load Background
	// need to find new panel image (this one seem to be too small)
	private static final String BACKGROUND_PATH = ClassLoader.getSystemResource("images/pause_scene.png").toString();
	
	// constructor
	public MenuSubscene() {
		// TODO Auto-generated constructor stub
		super(new AnchorPane(), 600, 600);
		setWidth(700);
		setHeight(430.5);		
		AnchorPane root = (AnchorPane) this.getRoot();
		root.setStyle("-fx-background-color: transparent; " 
						+ "-fx-background-image: url(" + BACKGROUND_PATH + "); "
						+ "-fx-background-size: cover; ");
		setLayoutX(1400);
		setLayoutY(245);
		
		subSceneBtn = new ButtonGenerator("back");
		subSceneBtn.setPrefHeight(31.5);
		subSceneBtn.setPrefWidth(210);
		subSceneBtn.setLayoutX(450);
		subSceneBtn.setLayoutY(330);
		
		root.getChildren().add(subSceneBtn);
		
	}
	
	public ButtonGenerator getSubSceneBtn() {
		return subSceneBtn;
	}
	
	public AnchorPane getPane() {
		return (AnchorPane) this.getRoot();
	}
	
	// set transition in out
	public void transitionIn() {
		show = true;
		TranslateTransition t = new TranslateTransition();
		t.setNode(this);
		t.setToX(-875);
		t.setToY(0);
		t.setDuration(new Duration(300));
		t.play();
	}
	public void transitionOut() {
		show = false;
		TranslateTransition t = new TranslateTransition();
		t.setNode(this);
		t.setToX(875);
		t.setToY(0);
		t.setDuration(new Duration(300));
		t.play();
	}
	
	public boolean isShow() {
		return show;
	}

}
