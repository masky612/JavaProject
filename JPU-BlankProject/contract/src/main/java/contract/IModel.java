package contract;

import java.util.Observable;

import entity.HelloWorld;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the hello world.
	 *
	 * @return the helloworld entity
	 */
	HelloWorld getHelloWorld();

	/**
	 * Load the message.
	 *
	 * @param i
	 *          the code
	 */
	void loadHelloWorld(int i);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
