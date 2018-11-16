package logic;

public class Balloon {
	
	// Element
	protected String alphabet;
	protected int speed;
	protected boolean isPoped; 
	
	// constr
	public Balloon() {
		this.alphabet = "";
		this.speed = 1;
		this.isPoped = false;
	}
	
	public Balloon(String alpha) {
		this.alphabet = alpha;
		this.speed = 1;
		this.isPoped = false;	
	}
	
	// methods
	public void pop() {
		setPoped(true);
	}
	
	public void accelerated() {
	
	}

	public String getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(String alphabet) {
		this.alphabet = alphabet;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = Math.max(speed, 1);
	}

	public boolean isPoped() {
		return isPoped;
	}

	public void setPoped(boolean isPoped) {
		this.isPoped = isPoped;
	}
	
	
	
}
