//package logic;
//
//import java.util.Random;
//
//import application.ScreenSizeCalibrator;
//import javafx.animation.TranslateTransition;
//import javafx.geometry.Pos;
//import javafx.scene.control.Label;
//import javafx.scene.layout.VBox;
//
//public class Balloon extends VBox {
//	
//	// Element
//	private Label box;
//	private Label balloon;
//	private static double  speed = 50;
//	private TranslateTransition t;
//	
//	// boarder
//	private double leftBoarder;
//	private double rightBoarder;
//	
//	// PATH
//	private final double DEADLINE = sc.setTongSize(750);
//	private final double FONT_SIZE = sc.setTongSize(25);
//	private final String BOX_PATH = ClassLoader.getSystemResource("images/box.png").toString();
//	private final String BOX_STYLE = "-fx-background-image: url(" + BOX_PATH + "); " + "-fx-background-size: cover;";
//	private final String TEXT_STYLE = "-fx-text-fill: #000000;"
//			+ "-fx-font-family: 'Joystix Monospace'; "
//			+ "-fx-font-size: " + FONT_SIZE + "; ";
//	private String[] PATH_LIST = {
//			"images/balloon.png",
//			"images/balloon2.png",
//			"images/balloon3.png",
//			"images/balloon4.png"};
//	
//	// constructor
//
//	public Balloon() {
//		speed = Math.random() * 0.7;
//		setAlignment(Pos.CENTER);
//		createBalloons();
//		createBox();
//		setBoarder();
//		setPosition();
//		fall();
//	}
//	
//	// methods
//	
////	random balloon picture
//	public void createBalloons() {
//		String PATH = PATH_LIST[(int)(Math.random() * PATH_LIST.length)];
//		String BALLOON_PATH = ClassLoader.getSystemResource(PATH).toString();
//		String BALLOON_STYLE = "-fx-background-image: url(" + BALLOON_PATH + "); " 
//											+ "-fx-background-size: cover;";
//		balloon = new Label();
//		balloon.setStyle(BALLOON_STYLE);
//		balloon.setPrefSize(sc.setTongSize(100), sc.setTongSize(100));
//		getChildren().add(balloon);
//	}
//	
//	public void createBox() {
//		box = new Label();
//		box.setText(getRandomChar());
//		box.setStyle(TEXT_STYLE + BOX_STYLE);
//		box.setPrefSize(sc.setTongSize(40), sc.setTongSize(40));
//		box.setAlignment(Pos.CENTER);
//		getChildren().add(box);
//	}
//	
//	public double getBalloonHeight() {
//		return box.getPrefHeight() + balloon.getPrefHeight();
//	}
//	
//	public double getBalloonWidth() {
//		return Math.max(box.getPrefWidth(), balloon.getPrefWidth());
//	}
//	
//	public void setBoarder() {
//		leftBoarder = sc.setTongSize(100);
//		rightBoarder = ScreenSizeCalibrator.WIDTH - leftBoarder - getBalloonWidth();
//	}
//	
//	public void setPosition() {
//		setTranslateX(getRandomPos());
//		setTranslateY(-getBalloonHeight());
//	}
//	
//	public void fall() {
//		
//		this.setLayoutY(this.getLayoutY() + Balloon.speed );
//		
//		
////		t = new TranslateTransition();
////		t.setNode(this);
////		t.setToY(DEADLINE - getBalloonHeight());
////		t.setDuration(new Duration(20000 - 20000*speed));
////		t.setOnFinished(e -> {
////			// TODO GameOver Interface
////			GameManager.setGameOver();
////			System.out.println("GAME OVER");
////		});
////		t.play();
//	}
//	
//	public void update() {
//		fall();
//		if(calculateHeigh(this.getLayoutY(), DEADLINE-getBalloonHeight()) == getBalloonHeight()) {
//			// game over 
//		}
//	}
//	
//	private double calculateHeigh(double y1, double y2) {
//		return Math.abs(y2-y1);
//	}
//	
//	public void pause() {
//		t.pause();
//	}
//	
//	public void unpause() {
//		t.play();
//	}
//	
//	public double getRandomPos() {
//		return (double)(Math.random() * (rightBoarder - leftBoarder) + leftBoarder);
//	}
//	
//	public String getRandomChar() {
//		Random r = new Random();
//	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//	    return Character.toString(alphabet.charAt(r.nextInt(alphabet.length())));
//	}
//	
//	public void pop() {
//		t.stop();
//		setDisable(true);
//		setVisible(false);
//	}
//	
//	public void accelerated() {
//		Balloon.speed += 1;
//	}
//
//	public String getAlphabet() {
//		return box.getText();
//	}
//
//	public void setAlphabet(String alphabet) {
//		box.setText(alphabet);
//	}
//
//	public double getSpeed() {
//		return speed;
//	}
//
//	public void setSpeed(double speed) {
//		this.speed = Math.min(speed, 1);
//	}
//
//}