import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
//*This class was NEWLY created for randomPlatform generator*
public class randomPlatform extends GameObject {

	public randomPlatform(Random random, Random random2, Random random3, Random random4) {
		super(random, random2, random3, random4);
		// TODO Auto-generated constructor stub
	}
	public void update() {
		super.update();
	}
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
	}

}
