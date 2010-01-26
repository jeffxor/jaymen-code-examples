package com.jaymen.java.certification.chp02;

import static junit.framework.Assert.*;

import org.junit.Test;


public class TemperatureTest {
	
	@Test
	public void testfc2(){
		double fahrenheit = 62.5;
		Temperature temperature = new Temperature();
		double celsius = temperature.f2c(fahrenheit);
		
		assertEquals("Values should be the same", 16.944444444444443, celsius);
	}
}
