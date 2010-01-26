package com.jaymen.java.certification.chp10;

import org.junit.Test;
import static org.junit.Assert.*;


public class PairTest {
	
	@Test
	public void testEquals(){
		Pair pair1 = new Pair(new Integer(10), new Integer(10));
		Pair pair2 = new Pair(new Integer(10), new Integer(10));
		
		assertTrue("The same object should be equal", pair1.equals(pair1));
		assertTrue("The same object data should be equal", pair1.equals(pair2));
	}

	@Test
	public void testNotEquals(){
		Pair pair1 = new Pair(new Integer(10), new Integer(10));
		Pair pair2 = new Pair(new Integer(10), new Integer(20));
		
		
		assertFalse("The different object data should not be equal", pair1.equals(pair2));
	}

	@Test
	public void testHashCode(){
		Pair pair1 = new Pair(new Integer(10), new Integer(10));
		Pair pair2 = new Pair(new Integer(10), new Integer(10));
		Pair pair3 = new Pair(new Integer(10), new Integer(20));
				
		assertEquals("Objects that equal should have the same hashcode",pair1.hashCode(), pair2.hashCode());
		assertFalse("Objects that are differnt should not have the same hashcode",pair1.hashCode() == pair3.hashCode());
	}
	
	@Test
	public void testToString(){
		Pair pair1 = new Pair(new Integer(10), new Integer(10));
		assertEquals("Test toString","1010", pair1.toString());
	}
}
