package com.jaymen.tdd;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.jaymen.tdd.model.PlainText;
import com.jaymen.tdd.model.Segment;
import com.jaymen.tdd.model.Variable;

public class TemplateParseTest {

	@Test
	public void parsingTemplateIntoSegmentObjects() throws Exception {
		TemplateParse p = new TemplateParse();
		List<Segment> segments = p.parseSegments("a ${b} c ${d}");
		assertSegments(segments,
				new PlainText("a "), new Variable("b"),
				new PlainText(" c "), new Variable("d"));
	}	

	private void assertSegments(List<? extends Object> actual, Object... expected) {
		assertEquals("Number of segments doesn't match.", expected.length, actual.size());
		assertEquals(Arrays.asList(expected), actual);
	}
}
