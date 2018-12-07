package application;

import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

// 2018 Prog Meth Project Create By Tong & Pinn

/*
 *  main application for launching game
 * 
 */

public class Main extends Application {
			
	@Override
	public void start(Stage primaryStage) {

		// Font Loader for import all fonts to the game
		Font.loadFont(ClassLoader.getSystemResourceAsStream("fonts/BACKTO1982.TTF"), 100);
		Font.loadFont(ClassLoader.getSystemResourceAsStream("fonts/Blox2.ttf"), 100);
		Font.loadFont(ClassLoader.getSystemResourceAsStream("fonts/joystix_monospace.ttf"), 100);
		Font.loadFont(ClassLoader.getSystemResourceAsStream("fonts/operational amplifier.ttf"), 100);
		Font.loadFont(ClassLoader.getSystemResourceAsStream("fonts/pixFont.TTF"), 100);
		Font.loadFont(ClassLoader.getSystemResourceAsStream("fonts/animatedalphabet.ttf"), 100);
		
		System.out.println(Screen.getPrimary().getBounds().getHeight());
		System.out.println(Screen.getPrimary().getBounds().getWidth());
		
		UIManager ui = new UIManager();
		
		primaryStage = ui.getMainStage();
		
		primaryStage.setTitle("Animal Rescue");				// game name 
		primaryStage.setFullScreen(true);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args); 
	}
	
}