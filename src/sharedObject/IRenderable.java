package sharedObject;

import javafx.scene.canvas.GraphicsContext;

public interface IRenderable {
	
	public int getZ();
	public void update();
	public boolean isVisible();
	public boolean isDestroyed();
	public void draw(GraphicsContext gc);

}
