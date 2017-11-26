import java.awt.Color;
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
		private int acceleration=5;
		private boolean pressedUp=false;
		private boolean pressedDown=false;
		private boolean pressedRight=false;
		private boolean pressedLeft=false;
		private int x=900;
	    private int y=810;
	    private int widthOfScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	    private int heightOfScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	    private JFrame mainGameWindow = new JFrame("MyGame");//Makes window with title "MyGame"
	    private Rectangle2D.Double floor = new Rectangle2D.Double(x, y, 50, 50);
	    private Timer paintTicker = new Timer(20, this); //Ticks every 20 milliseconds (50 times per second); calls on actionPerformed() when it ticks.
	    

		
	    public static void main(String[] args)
	    {
	        SwingUtilities.invokeLater(new MyGame());
	    }

	    public void run()
	    {
	    		mainGameWindow.addKeyListener(this);
	        mainGameWindow.setTitle("Riddle Pig");
	        mainGameWindow.setSize(widthOfScreen, heightOfScreen);
	        mainGameWindow.add(this);//Adds the paint method
	        mainGameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        mainGameWindow.setVisible(true);
	        paintTicker.start();
	    }

	    public void paint(Graphics g)
	    {
	        Graphics2D g2 = (Graphics2D)g;
	        g2.setColor(Color.BLUE);
	        g2.fill(floor);
	        g2.setColor(Color.red);
	        g2.draw(floor);
	        
	        
	    }

	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
	    if(pressedUp==true) {
	   jump(); 	
	   floor.setRect(x, y, 50, 50);
	    	
	    }
	    if(pressedDown==true) {
	    	floor.setRect(x, y+=5, 50, 50);
	    }
	    if(pressedLeft==true) {
	    	floor.setRect(x-=5, y, 50, 50);
	    }
	    if(pressedRight==true) {
	    	floor.setRect(x+=5, y, 50, 50);
	    }
				
	    	
	    		//System.out.println(x+" "+y);
	    	//	floor.setRect(x+=1, y+=5, 100, 100);
	    	//	System.out.println(x+" "+y);
	        repaint(); //Calls on the paint() method.
	    }

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
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
	if(acceleration==-5) {
		acceleration=5;
		pressedUp=false;
	}
}
}
