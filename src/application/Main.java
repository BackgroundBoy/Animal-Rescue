package application;

import javafx.application.Application;
import javafx.stage.Stage;

// 2018 Prog Meth Project Create By Tong & Pinn

/*
 *  main application for launching game
 * 
 */

public class Main extends Application {

	UIManager ui;
	
	@Override
	public void start(Stage primaryStage) {
		
		
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
