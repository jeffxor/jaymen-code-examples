package com.jaymen.java.certification.chp06;

import org.junit.Test;
import static org.junit.Assert.*;


public class PrimeWhileLoopTest {
	private static int NON_PRIME = 9;
	private static int PRIME = 3;
	public static String PRIMES_BELOW_100 = "1 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 ";
	
	@Test
	public void testNonPrime(){
		assertFalse(PrimeWhileLoop.isPrime(NON_PRIME));
	}

	@Test
	public void testPrime(){
		assertTrue(PrimeWhileLoop.isPrime(PRIME));
	}
	
	@Test
	public void primesBelow100(){
		String primes = new String();
		int i = 1;
		while(i < 100){
			if(PrimeWhileLoop.isPrime(i)){
				primes += i + " ";
			}
			i++;
		}
		assertEquals(PRIMES_BELOW_100, primes);
	}

}
