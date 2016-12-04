package dev.broystudios.towngame.resources;

public enum Resources {

	WOOD(15, "wood"), IRON(20, "iron");
	
	public int value;
	public String name;
	
	private Resources(int value, String name) {
		this.value = value;
		this.name = name;
	}
	
}
