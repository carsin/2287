package dev.broystudios.towngame;

import java.util.Random;

import dev.broystudios.towngame.graphics.Display;
import dev.broystudios.towngame.resources.Resources;
import dev.broystudios.towngame.scene.GameScene;
import dev.broystudios.towngame.scene.Scene;

public class Game implements Runnable {
	
	private Scene gameScene;
	
	private Random rand;
	private Time time;

	private String title;
	private int width, height;
	private Thread thread;
	private Display display;
	private boolean running = false;
	
	public Game(int width, int height, String title) {
		this.width = width;
		this.height = height;
		this.title = title;
		
		start();
		
	}
	
	public void tick() {
		time.tick();
		Scene.getCurrentScene().tick();
	}

	public void run() {
		init();
		
		int tps = 5;
		double timePerTick = 1000000000 / tps;
		double delta = 0;
		long now;
		long lastTimer = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTimer) / timePerTick;
			timer += now - lastTimer;
			lastTimer = now;
			
			if (delta >= 1) {
				tick();
				display.render();
				ticks++;
				delta--;
			}
			
			if (timer >= 1000000000) {
				ticks = 0;
				timer = 0;
				
			}
		}
		stop();
		
	}
	
	public void init() {
		InstanceHandler.init(this);
		display = new Display(width, height, title);
		time = new Time();
		rand = new Random();
		gameScene = new GameScene();
		Scene.setScene(gameScene);
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if (!running) return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Time getTime() {
		return time;
	}
	
}
