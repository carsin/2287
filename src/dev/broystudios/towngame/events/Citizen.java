package dev.broystudios.towngame.events;

import java.util.Random;

import dev.broystudios.towngame.building.ResidentialBuilding;

public class Citizen extends Event {

	Random random = new Random();
	
	public Citizen(int id, int frequency) {
		super(id, frequency);
	}

	public void runEvent() {
		int movingInAmount = random.nextInt(3);
		
		if (movingInAmount > ResidentialBuilding.townMaxResidents - ResidentialBuilding.townCurrentResidents) {
			runEvent();
		} else {
			ResidentialBuilding.townCurrentResidents += movingInAmount;
			if (movingInAmount >= 2) {
				System.out.println(movingInAmount + " wanderers take up in your town");
			} else {
				System.out.println("a lone wanderer settles in your town");
			}
		}
	}

}
