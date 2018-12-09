package application;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UIManager {

	private Stage mainStage;
	private Scene mainScene;
	private AnchorPane uiRoot;
	private MenuSubscene creditSubScene;
	private MenuSubscene optionSubScene;
	private MenuSubscene playSubScene; 
	private MenuSubscene curShowSubScene;
	private MenuSubscene dummySubScene;
	private final String BACKGROUND_PATH = ClassLoader.getSystemResource("images/bgfbig.png").toString();
	private final String LOGO_PATH = ClassLoader.getSystemResource("images/header.png").toString();
	private final String CURSOR_PATH = ClassLoader.getSystemResource("images/cursor.png")
			.toString();

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

	protected void createAllButtons() {
		createPlayButton();
		createCreditButton();
		createOptionButton();
		createExitButton();
	}

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

	protected void createCreditButton() {
		ButtonGenerator butt = new ButtonGenerator("CREDIT");
		butt.setLayoutX(122.5);
		butt.setLayoutY(385);
		uiRoot.getChildren().add(butt);
		butt.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				if (arg0.getButton().equals(MouseButton.PRIMARY)) {
					if (curShowSubScene.equals(creditSubScene)) {
						creditSubScene.transitionOut();
						curShowSubScene = dummySubScene;
					} else {
						curShowSubScene.transitionOut();
						creditSubScene.transitionIn();
						curShowSubScene = creditSubScene;
					}
				}
				arg0.consume();
			}
			
		});

	}

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

	protected void createExitButton() {
		ButtonGenerator butt = new ButtonGenerator("EXIT");
		butt.setLayoutX(122.5);
		butt.setLayoutY(525);
		uiRoot.getChildren().add(butt);
		butt.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				if (arg0.getButton().equals(MouseButton.PRIMARY)) {
					Platform.exit();
				}
			}
			
		});
	}

	protected void createBackground() {
		uiRoot.setStyle("-fx-background-image: url(" + BACKGROUND_PATH + "); " + "-fx-background-size: cover;");
	}

	protected void createLogo() {
		ImageView logo = new ImageView(new Image(LOGO_PATH));
		logo.setLayoutX(100);
		logo.setLayoutY(120);
		uiRoot.getChildren().add(logo);
	}

	protected void createSubScene() {
		curShowSubScene = new MenuSubscene();
		dummySubScene = new MenuSubscene();
		createCreditSubScene();
		createOptionSubScene();
		createPlaySubScene();
	}

	protected void createPlaySubScene() {
		playSubScene = new MenuSubscene();
		String path = ClassLoader.getSystemResource("images/play_scene.png").toString();
		playSubScene.getPane().setStyle("-fx-background-color: transparent; "
				+ "-fx-background-image: url(" + path + "); "
				+ "-fx-background-size: cover; ");
		LabelGenerator head_Tutorial = new LabelGenerator("Tutorial", 36);
		playSubScene.getPane().getChildren().add(head_Tutorial);
		head_Tutorial.setAlignment(Pos.CENTER);
		head_Tutorial.setPrefWidth(playSubScene.getWidth());;
		head_Tutorial.setLayoutY(30);
		playSubScene.getSubSceneBtn().setText("OK");
		playSubScene.getSubSceneBtn().setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				if (arg0.getButton().equals(MouseButton.PRIMARY)) {
					MediaManager.getInstance().stopAll();
					Main.showGameStage();
					Main.closeMenuStage();
				}
			}
			
		});
		uiRoot.getChildren().add(playSubScene);
	}
	
	protected void createCreditSubScene() {
		creditSubScene = new MenuSubscene();
		String path = ClassLoader.getSystemResource("images/helpSubscene.png").toString();
		creditSubScene.getPane().setStyle("-fx-background-color: transparent; " 
						+ "-fx-background-image: url(" + path + "); "
						+ "-fx-background-size: cover; ");
		uiRoot.getChildren().add(creditSubScene);
		creditSubScene.getSubSceneBtn().setOnMouseClicked(new EventHandler<MouseEvent>() {
		
			@Override
			public void handle(MouseEvent arg0) {
				creditSubScene.transitionOut();
				curShowSubScene = dummySubScene;
			}
			
		});
		LabelGenerator credit = new LabelGenerator("credit", 36);
		credit.setAlignment(Pos.CENTER);
		credit.setPrefWidth(creditSubScene.getWidth());
		credit.setLayoutY(30);
		creditSubScene.getPane().getChildren().addAll(credit);
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
		LabelGenerator head_option = new LabelGenerator("Option", 36);
		head_option.setAlignment(Pos.CENTER);
		head_option.setPrefWidth(optionSubScene.getWidth());
		head_option.setLayoutY(30);
		SliderBar slidebar = new SliderBar();
		slidebar.setAlignment(Pos.CENTER);
		slidebar.setLayoutX(100);
		slidebar.setLayoutY(180);
		optionSubScene.getPane().getChildren().addAll(head_option, slidebar);
	}

	protected void customCursor() {
		Image customCur = new Image(CURSOR_PATH);
		mainScene.setCursor(new ImageCursor(customCur));
	}

}
