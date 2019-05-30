package view;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;
import view.ViewPanel;
import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public final class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_A:
				return ControllerOrder.map1;
			case KeyEvent.VK_Z:
				return ControllerOrder.map2;
			case KeyEvent.VK_E:
				return ControllerOrder.map3;
			case KeyEvent.VK_R:
				return ControllerOrder.map4;
			case KeyEvent.VK_T:
				return ControllerOrder.map5;
			case KeyEvent.VK_UP:
				return ControllerOrder.up;
			case KeyEvent.VK_DOWN:
				return ControllerOrder.down;
			case KeyEvent.VK_LEFT:
				return ControllerOrder.left;
			case KeyEvent.VK_RIGHT:
				return ControllerOrder.right;
			default:
				return null;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}

	@Override
	public void movePlayer(int x, int y, ControllerOrder co) {
		try {
			((ViewPanel)this.viewFrame.getContentPane()).movePlayer(x,y,co);
		}
		catch(IOException ex){
			Logger.getLogger(View.class.getName()).log(Level.SEVERE,null, ex);
		}
		
		
		
	}
}
