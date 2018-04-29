import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;
import java.util.Random;

public class Platform extends GameObject{
	
	//static int platformWidth=100;
	//static int platformHeight=25;

	public Platform(int platformX, int platformY, int platformWidth, int platformHeight) {
		super(platformX, platformY, platformWidth, platformHeight);
	
		
	}

	public void update() {
		super.update();

	}
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
		
	}
}
