package minigame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle {
	public int spd = 4;
	public boolean direita, cima, baixo, esquerda;
	
	
	
	public Player(int x, int y ) {
		super(x,y,32,32);
		
	}
	public void tick() {
		if(direita) {
			x+= spd;
		}else if(esquerda) {
			x-=spd;
		}
		if(cima) {
			y-= spd;
		}else if(baixo) {
			y+=spd;
		}
		
	}
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
	
	}
}
