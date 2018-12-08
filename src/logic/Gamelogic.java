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
	
	public void clear() {
		gameContainer.clear();
	}
	
	public void logicUpdate() {
//		for(IRenderable ir : gameContainer) {
//			if(!ir.isDestroyed() && ir.isVisible())
//			ir.update();
//		}
		for(int i = gameContainer.size()-1; i >= 0; i--) {
			if(!gameContainer.get(i).isDestroyed() && gameContainer.get(i).isVisible())
				gameContainer.get(i).update();
			if(gameContainer.get(i).isDestroyed())
				gameContainer.remove(i);
		}
	}
	
}
