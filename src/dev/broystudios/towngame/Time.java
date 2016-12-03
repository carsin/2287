package dev.broystudios.towngame;

public class Time {
	
	public int minute, hour, day, dayCount, week, month = 1, year = 2287;
	
	public void tick() {
		advanceTime();
		printTime();
	}
	
	public void advanceTime() {
		
	}
	
	public String getYear() {
		return Integer.toString(year);
	}
	
	public void printTime() {
		System.out.println(hour + ":" + minute + " " + day + "/" + month + "/" + year + " Week: " + week + " DC: " + dayCount);
	}

}
