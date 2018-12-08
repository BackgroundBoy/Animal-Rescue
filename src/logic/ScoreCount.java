package logic;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ScoreCount extends HBox {

	private Label nameBox;
	private Label scoreBox;
	private int scoreCount;
	private Thread thread;
	private static int temporaryScore;
	private final double FONT_SIZE =  28;
	private final String TEXT_STYLE = "-fx-text-fill: #666666;"
			+ "-fx-font-family: 'Joystix Monospace'; "
			+ "-fx-font-size: " + FONT_SIZE + "; ";

	public ScoreCount() {
		scoreCount = 0;
		createBox();
	}
	
	public void createBox() {
		nameBox = new Label("SCORE: ");
		nameBox.setStyle(TEXT_STYLE);
		scoreBox = new Label("00000");
		scoreBox.setStyle(TEXT_STYLE);
		getChildren().addAll(nameBox, scoreBox);
	}
	
	public void start() {
		thread = new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(20);
					Platform.runLater(() -> {
						update();						
					});
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		});
		thread.start();
	}
	
	public void update() {
		scoreCount += temporaryScore;
		
		temporaryScore = 0;
		scoreBox.setText(String.format("%05d", scoreCount));
	}
	
	public static void addScore(int score) {
		temporaryScore = score;
	}
	
	public static void subScore(int score) {
		temporaryScore = -score;
	}
	
	public int getScoreCount() {
		return scoreCount;
	}
}
