package com.jaymen.java.certification.java.generics;

import org.junit.Test;

import static org.junit.Assert.*;

public class AutoBoxingTest {
	
	/**
	 * Simple test to see what can and can't be auto boxed.
	 * Remember that it boes and then widens.
	 * So an int can be come and Integer and the widened to Number
	 * But you can not for from int to long the box to a Long!
	 */
	@Test
	public void boxingOfArrayTypes(){
		Integer[][] arr1 = { { 1, 2 }, { 3, 4 } };
		Number[] arr2 = arr1[0];
		//int x = 1;

		assertTrue(arr1[0][0] == 1);
		//System.out.print(arr2[0] == x); //Compilation error incompatible types
		//System.out.print(x instanceof Integer); //Compilation error incompatible types
		assertTrue(arr1[1][0] > (Integer) arr2[0]);
		
	}

}
