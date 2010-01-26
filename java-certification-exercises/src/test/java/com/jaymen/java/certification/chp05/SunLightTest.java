package com.jaymen.java.certification.chp05;

import org.junit.Test;
import static org.junit.Assert.*;


public class SunLightTest {
	
	@Test
	public void kilometersToMetersTest(){
		assertEquals(1000L, SunLightApplication.kilometersToMeters(1));
	}
	
	@Test
	public void timeToTravelAtLightSpeedTest(){
		assertEquals(1L, SunLightApplication.timeToTravelAtLightSpeed(SunLightApplication.LIGHT_SPEED));
	}

	@Test
	public void numberofMinutesTest(){
		assertEquals(2L, SunLightApplication.numberofMinutes(120L));
	}

	@Test
	public void numberOfSecondsTest(){
		assertEquals(35L, SunLightApplication.numberOfSeconds(95L));
	}
}
