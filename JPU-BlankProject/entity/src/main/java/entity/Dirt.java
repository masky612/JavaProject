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
 * The Class Dirt.
 */
public class Dirt extends Cave {

	/**
	 * Instantiates a new dirt.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Dirt(final int x, final int y) {
		this.setY(y);
		this.setX(x);
		isBreakableByPlayer = true;
		isBreakableByExplosion = true;
		isMovable = false;
		isAlive = true;
		isAnExplosableEntity = false;
		

		try {
			BufferedImage img = ImageIO.read(new File("D:\\images\\dirt.png"));
			this.setImg(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
