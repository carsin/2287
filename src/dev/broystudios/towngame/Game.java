package dev.broystudios.towngame;

import java.util.Random;

import dev.broystudios.towngame.events.Event;
import dev.broystudios.towngame.graphics.Display;

public class Game implements Runnable {
	
	Random rand = new Random();

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
	
	public void generateEvent() {
		for (int i = 0; i < Event.events.length; i++) {
			if (Event.events[i] != null) {
				if ((int) rand.nextInt(Event.events[i].getFrequency() * 100) == 0) {
					Event.events[i].runEvent();
					break;
				}
			}
			break;
		}
	}
	
	public void tick() {
		generateEvent();
	}

	public void run() {
		init();
		
		int tps = 1;
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
		display = new Display(width, height, title);
		
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
	
}
