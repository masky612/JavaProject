/*
 * @author Xavier Nicolas Adèle Antoine
 */
package contract;

import java.util.Observable;

import entity.Level;

// TODO: Auto-generated Javadoc
/**
 * The Interface IModel.
 */
public interface IModel {

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	Level getLevel();

	/**
	 * Load level.
	 *
	 * @param i the i
	 */
	void loadLevel(int i);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
