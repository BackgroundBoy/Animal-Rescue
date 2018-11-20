package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.text.Font;

// 2018 Prog Meth Project Create By Tong & Pinn

/*
 *  main application for launching game
 * 
 */

public class Main extends Application {
		
	@Override
	public void start(Stage primaryStage) {
	
		UIManager ui = new UIManager();
		
		primaryStage = ui.getMainStage();
		
		primaryStage.setTitle("Animal Rescue");				// game name 
		primaryStage.setFullScreen(true);
		primaryStage.show();
		
//		// for calibrate screen fit other computers
//		ScreenSizeCalibrator scc = new ScreenSizeCalibrator();
		
	}

	public static void main(String[] args) {
		launch(args); 
	}
	
}