package com.jaymen.tdd;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TemplatePerformanceTest {
	
	private Template template;

	@Before
	public void setUp() throws Exception {
		template = new Template("${one}, ${two}, ${three}");
		template.set("one", "1");
		template.set("two", "2");
		template.set("three", "3");
	}
	
	@Test
	public void templateWith100WordsAnd20Variables() throws Exception {
		long expected = 200L;
		long time = System.currentTimeMillis();
		template.evaluate();
		time = System.currentTimeMillis() - time;
		assertTrue("Rendering the template took " + time
				+ "ms while the target was " + expected + "ms",
				time <= expected);
	}
}
