package dev.broystudios.towngame.events;

public class Trader extends Event {

	public Trader(int id, int frequency, boolean unlocked) {
		super(id, frequency, unlocked);
	}

	public void runEvent() {
		System.out.println("A trader comes through town");
	}

	public void unlockEvent() {
		this.unlocked = true;
	}

}
