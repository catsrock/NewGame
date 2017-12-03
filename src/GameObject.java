import java.awt.Rectangle;

public class GameObject {
int platformX;
int platformY;
int platformWidth;
int platformHeight;
boolean touchPlatform=true;
Rectangle platform;
public GameObject(int platformX, int platformY, int platformWidth, int platformHeight){
	this.platformX=platformX;
	this.platformY=platformY;
	this.platformWidth=platformWidth;
	this.platformHeight=platformHeight;
	platform=new Rectangle(platformX, platformY, platformWidth, platformHeight);
}
public void update() {
	
}
}
