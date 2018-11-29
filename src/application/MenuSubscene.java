package application;

import javafx.scene.layout.AnchorPane;
import javafx.scene.SubScene;
import javafx.util.Duration;

import java.nio.file.attribute.PosixFilePermission;

import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class MenuSubscene extends SubScene {

	private boolean show = false;
	private ButtonGenerator subSceneBtn;
	
	// use only calibrate size
	ScreenSizeCalibrator sc = new ScreenSizeCalibrator();
	
	// load Background
	// need to find new panel image (this one seem to be too small)
	private static final String BACKGROUND_PATH = ClassLoader.getSystemResource("images/pause_scene.png").toString();
	
	// constructor
	public MenuSubscene() {
		// TODO Auto-generated constructor stub
		super(new AnchorPane(), 600, 600);

		// Because i can't set this in constructor
		setWidth(sc.setPinSize(1000));
		setHeight(sc.setPinSize(615));
		
		AnchorPane root = (AnchorPane) this.getRoot();
		// set background
		root.setStyle("-fx-background-color: transparent; " 
						+ "-fx-background-image: url(" + BACKGROUND_PATH + "); "
						+ "-fx-background-size: cover; ");
		// set initial position
		setLayoutX(sc.setPinSize(2000));
		setLayoutY(sc.setPinSize(350));
		
		subSceneBtn = new ButtonGenerator("test");
		subSceneBtn.setPrefHeight(sc.setPinSize(45));
		subSceneBtn.setPrefWidth(sc.setPinSize(186));
		subSceneBtn.setLayoutX(sc.setPinSize(650));
		subSceneBtn.setLayoutY(sc.setPinSize(450));
		
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
		t.setToX(sc.setPinSize(-1250));
		t.setToY(0);
		t.setDuration(new Duration(300));
		t.play();
	}
	public void transitionOut() {
		show = false;
		TranslateTransition t = new TranslateTransition();
		t.setNode(this);
		t.setToX(sc.setPinSize(1250));
		t.setToY(0);
		t.setDuration(new Duration(300));
		t.play();
	}
	
	public boolean isShow() {
		return show;
	}
	
	
}
