package view;

import entity.Wall;
import entity.BreakableWall;
import entity.Clear;
import entity.Diamond;
import entity.Dirt;
import entity.Exit;
import entity.HelloWorld;
import entity.Monster;
import entity.Rock;
import entity.Rockfort;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

	/**
	 * The view frame.
	 */
	private ViewFrame viewFrame;
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
		BufferedImage img = null;
		// BufferedImage img2 = null;
		/*
		 * String[] message
		 * =this.getViewFrame().getModel().getHelloWorld().getMessage().split(";"); int
		 * hauteur = 400; for (String msg : message) { graphics.drawString(msg,
		 * 750,hauteur); hauteur+=10; }
		 */

		HashMap<Point, String> test = this.getViewFrame().getModel().getHelloWorld().createMap();

		// String test2 = this.getViewFrame().getModel().getHelloWorld().printMap(test);
		/*
		 * char carac; for (int i=0; i<test2.length(); i++) { carac= test2.charAt(i); if
		 * (carac=='U') {
		 * 
		 * try { img = ImageIO.read(new File("D:/images/wall.png"));
		 * 
		 * } catch (IOException ex) { ex.printStackTrace(); } graphics.clearRect(0, 0,
		 * this.getWidth(), this.getHeight()); //
		 * graphics.drawString(this.getViewFrame().getModel().getHelloWorld().getMessage
		 * (), 10, 20);
		 * 
		 * if (img != null) { graphics.drawImage(img, 32, 0, 16, 16, this); }
		 * 
		 * } }
		 */
		try {
			Set<Entry<Point, String>> setHm = test.entrySet();
			Iterator<Entry<Point, String>> it = setHm.iterator();
			while (it.hasNext()) {
				Entry<Point, String> e = it.next();
				img = replacePng(e.getValue(), e.getKey().x, e.getKey().y);
				if (img != null) {

					graphics.drawImage(Wall.getImg(), Wall.getX(), Wall.getY(), 16, 16, null);
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		/*
		 * graphics.clearRect(0, 0, this.getWidth(), this.getHeight()); //
		 */
		/*
		 * graphics.drawString(this.getViewFrame().getModel().getHelloWorld().getMessage
		 * (), 10, 20);
		 */

	}

	public BufferedImage replacePng(String valueMap, int x, int y) throws IOException {
		BufferedImage img = null;
		if ("U".equals(valueMap)) {
			img = ImageIO.read(new File("D:\\images\\wall.png"));
			new Wall(x, y, img);
		} else if ("D".equals(valueMap)) {
			img = ImageIO.read(new File("D:\\images\\dirt.png"));
			new Dirt(x, y, img);
		}
		else if ("E".equals(valueMap)) {
			img = ImageIO.read(new File("D:\\images\\exit.png"));
			new Exit(x, y, img);
		} else if ("B".equals(valueMap)) {
			img = ImageIO.read(new File("D:\\images\\breakableWall.png"));
			new BreakableWall(x, y, img);
		} else if ("C".equals(valueMap)) {
			img = ImageIO.read(new File("D:\\images\\clear.png"));
			new Clear(x, y, img);
		} else if ("R".equals(valueMap)) {
			img = ImageIO.read(new File("D:\\images\\rock.png"));
			new Rock(x, y, img);
		} else if ("O".equals(valueMap)) {
			img = ImageIO.read(new File("D:\\images\\diamond.png"));
			new Diamond(x, y, img);
		} else if ("M".equals(valueMap)) {
			img = ImageIO.read(new File("D:\\images\\monster.png"));
			new Monster(x, y, img);
		} else if ("S".equals(valueMap)) {
			img = ImageIO.read(new File("D:\\images\\down.png"));
			new Rockfort(x, y, img);
		}
		return img;
	}

}
