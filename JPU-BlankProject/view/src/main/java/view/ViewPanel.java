package view;

import entity.Wall;
import entity.BreakableWalls;
import entity.Cave;
import entity.Clear;
import entity.Diamonds;
import entity.Dirt;
import entity.Exit;
import entity.HelloWorld;
import entity.Rockford;
import entity.Rocks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import contract.ControllerOrder;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
public class ViewPanel extends JPanel implements Observer {
		 
	/**
	 * The view frame.
	 */
	private ViewFrame viewFrame;
	
	int Px;
	int Py;
	boolean checkvalue;
	int score = 0;
	int diamondValue = 20;
	int levelExitScore = 250;
		 
	public  HashMap<Point, Cave> test = new HashMap<>();
	
		
	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = -998294702363713521L;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, 2000, 2000);
		Image img = null;

		try {
			test = this.getViewFrame().getModel().getHelloWorld().createMap();
			Set<Entry<Point, Cave>> setHm = test.entrySet();
			Iterator<Entry<Point, Cave>> it = setHm.iterator();
			while (it.hasNext()) {
				Entry<Point, Cave> e = it.next();
				System.out.print(e.getValue());
				img = e.getValue().getImg();
				if (img != null) {
					graphics.drawImage(e.getValue().getImg(), e.getValue().getX(), e.getValue().getY(), 32, 32, null);
				}
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	public void itemGravity() {
		int testx = 32*29, testy = 32*29;
		//int mapsize = 32*30;
		
		while (testy >= 0) {
			
		while (testx >= 0) {
			Cave targettestblock = test.get(new Point(testx ,testy));
			boolean itemcantfly = targettestblock.getcanfall();
			if (itemcantfly == true) {
				Cave undertest = test.get(new Point(testx ,testy + 32));
				boolean underitemcantfly = undertest.getisfull();
				if (underitemcantfly == false) {
					
					Graphics graphics = this.getGraphics();
					targettestblock.setP(new Point(testx, testy + 32));
					targettestblock.setY(testy + 32);
					Image img = targettestblock.getImg();
					graphics.drawImage(img, testx, testy + 32, 32, 32, null);
					test.replace(new Point(testx, testy + 32), targettestblock);

					// update clear;
					graphics.drawImage(Clear.getImage(), testx, testy, 32, 32, null);
					test.replace(new Point(testx, testy), new Clear(testx, testy));
				}
			}
			testx =testx - 32;
			
		}
		testx = 32*29;
		testy =testy - 32;
	}
	}
	

	
	public void hitbox(int x, int y, int Px , int Py) {	
		itemGravity();
		Cave targetitem = test.get(new Point(x + Px, y + Py));
		boolean destructablebyPlayer = targetitem.getdestructP1();
		boolean claimablebyPlayer = targetitem.getclaimedP1();
		boolean thisIsDaWay = targetitem.getDaWay();
		if ( claimablebyPlayer == true){
			checkvalue = true;
			score = score + diamondValue ;
			System.out.println(" ur curent score is " + score);
		
		}
		else if ( destructablebyPlayer == true){
			checkvalue = true;
		} 
		else if ( thisIsDaWay == true && score >= levelExitScore ) {
			checkvalue = true;
			System.out.println("Weal Played U Won");
		}
		else {
			checkvalue = false;
		}
		/*if ( claimablebyPlayer == true){
			checkvalue = true;
			score ++ ;
			System.out.println(" ur curent score is ");
		}*/
	}
	
	
	public void movePlayer(int x, int y, ControllerOrder co) throws IOException {
		Graphics graphics = this.getGraphics();
		switch (co) {
		case up:
			Px = 0;
			Py = -32;
			hitbox( x,  y,  Px,  Py);
			if (checkvalue == true) {
			// update rockford;
			Rockford.getInstance().setP(new Point(x, y - 32));
			Rockford.getInstance().setY(y - 32);
			Image img = Rockford.getInstance().getImgUp();
			graphics.drawImage(img, x, y - 32, 32, 32, null);
			test.replace(new Point(x, y - 32), Rockford.getInstance());

			// update clear;
			graphics.drawImage(Clear.getImage(), x, y, 32, 32, null);
			test.replace(new Point(x, y), new Clear(x, y));
			}
			checkvalue = false;
			break;
			
		case right:
			Px = +32;
			Py = 0;
			hitbox( x,  y,  Px,  Py);
			if (checkvalue == true) {
			// update rockford;
			Rockford.getInstance().setP(new Point(x + 32, y));
			Rockford.getInstance().setX(x + 32);
			Image img1 = Rockford.getInstance().getImgRight();
			graphics.drawImage(img1, x + 32, y, 32, 32, null);
			test.replace(new Point(x + 32, y), Rockford.getInstance());

			// update clear;
			graphics.drawImage(Clear.getImage(), x, y, 32, 32, null);
			test.replace(new Point(x, y), new Clear(x, y));
			}
			checkvalue = false;
			break;

		case down:
			Px = 0;
			Py = 0 + 32;
			hitbox( x,  y,  Px,  Py);
			if (checkvalue == true) {
			// update rockford;
			Rockford.getInstance().setP(new Point(x, y + 32));
			Rockford.getInstance().setY(y + 32);
			Image img2 = Rockford.getInstance().getImgDown();
			graphics.drawImage(img2, x, y + 32, 32, 32, null);
			test.replace(new Point(x, y + 32), Rockford.getInstance());

			// update clear;
			graphics.drawImage(Clear.getImage(), x, y, 32, 32, null);
			test.replace(new Point(x, y), new Clear(x, y));
			}
			checkvalue = false;
			break;
			
		case left:
			Px = 0 -32;
			Py = 0;
			hitbox( x,  y,  Px,  Py);
			if (checkvalue == true) {
			// update rockford;
			Rockford.getInstance().setP(new Point(x - 32, y));
			Rockford.getInstance().setX(x - 32);
			Image img3 = Rockford.getInstance().getImgLeft();
			graphics.drawImage(img3, x - 32, y, 32, 32, null);
			test.replace(new Point(x - 32, y), Rockford.getInstance());

			// update clear;
			graphics.drawImage(Clear.getImage(), x, y, 32, 32, null);
			test.replace(new Point(x, y), new Clear(x, y));
			}
			checkvalue = false;
			break;

		default:
			break;
		}
	}

}
