import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;

public class Platform extends GameObject{
	int platformX;
	int platformY;
	int platformWidth=100;
	int platformHeight=25;

	public Platform(int platformX, int platformY, int platformWidth, int platformHeight) {
		super(platformX, platformY, platformWidth, platformHeight);
	this.platformX=platformX;
	this.platformY=platformY;
	this.platformWidth=platformWidth;
	this.platformHeight=platformHeight;
}
	public void update() {
		super.update();
		//platformY-=speed;
		//if(platformY<0) {
		//	touchPlatform=false;
		//}
	}
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(platformX, platformY, platformWidth, platformHeight);
		
	}
}
