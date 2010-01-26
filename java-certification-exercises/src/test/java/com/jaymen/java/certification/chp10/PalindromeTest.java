package com.jaymen.java.certification.chp10;

import static org.junit.Assert.*;

import org.junit.Test;


public class PalindromeTest {
	
	@Test
	public void testIsPalindrome(){
		String palindrome = "redivider";
		
		assertTrue("The word " + palindrome + " is a palindrome", Palindrome.isPalindrome(palindrome));
	}
	
	@Test
	public void testIsNotPalindrome(){
		String palindrome = "computer";
		
		assertFalse("The word " + palindrome + " is NOT a palindrome", Palindrome.isPalindrome(palindrome));
	}	
}
