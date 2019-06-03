/*
 * @author Xavier Nicolas Adèle Antoine
 */
package contract;

// TODO: Auto-generated Javadoc
/**
 * The Interface IView.
 */
public interface IView {

	/**
	 * Prints the message.
	 *
	 * @param message the message
	 */
	void printMessage(final String message);
	
	/**
	 * Move player.
	 *
	 * @param x the x
	 * @param y the y
	 * @param co the co
	 */
	void movePlayer(final int x, final int y, final ControllerOrder co);
}
