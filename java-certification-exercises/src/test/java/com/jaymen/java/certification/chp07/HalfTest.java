package com.jaymen.java.certification.chp07;

import org.junit.Test;
import static org.junit.Assert.*;


public class HalfTest {
	
	@Test
	public void testEvaluate(){
		Half half = new Half();
		assertEquals("Half of 4 should be 2", 2, half.evaluate(4));
	}

}