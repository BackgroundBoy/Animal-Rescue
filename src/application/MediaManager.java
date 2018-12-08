package application;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MediaManager {
	
	public static double volumn = 0.5;
	private static final String MAIN_PATH = ClassLoader.getSystemResource("sounds/[No Copyright Music] UNDERNEATH THE CHRISTMAS TREE (Instrumental) - myuu.mp3").toString();
	private static final String GAME_PATH = ClassLoader.getSystemResource("sounds/[No Copyright Music] Chill Relaxing Lofi Hip Hop Chillhop Instrumental (Copyright Free) Music.mp3").toString();
	private static final String GET_SCORE = ClassLoader.getSystemResource("sounds/Mario-coin-sound.mp3").toString();
	private static final String QUACK = ClassLoader.getSystemResource("sounds/Quack Sound Effect.mp3").toString();
	private static final String CLICK = ClassLoader.getSystemResource("Sounds/click.mp3").toString();
	private static final String ENTERED = ClassLoader.getSystemResource("Sounds/entered.mp3").toString();
	private static MediaPlayer mainPath = new MediaPlayer(new Media(MAIN_PATH));
	private static MediaPlayer gamePath = new MediaPlayer(new Media(GAME_PATH));
	private static MediaPlayer getScore = new MediaPlayer(new Media(GET_SCORE));
	private static MediaPlayer quack = new MediaPlayer(new Media(QUACK));
	private static MediaPlayer click = new MediaPlayer(new Media(CLICK));
	private static MediaPlayer entered = new MediaPlayer(new Media(ENTERED));
	
	public static void stopAll() {
		mainPath.stop();
		gamePath.stop();
	}
	
	public static void update() {
		mainPath.setVolume(volumn);
		gamePath.setVolume(volumn);
		getScore.setVolume(volumn);
		quack.setVolume(volumn);
		click.setVolume(volumn);
		entered.setVolume(volumn);
	}
	
	public static void playMainPath() {
		stopAll();
		mainPath.play();
	}
	
	public static void playGamePath() {
		stopAll();
		gamePath.play();
	}
		
	public static void playClick() {
		click.stop();
		click.play();
	}

	public static void playEntered() {
		entered.stop();
		entered.play();
	}
	
	public static void playGetScore() {
		getScore.stop();
		getScore.play();
	}
}
