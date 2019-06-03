/*
 * @author Xavier Nicolas Adèle Antoine
 */
package entity;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// TODO: Auto-generated Javadoc
/**
 * The Class Diamonds.
 */
public class Diamonds extends Cave {

	/**
	 * Instantiates a new diamonds.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Diamonds(final int x, final int y) {
		this.setY(y);
		this.setX(x);
		isBreakableByPlayer = false;
		isBreakableByExplosion = true;
		isMovable = true;
		isAlive = true;
		isClaimable = true;
		canFall = true;
		canFallKill = false;
		isAnExplosableEntity = false;
		canCascade = true;
		
		
		try {
			BufferedImage img = ImageIO.read(new File("D:\\images\\diamond.png"));
			this.setImg(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public static Image getImage() {
		
		try {
			return ImageIO.read(new File("D:\\images\\diamond.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
}
}
