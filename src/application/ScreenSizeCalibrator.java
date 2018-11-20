package application;

import javafx.stage.Screen;
import javafx.stage.Stage;

/*
	For fixing screen size problem
*/

public class ScreenSizeCalibrator {
	
	public static final double WIDTH = Screen.getPrimary().getBounds().getWidth();
	public static final double HEIGHT = Screen.getPrimary().getBounds().getHeight();
	
	public double setPinSize(double size) {
		return size / 1920 * WIDTH;
	}
	
	public double setTongSize(double size) {
		return size / 1366 * WIDTH;
	}
	
}
