import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;


public class ObjectManager implements ActionListener {
	ArrayList<GameObject> platform;
	//ArrayList<GameObject> randPlatform; //s
	Player wolf;
	Random r=new Random();
	int randomWidth=r.nextInt(61)+10;
	int randomHeight=r.nextInt(16)+10;
	long randomTime=0;
	int waitTime=1000;
	public ObjectManager(Player p1) {
		platform = new ArrayList<GameObject>();
		//randPlatform=new ArrayList<GameObject>(); //s
		wolf = p1;
		//platformer.start();
	}

	public void addPlatform(GameObject p) {
		platform.add(p);
		//randPlatform.add(p); //s
		// for (int i = 0; i < platform.size(); i++) {
		// GameObject p3=platform.get(i);
		// p3.draw(g);
		// wolf.draw(g);
		// }
		 System.out.println("daflh");
	}

	public void update() {
		for (int i = 0; i < platform.size(); i++) {
			GameObject p4 = platform.get(i);
			p4.update();
		}
		//for (int i=0; i<randPlatform.size(); i++) { //s
		//	GameObject p5=randPlatform.get(i); //s
		//	p5.update(); //s
		//} //s
		
		wolf.update();
	}

	public void draw(GameObject p, Graphics g) {
		wolf.draw(g);
		System.out.println("runningoutofwords");
		for (int i = 0; i < platform.size(); i++) {
			GameObject p3 = platform.get(i);
			p3.draw(g);
		}
		//for (int i = 0; i < randPlatform.size(); i++) { //s
		//	GameObject p6 = randPlatform.get(i); //s
		//	p6.draw(g); //s
		//} //s

	}
	public void randomPlatforms() {
		System.out.println(randomWidth+" ,"+randomHeight);
		if(System.currentTimeMillis()-randomTime>=waitTime) {
			platform.add(new Platform(r.nextInt(MyGame.widthOfScreen-randomWidth), r.nextInt(MyGame.heightOfScreen-randomHeight), randomWidth, randomHeight));
			platform.add(new Platform(r.nextInt(MyGame.widthOfScreen-randomWidth), r.nextInt(MyGame.heightOfScreen-randomHeight), randomWidth, randomHeight));
			platform.add(new Platform(r.nextInt(MyGame.widthOfScreen-randomWidth), r.nextInt(MyGame.heightOfScreen-randomHeight), randomWidth, randomHeight));
		randomTime=System.currentTimeMillis();
		
		}
	}

	public void setUpLevel() {

		platform.add(new Platform(1200, 680, 100, 25));
		platform.add(new Platform(920, 925, 10, 25));
		platform.add(new Platform(500, 500, 100, 25));
		randomPlatforms();
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

			

		}
		//for (int i = 0; i < randPlatform.size(); i++) { //s
			//GameObject p7 = randPlatform.get(i);
			//if (wolf.collisionBox.intersects(p7.collisionBox)) {
			//	wolf.update();
			//	if (wolf.collisionBox.intersects(p7.collisionBox)) {
				//	wolf.setY(p7.getY() - wolf.height);
				//}
				//if (wolf.x + wolf.width >= p7.x - p7.width && wolf.y + wolf.height > p7.y - p7.height) {
				//	MyGame.pressedDown = false;
				//	wolf.playerCollision = true;
				//	return true;
				//}
			//}
		//} //s
		
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
