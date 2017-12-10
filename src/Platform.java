import java.awt.Graphics;

public class Platform extends GameObject{
	int speed;
	boolean left;
	boolean right;
	boolean up;
	boolean down;

	public Platform(int platformX, int platformY, int platformWidth, int platformHeight) {
		super( platformX,  platformY,  platformWidth,  platformHeight);
	
}
	public void update() {
		super.update();
		
	}
	public void draw(Graphics g) {
		
	}
}
