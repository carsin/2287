package dev.building;

import dev.resources.Resource;

public abstract class ResidentialBuilding extends Building {

	protected int maxResidents;

	public ResidentialBuilding(int buildingCost, int buildingCount, boolean unlocked, int maxResidents, Resource resourceType) {
		super(buildingCost, buildingCount, unlocked, resourceType);

		this.maxResidents = maxResidents;
	}

}
