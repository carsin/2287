package dev.broystudios.towngame;

public class Time {
	
	private int minute, hour, day, dayCount, month, year = 2287;
	private int[] daysOfMonth = new int[12];
	public static final int JAN = 0, FEB = 1, MAR = 2, APR = 3, MAY = 4, JUN = 5, JUL = 6, AUG = 7, SEP = 8, OCT = 9,
			NOV = 10, DEC = 11;
	private final int timeStep = 1;

	public Time() {
		setMonths();
	}

	public void setMonths() {
		daysOfMonth[JAN] = 31;
		daysOfMonth[FEB] = 28;
		daysOfMonth[MAR] = 31;
		daysOfMonth[APR] = 30;
		daysOfMonth[MAY] = 31;
		daysOfMonth[JUN] = 30;
		daysOfMonth[JUL] = 31;
		daysOfMonth[AUG] = 31;
		daysOfMonth[SEP] = 30;
		daysOfMonth[OCT] = 31;
		daysOfMonth[NOV] = 30;
		daysOfMonth[DEC] = 31;
	}
	
	public void tick() {
		advanceTime();
	}

	public void advanceTime() {
		minute += timeStep;
		while (minute >= 60) {
			if (minute >= 60) {
				hour++;
				minute -= 60;
			}
			if (hour >= 24) {
				day++;
				dayCount++;
				hour = 0;
			}
			if (day >= daysOfMonth[month]) {
				month++;
				day = 0;
				if (month == FEB && year % 4 == 0) {
					daysOfMonth[FEB] = 29;
				} else {
					daysOfMonth[FEB] = 28;
				}
			
				if (month >= 12) {
					
					month -= 12;
					year++;
					
				}
			}
		}
		
		
	}

	public String getTimeAsString() {
		String newMinute = Integer.toString(minute), newHour = Integer.toString(hour);
		String indicator = "AM";
		if (minute < 10) {
			newMinute = "0" + Integer.toString(minute);
		}
		if (hour >= 12) {
			newHour = Integer.toString(hour - 12);
			indicator = "PM";
		}
		if (hour == 0 || hour == 12) {
			newHour = "12";
		}
		return (newHour + ":" + newMinute + " " + indicator + " " + (day + 1) + "/" + (month + 1) + "/" + year
				+ " Day Count: " + dayCount);
	}

	public int getMinute() {
		return minute;
	}

	public int getHour() {
		return hour;
	}

	public int getDay() {
		return day;
	}

	public int getDayCount() {
		return dayCount;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

}
