package logic;

import application.ScreenSizeCalibrator;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Screen;

public class Grounds extends Unit {
	
	protected static final double X = 0;
	protected static final double Y = 780;
	protected static double width;
	protected static double height = 1536-780;
	
	public Grounds() {
		this.z = -998;
		
	}
	
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.GRAY);
		gc.fillRect(Grounds.X, Grounds.Y,Screen.getPrimary().getBounds().getWidth() , Screen.getPrimary().getBounds().getHeight()-Y);
		
	}
	@Override 
	public boolean isDestroyed() {
		return false;
	}
	@Override
	public boolean isVisible() {
		return true;
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	public static final double getY() {
		return Y;
	}
}
