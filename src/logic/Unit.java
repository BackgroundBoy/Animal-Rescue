package logic;

import sharedObject.IRenderable;

public abstract class Unit implements IRenderable {
	
	protected double x,y;
	protected int z;
	protected boolean visible, destroyed;
	protected int unitScore;
	protected static double width, height;
	
	protected Unit() {
		visible = true;
		destroyed = false;
	}

	@Override
	public int getZ() {
		return z;
	}

	@Override 
	public boolean isVisible() {
		return visible;
	}
	
	@Override 
	public boolean isDestroyed() {
		return destroyed;
	}
	
	public int getUnitScore() {
		return unitScore;
	}
	
}
