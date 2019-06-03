/*
 * @author Xavier Nicolas Adèle Antoine
 */
package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// TODO: Auto-generated Javadoc
/**
 * The Class BreakableWalls.
 */
public class BreakableWalls extends Cave {

	/**
	 * Instantiates a new breakable walls.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public BreakableWalls(final int x, final int y) {
		this.setY(y);
		this.setX(x);
		isBreakableByPlayer = false;
		isBreakableByExplosion = true;
		isMovable = false;
		isAlive = true;
		isAnExplosableEntity = false;
		canCascade = true;
		
		try {
			BufferedImage img = ImageIO.read(new File("D:\\images\\breakableWall.png"));
			this.setImg(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
