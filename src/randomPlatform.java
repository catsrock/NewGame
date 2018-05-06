import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
//*This class was NEWLY created for randomPlatform generator*
public class randomPlatform  extends GameObject{

	public randomPlatform(){
		super();
		System.out.println("spook");
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

