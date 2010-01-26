package com.jaymen.java.certification.chp06.energy;

/** 
 * A controller that will manage the power plant and make sure that 
 * the reactor runs with optimal throughput. 
 */
public class Control {
	PowerPlant thePlant;

	final static int TOLERANCE = 10;

	public Control(PowerPlant p) {
		thePlant = p;
	}
	
	/** Run the power plant by continuously monitoring the optimalThroughput 
	 * and the actual throughput of the reactor. If the through puts differ 
	 * by more than 10 units, i.e. tolerance, adjust the reactor throughput.
	 * 
	 * If the reactor status becomes critical, the evacuate alarm is sounded 
	 * and the reactor is shut down. <p>The runSystem() method can handle the 
	 * reactor core directly but calls methods needAdjustment(), adjustThroughput(), 
	 * and shutdown() instead. 
	 */
	public void runSystem() {
		try {
			while (true) { // infinite loop
				int optimalThroughput = thePlant.getOptimalThroughput();
				if (needAdjustment(optimalThroughput))
					adjustThroughput(optimalThroughput);
			}
		} catch (ReactorCritical rc) {
			thePlant.soundEvacuateAlarm();
		} finally {
			shutdown();
		}
	}

	/** Reports whether the throughput of the reactor needs adjusting, given the 
	 * target throughput. This method should also monitor and report if the reactor 
	 * status becomes critical. 
	 * 
	 * @return true if the optimal and actual throughput values differ by more than 10 units. 
	 */
	public boolean needAdjustment(int target) throws ReactorCritical {
		if (thePlant.core.isCritical())
			throw new ReactorCritical();
		return Math.abs(thePlant.core.getThroughput() - target) > TOLERANCE;
	}

	/** Adjust the throughput of the reactor by calling increaseThroughput() 
	 * and decreaseThroughput() methods until the actual throughput is within 10 units 
	 * of the target throughput.
	 * @throws ReactorCritical 
	 */
	public void adjustThroughput(int target) throws ReactorCritical {
		while (needAdjustment(target)) {
			if ((thePlant.core.getThroughput() - target) > TOLERANCE){
				thePlant.core.increaseThroughput();
			}
			else{
				thePlant.core.decreaseThroughput();
			}
		}
	}

	/** 
	 * Shut down the reactor by lowering the throughput to 0.
	 */
	public void shutdown() {
		while (thePlant.core.getThroughput() > 0) {
			thePlant.core.decreaseThroughput();
		}
	}
}
