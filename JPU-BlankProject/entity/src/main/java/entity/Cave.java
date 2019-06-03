package entity;

import java.awt.Image;
import java.awt.Point;
import java.io.IOException;

public class Cave {
	protected boolean isBreakableByPlayer;
	protected boolean isBreakableByExplosion;
	protected boolean isMovable;
	protected boolean isFull = true;
	protected boolean canFall = false;
	protected boolean canCascade = false;
	protected boolean isAlive;
	protected boolean isClaimable = false;
	protected boolean isDaWay = false;
	protected boolean canFallKill = false;
	protected boolean canPush = false;
	protected boolean isAnExplosableEntity = true;
	protected boolean isAMonster = false;
	protected boolean wasGoingLeft = false;
	protected boolean wasGoingRight = false;
	protected boolean wasGoingUp = false;
	protected boolean wasGoingDown = false;

	protected int x;
	protected int y;
	private Image img;
	
	private Point p;
	public Point getP() {
		return p;
	}
	public boolean getCanCascade() {
		return canCascade;
	}
	public boolean getCanPush() {
		return canPush;
	}
	public void setP(Point p) {
		this.p = p;
	}
	public boolean getIsAMonster() {
		return isAMonster;
	}
	public boolean getGoLeft() {
		return wasGoingLeft;
	}
	public void setGoLeft(boolean wasGoingLeft) {
		this.wasGoingLeft = wasGoingLeft;
	}
	public boolean getGoRight() {
		return wasGoingRight;
	}
	public void setGoRight(boolean wasGoingRight) {
		this.wasGoingRight = wasGoingRight;
	}
	public boolean getGoUp() {
		return wasGoingUp;
	}
	public void setGoUp(boolean wasGoingUp) {
		this.wasGoingUp = wasGoingUp;
	}
	public boolean getGoDown() {
		return wasGoingDown;
	}
	public void setGoDown(boolean wasGoingDown) {
		this.wasGoingDown = wasGoingDown;
	}
	public boolean getIsBreakableByExplosion() {
		return isBreakableByExplosion;
	}
	public boolean getIsAnExplosableEntity() {
		return isAnExplosableEntity;
	}	
	public void setCanFallKill(boolean canFallKill) {
		this.canFallKill = canFallKill;
	}
	public boolean getCanFallKill() {
		return canFallKill;
	}
	public boolean getIsFull() {
		return isFull;
	}
	public boolean getCanFall() {
		return canFall;
	}
	public boolean getDaWay() {
		return isDaWay;
	}
	
	public boolean getDestructP1() {
		return isBreakableByPlayer ;
	}
	
	public boolean getClaimedP1() {
		return isClaimable ;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public static Cave getObjFromSpriteStr(String spriteStr, int x, int y) throws IOException {
		// TODO Auto-generated method stub
		switch (spriteStr) {
		case "U":
			return new Wall(x, y);
		case "D":
			return new Dirt(x, y);
		case "O":
			return new Diamonds(x, y);
		case "R":
			return new Rocks(x, y);
		case "C":
			return new Clear(x, y);
		case "E":
			return new Exit(x, y);
		case "M":
			return new Monster(x, y);
		case "B":
			return new BreakableWalls(x, y);
		case "S":
			Rockford.getInstance().setX(x);
			Rockford.getInstance().setY(y);
			Rockford.getInstance().setP(new Point(x,y));
			return Rockford.getInstance();
		default :
			return new Wall(x,y);
		}
		
	}
	/*
	 * protected boolean isBreakableByPlayer; protected boolean
	 * isBreakableByExplosion; protected boolean isMovable; protected boolean
	 * isAlive;
	 * 
	 * private static int x; private static int y; private static Image img;
	 * 
	 * public static int getX() { return x; }
	 * 
	 * public void setX(int x) { Object.x = x; }
	 * 
	 * public static int getY() { return y; }
	 * 
	 * public void setY(int y) { Object.y = y; }
	 * 
	 * public static Image getImg() { return img; }
	 * 
	 * public void setImg(Image img) { Object.img = img; }
	 */

}
