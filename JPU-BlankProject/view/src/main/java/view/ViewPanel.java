package view;

import entity.Wall;
import entity.BreakableWalls;
import entity.Cave;
import entity.Clear;
import entity.Diamonds;
import entity.Dirt;
import entity.Exit;
import entity.Level;
import entity.Rockford;
import entity.Rocks;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import contract.ControllerOrder;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
public class ViewPanel extends JPanel implements Observer {
		 
	/**
	 * The view frame.
	 */
	private ViewFrame viewFrame;
	public boolean death = false;
	public boolean won =false;
	int Px;
	int Py;
	boolean checkvalue;
	int score = 0;
	int diamondValue = 20;
	int levelExitScore = 250;
	int startvalue = 0; // cette valeur permet l'initialisation du thread de gravité par l'appuis sur la touche entrée.
		 
	public static  HashMap<Point, Cave> test = new HashMap<>();
	
	
	// ______________________________________ \\
	// thread de gestion de la gravité \\
	public class MyRunnable implements Runnable {
		@Override
		public void run() {
			int i = 1;
			while (i > 0) {
			try {
				TimeUnit.MILLISECONDS.sleep(200); // fait varié la vitesse de chute des objets (plus le nombre est grand plus ils tombent lentement).
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
			try {
				itemGravity();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	}
 // -------------------------------------------- \\
	
	// ______________________________________ \\
		// thread de gestion de la gravité \\
		public class MyRunnableMonster implements Runnable {
			@Override
			public void run() {
				int i = 1;
				while (i > 0) {
				try {
					TimeUnit.MILLISECONDS.sleep(400); // fait varié la vitesse de chute des objets (plus le nombre est grand plus ils tombent lentement).
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
				try {
					movementMonster();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		}
	 // -------------------------------------------- \\
	
	/**
	 * The Constant serialVersionUID.
	 */
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
				//System.out.print(e.getValue());
				img = e.getValue().getImg();
				if (img != null) {
					graphics.drawImage(e.getValue().getImg(), e.getValue().getX(), e.getValue().getY(), 32, 32, null);
				}
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	
	// 11111111111111111111111111111111111111111111111111111111111111
	//333333333333333333333333333DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD
	
	
	//deso pr le spam XD c juste pr être sur que vs voyer bien les message 
	public void lose() {
		viewFrame.printMessage("you lose");
		System.exit(0);

	}
	public void win(int score) {
		viewFrame.printMessage("you win with "+score+" point");
		System.exit(0);
	}
	
	//   /!\ win et lose c pr vous les gars je redirige dessus dés qu'on gagne ou perd vs avez juste a gerer l'interface et fermant les fenetre et en ramenant au menu avec un petit message.
	//
	// &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	// &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	
	
	
	// reste a faire : deplacement monstres (en cours)
	//                 colision monstres (-^)
	//				   interface graphique
	
	
	public void explode(int explodeY, int explodeX) throws IOException {
		Graphics graphics = this.getGraphics();
		int playerx = Rockford.getInstance().getX();	
		int playery = Rockford.getInstance().getY();
		
		if (test.get(new Point(explodeX ,explodeY)).getisBreakableByExplosion() == true) {
			graphics.drawImage(Clear.getImage(), explodeX, explodeY, 32, 32, null);
			test.replace(new Point(explodeX, explodeY), new Clear(explodeX, explodeY));
		}
		if (test.get(new Point(explodeX -32,explodeY)).getisBreakableByExplosion() == true) {
			graphics.drawImage(Clear.getImage(), explodeX -32, explodeY, 32, 32, null);
			test.replace(new Point(explodeX -32, explodeY), new Clear(explodeX -32, explodeY));
		}
		if (test.get(new Point(explodeX +32 ,explodeY)).getisBreakableByExplosion() == true) {
			graphics.drawImage(Clear.getImage(), explodeX +32, explodeY, 32, 32, null);
			test.replace(new Point(explodeX +32, explodeY), new Clear(explodeX +32, explodeY));
		}
		if (test.get(new Point(explodeX ,explodeY +32)).getisBreakableByExplosion() == true) {
			graphics.drawImage(Clear.getImage(), explodeX, explodeY +32, 32, 32, null);
			test.replace(new Point(explodeX, explodeY +32), new Clear(explodeX, explodeY +32));
		}
		if (test.get(new Point(explodeX +32,explodeY +32)).getisBreakableByExplosion() == true) {
			graphics.drawImage(Clear.getImage(), explodeX +32, explodeY +32, 32, 32, null);
			test.replace(new Point(explodeX +32, explodeY +32), new Clear(explodeX +32, explodeY +32));
		}
		if (test.get(new Point(explodeX -32,explodeY +32)).getisBreakableByExplosion() == true) {
			graphics.drawImage(Clear.getImage(), explodeX -32, explodeY +32, 32, 32, null);
			test.replace(new Point(explodeX -32, explodeY +32), new Clear(explodeX -32, explodeY +32));
		}
		if (test.get(new Point(explodeX ,explodeY +64)).getisBreakableByExplosion() == true) {
			graphics.drawImage(Clear.getImage(), explodeX, explodeY +64, 32, 32, null);
			test.replace(new Point(explodeX, explodeY +64), new Clear(explodeX, explodeY +64));
		}
		if (test.get(new Point(explodeX +32,explodeY +64)).getisBreakableByExplosion() == true) {
			graphics.drawImage(Diamonds.getImage(), explodeX +32, explodeY +64, 32, 32, null);
			test.replace(new Point(explodeX +32, explodeY +64), new Diamonds(explodeX +32, explodeY +64));
		}
		if (test.get(new Point(explodeX -32,explodeY +64)).getisBreakableByExplosion() == true) {
			graphics.drawImage(Diamonds.getImage(), explodeX -32, explodeY +64, 32, 32, null);
			test.replace(new Point(explodeX -32, explodeY +64), new Diamonds(explodeX -32, explodeY +64));
		}
		//zone explosion 
		//tuer le joueur
		if (playerx == explodeX && playery == explodeY + 32) {
			
			lose();
		}
		//System.out.println("boom");
	}


	public void itemGravity()throws IOException  {
		int testx = 32*29, testy = 32*29;
		
		while (testy >= 0) {
			
		while (testx >= 0) {
			Cave targettestblock = test.get(new Point(testx ,testy)); //cible un bloc
			boolean itemcantfly = targettestblock.getcanfall();
			if (itemcantfly == true) {  //si le bloc ciblé peux tombé (diamants ou roche) alors on passe a la suite
				Cave undertest = test.get(new Point(testx ,testy + 32)); // on regarde la bloc du dessous 
				if (undertest.getisfull() == false) { // si c'est vide alors le block tombe
					
					targettestblock.setcanfallkill(true);  // actuelisation de la position du bloc
					targettestblock.setP(new Point(testx, testy + 32));
					targettestblock.setY(testy + 32);
					Image img = targettestblock.getImg();
					Graphics graphics = this.getGraphics();
					graphics.drawImage(img, testx, testy + 32, 32, 32, null);
					test.replace(new Point(testx, testy + 32), targettestblock);

					// update clear;
					graphics.drawImage(Clear.getImage(), testx, testy, 32, 32, null);
					test.replace(new Point(testx, testy), new Clear(testx, testy));
					
				}else if(undertest.getcancascade() == true) { // cascade
					if (test.get(new Point(testx +32 ,testy)).getisfull() == false && test.get(new Point(testx +32 ,testy +32)).getisfull() == false ) {
						targettestblock.setcanfallkill(true);  // actuelisation de la position du bloc
						targettestblock.setP(new Point(testx +32, testy));
						targettestblock.setX(testx + 32);
						Image img = targettestblock.getImg();
						Graphics graphics = this.getGraphics();
						graphics.drawImage(img, testx +32, testy , 32, 32, null);
						test.replace(new Point(testx +32, testy), targettestblock);
						
						graphics.drawImage(Clear.getImage(), testx, testy, 32, 32, null);
						test.replace(new Point(testx, testy), new Clear(testx, testy));
					}
					else if (test.get(new Point(testx -32 ,testy)).getisfull() == false && test.get(new Point(testx -32 ,testy +32)).getisfull() == false ) {
						targettestblock.setcanfallkill(true);  // actuelisation de la position du bloc
						targettestblock.setP(new Point(testx -32, testy));
						targettestblock.setX(testx - 32);
						Image img = targettestblock.getImg();
						Graphics graphics = this.getGraphics();
						graphics.drawImage(img, testx -32, testy , 32, 32, null);
						test.replace(new Point(testx -32, testy), targettestblock);
						
						graphics.drawImage(Clear.getImage(), testx, testy, 32, 32, null);
						test.replace(new Point(testx, testy), new Clear(testx, testy));
					}
				}else if ( undertest.getisanexplosableentity() == true  && targettestblock.getcanfallkill() == true) { //si un joueur ou monstre se trouve sous le block qui tombe alors explosion
					int explodeY = targettestblock.getY();
					int explodeX = targettestblock.getX();
					explode(explodeY, explodeX);
				
				}else {
					targettestblock.setcanfallkill(false); //si le block du dessous est solide alors on annule le fait que le bloc tue au contacte
				}
				
			}
			testx =testx - 32;
		}
		testx = 32*29;
		testy =testy - 32;
		}
		}
	
	public void moveMonster(Cave monster, int monsterX, int monsterY,int dirX, int dirY) throws IOException{
		Graphics graphics = this.getGraphics();
		monster.setP(new Point(monsterX + dirX, monsterY + dirY));
		monster.setX(monsterX + dirX);
		monster.setY(monsterY + dirY);
		Image img1 = monster.getImg();
		graphics.drawImage(img1, monsterX + dirX, monsterY + dirY, 32, 32, null);
		test.replace(new Point(monsterX + dirX, monsterY + dirY), monster);

		// update clear;
		graphics.drawImage(Clear.getImage(), monsterX , monsterY , 32, 32, null);
		test.replace(new Point(monsterX , monsterY), new Clear(monsterX , monsterY));
		if (Rockford.getInstance().getX() == monsterX +dirX && Rockford.getInstance().getY() == monsterY +dirY) {
			explode( monsterY+dirY, monsterX+dirX);
			lose();
		}
	}
	
	
	public void movementMonster() throws IOException{
		int testx = 32*29, testy = 32*29;
		
		while (testy >= 0) {
			
		while (testx >= 0) {
			Cave monster =test.get(new Point(testx ,testy ));
			boolean imAMonster = monster.getisAMonster(); //cible l'entité monster
			if (imAMonster == true) {  //si le bloc ciblé est un monstre alors on passe a la suite
				int monsterX = monster.getX();
				int monsterY = monster.getY();
				if (test.get(new Point(testx ,testy)).getgoRight() == true) {
					if (test.get(new Point(testx ,testy -32)).getisfull() == false || test.get(new Point(testx ,testy -32)).getisanexplosableentity() == true && test.get(new Point(testx ,testy -32)).getisAMonster() == false ) { 
						monster.setgoRight(false);
						monster.setgoUp(true);
						moveMonster(monster, monsterX, monsterY,0,-32);//UP
					}
					else if (test.get(new Point(testx +32 ,testy)).getisfull() == false || test.get(new Point(testx +32,testy )).getisanexplosableentity() == true && test.get(new Point(testx +32,testy )).getisAMonster() == false ) {
						moveMonster(monster, monsterX, monsterY,+32,0);//RIGHT
					}
					else if(test.get(new Point(testx ,testy +32)).getisfull() == false || test.get(new Point(testx ,testy +32)).getisanexplosableentity() == true && test.get(new Point(testx ,testy +32)).getisAMonster() == false ) {
						monster.setgoRight(false);
						monster.setgoDown(true);
						moveMonster(monster, monsterX, monsterY,0,+32);//DOWN
					}else if (test.get(new Point(testx -32 ,testy)).getisfull() == false || test.get(new Point(testx -32,testy )).getisanexplosableentity() == true && test.get(new Point(testx -32,testy )).getisAMonster() == false ){
						monster.setgoRight(false);
						monster.setgoLeft(true);
						moveMonster(monster, monsterX, monsterY,-32,0);//LEFT
					}
					}
				
				
				
				else if(test.get(new Point(testx ,testy)).getgoLeft() == true) {
					if(test.get(new Point(testx ,testy +32)).getisfull() == false || test.get(new Point(testx ,testy +32)).getisanexplosableentity() == true && test.get(new Point(testx ,testy +32)).getisAMonster() == false) {
						monster.setgoLeft(false);
						monster.setgoDown(true);
						moveMonster(monster, monsterX, monsterY,0,+32);//DOWN
					
					}else if (test.get(new Point(testx -32 ,testy)).getisfull() == false || test.get(new Point(testx -32,testy )).getisanexplosableentity() == true && test.get(new Point(testx -32,testy )).getisAMonster() == false) {
						moveMonster(monster, monsterX, monsterY,-32,0);//LEFT
					
					}else if (test.get(new Point(testx ,testy -32)).getisfull() == false || test.get(new Point(testx ,testy -32)).getisanexplosableentity() == true && test.get(new Point(testx ,testy -32)).getisAMonster() == false) { 
						monster.setgoLeft(false);
						monster.setgoUp(true);
						moveMonster(monster, monsterX, monsterY,0,-32);//UP
					
					}else if (test.get(new Point(testx +32 ,testy)).getisfull() == false || test.get(new Point(testx +32,testy )).getisanexplosableentity() == true && test.get(new Point(testx +32,testy )).getisAMonster() == false ){//tt droit
						monster.setgoLeft(false);
						monster.setgoRight(true);
						moveMonster(monster, monsterX, monsterY,+32,0);//RIGHT
					}					
					}
				
				
				else if(test.get(new Point(testx ,testy)).getgoUp() == true ) {
					if (test.get(new Point(testx -32 ,testy)).getisfull() == false || test.get(new Point(testx -32,testy )).getisanexplosableentity() == true && test.get(new Point(testx -32,testy )).getisAMonster() == false) {
						monster.setgoUp(false);
						monster.setgoLeft(true);
						moveMonster(monster, monsterX, monsterY,-32,0);//LEFT
					
					}else if (test.get(new Point(testx ,testy -32)).getisfull() == false || test.get(new Point(testx ,testy -32)).getisanexplosableentity() == true && test.get(new Point(testx ,testy -32)).getisAMonster() == false) { 
						moveMonster(monster, monsterX, monsterY,0,-32);//UP
										
					}else if (test.get(new Point(testx +32 ,testy)).getisfull() == false || test.get(new Point(testx +32,testy )).getisanexplosableentity() == true && test.get(new Point(testx +32,testy )).getisAMonster() == false) {
						monster.setgoUp(false);
						monster.setgoRight(true);
						moveMonster(monster, monsterX, monsterY,+32,0);//RIGHT
					
					}else if(test.get(new Point(testx ,testy +32)).getisfull() == false || test.get(new Point(testx ,testy +32)).getisanexplosableentity() == true && test.get(new Point(testx ,testy +32)).getisAMonster() == false) {// droite
						monster.setgoUp(false);
						monster.setgoDown(true);
						moveMonster(monster, monsterX, monsterY,0,+32);//DOWN				
					}					
					}
				
				
				
				else { //DOWN
					if (test.get(new Point(testx +32 ,testy)).getisfull() == false || test.get(new Point(testx +32,testy )).getisanexplosableentity() == true && test.get(new Point(testx =32,testy )).getisAMonster() == false) {
						monster.setgoLeft(false);
						monster.setgoRight(true);
						moveMonster(monster, monsterX, monsterY,+32,0);//RIGHT
						
					}else if(test.get(new Point(testx ,testy +32)).getisfull() == false || test.get(new Point(testx ,testy +32)).getisanexplosableentity() == true && test.get(new Point(testx ,testy +32)).getisAMonster() == false) {
						moveMonster(monster, monsterX, monsterY,0,+32);//DOWN
						
					}else if (test.get(new Point(testx -32 ,testy)).getisfull() == false || test.get(new Point(testx -32,testy )).getisanexplosableentity() == true && test.get(new Point(testx -32,testy )).getisAMonster() == false) {
						monster.setgoUp(false);
						monster.setgoLeft(true);
						moveMonster(monster, monsterX, monsterY,-32,0);//LEFT
						
					}else if (test.get(new Point(testx ,testy -32)).getisfull() == false || test.get(new Point(testx ,testy -32)).getisanexplosableentity() == true && test.get(new Point(testx ,testy -32)).getisAMonster() == false) { //gauche
						monster.setgoLeft(false);
						monster.setgoUp(true);
						moveMonster(monster, monsterX, monsterY,0,-32);//UP
								
					}
					
					/*faire test de priorité
					 * gauche tjr prioritaire, tout droit,droite, demi tour
					 */
				}
			}
		testx =testx - 32;
	}
	testx = 32*29;
	testy =testy - 32;
	}
	}


	


	
	public void hitbox(int x, int y, int Px , int Py) {	
		Cave targetitem = test.get(new Point(x + Px, y + Py));
		boolean destructablebyPlayer = targetitem.getdestructP1();
		boolean claimablebyPlayer = targetitem.getclaimedP1();
		boolean thisIsDaWay = targetitem.getDaWay();
		if ( claimablebyPlayer == true){
			checkvalue = true;
			score = score + diamondValue ;
			Graphics g = this.getGraphics();
			g.clearRect(1000, 180, 250,30);
			g.setColor(Color.BLACK);
			g.fillRect(1000, 180, 250, 30);
			Font font = new Font("Courier", Font.BOLD, 20);
		    g.setFont(font);
		    g.setColor(Color.white);          
		    g.drawString(" Your curent score is " + score, 1000, 200); 
		    g.drawString ("Goal Score = " + levelExitScore, 1000, 350);
			//System.out.println(" Your curent score is " + score);
		
		}else if ( destructablebyPlayer == true){
			checkvalue = true;
		
		
		}else if ( thisIsDaWay == true && score >= levelExitScore ) {
			checkvalue = true;
			win(score);
			score = 0;
		}
		else {
			checkvalue = false;
		}
		
	}

	
	public void pushTheRock(int x, int y,int Px) throws IOException {
		Graphics graphics = this.getGraphics();
		Cave targetitem = test.get(new Point(x + Px, y));
		if (targetitem.getcanpush() == true) {
			Cave afterrock = test.get(new Point(x+Px+Px,y));
			if (afterrock.getisfull() == false) {
				
					targetitem.setP(new Point(x +Px*2 , y));
					targetitem.setX(x +Px*2);
					Image img1 = targetitem.getImg();
					graphics.drawImage(img1, x +Px*2, y, 32, 32, null);
					test.replace(new Point(x +Px*2, y), targetitem);
					
					Rockford.getInstance().setP(new Point(x +Px, y));
					Rockford.getInstance().setX(x +Px);
					if (Px > 0) {// RIGHT
						Image img = Rockford.getInstance().getImgRight();
						graphics.drawImage(img, x +Px, y, 32, 32, null);
					}else {
						Image img = Rockford.getInstance().getImgLeft();
						graphics.drawImage(img, x +Px, y, 32, 32, null);
					}
					test.replace(new Point(x +Px, y), Rockford.getInstance());
					
					// update clear;
					graphics.drawImage(Clear.getImage(), x, y, 32, 32, null);
					test.replace(new Point(x, y), new Clear(x, y));
				}
					
				}
	}


	
	public void movePlayer(int x, int y, ControllerOrder co) throws IOException {
		Graphics graphics = this.getGraphics();
		switch (co) {
		case up:
			Px = 0;
			Py = -32;
			hitbox( x,  y,  Px,  Py);
			if (checkvalue == true) {
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
			checkvalue = false;
			break;
			
		case right:
			
			if (startvalue != 1) {
				Thread myThread = new Thread(new MyRunnable());
		        myThread.start();
		        Thread myThreadMonster = new Thread(new MyRunnableMonster());
		        myThreadMonster.start();
		        startvalue = 1;
			}
			Px = +32;
			Py = 0;
			hitbox( x,  y,  Px,  Py);
			pushTheRock(x,y,Px);
			if (checkvalue == true) {
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
			checkvalue = false;
			break;

		case down:
			Px = 0;
			Py = 0 + 32;
			hitbox( x,  y,  Px,  Py);
			if (checkvalue == true) {
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
			checkvalue = false;
			break;
			
		case left:
			Px = 0 -32;
			Py = 0;
			hitbox( x,  y,  Px,  Py);
			pushTheRock(x,y,Px);
			if (checkvalue == true) {
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
			checkvalue = false;
			break;
		default:
			break;
		}
	}

}
