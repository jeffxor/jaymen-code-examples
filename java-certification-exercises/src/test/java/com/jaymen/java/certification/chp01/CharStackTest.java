package com.jaymen.java.certification.chp01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jaymen.java.certification.chp01.CharStack;

public class CharStackTest {
	private final String INITIAL_STRING = "!no tis ot nuf era skcatS";
	private final String FINAL_STRING = "Stacks are fun to sit on!";
	CharStack charStack;
	
	@Before
	public void loadCharStack(){
		charStack = new CharStack(40);
		
		for (int i = 0; i < INITIAL_STRING.length(); i++) {
			charStack.push(INITIAL_STRING.charAt(i));
		}
	}
	
	@Test 
	public void testPop(){
		StringBuffer stringBuffer = new StringBuffer();
		while (!charStack.isEmpty()) {
			stringBuffer.append(charStack.pop());
		}
		assertEquals("String should be equal", FINAL_STRING, stringBuffer.toString());
	}
	
}
