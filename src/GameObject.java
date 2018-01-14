import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject{
int x;
int y;
int width;
int height;
boolean touchPlatform=true;
Rectangle collisionBox;
public GameObject(int x, int y, int width, int height){
	
	collisionBox=new Rectangle(x, y, width, height);
}
public void update() {
	collisionBox.setBounds(x, y, width, height);
}
public void draw(Graphics g) {
	
}
}
