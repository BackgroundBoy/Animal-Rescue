package logic;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.IRenderable;
import sharedObject.IRenderableHolder;

public class Background implements IRenderable {

	public Background() {
	}
	
	@Override
	public int getZ() {
		return -999;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(IRenderableHolder.bg, 0, 0, 1366, 768);		
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	@Override
	public boolean isDestroyed() {
		return false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

}
