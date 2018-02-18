import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject{
	
	boolean playerCollision=false;
	private int acceleration=20;
	private static int playerWidth=50;
	private static int playerHeight=50;
public Player(int playerX, int playerY) {
	super(playerX, playerY, playerWidth, playerHeight);
	
}
public void update() {
	super.update();
	if(playerCollision==true) {
		
	}
}
public void draw(Graphics g) {
	g.setColor(Color.green);
	g.fillRect(x, y, playerWidth, playerHeight);
}
void jump() {
	
	this.y-=acceleration;
	acceleration--;
	if(acceleration==-21) {
		acceleration=20;
		MyGame.pressedUp=false;
	}
}
}
