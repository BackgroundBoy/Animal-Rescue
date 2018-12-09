package application;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class UIManager {

	private Stage mainStage;
	private Scene mainScene;
	private AnchorPane uiRoot;
	private MenuSubscene helpSubScene;
	private MenuSubscene optionSubScene;
	private MenuSubscene playSubScene; // aka tutorial
	private MenuSubscene curShowSubScene; // curShowSS
	private MenuSubscene dummySubScene; // dummySS

	// resource ClassLoader
	private final String BACKGROUND_PATH = ClassLoader.getSystemResource("images/b.jpg").toString();
	private final String CURSOR_PATH = ClassLoader.getSystemResource("images\\cursor_pointerFlat_shadow.png")
			.toString();

	// constructor
	public UIManager() {
		uiRoot = new AnchorPane();
		mainScene = new Scene(uiRoot, 1366, 768);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		createBackground();
		createAllButtons();
		createLogo();
		customCursor();
		createSubScene();
	}
	
	public Stage getMainStage() {
		return mainStage;
	}
	
	public Scene getMainScene() {
		return mainScene;
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
		butt.setLayoutX(122.5);
		butt.setLayoutY(315);
		uiRoot.getChildren().add(butt);

		butt.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				if (arg0.getButton().equals(MouseButton.PRIMARY)) {

					if (curShowSubScene.equals(playSubScene)) {
						playSubScene.transitionOut();
						curShowSubScene = dummySubScene;
					} else {
						curShowSubScene.transitionOut();
						playSubScene.transitionIn();
						curShowSubScene = playSubScene;
					}
				}
			}
		});
	}

	// help button
	protected void createHelpButton() {
		ButtonGenerator butt = new ButtonGenerator("HELP");
		butt.setLayoutX(122.5);
		butt.setLayoutY(385);
		uiRoot.getChildren().add(butt);

		butt.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				if (arg0.getButton().equals(MouseButton.PRIMARY)) {
					if (curShowSubScene.equals(helpSubScene)) {
						helpSubScene.transitionOut();
						curShowSubScene = dummySubScene;
					} else {
						curShowSubScene.transitionOut();
						helpSubScene.transitionIn();
						curShowSubScene = helpSubScene;
					}
				}
				arg0.consume();
			}
		});

	}

	// option button
	protected void createOptionButton() {
		ButtonGenerator opButt = new ButtonGenerator("OPTION");
		opButt.setLayoutX(122.5);
		opButt.setLayoutY(455);
		uiRoot.getChildren().add(opButt);

		opButt.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {

				if (arg0.getButton().equals(MouseButton.PRIMARY)) {

					if (curShowSubScene.equals(optionSubScene)) {
						optionSubScene.transitionOut();
						curShowSubScene = dummySubScene;
					} else {
						curShowSubScene.transitionOut();
						optionSubScene.transitionIn();
						curShowSubScene = optionSubScene;
					}
				}
				arg0.consume();
			}
		});
	}

	// exit button
	protected void createExitButton() {
		ButtonGenerator butt = new ButtonGenerator("EXIT");
		butt.setLayoutX(122.5);
		butt.setLayoutY(525);
		uiRoot.getChildren().add(butt);

		butt.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {

				if (arg0.getButton().equals(MouseButton.PRIMARY)) {
					// maybe create pop up confirm windows
					Platform.exit();
				}
			}
		});

	}

	// set Background
	protected void createBackground() {
		uiRoot.setStyle("-fx-background-image: url(" + BACKGROUND_PATH + "); " + "-fx-background-size: cover;");
	}

	// create Logo
	protected void createLogo() {
		LabelGenerator logo = new LabelGenerator("Animal Rescue");
		logo.setAsHeader();
		logo.setLayoutX(140);
		logo.setLayoutY(98);
		uiRoot.getChildren().add(logo);
	}

	// create subscenes
	protected void createSubScene() {
		curShowSubScene = new MenuSubscene();
		dummySubScene = new MenuSubscene();
		createHelpSubScene();
		createOptionSubScene();
		createPlaySubScene();
	}

	// aka tutorial
	// this subscene will a tutorial and { "I'm READY" } button which will start the
	// game
	protected void createPlaySubScene() {
		playSubScene = new MenuSubscene();
		
		LabelGenerator head_Tutorial = new LabelGenerator("Tutorial");
		head_Tutorial.setFont(new Font("Joystix Monospace", 36));
		playSubScene.getPane().getChildren().add(head_Tutorial);
		head_Tutorial.setAlignment(Pos.CENTER);
		head_Tutorial.setPrefWidth(playSubScene.getWidth());;
		head_Tutorial.setLayoutY(30);
		
		LabelGenerator text_Tutorial = new LabelGenerator("\tthis is a tutorial demo "+
														  " so I don't \n know what to write "+
														  "yet, so nvm just a plain\n text to test.");
		
		text_Tutorial.setPrefWidth(playSubScene.getWidth());
		text_Tutorial.setLayoutY(100);
		playSubScene.getPane().getChildren().add(text_Tutorial);
		
		playSubScene.getSubSceneBtn().setText("OK");
		playSubScene.getSubSceneBtn().setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				if(arg0.getButton().equals(MouseButton.PRIMARY)) {
					MediaManager.getInstance().stopAll();
					Main.showGameStage();
					Main.closeMenuStage();
				}
			}
		});
		
		uiRoot.getChildren().add(playSubScene);
	}
	
	protected void createHelpSubScene() {
		helpSubScene = new MenuSubscene();
		uiRoot.getChildren().add(helpSubScene);
		helpSubScene.getSubSceneBtn().setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				helpSubScene.transitionOut();
				curShowSubScene = dummySubScene;
			}
		});
		LabelGenerator head_help = new LabelGenerator("Help");
		head_help.setFont(new Font("Joystix Monospace", 36));
		head_help.setAlignment(Pos.CENTER);
		head_help.setPrefWidth(helpSubScene.getWidth());
		head_help.setLayoutY(30);
		LabelGenerator helpLabel = new LabelGenerator("write some texts here.");
		helpLabel.setAlignment(Pos.CENTER);
		helpLabel.setPrefWidth(helpSubScene.getWidth());
		helpLabel.setLayoutY(100);
		helpSubScene.getPane().getChildren().addAll(head_help, helpLabel);
	}
	
	protected void createOptionSubScene() {
		optionSubScene = new MenuSubscene();
		uiRoot.getChildren().add(optionSubScene);
		optionSubScene.getSubSceneBtn().setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				optionSubScene.transitionOut();
				curShowSubScene = dummySubScene;
			}
		});
		LabelGenerator head_option = new LabelGenerator("Option");
		head_option.setFont(new Font("Joystix Monospace", 36));
		head_option.setAlignment(Pos.CENTER);
		head_option.setPrefWidth(optionSubScene.getWidth());
		head_option.setLayoutY(30);
		SliderBar slidebar = new SliderBar();
		slidebar.setAlignment(Pos.CENTER);
		slidebar.setLayoutX(100);
		slidebar.setLayoutY(180);
		optionSubScene.getPane().getChildren().addAll(head_option, slidebar);
	}

	// set custom cursor. Just for FUN!
	protected void customCursor() {
		Image customCur = new Image(CURSOR_PATH);
		mainScene.setCursor(new ImageCursor(customCur));
	}

}
