package dev.broystudios.towngame.events;

public class Trader extends Event {

	public Trader(int id, int frequency) {
		super(id, frequency);
	}

	public void runEvent() {
		System.out.println("A trader comes through town");
	}

}
