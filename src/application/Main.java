package application;

import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/*	
 * 	Copyright by nothing
 * 
 * 	Animal Rescue
 * 	game for improving your keyboard skill
 * 
 * 	2110215 Programing Methodology (2018/1)
 * 	created By Tong & Pinn
 * 	1. Pollawat Hongwimol 6030400021
 * 	2. Peeranuth Kehasukchareon 6030416021 
 */	

public class Main extends Application {
		
	private static Stage menuStage;
	private static Stage gameStage;	
	
	@Override
	public void start(Stage primaryStage) {
		loadFont();
		showMenuStage();
	}

	public static void main(String[] args) {
		launch(args); 
	}
	
	public static void showMenuStage() {
		UIManager ui = new UIManager();
		menuStage = ui.getMainStage();
		menuStage.show();
		menuStage.setResizable(false);
		MediaManager.getInstance().playMainPath();
	}
	
	public static void showGameStage() {
		GameManager ui = new GameManager();
		gameStage = ui.getMainStage();
		gameStage.show();
		gameStage.setResizable(false);
		MediaManager.getInstance().playGamePath();
	}
	
	public static void closeMenuStage() {
		menuStage.close();
	}
	
	public static void closeGameStage() {
		gameStage.close();
	}
	
	private void loadFont() {
		Font.loadFont(ClassLoader.getSystemResourceAsStream("fonts/joystix_monospace.ttf"), 100);
	}
}