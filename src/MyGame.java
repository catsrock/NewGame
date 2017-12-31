import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class MyGame extends JComponent implements ActionListener, Runnable, KeyListener{
		private int acceleration=20;
		private boolean pressedUp=false;
		private boolean pressedDown=false;
		private boolean pressedRight=false;
		private boolean pressedLeft=false;
		private int x=900;
	    private int y=810;
	    static final int WIDTH=500;
	    static final int HEIGHT=800;
	    final int MENU_STATE = 0;
		final int GAME_STATE = 1;
		final int END_STATE = 2;
		int currentState = MENU_STATE;
		Font titleFont;
		Font startFont;
		Font instructionFont;
		Font gameOverFont;
		Font numkilledFont;
		Font backspaceFont;
		Platform p1;
	    private static int widthOfScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	    private static int heightOfScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	    private JFrame mainGameWindow = new JFrame("MyGame");//Makes window with title "MyGame"
	    private Rectangle2D.Double floor = new Rectangle2D.Double(x, y, 50, 50);
	    private Timer paintTicker = new Timer(20, this); //Ticks every 20 milliseconds (50 times per second); calls on actionPerformed() when it ticks.
	    ObjectManager manager=new ObjectManager();

		
	    public static void main(String[] args)
	    {
	        SwingUtilities.invokeLater(new MyGame());
	    }

	    public void run()
	    {
	    		mainGameWindow.addKeyListener(this);
	        mainGameWindow.setSize(widthOfScreen, heightOfScreen);
	        mainGameWindow.add(this);//Adds the paint method
	        mainGameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        mainGameWindow.setVisible(true);
	        paintTicker.start();
	    }
	    public void paintComponent(Graphics g) {
	    	
	        if (currentState == MENU_STATE) {
				drawMenuState(g);
			} else if (currentState == GAME_STATE) {
				drawGameState(g);
			} else if (currentState == END_STATE) {
				drawEndState(g);
			}
			Graphics2D g2 = (Graphics2D)g;
	       g2.setColor(Color.BLUE);
	      g2.fill(floor);
	       g2.setColor(Color.red);
	       g2.draw(floor);
			
		}
	    public void updateMenuState() {

		}

		public void updateGameState() {
			manager.update();
			//manager.manageEnemies();
			//manager.checkCollision();
			if (p1.touchPlatform == false) {
				currentState = END_STATE;
				manager.reset();
				p1 = new Platform(250, 700, 50, 50);
				//manager.addPlatform(p1);
			}
		}
		public void updateEndState() {

		}

		public void drawMenuState(Graphics g) {
			//manager.setScore(MENU_STATE);
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, MyGame.widthOfScreen, MyGame.heightOfScreen);
			g.setFont(titleFont);
			g.setColor(Color.yellow);
			g.drawString("RIDDLE PIG", 850, 200);

			g.setFont(startFont);
			g.drawString("Press ENTER to start", 850, 300);

			g.setFont(instructionFont);
			g.drawString("Press SPACE for instructions", 900, 400);

		}

		public void drawGameState(Graphics g) {
			g.setColor(Color.black);
			g.fillRect(0, 0, MyGame.widthOfScreen, MyGame.heightOfScreen);
			manager.draw(g);
			//Platform p2=new Platform(1000, 710, 100, 25);
			//p2.draw(g);
			
			//g.setColor(Color.YELLOW);
			//g.fillRect(1000, 710, 100, 25);
			
				
		}

		public void drawEndState(Graphics g) {
			g.setColor(Color.red);
			g.fillRect(0, 0, MyGame.widthOfScreen, MyGame.heightOfScreen);
			g.setFont(gameOverFont);
			g.setColor(Color.BLACK);
			g.drawString("GAME OVER", 100, 100);

			g.setFont(numkilledFont);
		//	g.drawString("You killed " + manager.getScore() + " aliens.", 150, 300);

			g.setFont(backspaceFont);
			g.drawString("Press BACKSPACE to Restart", 80, 500);

		}


	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
	    if(pressedUp==true) {
	   jump(); 	
	   
	    	
	    }
	    if(pressedDown==true) {
	    	y+=5;
	    }
	    if(pressedLeft==true) {
	    x-=5;
	    }
	    if(pressedRight==true) {
	    	x+=5;
	    }
			floor.setRect(x, y, 50, 50);	
	    	
	    		//System.out.println(x+" "+y);
	    	//	floor.setRect(x+=1, y+=5, 100, 100);
	    	//	System.out.println(x+" "+y);
	        repaint(); 
	    }

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				currentState++;
			}
			if(currentState>END_STATE) {
				currentState=MENU_STATE;
			}
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				pressedUp=true;
				
			
		}
			if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				pressedLeft=true;
				
				
			}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				pressedRight=true;
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				pressedDown=true;
			}
			
			
			if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				manager.addPlatform(p1);
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				
				
					
			}
			if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				pressedLeft=false;
					
				}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				pressedRight=false;
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				pressedDown=false;
			}
	}
void jump() {
	y-=acceleration;
	acceleration--;
	if(acceleration==-21) {
		acceleration=20;
		pressedUp=false;
	}
}
}
