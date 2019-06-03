/*
 * @author Xavier Nicolas Adèle Antoine
 */
package entity;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



// TODO: Auto-generated Javadoc
/**
 * The Class Rockford.
 */
public class Rockford extends Cave {
	
	
	

	/** The img up. */
	private Image imgUp;
	
	/** The img down. */
	private Image imgDown;
	
	/** The img left. */
	private Image imgLeft;
	
	/** The img right. */
	private Image imgRight;
	
	/** The instance. */
	private static Rockford INSTANCE = null;
	
	
	/**
	 * Gets the single instance of Rockford.
	 *
	 * @return single instance of Rockford
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static synchronized Rockford getInstance() throws IOException {
		if (Rockford.INSTANCE == null) {
			Rockford.INSTANCE = new Rockford(0,0);
		}
		return Rockford.INSTANCE;
	}
	
	/**
	 * Instantiates a new rockford.
	 *
	 * @param x the x
	 * @param y the y
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public  Rockford(int x, int y) throws IOException {
		this.setX(x);
		this.setY(y);
		this.p = new Point(x,y);
		
		
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
	
	

	
	/** The p. */
	private Point p;
	
	/**
	 * Gets the img up.
	 *
	 * @return the img up
	 */
	public Image getImgUp() {
		return imgUp;
	}

	/**
	 * Gets the img down.
	 *
	 * @return the img down
	 */
	public Image getImgDown() {
		return imgDown;
	}

	/**
	 * Gets the img left.
	 *
	 * @return the img left
	 */
	public Image getImgLeft() {
		return imgLeft;
	}

	/**
	 * Gets the img right.
	 *
	 * @return the img right
	 */
	public Image getImgRight() {
		return imgRight;
	}
	
	/*public Rockford(int x, int y)  {
		this.setX(x);
		this.setY(y);
		this.p = new Point(x,y);
		
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
	}*/
}
