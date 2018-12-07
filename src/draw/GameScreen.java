package draw;

import Input.IOmanager;
import java.util.Random;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import logic.Animals;
import logic.Hunters;
import sharedObject.*;

public class GameScreen extends Canvas {

	private Random random;
	private static final Character[] alphabets = { 'A','B','C','D','E','F','G','H',
												   'I','J','K','L','M','N','O','P',
												   'Q','R','S','T','U','V','W','X',
												   'Z'
												  };
	
	public GameScreen(double width, double height) {
		super(width, height);
		this.setVisible(true);
		random = new Random();

	}
	
	public double createRamdonPos() {
		return random.nextInt(1536-Animals.WIDTH);
	}
	public String createRandomKey() {
		Character c = alphabets[random.nextInt(25)];
		String s = String.valueOf(c);
		return s;
	}
	
	
	public void drawComponent() {
		GraphicsContext gc = this.getGraphicsContext2D();
		// draw
		for(IRenderable e : IRenderableHolder.getInstance().getContainer()) {
			if(e.isVisible() && !e.isDestroyed())
				e.draw(gc);
		}
		
	}
	
}
