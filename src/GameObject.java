import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	boolean touchPlatform = true;
	Rectangle collisionBox;
	Random rX;
	Random rY;
	Random rW;
	Random rH;
	

	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		collisionBox = new Rectangle(x, y, width, height);
	}
	//public GameObject(Random rX, Random rY, Random rW, Random rH) {
		//int numX=rX.nextInt();
		//int numY=rY.nextInt();
		//int numW=rW.nextInt();
		//int numH=rH.nextInt();
		//collisionBox= new Rectangle(numX, numY, numW, numH);
		
	//}
	
	


	public void update() {
		collisionBox.setBounds(x, y, width, height);
	}

	public void draw(Graphics g) {

	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
