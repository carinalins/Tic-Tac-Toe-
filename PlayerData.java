import processing.core.PApplet;
import processing.core.PFont;

public class PlayerData {
	int posX;
	int posY;
	PApplet p;
	PFont f;
	
	public PlayerData(int posX, int posY, PApplet p, PFont f){
		this.posX = posX;
		this.posY = posY;
		this.p = p;
		this.f = f;
	}
	
	public void setData(String data){
		p.text(data, posX, posY);
	}
}
