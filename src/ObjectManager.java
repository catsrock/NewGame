import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	ArrayList<GameObject> platform;
	// ArrayList<GameObject> randPlatform; //s
	Player wolf;
	Random r = new Random();
	int randomWidth = r.nextInt(61) + 10;
	int randomHeight = r.nextInt(16) + 10;
	 //r.nextInt((MyGame.heightOfScreen - 50) - 934) + 935;
	long randomTime = 0;
	int waitTime = 1000;

	public ObjectManager(Player p1) {
		platform = new ArrayList<GameObject>();
		// randPlatform=new ArrayList<GameObject>(); //s
		wolf = p1;
		// platformer.start();
	}

	public void addPlatform(GameObject p) {
		platform.add(p);

		// randPlatform.add(p); //s
		System.out.println("daflh");
		// for (int i = 0; i < platform.size(); i++) {
		// GameObject p3=platform.get(i);
		// p3.draw(g);
		// wolf.draw(g);
		// }

	}

	public void update() {
		wolf.update();
		for (int i = 0; i < platform.size(); i++) {
			GameObject p4 = platform.get(i);
			p4.update();
		}

	}

	public void draw(GameObject p, Graphics g) {
		wolf.draw(g);
		for (int i = 0; i < platform.size(); i++) {
			GameObject p3 = platform.get(i);
			p3.draw(g);
		}
		// for (int i = 0; i < randPlatform.size(); i++) { //s
		// GameObject p6 = randPlatform.get(i); //s
		// p6.draw(g); //s
		// } //s

	}

	public void drawWinPlatform(GameObject p, Graphics g) {

		GameObject p6 = platform.get(1);

		p6.drawWinPlatform(g);

	}

	public void setUpLevel() {
		platform.add(new Platform(920, 925, 10, 25));
		platform.add(new Platform(910, 60, 100, 25));
		platform.add(new Platform(1200, 680, 100, 25));
		platform.add(new Platform(500, 500, 100, 25));
		System.out.println("meep");
	}

	public void randomPlatforms() {
		
		
		if (System.currentTimeMillis() - randomTime >= waitTime) {
			for (int i = 0; i < 4; i++) {
				int randPlatY = r.nextInt((MyGame.heightOfScreen-80)+1)+80;
				platform.add(new Platform(r.nextInt(MyGame.widthOfScreen - randomWidth), randPlatY, randomWidth,
					randomHeight));
System.out.println(randomWidth + ", " + randomHeight+", "+randPlatY);
			}
			for (int i = 0; i < 2; i++) {
				platform.remove(3);
			}
			
				
				
				
			
			 // makes game harder, consider removing this line (haha)
			//platform.add(new Platform(r.nextInt(MyGame.widthOfScreen - randomWidth), randPlatY, randomWidth,	randomHeight));
				//platform.add(new Platform(r.nextInt(MyGame.widthOfScreen - randomWidth), randPlatY, randomWidth,	randomHeight));
		//	platform.add(new Platform(r.nextInt(MyGame.widthOfScreen - randomWidth), randPlatY, randomWidth,
			//		randomHeight));
		//	platform.remove(4);
			//platform.remove(5);
				//
			randomTime = System.currentTimeMillis();
		}
	}

	// public void manageEnemies(){
	// if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
	// addObject(new Alien(new Random().nextInt(MyGame.WIDTH), 0, 50, 50));
	// enemyTimer = System.currentTimeMillis();
	// }
	// }

	public boolean checkCollision() {
		for (int i = 0; i < platform.size(); i++) {

			GameObject p2 = platform.get(i);
			GameObject p5 = platform.get(1);
			if (wolf.collisionBox.intersects(p5.collisionBox)) {
				MyGame.currentState = MyGame.WIN_STATE;
			}
			// collisionX=wolf.x;
			// collisionY=wolf.y-1;
			// System.out.println("feep");
			if (wolf.collisionBox.intersects(p2.collisionBox)) {
				// JOptionPane.showMessageDialog(null, "blup");

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

		}
		// for (int i = 0; i < randPlatform.size(); i++) { //s
		// GameObject p7 = randPlatform.get(i);
		// if (wolf.collisionBox.intersects(p7.collisionBox)) {
		// wolf.update();
		// if (wolf.collisionBox.intersects(p7.collisionBox)) {
		// wolf.setY(p7.getY() - wolf.height);
		// }
		// if (wolf.x + wolf.width >= p7.x - p7.width && wolf.y + wolf.height > p7.y -
		// p7.height) {
		// MyGame.pressedDown = false;
		// wolf.playerCollision = true;
		// return true;
		// }
		// }
		// } //s

		wolf.playerCollision = false;
		return false;

	}

	public void reset() {
		platform.clear();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
