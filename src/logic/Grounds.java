package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import sharedObject.IRenderableHolder;

public class Grounds extends Unit {
	
	public static final double WIDTH = 1366;
	public static final double HEIGHT = 176;
	
	public Grounds() {
		this.z = -998;
		this.x = 0;
		this.y = 668;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(IRenderableHolder.ground, x, y);
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
		return 668;
	}
}
