package dev.broystudios.towngame;

import dev.broystudios.towngame.graphics.Display;

public class Game implements Runnable {

	private String title;
	private int width, height;
	private Thread thread;
	private Display display;
	
	public Game(int width, int height, String title) {
		this.width = width;
		this.height = height;
		this.title = title;
		
		start();
		
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		init();
		
		
	}
	
	public void init() {
		
		display = new Display(width, height, title);
		
	}
	
}
