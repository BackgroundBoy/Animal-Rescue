package application;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;



public class UIManager {
	
	private Stage mainStage;
	private Scene mainScene;
	private AnchorPane uiRoot;
	
	// resource ClassLoader
	private String BACKGROUND_PATH = ClassLoader.getSystemResource("images/a.jpg").toString();
	
	// constructor
	public UIManager() {
		uiRoot = new AnchorPane();
		mainScene = new Scene(uiRoot);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		setBackground();
	}
	
	// get main stage
	public Stage getMainStage() {
		return mainStage;
	}
	
	// create buttons
	public void createButton() {
		
	}
	
	// set Background
	public void setBackground() {
//		Image background = new Image(BACKGROUND_PATH);
//		BackgroundImage bg = new BackgroundImage(background, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
//		uiRoot.setBackground(new Background(bg));
		// use css
		uiRoot.setStyle(
				"-fx-background-image: url(" + BACKGROUND_PATH + 
				"); " +
				"-fx-background-size: cover;"
		);
		
	}
	
	
	

}
