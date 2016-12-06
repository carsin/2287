package dev.broystudios.towngame.events;

import dev.broystudios.towngame.InstanceHandler;

public class Trader extends Event {

	public Trader(int id, int frequency) {
		super(id, frequency);
	}

	public void runEvent() {
		InstanceHandler.getScreen().println("A trader comes through town");
	}

}
