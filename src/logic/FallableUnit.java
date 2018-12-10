package logic;

public abstract class FallableUnit extends Unit {

	private static int fallUnitSpawnRate = 1;
	private static boolean isSpawnRateIncreased = false;
	private static double fallUnitSpeed = 2;
	protected double speed;
	protected String key;
	
	protected boolean landOnGround() {
		return Grounds.getY() - this.y <= 150;
	}
	
	protected void fall() {
		this.y += speed;
	}
	
	public static void accelerate() {
		fallUnitSpeed += fallUnitSpeed * 0.05;
	}
	
	public static void increaseSpawnRate() {
		fallUnitSpawnRate = Math.min(5, fallUnitSpawnRate + 1);
	}
	
	public static void resetValues() {
		fallUnitSpawnRate = 1;
		fallUnitSpeed = 2;
		isSpawnRateIncreased = false;
	}
	
	public static int getFallUnitSpawnRate() {
		return fallUnitSpawnRate;
	}

	public static boolean isSpawnRateIncreased() {
		return isSpawnRateIncreased;
	}

	public static void setSpawnRateIncreased(boolean isSpawnRateIncreased) {
		FallableUnit.isSpawnRateIncreased = isSpawnRateIncreased;
	}

	public static double getFallUnitSpeed() {
		return fallUnitSpeed;
	}

	public String getKey() {
		return key;
	}
	
	
	
	
}
