package application;

import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/*	
 * 	2018 Prog Meth Project Create By Tong & Pinn
 *  main application for launching game
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
		menuStage.setTitle("Animal Rescue"); // game name 
		menuStage.show();
		MediaManager.getInstance().playMainPath();
	}
	
	public static void showGameStage() {
		GameManager ui = new GameManager();
		gameStage = ui.getMainStage();
		gameStage.setTitle("Animal Rescue"); // game name 
		gameStage.show();
		MediaManager.getInstance().playGamePath();
	}
	
	public static void closeMenuStage() {
		menuStage.close();
	}
	
	public static void closeGameStage() {
		gameStage.close();
	}
	
	private void loadFont() {
		Font.loadFont(ClassLoader.getSystemResourceAsStream("fonts/BACKTO1982.TTF"), 100);
		Font.loadFont(ClassLoader.getSystemResourceAsStream("fonts/Blox2.ttf"), 100);
		Font.loadFont(ClassLoader.getSystemResourceAsStream("fonts/joystix_monospace.ttf"), 100);
		Font.loadFont(ClassLoader.getSystemResourceAsStream("fonts/operational amplifier.ttf"), 100);
		Font.loadFont(ClassLoader.getSystemResourceAsStream("fonts/pixFont.TTF"), 100);
		Font.loadFont(ClassLoader.getSystemResourceAsStream("fonts/animatedalphabet.ttf"), 100);		
	}
}