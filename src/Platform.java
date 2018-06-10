import java.awt.Color;
import java.awt.Graphics;

public class Platform extends GameObject {

	// static int platformWidth=100;
	// static int platformHeight=25;

	public Platform(int platformX, int platformY, int platformWidth, int platformHeight) {
		super(platformX, platformY, platformWidth, platformHeight);

	}

	public void update() {
		super.update();

	}

	public void draw(Graphics g) {

		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);

	}

	public void drawWinPlatform(Graphics g) {
		if (x == 910 && y == 60) {
			g.setColor(Color.red);
			g.fillRect(x, y, width, height);
		} else {
			draw(g);
		}
	}
}
