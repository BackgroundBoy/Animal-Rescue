package application;

import javafx.stage.Screen;

/*  For fixing screen size problem  */

public class ScreenSizeCalibrator {
	
	public static final double WIDTH = Screen.getPrimary().getBounds().getWidth();
	public static final double HEIGHT = Screen.getPrimary().getBounds().getHeight();
	
	// For Creator "Pinn" Declare numbers related to his Screen Size
	public double setPinSize(double size) {
		return size / 1920 * WIDTH;
	}
	
	// For Creator "Tong" Declare numbers related to his Screen Size
	public double setTongSize(double size) {
		return size / 1366 * WIDTH;
	}
	
}
