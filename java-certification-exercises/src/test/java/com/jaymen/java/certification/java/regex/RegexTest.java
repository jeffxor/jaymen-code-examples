package com.jaymen.java.certification.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import static org.junit.Assert.*;
public class RegexTest {

	/**
	 * Test of the greedy matching regexs
	 */
	@Test 
	public void testRegexGreedy(){
		 
		Pattern p = Pattern.compile("\\d*");
		Matcher m = p.matcher("ab34ef");
		String matches = "";
		while(m.find()) {
			matches += (m.start() + m.group());
		}
		
		assertEquals("01234456", matches);
	}
}
