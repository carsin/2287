package dev.events;

public abstract class Event {

	public static Event[] events = new Event[10];
	
	public static Event trader = new Trader(0, 3, false);
	public static Event citizen = new Citizen(1, 3, false);
	
	protected int id;
	protected int frequency;
	protected boolean unlocked;
	
	public Event(int id, int frequency, boolean unlocked) {
		this.id = id;
		this.frequency = frequency;
		this.unlocked = unlocked;
		
		events[id] = this;
	}

	public abstract void runEvent();
	public abstract void unlockEvent();

	public int getFrequency() {
		return frequency;
	}
	
	public boolean isUnlocked() {
		return unlocked;
	}

}
