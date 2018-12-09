package logic;

import Exception.NegativeScoreException;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ScoreCount extends HBox {

	private Label nameBox;
	private Label scoreBox;
	private int scoreCount;
	private static int temporaryScore;
	private final String TEXT_STYLE = "-fx-text-fill: #666666;"
			+ "-fx-font-family: 'Joystix Monospace'; "
			+ "-fx-font-size: 28; ";

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
	
	
	public void update() throws NegativeScoreException {
		scoreCount += temporaryScore;
		temporaryScore = 0;
		scoreBox.setText(String.format("%05d", scoreCount));
		if(scoreCount < 0) {
			throw new NegativeScoreException();
		}
	}
	
	public static void addScore(int score) {
		temporaryScore += score;
	}
	
	public void resetScore() {
		scoreCount = 0;
	}
	
	public int getScoreCount() {
		return scoreCount;
	}
}
