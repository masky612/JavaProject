package entity;

import java.awt.Image;

public class Object {
	protected boolean isBreakableByPlayer;
	protected boolean isBreakableByExplosion;
	protected boolean isMovable;
	protected boolean isAlive;

	private static int x;
	private static int y;
	private static Image img;

	public static int getX() {
		return x;
	}

	public void setX(int x) {
		Object.x = x;
	}

	public static int getY() {
		return y;
	}

	public void setY(int y) {
		Object.y = y;
	}

	public static Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		Object.img = img;
	}

}
