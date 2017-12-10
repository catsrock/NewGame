import java.awt.Graphics;
import java.util.ArrayList;

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
public void reset() {
	platform.clear();
}

}
