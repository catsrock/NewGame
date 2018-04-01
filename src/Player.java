import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;

public class Player extends GameObject{
	private int gravity=3;
	boolean playerCollision=false;
	private int acceleration=15;
	private int tempX;
	//int tempX;
	private int tempY;
	//int tempY;
	private static int playerWidth=50;
	private static int playerHeight=50;
public Player(int playerX, int playerY) {
	super(playerX, playerY, playerWidth, playerHeight);
	tempX=x;
	tempY=y;
}

public void update() {
	super.update();
	collisionBox.setBounds(tempX, tempY+5, playerWidth, playerHeight);
	if(playerCollision==false) {
	//acceleration=0;
	
	x=tempX;
	y=tempY;
	tempY+=gravity;
	//this.y-=acceleration;
	//acceleration--;
	
	}
	else {
		gravity+=1;
		tempY-=gravity;
		//tempY-=gravity+1;
		playerCollision=false;
		//tempY-=1;
		
		
		
		//y+=gravity;
	}
	//else if(playerCollision==true) {
	//	y-=gravity;
	//}
}
public void draw(Graphics g) {
	Graphics2D g2=(Graphics2D) g;
	g.setColor(Color.RED);
	g.fillRect(x, y, playerWidth, playerHeight);
	g2.setColor(Color.BLUE);
	g2.draw(collisionBox);
}
public void jump() {
	acceleration=15;
	this.tempY-=acceleration;
	//this.y-=acceleration;
	acceleration--;	if(acceleration<0) {
	acceleration=20;
MyGame.pressedUp=false;	}
	
}
public void moveDown() {
	tempY+=5;
}
public void  moveLeft() {
	tempX-=5;
}
public void moveRight() {
	tempX+=5;
}
}
