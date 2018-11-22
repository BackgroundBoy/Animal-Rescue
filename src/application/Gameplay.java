package application;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;

public class Gameplay {

	private Timer backgroundGaming;
	private Double leftBoarder;
	private Double rightBoarder;
	private int timeGap;
	
	// size controller
	ScreenSizeCalibrator sc = new ScreenSizeCalibrator();

	public Gameplay() {
		backgroundGaming = new Timer();
		timeGap = 5000;
		setLeftandRightBoarder();
	}
	
	public void start() {

		System.out.println("GAME READY");
		
		backgroundGaming.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
//				Platform.runLater(new Runnable() {
//					
//					@Override
//					public void run() {
//						// TODO Auto-generated method stub
//						
//					}
//				});
				
				int random = (int)(Math.random() * (rightBoarder) + leftBoarder);
				System.out.println(random);
			}
						
		}, 0, timeGap); // Long period
	}
	
	public void setLeftandRightBoarder() {
		leftBoarder = sc.setTongSize(200);
		rightBoarder = ScreenSizeCalibrator.WIDTH - leftBoarder;
	}
	
	
	// Getters & Setters :
	
	public void setTimeGap(int gap) {
		timeGap = gap;
	}
	
	public int getTimeGap() {
		return timeGap;
	}
	
}
