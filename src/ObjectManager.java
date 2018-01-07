import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
ArrayList<GameObject> platform;
Player wolf;
public ObjectManager(Player p) {
	platform=new ArrayList<GameObject>();
	wolf=p;
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
	wolf.draw(g);
	for (int i = 0; i < platform.size(); i++) {
		GameObject p=platform.get(i);
		p.draw(g);
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
	for (int i = 0; i < platform.size(); i++) {
		
			GameObject p1 = platform.get(i);
			
			
			if(p1.collisionBox.intersects(wolf.collisionBox)){
				
					//score++;
					//System.out.println(score);
					p1.touchPlatform = false;
					System.out.println("hi");
				}
				


		}
	}

public void reset() {
	platform.clear();
}

}
