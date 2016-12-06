package dev.broystudios.towngame.events;

import java.util.Random;

import dev.broystudios.towngame.GameStats;

public class Citizen extends Event {

	Random random = new Random();
	
	public Citizen(int id, int frequency, boolean unlocked) {
		super(id, frequency, unlocked);
	}

	public void runEvent() {
		if (GameStats.townMaxResidents == GameStats.townCurrentResidents) {
			System.out.println("town full");
		} else {
			System.out.println("a wanderer settles in your town " + GameStats.townCurrentResidents + "/" + GameStats.townMaxResidents);
			GameStats.townCurrentResidents++;
		}
			
	}

	public void unlockEvent() {
		this.unlocked = true;
		System.out.println("you unlock citizen event");
	}

}
