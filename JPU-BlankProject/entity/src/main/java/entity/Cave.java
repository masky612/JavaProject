/*
 * @author Xavier Nicolas Adèle Antoine
 */
package entity;

import java.awt.Image;
import java.awt.Point;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class Cave.
 */
public class Cave {
	
	/** The is breakable by player. */
	protected boolean isBreakableByPlayer;
	
	/** The is breakable by explosion. */
	protected boolean isBreakableByExplosion;
	
	/** The is movable. */
	protected boolean isMovable;
	
	/** The is full. */
	protected boolean isFull = true;
	
	/** The can fall. */
	protected boolean canFall = false;
	
	/** The can cascade. */
	protected boolean canCascade = false;
	
	/** The is alive. */
	protected boolean isAlive;
	
	/** The is claimable. */
	protected boolean isClaimable = false;
	
	/** The is da way. */
	protected boolean isDaWay = false;
	
	/** The can fall kill. */
	protected boolean canFallKill = false;
	
	/** The can push. */
	protected boolean canPush = false;
	
	/** The is an explosable entity. */
	protected boolean isAnExplosableEntity = true;
	
	/** The is A monster. */
	protected boolean isAMonster = false;
	
	/** The was going left. */
	protected boolean wasGoingLeft = false;
	
	/** The was going right. */
	protected boolean wasGoingRight = false;
	
	/** The was going up. */
	protected boolean wasGoingUp = false;
	
	/** The was going down. */
	protected boolean wasGoingDown = false;

	/** The x. */
	protected int x;
	
	/** The y. */
	protected int y;
	
	/** The img. */
	private Image img;
	
	/** The p. */
	private Point p;
	
	/**
	 * Gets the p.
	 *
	 * @return the p
	 */
	public Point getP() {
		return p;
	}
	
	/**
	 * Gets the can cascade.
	 *
	 * @return the can cascade
	 */
	public boolean getCanCascade() {
		return canCascade;
	}
	
	/**
	 * Gets the can push.
	 *
	 * @return the can push
	 */
	public boolean getCanPush() {
		return canPush;
	}
	
	/**
	 * Sets the p.
	 *
	 * @param p the new p
	 */
	public void setP(Point p) {
		this.p = p;
	}
	
	/**
	 * Gets the checks if is A monster.
	 *
	 * @return the checks if is A monster
	 */
	public boolean getIsAMonster() {
		return isAMonster;
	}
	
	/**
	 * Gets the go left.
	 *
	 * @return the go left
	 */
	public boolean getGoLeft() {
		return wasGoingLeft;
	}
	
	/**
	 * Sets the go left.
	 *
	 * @param wasGoingLeft the new go left
	 */
	public void setGoLeft(boolean wasGoingLeft) {
		this.wasGoingLeft = wasGoingLeft;
	}
	
	/**
	 * Gets the go right.
	 *
	 * @return the go right
	 */
	public boolean getGoRight() {
		return wasGoingRight;
	}
	
	/**
	 * Sets the go right.
	 *
	 * @param wasGoingRight the new go right
	 */
	public void setGoRight(boolean wasGoingRight) {
		this.wasGoingRight = wasGoingRight;
	}
	
	/**
	 * Gets the go up.
	 *
	 * @return the go up
	 */
	public boolean getGoUp() {
		return wasGoingUp;
	}
	
	/**
	 * Sets the go up.
	 *
	 * @param wasGoingUp the new go up
	 */
	public void setGoUp(boolean wasGoingUp) {
		this.wasGoingUp = wasGoingUp;
	}
	
	/**
	 * Gets the go down.
	 *
	 * @return the go down
	 */
	public boolean getGoDown() {
		return wasGoingDown;
	}
	
	/**
	 * Sets the go down.
	 *
	 * @param wasGoingDown the new go down
	 */
	public void setGoDown(boolean wasGoingDown) {
		this.wasGoingDown = wasGoingDown;
	}
	
	/**
	 * Gets the checks if is breakable by explosion.
	 *
	 * @return the checks if is breakable by explosion
	 */
	public boolean getIsBreakableByExplosion() {
		return isBreakableByExplosion;
	}
	
	/**
	 * Gets the checks if is an explosable entity.
	 *
	 * @return the checks if is an explosable entity
	 */
	public boolean getIsAnExplosableEntity() {
		return isAnExplosableEntity;
	}	
	
	/**
	 * Sets the can fall kill.
	 *
	 * @param canFallKill the new can fall kill
	 */
	public void setCanFallKill(boolean canFallKill) {
		this.canFallKill = canFallKill;
	}
	
	/**
	 * Gets the can fall kill.
	 *
	 * @return the can fall kill
	 */
	public boolean getCanFallKill() {
		return canFallKill;
	}
	
	/**
	 * Gets the checks if is full.
	 *
	 * @return the checks if is full
	 */
	public boolean getIsFull() {
		return isFull;
	}
	
	/**
	 * Gets the can fall.
	 *
	 * @return the can fall
	 */
	public boolean getCanFall() {
		return canFall;
	}
	
	/**
	 * Gets the da way.
	 *
	 * @return the da way
	 */
	public boolean getDaWay() {
		return isDaWay;
	}
	
	/**
	 * Gets the destruct P 1.
	 *
	 * @return the destruct P 1
	 */
	public boolean getDestructP1() {
		return isBreakableByPlayer ;
	}
	
	/**
	 * Gets the claimed P 1.
	 *
	 * @return the claimed P 1
	 */
	public boolean getClaimedP1() {
		return isClaimable ;
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x.
	 *
	 * @param x the new x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y.
	 *
	 * @param y the new y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Gets the img.
	 *
	 * @return the img
	 */
	public Image getImg() {
		return img;
	}

	/**
	 * Sets the img.
	 *
	 * @param img the new img
	 */
	public void setImg(Image img) {
		this.img = img;
	}

	/**
	 * Gets the obj from sprite str.
	 *
	 * @param spriteStr the sprite str
	 * @param x the x
	 * @param y the y
	 * @return the obj from sprite str
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
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
