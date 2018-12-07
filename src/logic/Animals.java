package logic;

import Input.IOmanager;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.IRenderableHolder;

public class Animals extends FallableUnit {
	
	protected static int radius = 184;
	public static final int WIDTH = 128, HEIGHT = 184;
	
	public Animals(double x, double y, String key) {
		this.x = x;
		this.y = y;
		this.key = key;
		this.z = 8;
		this.speed = 2;
		this.score = -1;
	}
	
	
	@Override
	public void draw(GraphicsContext gc) {		
		if(this.key.equals("A")) 
			gc.drawImage(IRenderableHolder.a1, x, y);
		else if(this.key.equals("B"))
			gc.drawImage(IRenderableHolder.a2, x, y);
		else if(key.equals("C"))
			gc.drawImage(IRenderableHolder.a3, x, y);
		else if(key.equals("D"))
			gc.drawImage(IRenderableHolder.a4, x, y);
		else if(key.equals("E"))
			gc.drawImage(IRenderableHolder.a5, x, y);
		else if(key.equals("F"))
			gc.drawImage(IRenderableHolder.a6, x, y);
		else if(key.equals("G"))
			gc.drawImage(IRenderableHolder.a7, x, y);
		else if(key.equals("H"))
			gc.drawImage(IRenderableHolder.a8, x, y);
		else if(key.equals("I"))
			gc.drawImage(IRenderableHolder.a9, x, y);
		else if(key.equals("J"))
			gc.drawImage(IRenderableHolder.a10, x, y);
		else if(key.equals("K"))
			gc.drawImage(IRenderableHolder.a11, x, y);
		else if(key.equals("L"))
			gc.drawImage(IRenderableHolder.a12, x, y);
		else if(key.equals("M"))
			gc.drawImage(IRenderableHolder.a13, x, y);
		else if(key.equals("N"))
			gc.drawImage(IRenderableHolder.a14, x, y);
		else if(key.equals("O"))
			gc.drawImage(IRenderableHolder.a15, x, y);
		else if(key.equals("P"))
			gc.drawImage(IRenderableHolder.a16, x, y);
		else if(key.equals("Q"))
			gc.drawImage(IRenderableHolder.a17, x, y);
		else if(key.equals("R"))
			gc.drawImage(IRenderableHolder.a18, x, y);
		else if(key.equals("S"))
			gc.drawImage(IRenderableHolder.a19, x, y);
		else if(key.equals("T"))
			gc.drawImage(IRenderableHolder.a20, x, y);
		else if(key.equals("U"))
			gc.drawImage(IRenderableHolder.a21, x, y);
		else if(key.equals("V"))
			gc.drawImage(IRenderableHolder.a22, x, y);
		else if(key.equals("W"))
			gc.drawImage(IRenderableHolder.a23, x, y);
		else if(key.equals("X"))
			gc.drawImage(IRenderableHolder.a24, x, y);
		else if(key.equals("Y"))
			gc.drawImage(IRenderableHolder.a25, x, y);
		else if(key.equals("Z"))
			gc.drawImage(IRenderableHolder.a26, x, y);
	}


	@Override
	public void update() {
		fall();
		if( IOmanager.getTriggered() && IOmanager.getCode().equals(key)){
			this.destroyed = true;
			System.out.println("animal " + key + " is DESTROYED! MOTHERFUCKER");
		}
		if(this.landOnGround()) {
			System.out.println("animal " + key + "is landed");
			this.speed = 0;
		}
	}


}
