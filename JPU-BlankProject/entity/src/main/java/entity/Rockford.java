package entity;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rockford extends Cave {
	
	

	private Image imgUp;
	private Image imgDown;
	private Image imgLeft;
	private Image imgRight;
	
	public Rockford(int x, int y) throws IOException {
		this.p = new Point(x, y);
		this.imgUp = ImageIO.read(new File("D:pictures\\sprites\\up.png"));
		this.imgDown = ImageIO.read(new File("D:pictures\\sprites\\down.png"));
		this.imgLeft = ImageIO.read(new File("D:pictures\\sprites\\left.png"));
		this.imgRight = ImageIO.read(new File("D:pictures\\sprites\\right.png"));
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
