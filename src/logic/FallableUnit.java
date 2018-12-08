package logic;

public abstract class FallableUnit extends Unit {

	protected static int radius;
	protected int speed;
	protected String key;
	
	protected boolean landOnGround() {
		return Grounds.getY() - this.y <= this.radius + 150;
	}
	
	protected void fall() {
		this.y += speed;
	}
	
	public void accelerate() {
		this.speed += 0.5;
	}
}
