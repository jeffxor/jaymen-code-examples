package com.jaymen.java.certification.chp06;

/**
 * Create different versions of a program that finds all the primes below 100. 
 * Create one version that only uses the for(;;) loop (i.e., no while or do-while). 
 * Create another version that only uses the while loop.
 *
 * This is the version using while loops
 */
public class PrimeWhileLoop {

	public static void main(String[] args) {
		System.out.print("Prime numbers below 100 are: ");
		int i = 1;
		while(i < 100){
			if(isPrime(i)){
				System.out.print(i + " ");
			}
			i++;
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
		int i = 2;
		while(i < number){
			if(number % i == 0){
				return false;
			}
			i++;
		}
		return true;
	}
}
