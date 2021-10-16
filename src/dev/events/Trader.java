package dev.broystudios.towngame.events;

import dev.broystudios.towngame.InstanceHandler;

public class Trader extends Event {

	public Trader(int id, int frequency, boolean unlocked) {
		super(id, frequency, unlocked);
	}

	public void runEvent() {
		InstanceHandler.getScreen().println("A trader comes through town");
	}

	public void unlockEvent() {
		this.unlocked = true;
	}

}
