/*
 * @author Xavier Nicolas Adèle Antoine
 */
package controller;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import entity.Rockford;
// TODO: Auto-generated Javadoc

/**
 * The Class Controller.
 */
public final class Controller implements IController {

	/** The view. */
	private IView view;

	/** The model. */
	private IModel model;
	
	/** The game start. */
	public boolean gameStart = false;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view the view
	 * @param model the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/**
	 * Control.
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMessage("Press key '1', '2', '3', '4' or '5', to chose your level, once you move the game is lauched amd you cant change anymore.");
	}
	

	/**
	 * Sets the view.
	 *
	 * @param pview the new view
	 */
	private void setView(final IView pview) {
		this.view = pview;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * Order perform.
	 *
	 * @param controllerOrder the controller order
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		if (gameStart == false ) {
		switch (controllerOrder) {
		case map1:
			this.model.loadLevel(1);
			break;
		case map2:
			this.model.loadLevel(2);
			break;
		case map3:
			this.model.loadLevel(3);
			break;
		case map4:
			this.model.loadLevel(4);
			break;
		case map5:
			this.model.loadLevel(5);
			break;
		default :
			break;
		}
		}switch (controllerOrder) {
		case up:
			try {
				if (gameStart == false) {
					gameStart = true;
				}
				
				this.view.movePlayer(Rockford.getInstance().getX(), Rockford.getInstance().getY(),ControllerOrder.up);
			} catch (IOException ex) {
				Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
			}
			break;
		case right:
			try {
				if (gameStart == false) {
					gameStart = true;
				}
				
				this.view.movePlayer(Rockford.getInstance().getX(), Rockford.getInstance().getY() ,ControllerOrder.right);
			} catch (IOException ex) {
				Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
			}
			break;
		case down:
			try {
				if (gameStart == false) {
					gameStart = true;
				}
				
				this.view.movePlayer(Rockford.getInstance().getX(), Rockford.getInstance().getY(),ControllerOrder.down);
			} catch (IOException ex) {
				Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
			}
			break;
		case left:
			try {
				if (gameStart == false) {
					gameStart = true;
				}
				
				this.view.movePlayer(Rockford.getInstance().getX(), Rockford.getInstance().getY(),ControllerOrder.left);
			} catch (IOException ex) {
				Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
			}
			break;
		
		/*
		 * case down: this.view.movePlayer(x, y); break; case left:
		 * this.view.movePlayer(x, y); break; case right: this.view.movePlayer(x, y);
		 * break;
		 */
		default:
			break;
		}
	}

}

