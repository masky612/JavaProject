package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Monster extends Cave {

	public Monster(final int x, final int y) {
		this.setY(y);
		this.setX(x);
		isBreakableByPlayer = false;
		isBreakableByExplosion = true;
		isMovable = true;
		isAlive = true;

		try {
			BufferedImage img = ImageIO.read(new File("D:\\images\\monster.png"));
			this.setImg(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
