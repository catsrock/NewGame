import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
ArrayList<GameObject> platform;
Player wolf;
public ObjectManager(Player p1) {
	platform=new ArrayList<GameObject>();
	wolf=p1;
}
public void addPlatform(GameObject p, Graphics g) {
	wolf.draw(g);
	platform.add(p);
	
}
public void update() {
	for (int i = 0; i < platform.size(); i++) {
		GameObject p4 = platform.get(i);
		p4.update();
	}
	
}
public void draw(Graphics g) {
	wolf.draw(g);
	for (int i = 0; i < platform.size(); i++) {
		GameObject p3=platform.get(i);
		p3.draw(g);
	}
	
	setUpLevel();
	
}
public void setUpLevel() {
	
		platform.add(new Platform(1000, 710, 100, 25));
		platform.add(new Platform (1200, 680, 100, 25));
	
}


//public void manageEnemies(){
	//if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
		//addObject(new Alien(new Random().nextInt(MyGame.WIDTH), 0, 50, 50));
//enemyTimer = System.currentTimeMillis();
	//}
//}


public void checkCollision() {
	System.out.println("boo");
	for (int i = 0; i < platform.size(); i++) {
		
			GameObject p2 = platform.get(i);
			System.out.println("feep");
			
			if(p2.collisionBox.intersects(wolf.collisionBox)){
				//wolf.collisionBox.intersects(p2.collisionBox)
					//score++;
					//System.out.println(score);
					//p1.touchPlatform = false;
					System.out.println("hi");
				}
				System.out.println("hello");


		}
	System.out.println("meep");
	}

public void reset() {
	platform.clear();
}

}
