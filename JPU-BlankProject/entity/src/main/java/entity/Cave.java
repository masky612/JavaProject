package entity;

import java.awt.Image;

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

		case "C":
			return new Clear(x, y);

		}
		return null;
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
