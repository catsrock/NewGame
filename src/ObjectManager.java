import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<GameObject> platform;
	Player wolf;
	int rX;
	int rY;

	public ObjectManager(Player p1) {
		platform = new ArrayList<GameObject>();
		wolf = p1;
	}

	public void addPlatform(GameObject p, Graphics g) {
		platform.add(p);
		System.out.println("daflh");
		// for (int i = 0; i < platform.size(); i++) {
		// GameObject p3=platform.get(i);
		// p3.draw(g);
		// wolf.draw(g);
		// }
	}

	public void update() {
		for (int i = 0; i < platform.size(); i++) {
			GameObject p4 = platform.get(i);
			p4.update();
		}
		wolf.update();
	}

	public void draw(GameObject p, Graphics g) {

		wolf.draw(g);
		System.out.println("runningoutofwords");
		for (int i = 0; i < platform.size(); i++) {
			GameObject p3 = platform.get(i);
			p3.draw(g);
		}

	}

	public void randomPlatform(Random x, Random y, int width, int height) {

	}

	public void setUpLevel() {

		platform.add(new Platform(1200, 680, 100, 25));
		platform.add(new Platform(0, 925, 10000, 25));
		platform.add(new Platform(500, 500, 100, 25));
	}

	// public void manageEnemies(){
	// if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
	// addObject(new Alien(new Random().nextInt(MyGame.WIDTH), 0, 50, 50));
	// enemyTimer = System.currentTimeMillis();
	// }
	// }

	public boolean checkCollision() {
		System.out.println("boo");
		for (int i = 0; i < platform.size(); i++) {

			GameObject p2 = platform.get(i);
			// collisionX=wolf.x;
			// collisionY=wolf.y-1;
			// System.out.println("feep");
			if (wolf.collisionBox.intersects(p2.collisionBox)) {
				// JOptionPane.showMessageDialog(null, "blup");

				wolf.update();
				// if(yHitbox.y>=p2.x-p2.width) {

				// }
				if (wolf.collisionBox.intersects(p2.collisionBox)) {
					wolf.setY(p2.getY() - wolf.height);
				}
				// if(wolf.x+wolf.width>=p2.x-p2.width && wolf.y+wolf.height>p2.y-p2.height)
				if (wolf.x + wolf.width >= p2.x - p2.width && wolf.y + wolf.height > p2.y - p2.height) {
					// JOptionPane.showMessageDialog(null, "WURK");
					MyGame.pressedDown = false;
					wolf.playerCollision = true;
					// JOptionPane.showMessageDialog(null, "WURK");
					// ySystem.out.println("nup");

					return true;

				}

				// if(collisionY+playerHeight>p2.height && collisionX+playerWidth>=p2.width ) {

				// }

			}

			System.out.println("hello");

		}
		wolf.playerCollision = false;
		return false;

	}

	public void reset() {
		platform.clear();
	}

}
