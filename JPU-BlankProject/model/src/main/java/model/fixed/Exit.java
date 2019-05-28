package model.fixed;

public class Exit extends Object{
	public Exit(boolean isBreakableByPlayer,boolean isBreakableByExplosion,boolean isMovable,boolean isAlive){
		isBreakableByPlayer = false;
		isBreakableByExplosion = false;
		isMovable = false;
		isAlive = false;
	}
}
