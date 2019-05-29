package entity;

import java.awt.Image;
import java.io.IOException;

public class Cave {
	protected boolean isBreakableByPlayer;
	protected boolean isBreakableByExplosion;
	protected boolean isMovable;
	protected boolean isAlive;

	private int x;
	private int y;
	private Image img;

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

	public static Cave getObjFromSpriteStr(String spriteStr, int x, int y) {
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
			return new Rockford(x, y);
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
