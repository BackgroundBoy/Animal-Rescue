package logic;

import Input.IOmanager;
import application.GameManager;
import application.MediaManager;
import draw.GameScreen;
import javafx.scene.canvas.GraphicsContext;
import sharedObject.IRenderableHolder;

public class Animals extends FallableUnit {
	
//	protected static int radius = 184;
	public static final int WIDTH = 128, HEIGHT = 184;
	private static int score = -5;
	private boolean flashing = false;
	private int flashCount = 3;
	private int flashDuration = 20;
	private int showDuration = 30;
	
	public Animals(double x, double y, String key) {
		this.x = x;
		this.y = y;
		this.key = key;
		this.z = 8;
		this.speed = 2;
	}
	
	@Override
	public void draw(GraphicsContext gc) {		
		if(key.equals("A")) 
			gc.drawImage(IRenderableHolder.a1, x, y);
		else if(key.equals("B"))
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
		else if(key.equals("s1")) {
			gc.drawImage(IRenderableHolder.s1, x, y); key = "s2"; }
		else if(key.equals("s2")) {
			gc.drawImage(IRenderableHolder.s2, x, y); key = "s3"; }
		else if(key.equals("s3")) {
			gc.drawImage(IRenderableHolder.s3, x, y); key = "s4"; }
		else if(key.equals("s4")) {
			gc.drawImage(IRenderableHolder.s4, x, y); key = "s5"; }
		else if(key.equals("s5")) {
			gc.drawImage(IRenderableHolder.s5, x, y); key = "s6"; }
		else if(key.equals("s6")) {
			gc.drawImage(IRenderableHolder.s6, x, y); key = "s7"; }
		else if(key.equals("s7")) {
			gc.drawImage(IRenderableHolder.s7, x, y); key = "s8"; }
		else if(key.equals("s8")) {
			gc.drawImage(IRenderableHolder.s8, x, y); key = "s9"; }
		else if(key.equals("s9")) {
			gc.drawImage(IRenderableHolder.s9, x, y); key = "s10"; }
		else if(key.equals("s10")) {
			gc.drawImage(IRenderableHolder.s10, x, y); key = "s11"; }
		else if(key.equals("s11")) {
			gc.drawImage(IRenderableHolder.s11, x, y); key = "s12"; }
		else if(key.equals("s12")) {
			gc.drawImage(IRenderableHolder.s12, x, y); key = "s12"; }
	}

	@Override
	public void update() {
		fall();
		Character c = key.charAt(0);
		if( IOmanager.getTriggered() && IOmanager.getCode().equals(key)){
			this.destroyed = true;
			if(GameScreen.getAnimalsAlphabets().contains(c)) {
				MediaManager.getInstance().playQuack();
				GameScreen.getAnimalsAlphabets().remove(c);
				System.out.println("aniChar " + key + " remove");
			}
			ScoreCount.addScore(Animals.score);
			System.out.println("animal " + key + " is DESTROYED! score " + Animals.score);
		}
		if(this.landOnGround()) {
			if (speed != 0) 
				key = "s1";
			this.speed = 0;	
			if(GameScreen.getAnimalsAlphabets().contains(c)) {
				GameScreen.getAnimalsAlphabets().remove(c);
			}
			
			if(key.equals("s12") && !flashing && !isDestroyed()) {
				flashing = true;
				System.out.println("flashing!");
			}
			
			if(flashing) {
				if(flashCount == 0) {
					this.visible = false;
					this.flashing = false;
					this.destroyed = true;
				}else {
					if(flashDuration > 0) {
						this.visible = false;
						this.flashDuration--;
					}else {
						if(showDuration > 0) {
							this.visible = true;
							this.showDuration--;
						} else {
							this.flashCount--;
							this.showDuration = 30;
							this.flashDuration = 20;							
						}
					}
				}
				
			}
			
			
		}
		if (GameManager.getGameOver()) {
			this.destroyed = true;
		}
	}

}
