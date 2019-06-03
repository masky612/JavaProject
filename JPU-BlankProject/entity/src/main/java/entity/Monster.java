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
 * The Class Monster.
 */
public class Monster extends Cave {

	/**
	 * Instantiates a new monster.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Monster(final int x, final int y) {
		this.setY(y);
		this.setX(x);
		isBreakableByPlayer = false;
		isBreakableByExplosion = true;
		isMovable = true;
		isAlive = true;
		isAMonster = true;
		wasGoingLeft = false;
		wasGoingRight = false;
		wasGoingUp = false;
		wasGoingDown = false;

		try {
			BufferedImage img = ImageIO.read(new File("D:\\images\\monster.png"));
			this.setImg(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
