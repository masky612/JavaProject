package entity;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rockford extends Cave {
	
	

	private Image imgUp;
	private Image imgDown;
	private Image imgLeft;
	private Image imgRight;
	
	public Rockford(int x, int y)  {
		this.p = new Point(x, y);
		try {
			this.imgUp = ImageIO.read(new File("D:\\images\\up.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.imgDown = ImageIO.read(new File("D:\\images\\down.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.imgLeft = ImageIO.read(new File("D:\\images\\left.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			this.imgRight = ImageIO.read(new File("D:\\images\\right.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			BufferedImage img = ImageIO.read(new File("D:\\images\\down.png"));
			this.setImg(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private Point p;
	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

	public Image getImgUp() {
		return imgUp;
	}

	public Image getImgDown() {
		return imgDown;
	}

	public Image getImgLeft() {
		return imgLeft;
	}

	public Image getImgRight() {
		return imgRight;
	}
}
