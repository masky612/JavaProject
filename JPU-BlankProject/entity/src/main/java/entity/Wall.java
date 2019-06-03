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
 * The Class Wall.
 */
public class Wall extends Cave {

	/**
	 * Instantiates a new wall.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Wall(final int x, final int y) {
		this.setY(y);
		this.setX(x);
		isBreakableByPlayer = false;
		isBreakableByExplosion = false;
		isMovable = false;
		isAlive = true;
		isAnExplosableEntity = false;
		

		try {
			BufferedImage img = ImageIO.read(new File("D:\\images\\wall.png"));
			this.setImg(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
