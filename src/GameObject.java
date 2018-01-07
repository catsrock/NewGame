import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject{
int platformX;
int platformY;
int platformWidth;
int platformHeight;
boolean touchPlatform=true;
Rectangle collisionBox;
public GameObject(int platformX, int platformY, int platformWidth, int platformHeight){
	
	collisionBox=new Rectangle(platformX, platformY, platformWidth, platformHeight);
}
public void update() {
	collisionBox.setBounds(platformX, platformY, platformWidth, platformHeight);
}
public void draw(Graphics g) {
	
}
}
