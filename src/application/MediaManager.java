package application;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import javafx.scene.media.AudioClip;

public class MediaManager {
	
	public static double volumn = 0.5;
	private static final String MAIN_PATH = ClassLoader.getSystemResource("sounds/[No Copyright Music] UNDERNEATH THE CHRISTMAS TREE (Instrumental) - myuu.mp3").toString();
	private static final String GAME_PATH = ClassLoader.getSystemResource("sounds/[No Copyright Music] Chill Relaxing Lofi Hip Hop Chillhop Instrumental (Copyright Free) Music.mp3").toString();
	private static final String GET_SCORE = ClassLoader.getSystemResource("sounds/Mario-coin-sound.mp3").toString();
	private static final String QUACK = ClassLoader.getSystemResource("sounds/Quack Sound Effect.mp3").toString();
	private static final String CLICK = ClassLoader.getSystemResource("Sounds/click.mp3").toString();
	private static final String ENTERED = ClassLoader.getSystemResource("Sounds/entered.mp3").toString();
	private MediaPlayer mainPath = new MediaPlayer(new Media(MAIN_PATH));
	private MediaPlayer gamePath = new MediaPlayer(new Media(GAME_PATH));
	private AudioClip getScore = new AudioClip(GET_SCORE);
	private AudioClip quack = new AudioClip(QUACK);
	private AudioClip click = new AudioClip(CLICK);
	private AudioClip entered = new AudioClip(ENTERED);
	public static final MediaManager instance = new MediaManager();
		
	public MediaManager() {
		mainPath.setOnEndOfMedia(new Runnable() {
		
			@Override
			public void run() {
				mainPath.seek(Duration.ZERO);
				mainPath.play();
			}
			
		});
		
		gamePath.setOnEndOfMedia(new Runnable() {
			
			@Override
			public void run() {
				gamePath.seek(Duration.ZERO);
				gamePath.play();
			}
			
		});
	}
	
	public void stopAll() {
		mainPath.stop();
		gamePath.stop();
	}
	
	public void update() {
		mainPath.setVolume(volumn);
		gamePath.setVolume(volumn);
		getScore.setVolume(volumn);
		quack.setVolume(volumn);
		click.setVolume(volumn);
		entered.setVolume(volumn);
	}
	
	public void playMainPath() {
		stopAll();
		mainPath.play();
	}
	
	public void playGamePath() {
		stopAll();
		gamePath.play();
	}
	
	public void pauseGamePath() {
		gamePath.pause();
	}
	
	public void resumeGamePath() {
		gamePath.play();
	}
	
	public void replayGamePath() {
		gamePath.seek(Duration.ZERO);
		gamePath.play();
	}
		
	public void playClick() {
		click.stop();
		click.play();
	}

	public void playEntered() {
		entered.stop();
		entered.play();
	}
	
	public void playGetScore() {
		getScore.stop();
		getScore.play();
	}
	
	public void playQuack() {
		quack.stop();
		quack.play();
	}
	
	public static MediaManager getInstance() {
		return instance;
	}
}
