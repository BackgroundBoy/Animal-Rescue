package logic;

public abstract class FallableUnit extends Unit {

//	protected static int radius;
	public static int fallUnitGenRate = 1;
	public static boolean isGenRateIncreased = false;
	public static double fallUnitSpeed = 2;
	protected double speed;
	protected String key;
	
	protected boolean landOnGround() {
		return Grounds.getY() - this.y <= 150;
	}
	
	protected void fall() {
		this.y += speed;
	}
	
	public static void accelerate() {
		fallUnitSpeed += fallUnitSpeed*0.1;
	}
	
	public static void increaseGenRate() {
		fallUnitGenRate = Math.min(5, fallUnitGenRate+1);
	}
}
