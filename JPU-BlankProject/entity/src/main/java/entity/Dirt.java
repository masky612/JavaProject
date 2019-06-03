package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Dirt extends Cave {

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
