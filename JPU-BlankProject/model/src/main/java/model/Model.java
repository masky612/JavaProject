/*
 * @author Xavier Nicolas Adèle Antoine
 */
package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import entity.Level;

// TODO: Auto-generated Javadoc
/**
 * The Class Model.
 */
public final class Model extends Observable implements IModel {

	/** The level. */
	private Level level;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.level = new Level();
	}

	/**
     * Gets the hello world.
     *
     * @return the hello world
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public Level getLevel() {
		return this.level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level the new level
	 */
	private void setLevel(final Level level) {
		this.level = level;
		this.setChanged();
		this.notifyObservers();
	}

	/**
     * Load hello world.
     *
     * @param code
     *            the code
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadLevel(final int code) {
		try {
			final DAOLevel daoLevel = new DAOLevel(DBConnection.getInstance().getConnection());
			this.setLevel(daoLevel.find(code));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/**
     * Gets the observable.
     *
     * @return the observable
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}


}
