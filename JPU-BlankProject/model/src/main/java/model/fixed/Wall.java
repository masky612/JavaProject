package model.fixed;

public class Wall {
	public Wall(boolean isBreakableByPlayer,boolean isBreakableByExplosion,boolean isMovable,boolean isAlive){
		isBreakableByPlayer = false;
		isBreakableByExplosion = false;
		isMovable = false;
		isAlive = true;
	}
}
