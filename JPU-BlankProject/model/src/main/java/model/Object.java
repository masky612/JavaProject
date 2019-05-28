package model;

public class Object {
	protected boolean isBreakableByPlayer;
	protected boolean isBreakableByExplosion;
	protected boolean isMovable;
	protected boolean isAlive;
	protected int x;
	protected int y;


	public int getx () {
		return x;
 }
	public void setx() {
		this.x = x;
 }
	public int gety () {
		return y;
	}
	public void sety() {
		this.y = y;
	}
	
	
	
}