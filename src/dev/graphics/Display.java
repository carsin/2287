package dev.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import dev.InstanceHandler;
import dev.graphics.ui.ClickListener;
import dev.graphics.ui.Screen;
import dev.graphics.ui.UIButton;

public class Display {

	private JFrame f;
	private Canvas c;
	private int width, height;
	private String title;
	private Screen screen;

	public Display(int width, int height, String title) {
		this.width = width;
		this.height = height;
		this.title = title;

		screen = new Screen();
		generateFrame();

		//Carson, follow this format for a button
		InstanceHandler.getUIHandler().add(new UIButton(width - 120, height - 40, 100, 20, Color.RED, "TEST", new ClickListener() {
			@Override
			public void onClick() {
				screen.println("click dat button ooh yeah");
			}
		}));

	}

	public void generateFrame() {

		f = new JFrame();
		c = new Canvas();

		c.setMaximumSize(new Dimension(width, height));
		c.setMinimumSize(new Dimension(width, height));
		c.setPreferredSize(new Dimension(width, height));
		c.addMouseListener(InstanceHandler.getMouseHandler());
		c.addMouseMotionListener(InstanceHandler.getMouseHandler());
		c.setFocusable(false);

		f.setTitle(title);
		f.setSize(width, height);
		f.add(c);
		f.addMouseListener(InstanceHandler.getMouseHandler());
		f.addMouseMotionListener(InstanceHandler.getMouseHandler());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setFocusable(true);
		f.requestFocus();
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
		screen.render(g);
		InstanceHandler.getUIHandler().tick();
		InstanceHandler.getUIHandler().render(g);

		b.show();
		g.dispose();

	}

	public Screen getScreen() {
		return screen;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
