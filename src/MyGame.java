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
		private boolean pressedUp;
		private boolean pressedDown;
		private boolean pressedRight;
		private boolean pressedLeft;
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
	        mainGameWindow.setTitle("MyGame");
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
				if(pressedUp==true) {
					floor.setRect(x, y-=5, 50, 50);
					System.out.println("um");
				}
				else if(pressedUp==false){
					floor.setRect(x, y, 50, 50);
				}
				
				
				
				//System.out.println("whee");
			}
			else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				if(pressedDown==true)
				floor.setRect(x-=5, y, 50, 50 );
				System.out.println("beep");
			}
			else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				floor.setRect(x+=5, y, 50, 50 );
				System.out.println("bleep");
			}
			else {
				floor.setRect(x, y+=5, 50, 50 );
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
}