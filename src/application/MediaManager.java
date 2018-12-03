package application;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MediaManager {
	
	
	MediaPlayer mp;
	
	private String MAIN_PATH = ClassLoader.getSystemResource("sounds/[No Copyright Music] UNDERNEATH THE CHRISTMAS TREE (Instrumental) - myuu.mp3").toString();
//	private String GAME_PATH = 
	
	public MediaManager() {
		mp = new MediaPlayer(new Media(MAIN_PATH));
	}

	public void play() {
		mp.play();
	}

}
