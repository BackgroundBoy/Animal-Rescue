package draw;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Screen;
import logic.Animals;
import sharedObject.IRenderable;
import sharedObject.IRenderableHolder;


public class GameScreen extends Canvas {

	private Random random;
	private static final Character[] ALPHABETS = { 'A','B','C','D','E','F','G','H',
												   'I','J','K','L','M','N','O','P',
												   'Q','R','S','T','U','V','W','X',
												   'Y','Z'
												  };
	private static List<Character> huntersAlphabets;
	private static List<Character> animalsAlphabets;
	
	
	public GameScreen(double width, double height) {
		super(width, height);
		this.setVisible(true);
		random = new Random();
		huntersAlphabets = new ArrayList<Character>();
		animalsAlphabets = new ArrayList<Character>();
	}
	
	public double createRamdonPos() {
		return random.nextInt((int)1366-Animals.WIDTH);
	}
	
	public String createAnimalsKey() {
		Character c = ALPHABETS[random.nextInt(26)];
		while(huntersAlphabets.contains(c)) {
			c = ALPHABETS[random.nextInt(26)];
		}
		animalsAlphabets.add(c);	
		String s = String.valueOf(c);
		return s;
	}
	
	public String createHuntersKey() {
		Character c = ALPHABETS[random.nextInt(26)];
		while(animalsAlphabets.contains(c)) {
			c = ALPHABETS[random.nextInt(26)];
		}
		huntersAlphabets.add(c);
		String s = String.valueOf(c);
		return s;
	}
	
	public static List<Character> getHuntersAlphabets(){
		return huntersAlphabets;
	}
	
	public static List<Character> getAnimalsAlphabets(){
		return animalsAlphabets;
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
