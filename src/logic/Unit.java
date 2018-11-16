package logic;

public class Unit {
	
	protected int score;
	protected boolean isLanded;
	
	
	public Unit( int score ) {
		this.score = Math.max(score, 0);
		this.isLanded = false;
	}
	
	public void landed() {
		this.isLanded = true;
	}
	
	
	
}
