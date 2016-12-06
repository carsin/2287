package dev.broystudios.towngame.building;

import dev.broystudios.towngame.resources.Resource;

public class Hut extends ResidentialBuilding {

	public Hut() {
		super(10, 0, true, 2, Resource.WOOD);
	}

	public void buildBuilding() {
		if (unlocked) {
			Resource.editResource(Resource.WOOD, buildingCost, false);
			ResidentialBuilding.townMaxResidents += 2;
			buildingCount++;
			buildingCost += 10;
			System.out.println("you build a hut");
		} else {
			System.out.println("error not unlocked");
		}
	}

	public void unlockBuilding() {
		this.unlocked = true;
	}

}
