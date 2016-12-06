package dev.broystudios.towngame.events;

import java.util.Random;

<<<<<<< HEAD
import dev.broystudios.towngame.InstanceHandler;
import dev.broystudios.towngame.building.ResidentialBuilding;
=======
import dev.broystudios.towngame.GameStats;
>>>>>>> origin/master

public class Citizen extends Event {

	Random random = new Random();
	
	public Citizen(int id, int frequency, boolean unlocked) {
		super(id, frequency, unlocked);
	}

	public void runEvent() {
		if (GameStats.townMaxResidents == GameStats.townCurrentResidents) {
			System.out.println("town full");
		} else {
<<<<<<< HEAD
			ResidentialBuilding.townCurrentResidents += movingInAmount;
			if (movingInAmount >= 2) {
				InstanceHandler.getScreen().println(movingInAmount + " wanderers take up in your town");
			} else {
				InstanceHandler.getScreen().println("a lone wanderer settles in your town");
			}
=======
			System.out.println("a wanderer settles in your town " + GameStats.townCurrentResidents + "/" + GameStats.townMaxResidents);
			GameStats.townCurrentResidents++;
>>>>>>> origin/master
		}
			
	}

	public void unlockEvent() {
		this.unlocked = true;
		System.out.println("you unlock citizen event");
	}

}
