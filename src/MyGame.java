import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class MyGame extends JComponent implements ActionListener, Runnable, KeyListener {
	static boolean pressedUp = false;
	static boolean pressedDown = false;
	private static boolean pressedRight = false;
	private static boolean pressedLeft = false;
	private int x = 900; // 900
	private int y = 810; // 810
	static final int WIDTH = 500;
	static final int HEIGHT = 800;
	static final int MENU_STATE = 0;
	final int INSTRUCTION_STATE = 1;
	final int GAME_STATE = 2;
	final int END_STATE = 3;
	static final int WIN_STATE = 4;
	static int currentState = MENU_STATE;
	Font titleFont;
	Font startFont;
	Font instructionFont;
	Font gameOverFont;
	Font backspaceFont;
	Font winningFont;
	static int widthOfScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	static int heightOfScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	private JFrame mainGameWindow = new JFrame("MyGame");// Makes window with title "MyGame"
	static boolean stopPlatforms = false; // this is supposed to make the platforms stop appearing
	static boolean setFixedPlatforms = false; // setting fixed platforms on the screen so they stay there
	static boolean setUp = false; // checking if everything is setup?
	static long startTime;
	private Timer paintTicker = new Timer(20, this); // Ticks every 20 milliseconds (50 times per second); calls on
														// actionPerformed() when it ticks.
	Player wolf = new Player(x, y);
	ObjectManager manager = new ObjectManager(wolf);

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new MyGame());

	}

	public MyGame() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		startFont = new Font("Arial", Font.PLAIN, 24);
		instructionFont = new Font("Arial", Font.PLAIN, 24);
		gameOverFont = new Font("Arial", Font.PLAIN, 48);
		backspaceFont = new Font("Arial", Font.PLAIN, 24);
		winningFont = new Font("Arial", Font.CENTER_BASELINE, 48);
	}

	public void run() {
		mainGameWindow.addKeyListener(this);
		mainGameWindow.setSize(widthOfScreen, heightOfScreen);
		mainGameWindow.add(this);// Adds the paint method
		mainGameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainGameWindow.setVisible(true);
		paintTicker.start();
	}

	public void paintComponent(Graphics g) {

		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == INSTRUCTION_STATE) {
			drawInstructionState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == WIN_STATE) {
			drawWinState(g);
		}
	}

	public void updateMenuState() {

	}

	public void updateInstructionState() {

	}

	public void updateGameState() {

		// System.out.println("bai");
		manager.update();
		// manager.manageEnemies();
		manager.checkCollision();

	}

	public void updateEndState() {

	}

	public void drawMenuState(Graphics g) {
		// manager.setScore(MENU_STATE);
		g.setColor(Color.black);
		g.fillRect(0, 0, MyGame.widthOfScreen, MyGame.heightOfScreen);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("SPONTANEOUS", 780, 200);
		g.setColor(Color.GRAY);
		g.setFont(startFont);
		g.drawString("Press ENTER to start", 855, 300);
		g.setColor(Color.lightGray);
		g.setFont(instructionFont);
		g.drawString("Press SPACE for instructions", 820, 400);

	}

	public void drawInstructionState(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, MyGame.widthOfScreen, MyGame.heightOfScreen);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("WELCOME", 840, 200);
		g.setFont(instructionFont);
		g.drawString("Use arrow keys to navigate. You can use the up arrow, and left and right ones.", 600, 300);
		g.drawString("WARNING! You can only jump when on a platform, and you can't jump very high.", 500, 400);
		g.drawString(
				"Be careful! The platforms only remain on the screen for a set amount of time. Your goal is to reach the platform at the top of the screen within five minutes.",
				250, 500);
		g.drawString("There are a couple fixed platforms on the screen to help you along the way.", 400, 550);
		g.setFont(startFont);
		g.drawString("GOOD LUCK! Press ENTER to start", 700, 700);
	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, MyGame.widthOfScreen, MyGame.heightOfScreen);
		manager.draw(wolf, g);
		manager.drawWinPlatform(wolf, g);
		// Platform p2=new Platform(1000, 710, 100, 25);
		// p2.draw(g);

		// g.setColor(Color.YELLOW);
		// g.fillRect(1000, 710, 100, 25);

	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(0, 0, MyGame.widthOfScreen, MyGame.heightOfScreen);
		g.setFont(gameOverFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 1000, 100);
		// g.drawString("You killed " + manager.getScore() + " aliens.", 150, 300);

	}

	public void drawWinState(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, MyGame.widthOfScreen, MyGame.heightOfScreen);
		g.setFont(winningFont);
		g.setColor(Color.white);
		g.drawString("Congrats You Win", 750, 500);
	}

	public void timeLimit() {
		if (System.currentTimeMillis() - startTime >= 300000) {
			currentState = END_STATE;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (wolf.playerCollision == true) {
			if (pressedUp == true) {
				wolf.jump();

			}
		} else {
			pressedUp = false;
		}
		if (pressedDown == true) {
			wolf.moveDown();
			// wolf.y+=5;

		}
		if (pressedLeft == true) {
			wolf.moveLeft();
			// wolf.x-=5;

		}
		if (pressedRight == true) {
			wolf.moveRight();
			// wolf.x+=5;

		}

		// else {
		// currentState = END_STATE;
		// }

		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == INSTRUCTION_STATE) {
			updateInstructionState();
		}

		// else if (currentState == GAME_STATE) {
		// updateGameState();

		// manager.randomPlatforms(); was originally here, with setuplevel right above
		// it
		// }

		if (currentState == GAME_STATE) {

			if (setUp == false) {
				manager.setUpLevel();
				setUp = true;
				startTime = System.currentTimeMillis();
			}

			if (stopPlatforms == false) {
				manager.randomPlatforms();
			}
			timeLimit();
			updateGameState();
		}

		if (wolf.y > heightOfScreen) {
			currentState = END_STATE;
		}

		else if (currentState == END_STATE) {
			updateEndState();
		}
		// if(stopPlatforms==true) {

		// }

		// System.out.println(x+" "+y);
		// floor.setRect(x+=1, y+=5, 100, 100);
		// System.out.println(x+" "+y);
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState = GAME_STATE;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			currentState = INSTRUCTION_STATE;
		}
		if (currentState > END_STATE) {
			currentState = MENU_STATE;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {

			pressedUp = true;

		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			pressedLeft = true;

		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			pressedRight = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			pressedDown = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			pressedUp = false;

		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			pressedLeft = false;

		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			pressedRight = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			pressedDown = false;
		}
	}

}
