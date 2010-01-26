package com.jaymen.java.certification.chp05;

public class SunLightApplication {
	//Constant used for light speed in meters per second
	public static final long LIGHT_SPEED = 299792458; 
	
	public static void main(String[] args) {
		// Distance from sun (150 million kilometers)
		long kmFromSun = 150000000;
		long distanceInMeters = kilometersToMeters(kmFromSun);
		long timeInSeconds = timeToTravelAtLightSpeed(distanceInMeters);
		printResult(timeInSeconds);
		
	}
	public static void printResult(long seconds) {
		System.out.print("Light will use ");
		System.out.print(numberofMinutes(seconds) + " minute(s) and " + numberOfSeconds(seconds) + " second(s)");
		System.out.println(" to travel from the sun to the earth.");
	}
	
	/**
	 * Calculate how many meters there are from the amount of 
	 * kilometers.
	 * 
	 * @param kilometers The number of kilometers.
	 * @return The number of meters in the kilometers.
	 */
	public static long kilometersToMeters(long kilometers){
		return kilometers * 1000L;
	}
	
	/**
	 * Calculate how many seconds it will take to travel a certain
	 * distance at light speed.
	 * 
	 * @param distance Distance in meters to travel.
	 * @return Time in seconds it will take to travel the distance
	 */
	public static long timeToTravelAtLightSpeed(long distance){
		return distance / LIGHT_SPEED;
	}
	
	/**
	 * Calculate how many full minutes there are in depending
	 * on the number of seconds.
	 * 
	 * @param seconds The number of seconds.
	 * @return The number of full minutes.
	 */
	public static long numberofMinutes(long seconds){
		return seconds/60;
	}
	
	/**
	 * Calculate how many left over seconds there are after full
	 * minutes have been taken out.
	 * 
	 * @param secs The number of seconds.
	 * @return The number of left over seconds.
	 */
	public static long numberOfSeconds(long seconds){
		return seconds%60;
	}

}
