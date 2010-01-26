package com.jaymen.java.certification.chp06;

import org.junit.Test;
import static org.junit.Assert.*;


public class PrimeForLoopTest {
	private static int NON_PRIME = 9;
	private static int PRIME = 3;
	
	@Test
	public void testNonPrime(){
		assertFalse(PrimeForLoop.isPrime(NON_PRIME));
	}

	@Test
	public void testPrime(){
		assertTrue(PrimeForLoop.isPrime(PRIME));
	}

	@Test
	public void primesBelow100(){
		String primes = new String();
		for(int i =1; i < 100; i++){
			if(PrimeForLoop.isPrime(i)){
				primes += i + " ";
			}
		}
		assertEquals(PrimeWhileLoopTest.PRIMES_BELOW_100, primes);
	}
}
