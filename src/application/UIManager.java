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
	private String BACKGROUND_PATH = ClassLoader.getSystemResource("images/b.jpg").toString();

	// constructor
	public UIManager() {
		uiRoot = new AnchorPane();
		mainScene = new Scene(uiRoot);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		setBackground();
		createPlayButton();
		createHelpButton();
		createOptionButton();
		createExitButton();
		
	}

	// get main stage
	public Stage getMainStage() {
		return mainStage;
	}

	// create buttons :
	// play Button
	public void createPlayButton() {
		ButtonGenerator butt = new ButtonGenerator("PLAY");
		butt.setLayoutX(175);
		butt.setLayoutY(250);
		uiRoot.getChildren().add(butt);
	}
	// help button 
	public void createHelpButton() {
		ButtonGenerator butt = new ButtonGenerator("HELP");
		butt.setLayoutX(175);
		butt.setLayoutY(350);
		uiRoot.getChildren().add(butt);
	}
	// option button
	public void createOptionButton() {
		ButtonGenerator opButt = new ButtonGenerator("OPTION");
		opButt.setLayoutX(175);
		opButt.setLayoutY(450);
		uiRoot.getChildren().add(opButt);
	}
	// exit button
	public void createExitButton() {
		ButtonGenerator butt = new ButtonGenerator("EXIT");
		butt.setLayoutX(175);
		butt.setLayoutY(550);
		uiRoot.getChildren().add(butt);
	}

	// set Background
	public void setBackground() {
		// Image background = new Image(BACKGROUND_PATH);
		// BackgroundImage bg = new BackgroundImage(background, BackgroundRepeat.REPEAT,
		// BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
		// uiRoot.setBackground(new Background(bg));

		// use css
		uiRoot.setStyle("-fx-background-image: url(" + BACKGROUND_PATH + "); " + "-fx-background-size: cover;");
	}

}
