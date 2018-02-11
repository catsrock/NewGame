import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class ObjectManager {
ArrayList<GameObject> platform;
Player wolf;
public ObjectManager(Player p1) {
	platform=new ArrayList<GameObject>();
	wolf=p1;
}
public void addPlatform(GameObject p, Graphics g) {
	platform.add(p);
	System.out.println("daflh");
	//for (int i = 0; i < platform.size(); i++) {
	//	GameObject p3=platform.get(i);
		//p3.draw(g);
	//wolf.draw(g);
	//}
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
		GameObject p3=platform.get(i);
		p3.draw(g);
	}
	
	
}
public void setUpLevel() {
	
		platform.add(new Platform(1000, 710));
		platform.add(new Platform (1200, 680));
	
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
			//System.out.println("feep");
			if(p2.collisionBox.intersects(wolf.collisionBox)) {
				JOptionPane.showMessageDialog(null, "flurrrrb");
				System.out.println("hi");
			}
			else {
				System.out.println("blurrrb");
			}
				
					//score++;
					//System.out.println(score);
					//p1.touchPlatform = false;
					
				
				System.out.println("hello");


		}
	System.out.println("meep");
	}

public void reset() {
	platform.clear();
}


}
