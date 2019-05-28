package entity;

import java.awt.Point;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
/**
 * Mais c'est pas gentil
 *
 * @author Jean-Aymeric Diet
 */
public class HelloWorld extends Entity {

	/** The id. */
	private int id;

	/** The key. */
	private String key;

	/** The message. */
	private String message;

	/**
	 * Instantiates a new hello world.
	 *
	 * @param id      the id
	 * @param key     the key
	 * @param message the message
	 */
	public HelloWorld(final int id, final String key, final String message) {
		this.setId(id);
		this.setKey(key);
		this.setMessage(message);
	}

	/**
	 * Instantiates a new hello world.
	 */
	public HelloWorld() {
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

	public HashMap<Point, String> createMap() {
		/*String[] chaineMap = this.getMessage().split(",");
		HashMap<Point, String> map = new HashMap<Point, String>();
		int x = 0;
		int y = 0;
		for (String sprite : chaineMap) {
			if (sprite == ";") {
				y++;
				x = 0;
			} else {
				map.put(new Point(x, y), sprite);	
				x++;
				System.out.println("mon sprite: " + sprite);	
			}
			
		}
		return map;*/
		
		String chaineMap = this.getMessage();
		HashMap<Point, String> map = new HashMap<Point, String>();
		int x = 0;
		int y = 0;
		char sprite;
		String spriteStr;
		for (int i=0; i<chaineMap.length(); i++) {
			sprite= chaineMap.charAt(i);
			
			if (sprite == ';') {
				y++;
				x = 0;
				spriteStr= ""+sprite;
				map.put(new Point(x, y), spriteStr);
				//System.out.println("i'm if");	
			} else {
				spriteStr= ""+sprite;
				map.put(new Point(x, y), spriteStr);	
				x++;
				//System.out.println("my sprite: " + spriteStr);	
			}
			
		}
		/*Set<Entry<Point, String>> setHm = map.entrySet();
	      Iterator<Entry<Point, String>> it = setHm.iterator();
	      while(it.hasNext()){
	         Entry<Point, String> e = it.next();
	         
	        System.out.println((int)e.getKey().getY()+" "+(int)e.getKey().getX()+ " : " + e.getValue());
	      }*/
		return map;
	}

	
	public String printMap(HashMap<Point, String> map) {
		int height = 30;
		int width = 30;
		int lenght = height * width;
		StringBuilder grid = new StringBuilder(lenght);
		for (int i = 0; i < lenght; i++) {
			if (i >= width && i % (width) == 0) {
				grid.append('\n');
			}
			grid.append(' ');
		}
		for (Point c : map.keySet()) {
			int index = (int) (c.getX() * (width + 1) + c.getY());
			grid.setCharAt(index, map.get(c).toString().charAt(0));
			//System.out.println(c.getX()+" "+c.getY());

		}
		
		//System.out.println(grid.toString());
		return grid.toString();
	}

}
