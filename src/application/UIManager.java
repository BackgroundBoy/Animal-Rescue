package application;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class UIManager {
	
	private Stage mainStage;
	private Scene mainScene;
	private AnchorPane uiRoot;
	
	// constructor
	public UIManager() {
		uiRoot = new AnchorPane();
		mainScene = new Scene(uiRoot);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
	}
	
	// get main stage
	public Stage getMainStage() {
		return mainStage;
	}
	
	// create buttons
	public void createButton() {
		
	}
	
	
	

}
