package dev.resources;

public enum Resource {

	WOOD(0, 15, "wood", true);

	public int amount;
	public int value;
	public String name;
	public boolean unlocked;

	private Resource(int amount, int value, String name, boolean unlocked) {
		this.amount = amount;
		this.value = value;
		this.name = name;
		this.unlocked = unlocked;
	}

	public static void editResource(Resource resource, int editAmount, boolean add) {
		// for the boolean argument, true means addition, false means subtraction.
		if (add) {
			resource.amount += editAmount;
		}

		if (add == false) {
			resource.amount -= editAmount;
		}
	}

	public static int getResourceAmount(Resource resource) {
		return resource.amount;
	}

}
