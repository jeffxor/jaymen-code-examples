package com.jaymen.java.certification.chp06;

/**
 * Create different versions of a program that finds all the primes below 100. 
 * Create one version that only uses the for(;;) loop (i.e., no while or do-while). 
 * Create another version that only uses the while loop.
 *
 * This is the version using for loops
 */
public class PrimeForLoop {

	public static void main(String[] args){
		System.out.print("Prime numbers below 100 are: ");
		for(int i = 1; i < 100; i++){
			if(isPrime(i)){
				System.out.print(i + " ");
			}
		}
	}

	/**
	 * Calculate if the number is a prime number. Very
	 * crude calculation but it works!
	 * 
	 * @param number A number to test.
	 * @return True if the number is prime. False, otherwise.
	 */
	public static boolean isPrime(int number){
		//Start loop from too to exclude division by 1
		for(int i = 2; i < number; i++){
			if(number % i == 0)
				return false;
		}
		return true;
	}
}
