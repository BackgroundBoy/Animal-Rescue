package application;

import javafx.event.EventHandler;
import javafx.scene.ImageCursor;
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
import javafx.application.Platform;
import javafx.event.Event;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class UIManager {

	private Stage mainStage;
	private Scene mainScene;
	private AnchorPane uiRoot;
	private MenuSubscene helpSubScene;
	private MenuSubscene optionSubScene;

	// resource ClassLoader
	private final String BACKGROUND_PATH = ClassLoader.getSystemResource("images/b.jpg").toString();
	private final String CURSOR_PATH = ClassLoader.getSystemResource("images\\cursor_pointerFlat_shadow.png").toString();
			
	// constructor
	public UIManager() {
		uiRoot = new AnchorPane();
		mainScene = new Scene(uiRoot);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		createBackground();
		createAllButtons();
		createLogo();
		customCursor();
		createSubScene();
		
		
	}

	// get main stage
	public Stage getMainStage() {
		return mainStage;
	}

	// create buttons :
	protected void createAllButtons() {
		createPlayButton();
		createHelpButton();
		createOptionButton();
		createExitButton();
	}
	// play Button
	protected void createPlayButton() {
		ButtonGenerator butt = new ButtonGenerator("PLAY");
		butt.setLayoutX(175);
		butt.setLayoutY(250);
		uiRoot.getChildren().add(butt);
	}
	// help button 
	protected void createHelpButton() {
		ButtonGenerator butt = new ButtonGenerator("HELP");
		butt.setLayoutX(175);
		butt.setLayoutY(350);
		uiRoot.getChildren().add(butt);
		
		butt.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getButton().equals(MouseButton.PRIMARY)) {
					if(!helpSubScene.isShow())
						helpSubScene.transitionIn();
					else 
						helpSubScene.transitionOut();
				}
				arg0.consume();
			}
		});
		
	}
	// option button
	protected void createOptionButton() {
		ButtonGenerator opButt = new ButtonGenerator("OPTION");
		opButt.setLayoutX(175);
		opButt.setLayoutY(450);
		uiRoot.getChildren().add(opButt);
		
		opButt.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getButton().equals(MouseButton.PRIMARY)) {
					
					if(!optionSubScene.isShow())
						optionSubScene.transitionIn();
					else
						optionSubScene.transitionOut();
					
				}
				
				arg0.consume();
			}
		});
	}
	// exit button
	protected void createExitButton() {
		ButtonGenerator butt = new ButtonGenerator("EXIT");
		butt.setLayoutX(175);
		butt.setLayoutY(550);
		uiRoot.getChildren().add(butt);
		
		butt.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getButton().equals(MouseButton.PRIMARY)) {
					// maybe create pop up confirm windows 
					Platform.exit();
				}
			}
		});
		
	}

	// set Background
	protected void createBackground() {
		// Image background = new Image(BACKGROUND_PATH);
		// BackgroundImage bg = new BackgroundImage(background, BackgroundRepeat.REPEAT,
		// BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
		// uiRoot.setBackground(new Background(bg));

		// use css
		uiRoot.setStyle("-fx-background-image: url(" + BACKGROUND_PATH + "); " + "-fx-background-size: cover;");
	}
	
	// create Logo
	protected void createLogo() {
		LabelGenerator logo = new LabelGenerator("Animal\n  Rescue");
//		logo.setLogoFont();
		logo.setLayoutX(700);
		logo.setLayoutY(250);
		uiRoot.getChildren().add(logo);
	}
	
	// create subscenes
	protected void createSubScene() {
		helpSubScene = new MenuSubscene();
		optionSubScene = new MenuSubscene();
		
		uiRoot.getChildren().addAll(helpSubScene,optionSubScene);
	}
	
	// set custom cursor. Just for FUN!
	// Pinn really like this idea <3
	protected void customCursor() {
		Image customCur = new Image(CURSOR_PATH);
		mainScene.setCursor(new ImageCursor(customCur));
	}
}
