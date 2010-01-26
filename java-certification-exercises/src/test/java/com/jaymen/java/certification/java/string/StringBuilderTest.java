package com.jaymen.java.certification.java.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringBuilderTest {

	/**
	 * Simple test to understand how reverse works
	 */
	@Test 
	public void testStringBuilderReverse(){
		StringBuilder s = new StringBuilder("hamburger");
		assertEquals("regrubmah", s.reverse().toString());
	}

	/**
	 * This was a question I got wrong it involves a number of
	 * StringBuilder methods, insert, delete, indexOf.
	 */
	@Test
	public void testStringBuilderInsert(){
		StringBuilder s = new StringBuilder("012345678 ");
		if (s.length() == 10)
			s.insert(10, "abcdef");
		s.delete(3,8);
		assertEquals(7, s.indexOf("c"));
	}

	/**
	 * Test what happens with an incorrect index.
	 */
	@Test (expected=StringIndexOutOfBoundsException.class) 
	public void testStringBuilderInsertGreaterIndex(){
		StringBuilder s = new StringBuilder("0123456789");
		s.insert(11, "abcdef");
		assertEquals("0123456789 abcdef", s.toString());
	}
	
	/**
	 * Simple test of how substring works
	 */
	@Test 
	public void testStringBuilderSubString(){
		StringBuilder s = new StringBuilder("hamburger");
		assertEquals("urge", s.substring(4, 8).toString());	
		
	}
}
