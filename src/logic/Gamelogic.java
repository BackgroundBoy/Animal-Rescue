package logic;

import java.util.ArrayList;
import java.util.List;
import sharedObject.*;

public class Gamelogic {

	private List<IRenderable> gameContainer;
	
	
	public Gamelogic() {
		this.gameContainer = new ArrayList<IRenderable>();
		Background bg = new Background();
		Grounds ground = new Grounds();
		IRenderableHolder.getInstance().add(bg);
		IRenderableHolder.getInstance().add(ground);
		
	}
	
	public void addNewObj(IRenderable r) {
		gameContainer.add(r);
		IRenderableHolder.getInstance().add(r);
	}
	
	public void logicUpdate() {
		for(IRenderable ir : gameContainer) {
			if(!ir.isDestroyed() && ir.isVisible())
			ir.update();
		}
	}
	
}
