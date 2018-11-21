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
	
	private Timer timer;
	private int counter = 0;
	private HBox box;
	private Label minute;
	private Label second;
	private Label colon;
	
	// Size controller
	ScreenSizeCalibrator sc = new ScreenSizeCalibrator();
	private final double FONT_SIZE =  sc.setPinSize(40);

	private final String TIME_TEXT_STYLE = "-fx-text-fill: #000000;"
			+ "-fx-font-family: 'Joystix Monospace'; "
			+ "-fx-font-size: " + FONT_SIZE + "; ";
	
	// initiallize time counting
	public GameTimer() {
		timer = new Timer();
		insertTimeBox();
	}
	
	// Merge Labels into a Box
	public void insertTimeBox() {
		box = new HBox(sc.setPinSize(2));
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
		
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				counter++;
				Platform.runLater(new Runnable() {
				      @Override public void run() {
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
				      }
				});
				
			}
		}, 0, 1000); // delay, duration
	}
	
	// Temporary Stop
	public void pause() {
		
		System.out.println("TIME PAUSE");
		
		try {
			timer.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	// Continue from temporary stop
	public void unpause() {
		
		System.out.println("TIME UNPAUSE");
		
		timer.notify();
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
		
		timer.cancel();
		timer.purge();
	}
	
	public int getMinute() {
		return Integer.parseInt(minute.getText());
	}
	
	public int getSecond() {
		return Integer.parseInt(second.getText());
	}
}
