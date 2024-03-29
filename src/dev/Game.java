package dev;

import java.util.Random;

import dev.building.Hut;
import dev.events.Event;
import dev.graphics.Display;
import dev.graphics.ui.UIHandler;
import dev.input.MouseHandler;
import dev.resources.Resource;

public class Game implements Runnable {

	private Random rand;
	private Time time;
	private Hut hut;
	private MouseHandler mouseHandler;
	private UIHandler uiHandler;
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
		generateEvent();
		// Scene.getCurrentScene().tick();
	}

	public void generateEvent() {
		for (int i = 0; i < Event.events.length; i++) {
			if (Event.events[i] != null && Event.events[i].isUnlocked()) {
				if ((int) rand.nextInt(Event.events[i].getFrequency() * 1) == 0) {
					Event.events[i].runEvent();
					break;
				}
			}
		}
	}

	public void run() {
		init();

		int tps = 1;
		int fps = 20;
		double timePerFrame = 1000000000 / fps;
		double timePerTick = 1000000000 / tps;
		double deltaFrame = 0;
		double deltaTick = 0;
		long now;
		long lastTimer = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			deltaTick += (now - lastTimer) / timePerTick;
			deltaFrame += (now - lastTimer) / timePerFrame;
			timer += now - lastTimer;
			lastTimer = now;

			if (deltaTick >= 1) {
				tick();
				ticks++;
				deltaTick--;
			}

			if(deltaFrame >= 1) {
				display.render();
				deltaFrame--;
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
		uiHandler = new UIHandler();
		mouseHandler = new MouseHandler();
		display = new Display(width, height, title);
		time = new Time();
		rand = new Random();
		hut = new Hut();


		Event.citizen.unlockEvent();
		Resource.editResource(Resource.WOOD, 10, true);
		hut.buildBuilding();
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
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

	public Display getDisplay() {
		return display;
	}

	public MouseHandler getMouseHandler() {
		return mouseHandler;
	}

	public UIHandler getUIHandler() {
		return uiHandler;
	}

}
