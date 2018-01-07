import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject{
	int playerX;
	int playerY;
	private int playerWidth=50;
	private int playerHeight=50;
public Player(int playerX, int playerY) {
	super();
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
