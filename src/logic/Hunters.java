package logic;

import Input.IOmanager;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Hunters extends FallableUnit {
	
	protected static int radius = 184;
	public static final int WIDTH = 50, HEIGHT = 184;
	
	public Hunters(double x, double y, String key) {
		this.x = x;
		this.y = y;
		this.key = key;
		this.z = 9;
		this.score = 1;
		this.speed = 2;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.RED);
		gc.fillRect(x, y, 128, 184);	
		gc.setFill(Color.BLUE);
		gc.fillText(key, x, y);
	}
	
	@Override
	public void update() {
		fall();
		if(IOmanager.getTriggered() && IOmanager.getCode().equals(key)){
			this.destroyed = true;
			ScoreCount.subScore(score);
			System.out.println(key + " is DESTROYED! score +" + score);
		}
		if(this.landOnGround()) {
			System.out.println("hunter " + key + " is landed");
			this.speed = 0;
		}
	}

}
