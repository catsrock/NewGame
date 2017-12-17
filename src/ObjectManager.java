import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
ArrayList<GameObject> platform;
public ObjectManager() {
	platform=new ArrayList<GameObject>();
}
public void addPlatform(GameObject p) {
	platform.add(p);
}
public void update() {
	for (int i = 0; i < platform.size(); i++) {
		GameObject p = platform.get(i);
		p.update();
	}
	
}
public void draw(Graphics g) {
	for (int i = 0; i < platform.size(); i++) {
		GameObject p=platform.get(i);
		p.draw(g);
	}
}
//public void manageEnemies(){
	//if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
		//addObject(new Alien(new Random().nextInt(MyGame.WIDTH), 0, 50, 50));
//enemyTimer = System.currentTimeMillis();
	//}
//}


//public void checkCollision() {
	//for (int i = 0; i < platform.size(); i++) {
		//for (int j = i + 1; j < platform.size(); j++) {
			//GameObject p1 = platform.get(i);
			//GameObject p2 = platform.get(j);
			
			//if(p1.collisionBox.intersects(p2.collisionBox)){
			//	if((p1 instanceof Alien && p2 instanceof Projectile) ||
			//	   (p2 instanceof Alien && p1 instanceof Projectile)){
			//		score++;
			//		System.out.println(score);
			//		p1.touchPlatform = false;
			//		p2.touchPlatform = false;
			//	}
			//	else if((p1 instanceof Alien && p2 instanceof Rocketship) ||
			//			(p2 instanceof Alien && p1 instanceof Rocketship)){
			//		p1.touchPlatform = false;
			//		p2.touchPlatform = false;
			//	}

//			}
//		}
//	}
//}
public void reset() {
	platform.clear();
}

}
