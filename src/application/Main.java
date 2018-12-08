package application;

import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/*	
 * 	2018 Prog Meth Project Create By Tong & Pinn
 *  main application for launching game
 */

public class Main extends Application {
		
	@Override
	public void start(Stage primaryStage) {
		loadFont();
		UIManager ui = new UIManager();
		primaryStage.setTitle("Animal Rescue"); // game name 
		primaryStage = ui.getMainStage();
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args); 
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