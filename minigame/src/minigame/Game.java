package minigame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener{
	// SETAR O TAMANHO DA TELA
	public static int WIDTH = 480, HEIGHT = 480;
	public Player player;
	
	public Game() {
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		player = new Player(0,0);
	
	
	}
	
	
	
	public void tick() {
		player.tick();
		
	}
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(1);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		bs.show();
		//fundo
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
	
		// Renderizar a imagem do player
		player.render(g);
	}
	
	
	public static void main (String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		
		
		frame.add(game);
		frame.setTitle("Mini Game");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		new Thread(game).start();
		
		
		
		
		
	}
	
	
	@Override
	public void run() {
		while(true) {
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D) {
			player.direita = true;
		}else if(e.getKeyCode() == KeyEvent.VK_A) {
			player.esquerda = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_W){
			player.cima = true;
		}else if(e.getKeyCode() == KeyEvent.VK_S) {
			player.baixo = true;
		}
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D) {
			player.direita = false;
		}else if(e.getKeyCode() == KeyEvent.VK_A) {
			player.esquerda = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_W) {
			player.cima = false;
		}else if(e.getKeyCode() == KeyEvent.VK_S) {
			player.baixo = false;
		}
		// TODO Auto-generated method stub
		
	}

}
