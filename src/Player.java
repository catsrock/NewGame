import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

public class Player extends GameObject{
	private int gravity=3;
	boolean playerCollision=false;
	private int acceleration=15;
	private static int playerWidth=50;
	private static int playerHeight=50;
public Player(int playerX, int playerY) {
	super(playerX, playerY, playerWidth, playerHeight);
	
}
public void update() {
	super.update();
	if(playerCollision==true) {
	//gravity=4;
	//this.y-=gravity;
	acceleration=0;
	//y-=acceleration;
	this.y-=acceleration;
	acceleration--;
		
	}
	else {
		y+=gravity;
	}
	//else if(playerCollision==true) {
	//	y-=gravity;
	//}
}
public void draw(Graphics g) {
	g.setColor(Color.green);
	g.fillRect(x, y, playerWidth, playerHeight);
}
public void jump() {
	acceleration=15;
	this.y-=acceleration;
	acceleration--;
//	if(acceleration<0) {
	//	acceleration=20;
//		MyGame.pressedUp=false;
//	}
	
}
public void moveDown() {
	y+=5;
}
public void  moveLeft() {
	x-=5;
}
public void moveRight() {
	x+=5;
}
}
