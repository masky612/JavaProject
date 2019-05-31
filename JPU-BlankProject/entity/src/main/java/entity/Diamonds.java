package entity;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Diamonds extends Cave {

	public Diamonds(final int x, final int y) {
		this.setY(y);
		this.setX(x);
		isBreakableByPlayer = false;
		isBreakableByExplosion = true;
		isMovable = true;
		isAlive = true;
		isClaimable = true;
		canfall = true;
		canfallkill = false;
		isanexplosableentity = false;
		
		
		try {
			BufferedImage img = ImageIO.read(new File("D:\\images\\diamond.png"));
			this.setImg(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
