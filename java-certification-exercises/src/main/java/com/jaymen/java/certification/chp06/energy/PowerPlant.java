package com.jaymen.java.certification.chp06.energy;

/** 
 * A PowerPlant with a reactor core. 
 */
public class PowerPlant {
	/** 
	 * Each power plant has a reactor core. This has package 
	 * accessibility so that the Control class that is defined 
	 * in the same package can access it. 
	 */
	Reactor core;

	/** 
	 * Initializes the power plant, creates a reactor core. 
	 */
	PowerPlant() {
		core = new Reactor();
	}

	/** 
	 * Sound the alarm to evacuate the power plant. 
	 */
	public void soundEvacuateAlarm() {
		//TODO: ... implementation unspecified ...
	}
	
	/** 
	 * Get the level of reactor output that is most desirable at this time.
	 * (Units are unspecified.) 
	 */
	public int getOptimalThroughput() {
		//TODO: ... implementation unspecified ...
		return 0;
	}
	/** 
	 * The main entry point of the program: sets up a PowerPlant object 
	 * and a Control object and lets the Control object run the power plant. 
	 */
	public static void main(String[] args) {
		PowerPlant plant = new PowerPlant();
		Control ctrl = new Control(plant);
		ctrl.runSystem();
	}
}
