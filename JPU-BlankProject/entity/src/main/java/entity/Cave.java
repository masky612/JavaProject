package entity;

import java.awt.Image;
import java.awt.Point;
import java.io.IOException;

public class Cave {
	protected boolean isBreakableByPlayer;
	protected boolean isBreakableByExplosion;
	protected boolean isMovable;
	protected boolean isfull = true;
	protected boolean canfall = false;
	protected boolean cancascade = false;
	protected boolean isAlive;
	protected boolean isClaimable = false;
	protected boolean isDaWay = false;
	protected boolean canfallkill = false;
	protected boolean canpush = false;
	protected boolean isanexplosableentity = true;
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
	public boolean getcancascade() {
		return cancascade;
	}
	public boolean getcanpush() {
		return canpush;
	}
	public void setP(Point p) {
		this.p = p;
	}
	public boolean getisAMonster() {
		return isAMonster;
	}
	public boolean getgoLeft() {
		return wasGoingLeft;
	}
	public void setgoLeft(boolean wasGoingLeft) {
		this.wasGoingLeft = wasGoingLeft;
	}
	public boolean getgoRight() {
		return wasGoingRight;
	}
	public void setgoRight(boolean wasGoingRight) {
		this.wasGoingRight = wasGoingRight;
	}
	public boolean getgoUp() {
		return wasGoingUp;
	}
	public void setgoUp(boolean wasGoingUp) {
		this.wasGoingUp = wasGoingUp;
	}
	public boolean getgoDown() {
		return wasGoingDown;
	}
	public void setgoDown(boolean wasGoingDown) {
		this.wasGoingDown = wasGoingDown;
	}
	public boolean getisBreakableByExplosion() {
		return isBreakableByExplosion;
	}
	public boolean getisanexplosableentity() {
		return isanexplosableentity;
	}	
	public void setcanfallkill(boolean canfallkill) {
		this.canfallkill = canfallkill;
	}
	public boolean getcanfallkill() {
		return canfallkill;
	}
	public boolean getisfull() {
		return isfull;
	}
	public boolean getcanfall() {
		return canfall;
	}
	public boolean getDaWay() {
		return isDaWay;
	}
	
	public boolean getdestructP1() {
		return isBreakableByPlayer ;
	}
	
	public boolean getclaimedP1() {
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
