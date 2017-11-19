import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

public class NewGame extends JComponent implements ActionListener, Runnable, MouseListener, KeyListener
{
	private int x=0;
    private int y=0;
    private int widthOfScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    private int heightOfScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    private JFrame mainGameWindow = new JFrame("NewGame");//Makes window with title "NewGame"
    private Rectangle2D.Double floor = new Rectangle2D.Double(x, y, 100, 100);
    private Timer paintTicker = new Timer(20, this); //Ticks every 20 milliseconds (50 times per second); calls on actionPerformed() when it ticks.
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new NewGame());
    }

    public void run()
    {
    		mainGameWindow.addMouseListener(this);
    		mainGameWindow.addKeyListener(this);
        mainGameWindow.setTitle("NewGame");
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
    		floor.setRect(x+=1, y+=5, 100, 100);
    	//	System.out.println(x+" "+y);
        repaint(); //Calls on the paint() method.
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getX()>floor.getX() && e.getX()<floor.getX()+100 && e.getY()>floor.getY() && e.getY()<floor.getY()+100) {
			System.out.println("bleh");
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			floor.setRect(x+=5, y+=10, 100, 100);
			System.out.println("whee");
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
