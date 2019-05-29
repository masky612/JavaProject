package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class Controller.1234
 */
public final class Controller implements IController {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
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
		this.view.printMessage("Appuyer sur les touches '1', '2', '3' ou '4', pour afficher le niveaux que vous voulez.");
	}

	/**
     * Sets the view.
     *
     * @param pview
     *            the new view
     */
	private void setView(final IView pview) {
		this.view = pview;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
     * Order perform.
     *
     * @param controllerOrder
     *            the controller order
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case map1:
				this.model.loadHelloWorld(1);
				break;
			case map2:
				this.model.loadHelloWorld(2);
				break;
			case map3:
				this.model.loadHelloWorld(3);
				break;
			case map4:
				this.model.loadHelloWorld(4);
				break;
			case map5:
				this.model.loadHelloWorld(5);
			case up:
				this.view.movePlayer(x, y);
				break;
			case down:
				this.view.movePlayer(x, y);
				break;
			case left:
				this.view.movePlayer(x, y);
				break;
			case right:
				this.view.movePlayer(x, y);
				break;
				
			default:
				break;
		}
	}

}
