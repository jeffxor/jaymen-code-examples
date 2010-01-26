package com.jaymen.java.certification.chp01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jaymen.java.certification.chp01.PrintableCharStack;

public class PrintableCharStackTest {
	private final String INITIAL_STRING = "!no tis ot nuf era skcatS";
	private final String FINAL_STRING = "!no tis ot nuf era skcatS";

	PrintableCharStack charStack;
	
	@Before
	public void loadCharStack(){
		charStack = new PrintableCharStack(40);
		
		for (int i = 0; i < INITIAL_STRING.length(); i++) {
			charStack.push(INITIAL_STRING.charAt(i));
		}
	}
	
	@Test
	public void testToString(){
		
		String actual = charStack.toString();
		
		assertEquals("String should be the same", FINAL_STRING, actual);
	}
	
	
}
