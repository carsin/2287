package dev.broystudios.towngame.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Display {

	private JFrame f;
	private Canvas c;
	private int width, height;
	private String title;
	
	public Display(int width, int height, String title) {
		this.width = width;
		this.height = height;
		this.title = title;
		
		
		generateFrame();
		
	}
	
	public void generateFrame() {
		
		f = new JFrame();
		c = new Canvas();
		
		c.setMaximumSize(new Dimension(width, height));
		c.setMinimumSize(new Dimension(width, height));
		c.setPreferredSize(new Dimension(width, height));
		
		f.setTitle(title);
		f.setSize(width, height);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.add(c);
		f.pack();
		f.setVisible(true);
		
	}
	
	public void render() {
		
		BufferStrategy b = c.getBufferStrategy();
		if(b == null) {
			c.createBufferStrategy(3);
			return;
		}
		
		Graphics g = b.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		
		b.show();
		g.dispose();
		
	}
	
}
