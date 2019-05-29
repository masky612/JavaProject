package entity;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rocks extends Object {
	public Rocks(final int x, final int y, BufferedImage img){
		this.setY(y);
        this.setX(x);
        isBreakableByPlayer = false;
        isBreakableByExplosion = false;
        isMovable = false;
        isAlive = true;
    
	
    try {
    	img = ImageIO.read(new File("D:\\pictures\\sprites\\rock.png"));
        this.setImg(img);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
	
}
}