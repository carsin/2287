package dev.building;

import dev.GameStats;
import dev.resources.Resource;

public abstract class Building {

	protected int buildingCount;
	protected int buildingCost;
	protected boolean unlocked;

	public Building(int buildingCost, int buildingCount, boolean unlocked, Resource resourceType) {
		this.buildingCost = buildingCost;
		this.unlocked = unlocked;
		this.buildingCount = buildingCount;
	}

	public abstract void buildBuilding();

	public abstract void unlockBuilding();

	public void upgradeTown() {
		GameStats.maxBuildings += 5;
		Resource.editResource(Resource.WOOD, GameStats.upgradeTownCost, false);
	}

}
