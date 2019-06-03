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
 * The Class Rocks.
 */
public class Rocks extends Cave {

	/**
	 * Instantiates a new rocks.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Rocks(final int x, final int y) {
		this.setY(y);
		this.setX(x);
		isBreakableByPlayer = false;
		isBreakableByExplosion = true;
		isMovable = true;
		isAlive = true;
		canFall = true;
		canFallKill = false;
		canPush = true;
		isAnExplosableEntity = false;
		canCascade = true;
		
		try {
			BufferedImage img = ImageIO.read(new File("D:\\images\\rock.png"));
			this.setImg(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}