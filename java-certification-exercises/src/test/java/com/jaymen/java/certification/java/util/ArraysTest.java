package com.jaymen.java.certification.java.util;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;


public class ArraysTest {
	
	/**
	 * Test what happens with an unsorted boxed array
	 */
	@Test
	public void binarySearchIntegerArrayUnsorted(){
		Integer[] arr = { 1, 2, 3 };
		assertEquals(0, Arrays.binarySearch(arr, 1));
	}

	/**
	 * Test what happens when searching for unrelated types
	 */
	@Test(expected=ClassCastException.class) 
	public void binarySearchIntegerArrayForString()  {
		Integer[] arr = { 1, 2, 3 }; 
		Arrays.binarySearch(arr, "javachamp");
	}
}
