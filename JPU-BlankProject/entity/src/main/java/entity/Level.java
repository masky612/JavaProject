/*
 * @author Xavier Nicolas Adèle Antoine
 */
package entity;

import java.awt.Point;
import java.io.IOException;
import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class Level.
 */
public class Level extends Entity {

	/** The id. */
	private int id;

	/** The key. */
	private String key;

	/** The message. */
	private String message;

	/**
	 * Instantiates a new level.
	 *
	 * @param id the id
	 * @param key the key
	 * @param message the message
	 */
	public Level(final int id, final String key, final String message) {
		this.setId(id);
		this.setKey(key);
		this.setMessage(message);
	}

	/**
	 * Instantiates a new level.
	 */
	public Level() {
		this(0, "", "");
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getKey() {
		return this.key;
	}

	/**
	 * Sets the key.
	 *
	 * @param key the new key
	 */
	public void setKey(final String key) {
		this.key = key;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(final String message) {
		this.message = message;
	}

	 // Creating HashMap to link objects with coordinates
	
	/**
 	 * Creates the map.
 	 *
 	 * @return the hash map
 	 * @throws IOException Signals that an I/O exception has occurred.
 	 */
 	public HashMap<Point, Cave> createMap() throws IOException {

		String chaineMap = this.getMessage();
		HashMap<Point, Cave> map = new HashMap<Point, Cave>();
		int x = 0;
		int y = 0;
		char sprite;
		String spriteStr;
		for (int i = 0; i < chaineMap.length(); i++) {
			sprite = chaineMap.charAt(i);

			if (sprite == ';') {
				y += 32;
				x = 0;
				spriteStr = String.valueOf(sprite);
				Cave obj = Cave.getObjFromSpriteStr(spriteStr, x, y);
				map.put(new Point(x, y), obj);

			} else {
				spriteStr = "" + sprite;
				Cave obj = Cave.getObjFromSpriteStr(spriteStr, x, y);
				map.put(new Point(x, y), obj);
				x += 32;

			}
		}

		return map;
	}

}
