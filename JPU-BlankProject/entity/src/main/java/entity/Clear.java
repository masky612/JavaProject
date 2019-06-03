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
 * The Class Clear.
 */
public class Clear extends Cave {
	
	/** The Constant CLEAR_PATH. */
	public final static String CLEAR_PATH = "D:\\images\\clear.png";
	
	/**
	 * Instantiates a new clear.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Clear(final int x, final int y) {
		this.setY(y);
		this.setX(x);
		isBreakableByPlayer = true;
		isBreakableByExplosion = true;
		isMovable = false;
		isAlive = true;
		isFull = false;
		isAnExplosableEntity = false;

		try {
			BufferedImage img = ImageIO.read(new File(CLEAR_PATH));
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
			return ImageIO.read(new File(CLEAR_PATH));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
}
}
