package application;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class Life extends HBox {
	
	public static int life = 5;
	private static final String LIFE_PATH = ClassLoader.getSystemResource("images/life.png").toString();
	private Thread thread;
	
	public Life() {
		super(10);
		thread = new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(20);
					Platform.runLater(() -> {
						if (life < 0) 
							GameManager.setGameOver();
						getChildren().clear();
						for (int i = 0; i < life; i++) {
							getChildren().addAll(new ImageView(new Image(LIFE_PATH)));
						}											
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
	}
	
	public void pause() {
		thread.suspend();
	}
	
	public void unpause() {
		thread.resume();
	}
	
	public static void minusOne() {
		life -= 1;
	}
	
	public static void reset() {
		life = 5;
	}
}
