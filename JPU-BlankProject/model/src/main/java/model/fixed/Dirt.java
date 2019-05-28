package model.fixed;

public class Dirt extends Object {
	public Dirt(boolean isBreakableByPlayer,boolean isBreakableByExplosion,boolean isMovable,boolean isAlive){
		isBreakableByPlayer = true;
		isBreakableByExplosion = true;
		isMovable = false;
		isAlive = true;
	}
	
}	
