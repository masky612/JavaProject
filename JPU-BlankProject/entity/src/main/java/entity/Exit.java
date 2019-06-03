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
 * The Class Exit.
 */
public class Exit extends Cave {

	/**
	 * Instantiates a new exit.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Exit(final int x, final int y) {
		this.setY(y);
		this.setX(x);
		isBreakableByPlayer = false;
		isBreakableByExplosion = false;
		isMovable = false;
		isAlive = true;
		isDaWay = true;
		isAnExplosableEntity = false;
		
				
		try {
			BufferedImage img = ImageIO.read(new File("D:\\images\\exit.png"));
			this.setImg(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
