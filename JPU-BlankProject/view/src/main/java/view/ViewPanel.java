/*
 * @author Xavier Nicolas Adèle Antoine
 */
package view;

import entity.Cave;
import entity.Clear;
import entity.Diamonds;
import entity.Rockford;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.Map.Entry;

import javax.swing.JPanel;

import contract.ControllerOrder;

// TODO: Auto-generated Javadoc
/**
 * The Class ViewPanel.
 */
public class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame viewFrame;

	/** The Px. */
	int Px;
	
	/** The Py. */
	int Py;
	
	/** The check value. */
	boolean checkValue;
	
	/** The score. */
	int score = 0; // initialisation of the score
	
	/** The diamond value. */
	int diamondValue = 20; // set the global value of diamond
	
	/** The level exit score. */
	int levelExitScore = 250; // set the goal score to end a level
	
	/** The start value. */
	int startValue = 0; // permit to start the gravity thread

	/** The test. */
	public static HashMap<Point, Cave> test = new HashMap<>();

	// ______________________________________ \\
	/**
	 * The Class MyRunnable.
	 */
	// thread who permit to create gravity \\
	public class MyRunnable implements Runnable {
		
		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			int i = 1;
			while (i > 0) {
				try {
					TimeUnit.MILLISECONDS.sleep(200); // pause the loop to reduce rock's fall speed
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					itemGravity();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	// ______________________________________ \\

	// -------------------------------------- \\
	/**
	 * The Class MyRunnableMonster.
	 */
	// thread de gestion de la gravité \\
	public class MyRunnableMonster implements Runnable {
		
		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			int i = 1;
			while (i > 0) {
				try {
					TimeUnit.MILLISECONDS.sleep(400); // pause the loop to reduce moster's movement speed
													
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					movementMonster(); //call the monster movement fonction
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	// -------------------------------------- \\

	/** The Constant serialVersionUID. */
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

	// Creating the game map with objects

	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, 2000, 2000);
		Image img = null;

		try {
			test = this.getViewFrame().getModel().getLevel().createMap();
			Set<Entry<Point, Cave>> setHm = test.entrySet();
			Iterator<Entry<Point, Cave>> it = setHm.iterator();

			while (it.hasNext()) {
				Entry<Point, Cave> e = it.next();
				// System.out.print(e.getValue());
				img = e.getValue().getImg();
				if (img != null) {
					graphics.drawImage(e.getValue().getImg(), e.getValue().getX(), e.getValue().getY(), 32, 32, null);
				}
			}

		} catch (IOException e1) {

			e1.printStackTrace();
		}

	}

	/**
	 * Lose.
	 */
	public void lose() {
		viewFrame.printMessage("you lose"); //open a window to print the lose message
		System.exit(0); //kill the game

	}

	/**
	 * Win.
	 *
	 * @param score the score
	 */
	public void win(int score) {
		viewFrame.printMessage("you win with " + score + " point"); //open a window to print the win message
		System.exit(0); //kill the game
	}

	/**
	 * Explode.
	 *
	 * @param explodeY the explode Y
	 * @param explodeX the explode X
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void explode(int explodeY, int explodeX) throws IOException { //clear every tile within the explosion radius
		Graphics graphics = this.getGraphics();
		int playerx = Rockford.getInstance().getX(); // get player's X coordinates
		int playery = Rockford.getInstance().getY(); // get player's Y coordinates

		if (test.get(new Point(explodeX, explodeY)).getIsBreakableByExplosion() == true) { //check if tile is breakable by explosion
			graphics.drawImage(Clear.getImage(), explodeX, explodeY, 32, 32, null); // x and y get the value of tile's coordinates
			test.replace(new Point(explodeX, explodeY), new Clear(explodeX, explodeY)); //erase tile
		}
		if (test.get(new Point(explodeX - 32, explodeY)).getIsBreakableByExplosion() == true) {
			graphics.drawImage(Clear.getImage(), explodeX - 32, explodeY, 32, 32, null);
			test.replace(new Point(explodeX - 32, explodeY), new Clear(explodeX - 32, explodeY));
		}
		if (test.get(new Point(explodeX + 32, explodeY)).getIsBreakableByExplosion() == true) {
			graphics.drawImage(Clear.getImage(), explodeX + 32, explodeY, 32, 32, null);
			test.replace(new Point(explodeX + 32, explodeY), new Clear(explodeX + 32, explodeY));
		}
		if (test.get(new Point(explodeX, explodeY + 32)).getIsBreakableByExplosion() == true) {
			graphics.drawImage(Clear.getImage(), explodeX, explodeY + 32, 32, 32, null);
			test.replace(new Point(explodeX, explodeY + 32), new Clear(explodeX, explodeY + 32));
		}
		if (test.get(new Point(explodeX + 32, explodeY + 32)).getIsBreakableByExplosion() == true) {
			graphics.drawImage(Clear.getImage(), explodeX + 32, explodeY + 32, 32, 32, null);
			test.replace(new Point(explodeX + 32, explodeY + 32), new Clear(explodeX + 32, explodeY + 32));
		}
		if (test.get(new Point(explodeX - 32, explodeY + 32)).getIsBreakableByExplosion() == true) {
			graphics.drawImage(Clear.getImage(), explodeX - 32, explodeY + 32, 32, 32, null);
			test.replace(new Point(explodeX - 32, explodeY + 32), new Clear(explodeX - 32, explodeY + 32));
		}
		if (test.get(new Point(explodeX, explodeY + 64)).getIsBreakableByExplosion() == true) {
			graphics.drawImage(Clear.getImage(), explodeX, explodeY + 64, 32, 32, null);
			test.replace(new Point(explodeX, explodeY + 64), new Clear(explodeX, explodeY + 64));
		}
		if (test.get(new Point(explodeX + 32, explodeY + 64)).getIsBreakableByExplosion() == true) {
			graphics.drawImage(Diamonds.getImage(), explodeX + 32, explodeY + 64, 32, 32, null);
			test.replace(new Point(explodeX + 32, explodeY + 64), new Diamonds(explodeX + 32, explodeY + 64));
		}
		if (test.get(new Point(explodeX - 32, explodeY + 64)).getIsBreakableByExplosion() == true) {
			graphics.drawImage(Diamonds.getImage(), explodeX - 32, explodeY + 64, 32, 32, null);
			test.replace(new Point(explodeX - 32, explodeY + 64), new Diamonds(explodeX - 32, explodeY + 64));
		}
		
		if (playerx == explodeX && playery == explodeY + 32) { // if the player was in the explosion area

			lose();
		}

	}

	/**
	 * Item gravity.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void itemGravity() throws IOException {
		
		int testx = 32 * 29, testy = 32 * 29;

		while (testy >= 0) {
				//loop and check every tiles to find a rock
			while (testx >= 0) {
				Cave targettestblock = test.get(new Point(testx, testy)); // target a tile
				boolean itemcantfly = targettestblock.getCanFall();
				if (itemcantfly == true) { // if the tile can fall (diamond or rock) them:
					Cave undertest = test.get(new Point(testx, testy + 32)); // check the tile below 
					if (undertest.getIsFull() == false) { // if its empty the the rock/diamond fall

						targettestblock.setCanFallKill(true); // set the fact that the rock can kill the player and actualize his position
						targettestblock.setP(new Point(testx, testy + 32));
						targettestblock.setY(testy + 32);
						Image img = targettestblock.getImg();
						Graphics graphics = this.getGraphics();
						graphics.drawImage(img, testx, testy + 32, 32, 32, null);
						test.replace(new Point(testx, testy + 32), targettestblock);

						// clear the previous rock/diamond position
						graphics.drawImage(Clear.getImage(), testx, testy, 32, 32, null);
						test.replace(new Point(testx, testy), new Clear(testx, testy));

					} else if (undertest.getCanCascade() == true) { // cascade
						//if the tile bellow is a rock or a diamond them check tile next to them and if they are empty move the rock
						if (test.get(new Point(testx + 32, testy)).getIsFull() == false // check Right side
								&& test.get(new Point(testx + 32, testy + 32)).getIsFull() == false) {
							targettestblock.setCanFallKill(true); 
							targettestblock.setP(new Point(testx + 32, testy));
							targettestblock.setX(testx + 32);
							Image img = targettestblock.getImg();
							Graphics graphics = this.getGraphics();
							graphics.drawImage(img, testx + 32, testy, 32, 32, null);
							test.replace(new Point(testx + 32, testy), targettestblock);

							graphics.drawImage(Clear.getImage(), testx, testy, 32, 32, null);
							test.replace(new Point(testx, testy), new Clear(testx, testy));
						} else if (test.get(new Point(testx - 32, testy)).getIsFull() == false // check left side
								&& test.get(new Point(testx - 32, testy + 32)).getIsFull() == false) {
							targettestblock.setCanFallKill(true); 
							targettestblock.setP(new Point(testx - 32, testy));
							targettestblock.setX(testx - 32);
							Image img = targettestblock.getImg();
							Graphics graphics = this.getGraphics();
							graphics.drawImage(img, testx - 32, testy, 32, 32, null);
							test.replace(new Point(testx - 32, testy), targettestblock);

							graphics.drawImage(Clear.getImage(), testx, testy, 32, 32, null);
							test.replace(new Point(testx, testy), new Clear(testx, testy));
						} else {
							targettestblock.setCanFallKill(false);
						}
					} else if (undertest.getIsAnExplosableEntity() == true && targettestblock.getCanFallKill() == true) { // if the rock is falling and the player is bellow then
																		
						int explodeY = targettestblock.getY();
						int explodeX = targettestblock.getX();
						explode(explodeY, explodeX); // generate an explosion on the player

					} else {
						targettestblock.setCanFallKill(false); // if the tile bellow is a static one then set set canfallkill to false 
					}

				}
				testx = testx - 32;
			}
			testx = 32 * 29;
			testy = testy - 32;
		}
	}

	/**
	 * Move monster.
	 *
	 * @param monster the monster
	 * @param monsterX the monster X
	 * @param monsterY the monster Y
	 * @param dirX the dir X
	 * @param dirY the dir Y
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void moveMonster(Cave monster, int monsterX, int monsterY, int dirX, int dirY) throws IOException {
		//move the monster position and clear his previous position
		Graphics graphics = this.getGraphics();
		monster.setP(new Point(monsterX + dirX, monsterY + dirY));
		monster.setX(monsterX + dirX);
		monster.setY(monsterY + dirY);
		Image img1 = monster.getImg();
		graphics.drawImage(img1, monsterX + dirX, monsterY + dirY, 32, 32, null);
		test.replace(new Point(monsterX + dirX, monsterY + dirY), monster);

		// update clear;
		graphics.drawImage(Clear.getImage(), monsterX, monsterY, 32, 32, null);
		test.replace(new Point(monsterX, monsterY), new Clear(monsterX, monsterY));
		if (Rockford.getInstance().getX() == monsterX + dirX && Rockford.getInstance().getY() == monsterY + dirY) {
			explode(monsterY + dirY, monsterX + dirX);
			lose();
		}
	}

	/**
	 * Movement monster.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void movementMonster() throws IOException {
		int monsterdebugleft = 0;
		int monsterdebugup = 0;
		int testx = 32 * 29, testy = 32 * 29;

		while (testy >= 0) {
			// check the map to find monster
			while (testx >= 0) {
				Cave monster = test.get(new Point(testx, testy));
				boolean imAMonster = monster.getIsAMonster(); 
				if (imAMonster == true) { // if a monster is found
					int monsterX = monster.getX(); //get monster coordinates
					int monsterY = monster.getY();
					// The monster checks if it can move in the tile at his left ,if he can't, he checks the tile upward,then to his right ,then downward.It moves to the first available tile					
					if (test.get(new Point(testx, testy)).getGoRight() == true) {
						if (test.get(new Point(testx, testy - 32)).getIsFull() == false
								|| test.get(new Point(testx, testy - 32)).getIsAnExplosableEntity() == true
										&& test.get(new Point(testx, testy - 32)).getIsAMonster() == false) {
							monster.setGoRight(false);
							monster.setGoUp(true);
							monsterdebugup = 1;
							moveMonster(monster, monsterX, monsterY, 0, -32);// UP
						} else if (test.get(new Point(testx + 32, testy)).getIsFull() == false
								|| test.get(new Point(testx + 32, testy)).getIsAnExplosableEntity() == true
										&& test.get(new Point(testx + 32, testy)).getIsAMonster() == false) {
							moveMonster(monster, monsterX, monsterY, +32, 0);// RIGHT
						} else if (test.get(new Point(testx, testy + 32)).getIsFull() == false
								|| test.get(new Point(testx, testy + 32)).getIsAnExplosableEntity() == true
										&& test.get(new Point(testx, testy + 32)).getIsAMonster() == false) {
							monster.setGoRight(false);
							monster.setGoDown(true);
							moveMonster(monster, monsterX, monsterY, 0, +32);// DOWN
						} else if (test.get(new Point(testx - 32, testy)).getIsFull() == false
								|| test.get(new Point(testx - 32, testy)).getIsAnExplosableEntity() == true
										&& test.get(new Point(testx - 32, testy)).getIsAMonster() == false) {
							monster.setGoRight(false);
							monster.setGoLeft(true);
							monsterdebugleft = 1;
							moveMonster(monster, monsterX, monsterY, -32, 0);// LEFT
						}
					}

					else if (test.get(new Point(testx, testy)).getGoLeft() == true) {
						if (monsterdebugleft == 0) {
							if (test.get(new Point(testx, testy + 32)).getIsFull() == false
									|| test.get(new Point(testx, testy + 32)).getIsAnExplosableEntity() == true
											&& test.get(new Point(testx, testy + 32)).getIsAMonster() == false) {
								monster.setGoLeft(false);
								monster.setGoDown(true);
								moveMonster(monster, monsterX, monsterY, 0, +32);// DOWN

							} else if (test.get(new Point(testx - 32, testy)).getIsFull() == false
									|| test.get(new Point(testx - 32, testy)).getIsAnExplosableEntity() == true
											&& test.get(new Point(testx - 32, testy)).getIsAMonster() == false) {
								monsterdebugleft = 1;
								moveMonster(monster, monsterX, monsterY, -32, 0);// LEFT

							} else if (test.get(new Point(testx, testy - 32)).getIsFull() == false
									|| test.get(new Point(testx, testy - 32)).getIsAnExplosableEntity() == true
											&& test.get(new Point(testx, testy - 32)).getIsAMonster() == false) {
								monster.setGoLeft(false);
								monster.setGoUp(true);
								monsterdebugup = 1;
								moveMonster(monster, monsterX, monsterY, 0, -32);// UP

							} else if (test.get(new Point(testx + 32, testy)).getIsFull() == false
									|| test.get(new Point(testx + 32, testy)).getIsAnExplosableEntity() == true
											&& test.get(new Point(testx + 32, testy)).getIsAMonster() == false) {// tt
																													// droit
								monster.setGoLeft(false);
								monster.setGoRight(true);
								moveMonster(monster, monsterX, monsterY, +32, 0);// RIGHT
							}
						} else {
							monsterdebugleft = 0;
						}
					}

					else if (test.get(new Point(testx, testy)).getGoUp() == true) {
						if (monsterdebugup == 0) {
							if (test.get(new Point(testx - 32, testy)).getIsFull() == false
									|| test.get(new Point(testx - 32, testy)).getIsAnExplosableEntity() == true
											&& test.get(new Point(testx - 32, testy)).getIsAMonster() == false) {
								monster.setGoUp(false);
								monster.setGoLeft(true);
								monsterdebugleft = 1;
								moveMonster(monster, monsterX, monsterY, -32, 0);// LEFT

							} else if (test.get(new Point(testx, testy - 32)).getIsFull() == false
									|| test.get(new Point(testx, testy - 32)).getIsAnExplosableEntity() == true
											&& test.get(new Point(testx, testy - 32)).getIsAMonster() == false) {
								monsterdebugup = 1;
								moveMonster(monster, monsterX, monsterY, 0, -32);// UP

							} else if (test.get(new Point(testx + 32, testy)).getIsFull() == false
									|| test.get(new Point(testx + 32, testy)).getIsAnExplosableEntity() == true
											&& test.get(new Point(testx + 32, testy)).getIsAMonster() == false) {
								monster.setGoUp(false);
								monster.setGoRight(true);
								moveMonster(monster, monsterX, monsterY, +32, 0);// RIGHT

							} else if (test.get(new Point(testx, testy + 32)).getIsFull() == false
									|| test.get(new Point(testx, testy + 32)).getIsAnExplosableEntity() == true
											&& test.get(new Point(testx, testy + 32)).getIsAMonster() == false) {// droite
								monster.setGoUp(false);
								monster.setGoDown(true);
								moveMonster(monster, monsterX, monsterY, 0, +32);// DOWN
							}
						} else {
							monsterdebugup = 0;
						}
					}

					else { // DOWN
						if (test.get(new Point(testx + 32, testy)).getIsFull() == false
								|| test.get(new Point(testx + 32, testy)).getIsAnExplosableEntity() == true
										&& test.get(new Point(testx = 32, testy)).getIsAMonster() == false) {
							monster.setGoLeft(false);
							monster.setGoRight(true);
							moveMonster(monster, monsterX, monsterY, +32, 0);// RIGHT

						} else if (test.get(new Point(testx, testy + 32)).getIsFull() == false
								|| test.get(new Point(testx, testy + 32)).getIsAnExplosableEntity() == true
										&& test.get(new Point(testx, testy + 32)).getIsAMonster() == false) {
							moveMonster(monster, monsterX, monsterY, 0, +32);// DOWN

						} else if (test.get(new Point(testx - 32, testy)).getIsFull() == false
								|| test.get(new Point(testx - 32, testy)).getIsAnExplosableEntity() == true
										&& test.get(new Point(testx - 32, testy)).getIsAMonster() == false) {
							monster.setGoUp(false);
							monster.setGoLeft(true);
							monsterdebugleft = 1;
							moveMonster(monster, monsterX, monsterY, -32, 0);// LEFT

						} else if (test.get(new Point(testx, testy - 32)).getIsFull() == false
								|| test.get(new Point(testx, testy - 32)).getIsAnExplosableEntity() == true
										&& test.get(new Point(testx, testy - 32)).getIsAMonster() == false) { // gauche
							monster.setGoLeft(false);
							monster.setGoUp(true);
							monsterdebugup = 1;
							moveMonster(monster, monsterX, monsterY, 0, -32);// UP

						}

					}
				}
				testx = testx - 32;
			}
			testx = 32 * 29;
			testy = testy - 32;
		}
	}

	
	/**
	 * Hitbox.
	 *
	 * @param x the x
	 * @param y the y
	 * @param Px the px
	 * @param Py the py
	 */
	public void hitbox(int x, int y, int Px, int Py) { //check the type of tile where the player try to go
		Cave targetitem = test.get(new Point(x + Px, y + Py));
		boolean destructablebyPlayer = targetitem.getDestructP1();
		boolean claimablebyPlayer = targetitem.getClaimedP1();
		boolean thisIsDaWay = targetitem.getDaWay();
		if (claimablebyPlayer == true) { // if its a diamond claim it and inprove the score
			checkValue = true;
			score = score + diamondValue;
			Graphics g = this.getGraphics();
			g.clearRect(1000, 180, 250, 30);
			g.setColor(Color.BLACK);
			g.fillRect(1000, 180, 250, 30);
			Font font = new Font("Courier", Font.BOLD, 20);
			g.setFont(font);
			g.setColor(Color.white);
			g.drawString(" Your curent score is " + score, 1000, 200);
			g.drawString("Goal Score = " + levelExitScore, 1000, 350);
			// System.out.println(" Your curent score is " + score);

		} else if (destructablebyPlayer == true) { // if its dirt clear it a move the player
			checkValue = true;

		} else if (thisIsDaWay == true && score >= levelExitScore) { // if its the exit and the score is high enough the finish the level
			checkValue = true;
			win(score);
			score = 0;
		} else { // else do nothing 
			checkValue = false;
		}

	}

	/**
	 * Push the rock.
	 *
	 * @param x the x
	 * @param y the y
	 * @param Px the px
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void pushTheRock(int x, int y, int Px) throws IOException { // if the player walk against a rock and the tile behind it is empty then move the rock 
		Graphics graphics = this.getGraphics();
		Cave targetitem = test.get(new Point(x + Px, y));
		if (targetitem.getCanPush() == true) {
			Cave afterrock = test.get(new Point(x + Px + Px, y));
			if (afterrock.getIsFull() == false) {

				targetitem.setP(new Point(x + Px * 2, y));
				targetitem.setX(x + Px * 2);
				Image img1 = targetitem.getImg();
				graphics.drawImage(img1, x + Px * 2, y, 32, 32, null);
				test.replace(new Point(x + Px * 2, y), targetitem);

				Rockford.getInstance().setP(new Point(x + Px, y));
				Rockford.getInstance().setX(x + Px);
				if (Px > 0) {// RIGHT
					Image img = Rockford.getInstance().getImgRight();
					graphics.drawImage(img, x + Px, y, 32, 32, null);
				} else {
					Image img = Rockford.getInstance().getImgLeft();
					graphics.drawImage(img, x + Px, y, 32, 32, null);
				}
				test.replace(new Point(x + Px, y), Rockford.getInstance());

				// update clear;
				graphics.drawImage(Clear.getImage(), x, y, 32, 32, null);
				test.replace(new Point(x, y), new Clear(x, y));
			}

		}
	}

	/**
	 * Move player.
	 *
	 * @param x the x
	 * @param y the y
	 * @param co the co
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void movePlayer(int x, int y, ControllerOrder co) throws IOException {
		Graphics graphics = this.getGraphics();
		switch (co) {
		case up:
			Px = 0;
			Py = -32;
			hitbox(x, y, Px, Py);
			if (checkValue == true) {
				// update rockford;
				Rockford.getInstance().setP(new Point(x, y - 32));
				Rockford.getInstance().setY(y - 32);
				Image img = Rockford.getInstance().getImgUp();
				graphics.drawImage(img, x, y - 32, 32, 32, null);
				test.replace(new Point(x, y - 32), Rockford.getInstance());

				// update clear;
				graphics.drawImage(Clear.getImage(), x, y, 32, 32, null);
				test.replace(new Point(x, y), new Clear(x, y));
			}
			checkValue = false;
			break;

		case right:

			if (startValue != 1) {
				Thread myThread = new Thread(new MyRunnable()); //launch the thread of gravity and monster movement when the player first move
				myThread.start();
				Thread myThreadMonster = new Thread(new MyRunnableMonster());
				myThreadMonster.start();
				startValue = 1;
			}
			Px = +32;
			Py = 0;
			hitbox(x, y, Px, Py);
			pushTheRock(x, y, Px);
			if (checkValue == true) {
				// update rockford;
				Rockford.getInstance().setP(new Point(x + 32, y));
				Rockford.getInstance().setX(x + 32);
				Image img1 = Rockford.getInstance().getImgRight();
				graphics.drawImage(img1, x + 32, y, 32, 32, null);
				test.replace(new Point(x + 32, y), Rockford.getInstance());

				// update clear;
				graphics.drawImage(Clear.getImage(), x, y, 32, 32, null);
				test.replace(new Point(x, y), new Clear(x, y));
			}
			checkValue = false;
			break;

		case down:
			Px = 0;
			Py = 0 + 32;
			hitbox(x, y, Px, Py);
			if (checkValue == true) {
				// update rockford;
				Rockford.getInstance().setP(new Point(x, y + 32));
				Rockford.getInstance().setY(y + 32);
				Image img2 = Rockford.getInstance().getImgDown();
				graphics.drawImage(img2, x, y + 32, 32, 32, null);
				test.replace(new Point(x, y + 32), Rockford.getInstance());

				// update clear;
				graphics.drawImage(Clear.getImage(), x, y, 32, 32, null);
				test.replace(new Point(x, y), new Clear(x, y));
			}
			checkValue = false;
			break;

		case left:
			Px = 0 - 32;
			Py = 0;
			hitbox(x, y, Px, Py);
			pushTheRock(x, y, Px);
			if (checkValue == true) {
				// update rockford;
				Rockford.getInstance().setP(new Point(x - 32, y));
				Rockford.getInstance().setX(x - 32);
				Image img3 = Rockford.getInstance().getImgLeft();
				graphics.drawImage(img3, x - 32, y, 32, 32, null);
				test.replace(new Point(x - 32, y), Rockford.getInstance());

				// update clear;
				graphics.drawImage(Clear.getImage(), x, y, 32, 32, null);
				test.replace(new Point(x, y), new Clear(x, y));
			}
			checkValue = false;
			break;
		default:
			break;
		}
	}

}
