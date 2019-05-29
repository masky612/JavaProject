package view;
import entity.Wall;
import entity.BreakableWalls;
import entity.Diamonds;
import entity.Dirt;
import entity.Exit;
import entity.HelloWorld;
import entity.Rocks;

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

       // HashMap<Point, Object> test = this.getViewFrame().getModel().getHelloWorld().createMap();

        HashMap<Point, String> test = this.getViewFrame().getModel().getHelloWorld().createMap();
      
	
       /* try {
            Set<Entry<Point, Object>> setHm = test.entrySet();
            Iterator<Entry<Point, Object>> it = setHm.iterator();
            while (it.hasNext()) {
                Entry<Point, Object> e = it.next();
                img = ((Object) e.getValue()).getImg();
               // img = replacePng(e.getValue(),e.getKey().x,e.getKey().y);
                if (img != null) {
                
                    graphics.drawImage(Wall.getImg(),Wall.getX(),Wall.getY(), 32, 32, null);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
        
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
        
        
        /*graphics.clearRect(0, 0, this.getWidth(),
                this.getHeight()); //*/
       /* graphics.drawString(this.getViewFrame().getModel().getHelloWorld().getMessage(), 10, 20);*/
        

    }

    public BufferedImage replacePng(String test,int x, int y) throws IOException {
        BufferedImage img = null;
        if ("U".equals(test)) {
            //System.out.println(e.getValue());
       	 img = ImageIO.read(new File("D:\\pictures\\sprites\\wall.png"));

        }else if("D".equals(test)) {
        	 img = ImageIO.read(new File("D:\\pictures\\sprites\\dirt.png"));
        new Dirt(x,y,img);
        }
        else if("R".equals(test)) {
        	img = ImageIO.read(new File("D:\\pictures\\sprites\\rock.png"));
            new Rocks(x,y,img);
        }
        else if("O".equals(test)) {
        	img = ImageIO.read(new File("D:\\pictures\\sprites\\diamond.png"));
            new Diamonds(x,y,img);
        }
        else if("E".equals(test)) {
        	img = ImageIO.read(new File("D:\\pictures\\sprites\\exit.png"));
            new Exit(x,y,img);
        }
        else if("B".equals(test)) {
        	img = ImageIO.read(new File("D:\\pictures\\sprites\\breakableWall.png"));
            new BreakableWalls(x,y,img);
        }
        return img;
    }

}
