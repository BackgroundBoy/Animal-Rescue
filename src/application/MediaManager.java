package application;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MediaManager {
	
	
	MediaPlayer mainPath;
	MediaPlayer gamePath;
	MediaPlayer getScore;
	
	private String MAIN_PATH = ClassLoader.getSystemResource("sounds/[No Copyright Music] UNDERNEATH THE CHRISTMAS TREE (Instrumental) - myuu.mp3").toString();
	private String GAME_PATH = ClassLoader.getSystemResource("sounds/[No Copyright Music] Chill Relaxing Lofi Hip Hop Chillhop Instrumental (Copyright Free) Music.mp3").toString();
	private String GET_SCORE = ClassLoader.getSystemResource("sounds/Mario-coin-sound.mp3").toString();
//	private String GAME_PATH = 
	
	public MediaManager() {
		mainPath = new MediaPlayer(new Media(MAIN_PATH));
		gamePath = new MediaPlayer(new Media(GAME_PATH));
		getScore = new MediaPlayer(new Media(GET_SCORE));
		gamePath.setVolume(0.5);
		getScore.setVolume(0.5);
	}

	public void playMainPath() {
		mainPath.play();
	}
	
	public void playGamePath() {
		gamePath.play();
	}
	
	public void playGetScore() {
		getScore.stop();
		getScore.play();
	}
	
	public void stop() {
		mainPath.stop();
		gamePath.stop();
		getScore.stop();
	}

}
