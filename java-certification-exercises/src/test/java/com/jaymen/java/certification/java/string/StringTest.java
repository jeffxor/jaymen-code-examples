package com.jaymen.java.certification.java.string;


import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringTest {

	/**
	 * Simple test to test strings substring method.
	 */
	@Test
	public void testStubstring(){
		String word = "restructure";
        assertEquals("s",word.substring(2, 3));
	}

	/**
	 * Another simple test of the substring method.
	 */
	@Test 
	public void testSubString(){
		assertEquals("urge", "hamburger".substring(4, 8));			
	}
	
	/**
	 * Test the overloaded string concatenation with a null reference.
	 * Notice the difference between the system.out.println which works.
	 */
	@Test (expected=NullPointerException.class) 
	public void testNullAddition(){
		System.out.println(null + "");
        assertEquals(null, null + "");
        
	}
	
	/**
	 * Test concatenation with Strings in a for loop.
	 */
	@Test 
	public void testForLoopArray(){
		String [] args = {"-", "A", "."};
        String string = "";
        for(int x = 0; ++x < args.length ;){
        	string += args[x];
        }
        
        assertEquals("A.", string);
	}
	
	/**
	 * Test to understand the basics of the overloaded string concatenation.
	 */
	@Test 
	public void testStringConcatenation(){
        assertEquals("5A", 2+3+"A");
        assertEquals("A23", "A"+2+3);
        assertEquals("A5", "A"+(2+3));
	}
	
	/**
	 * Test string method equality. Here the trim method returns a 
	 * new string with the same contents
	 */
	@Test 
	public void testStringMethodReferenceEquality(){
        assertEquals(false, " String ".trim() == "String");
	}
	
	/**
	 * Test string method equality. Here the trim method returns a 
	 * new string with the same contents.
	 */
	@Test 
	public void testStringMethodEquality(){
        assertEquals(true, " String ".trim().equals("String"));
	}	

	/**
	 * Test what happens with an incorrect string index.
	 */
	@Test(expected=StringIndexOutOfBoundsException.class) 
	public void testStringSubStringNegativeParams(){	
		assertEquals("hamburge", "hamburger".substring(-1, 8));
		assertEquals("urger", "hamburger".substring(4, 20));
	}

	/**
	 * Test the substring equality of strings
	 */
	@Test 
	public void testSubStringEquality(){
		assertEquals(true, "String".substring(0) == "String");			
	}
	
	/**
	 * Simple test to check the natural sorting of strings.
	 */
	@Test 
	public void testStringNaturalOrdering(){
		Set<String> set = new TreeSet<String>();
		set.add(" ");
		set.add("a");
		set.add("A");
		set.add(" a");
		set.add(" A");
		set.add(" aa");
		set.add(" aA");
		set.add(" aAA");
		set.add("aa");
		set.add("aA");
		set.add("aaa");
		set.add("aAA");
		set.add("Aa");
		set.add("AA");
		set.add("aaab");
				
		String expected = "[ ,  A,  a,  aA,  aAA,  aa, A, AA, Aa, a, aA, aAA, aa, aaa, aaab]";
		assertEquals(expected, set.toString());			
	}
	
}
