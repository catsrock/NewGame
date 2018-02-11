import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;

public class Platform extends GameObject{
	
	static int platformWidth=100;
	static int platformHeight=25;

	public Platform(int platformX, int platformY) {
		super(platformX, platformY, platformWidth, platformHeight);
	
	
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
		g.fillRect(x, y, platformWidth, platformHeight);
		
	}
}
