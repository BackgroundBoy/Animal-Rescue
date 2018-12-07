package application;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/*
 *	class for time counting
 *	there are start(), terminate(), pause(), unPause()
 *	method start quite dirty, let's clean up later
 */

public class GameTimer {
	
	private int counter = -1;
	private HBox box;
	private Label minute;
	private Label second;
	private Label colon;
	private Thread t;
	
	private final double FONT_SIZE = 28;
	private final String TIME_TEXT_STYLE = "-fx-text-fill: #666666;"
			+ "-fx-font-family: 'Joystix Monospace'; "
			+ "-fx-font-size: " + FONT_SIZE + "; ";
	
	// initiallize time counting
	public GameTimer() {
		insertTimeBox();
	}
	
	// Merge Labels into a Box
	public void insertTimeBox() {
		box = new HBox(1.4);
		minute = new Label("00");
		second = new Label("00");
		colon = new Label(":");
		box.getChildren().addAll(minute, colon, second);
		setAllStyle();
	}
	
	// set style
	public void setAllStyle() {
		minute.setStyle(TIME_TEXT_STYLE);
		colon.setStyle(TIME_TEXT_STYLE);
		second.setStyle(TIME_TEXT_STYLE);
	}
	
	// export Label
	public HBox getTimerBox() {
		return box;
	}

	// count +1 every 1 second
	// probably clean this method later :D
	public void start() {
		System.out.println("TIME START");
		t = new Thread(() -> {
				while (true) {
					counter++;
					try {
						Thread.sleep(1000);
						Platform.runLater(() -> {
							if (counter < 10)
								second.setText("0" + Integer.toString(counter));
							else if (counter < 60)
								second.setText(Integer.toString(counter));
							else {
								if (Integer.parseInt(minute.getText()) < 9)
									minute.setText("0" + Integer.toString(Integer.parseInt(minute.getText()) + 1));
								else 
									minute.setText(Integer.toString(Integer.parseInt(minute.getText()) + 1));
								second.setText("00");
								counter = counter % 60;
							}
						});
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		});
		t.start();
	}
	
	// Temporary Stop
	public void pause() {
		System.out.println("TIME PAUSE");
		t.suspend();
	}
	
	// Continue from temporary stop
	public void unpause() {
		System.out.println("TIME UNPAUSE");
		t.resume();
	}
	
	public void reset() {
		System.out.println("TIME RESET");
		counter = 0;
		minute.setText("00");
		second.setText("00");
	}
	
	// clear all thread also
	public void terminate() {
		System.out.println("TIME TERMINATE");
		// TODO
	}
	
	public int getMinute() {
		return Integer.parseInt(minute.getText());
	}
	
	public int getSecond() {
		return Integer.parseInt(second.getText());
	}
}
