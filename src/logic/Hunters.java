package logic;

import Input.IOmanager;
import application.GameManager;
import application.MediaManager;
import draw.GameScreen;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sharedObject.IRenderableHolder;

public class Hunters extends FallableUnit {
	
//	protected static int radius = 150;
	public static final int WIDTH = 100, HEIGHT = 150;
	private static int score = 1;
	
	public Hunters(double x, double y, String key) {
		this.x = x;
		this.y = y;
		this.key = key;
		this.z = 9;
		this.speed = 2;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(IRenderableHolder.p1, x, y + 10);
		gc.drawImage(IRenderableHolder.h1, x + 20, y + 80);
		gc.setFill(Color.GOLD);
		gc.setFont(new Font("Joystix Monospace", 36));
		gc.fillText(key, x + 47, y + 45);
	}
	
	@Override
	public void update() {
		fall();
		if(IOmanager.getTriggered() && IOmanager.getCode().equals(key)){
			this.destroyed = true;
			Character c = key.charAt(0);
			if(GameScreen.getHuntersAlphabets().contains(c)) {
				MediaManager.playGetScore();
				GameScreen.getHuntersAlphabets().remove(c);
				System.out.println("hunChar " + key + " remove");
			}
			ScoreCount.addScore(Hunters.score);
			System.out.println("hunter " + key + " is DESTROYED! score +" + Hunters.score);
		}
		if(this.landOnGround()) {
			System.out.println("hunter " + key + " is landed");
			this.speed = 0;
			GameManager.setGameOver();
		}
		if (GameManager.getGameOver()) {
			this.destroyed = true;
		}
	}

}
