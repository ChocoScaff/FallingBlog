package fr.eseo.e3.poo.projet.blox.modele.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	final int FPS = 60;
	Thread gameThread;
	
	public GamePanel ()	{
		
		// Final Settings
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setBackground(Color.black);
		this.setLayout(null);
		
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
		
	}
	
	public void paintComponent(Graphics g)	{
		super.paintComponent(g);
	}
}
