package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BreakableWalls extends Cave {

	public BreakableWalls(final int x, final int y) {
		this.setY(y);
		this.setX(x);
		isBreakableByPlayer = false;
		isBreakableByExplosion = true;
		isMovable = false;
		isAlive = true;

		try {
			BufferedImage img = ImageIO.read(new File("D:\\images\\breakableWall.png"));
			this.setImg(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
