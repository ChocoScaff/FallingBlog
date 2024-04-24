package fr.eseo.e3.poo.projet.blox.modele.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	final int FPS = 60;
	Thread gameThread;
	PlayManager pm;
	
	public GamePanel ()	{
		
		// Final Settings
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setBackground(Color.black);
		this.setLayout(null);
		
		pm = new PlayManager();
	}
	
	public void launchGame()	{
		gameThread = new Thread(this);
		gameThread.start();
	}
	@Override
	public void run() {
		
		// Game Loop
		 
	}
	
	private void update()	{
		
		pm.update();
	}
	
	public void paintComponent(Graphics g)	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		pm.draw(g2);
		
	}
}