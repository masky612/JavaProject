package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
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
	 * @param viewFrame
	 *          the new view frame
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
		//BufferedImage img = null;
		//BufferedImage img2 = null;
		String[] message =this.getViewFrame().getModel().getHelloWorld().getMessage().split(";");
		int hauteur = 400;
		for (String msg : message)  
        { 
			graphics.drawString(msg, 750,hauteur);
			hauteur+=10;
        } 
		/*try {
            img = ImageIO.read(new File("D:/images/wall.png"));
            img2 = ImageIO.read(new File("D:/images/diamond.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
       // graphics.drawString(this.getViewFrame().getModel().getHelloWorld().getMessage(), 10, 20);

        if (img != null) {
        	graphics.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        }
        if (img2 != null) {
            graphics.drawImage(img2, 16, 0, 16,16, this);
        }*/ 
	}
}

