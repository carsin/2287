package dev.broystudios.towngame.building;

import dev.broystudios.towngame.resources.Resource;

public abstract class Building {

	protected int buildingCount;
	protected int buildingCost;
	protected boolean unlocked;

	public int upgradeTownCost = 100;
	public static int maxBuildings = 25;
	public static int currentBuildings = 0;

	public Building(int buildingCost, int buildingCount, boolean unlocked, Resource resourceType) {
		this.buildingCost = buildingCost;
		this.unlocked = unlocked;
		this.buildingCount = buildingCount;
	}

	public abstract void buildBuilding();

	public abstract void unlockBuilding();

	public void upgradeTown() {
		maxBuildings += 5;
		Resource.editResource(Resource.WOOD, upgradeTownCost, false);
	}

}
