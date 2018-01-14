import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject{
	int playerX;
	int playerY;
	private static int playerWidth=50;
	private static int playerHeight=50;
public Player(int playerX, int playerY) {
	super(playerX, playerY, playerWidth, playerHeight);
	this.playerX=playerX;
	this.playerY=playerY;
}
public void update() {
	super.update();
}
public void draw(Graphics g) {
	g.setColor(Color.green);
	g.fillRect(playerX, playerY, playerWidth, playerHeight);
}
}
