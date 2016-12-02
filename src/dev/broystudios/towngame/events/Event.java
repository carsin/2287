package dev.broystudios.towngame.events;

public abstract class Event {
	
	public static Event[] events = new Event[10];
	
	public static Event trader = new Trader(0, 3);
	
	protected int id;
	protected int frequency;
	
	public Event(int id, int frequency) {
		this.id = id;
		this.frequency = frequency;
		events[id] = this;
	}
	
	public abstract void runEvent();

	public int getFrequency() {
		return frequency;
	}

}
