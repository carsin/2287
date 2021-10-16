package dev.broystudios.towngame.building;

import dev.broystudios.towngame.resources.Resource;

public abstract class ResidentialBuilding extends Building {

	protected int maxResidents;

	public ResidentialBuilding(int buildingCost, int buildingCount, boolean unlocked, int maxResidents, Resource resourceType) {
		super(buildingCost, buildingCount, unlocked, resourceType);

		this.maxResidents = maxResidents;
	}

}
