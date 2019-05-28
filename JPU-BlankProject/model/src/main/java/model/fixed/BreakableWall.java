package model.fixed;

public class BreakableWall extends Object {
	public BreakableWall(boolean isBreakableByPlayer,boolean isBreakableByExplosion,boolean isMovable,boolean isAlive){
		isBreakableByPlayer = false;
		isBreakableByExplosion = true;
		isMovable = false;
		isAlive = true;
	}
}
