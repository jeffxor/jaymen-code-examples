package com.jaymen.tdd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jaymen.tdd.exceptions.MissingValueException;
import com.jaymen.tdd.model.Segment;

public class Template {
	private Map<String, String> variables;
	private String templateText;

	public Template(String templateText) {
		this.variables = new HashMap<String, String>();
		this.templateText = templateText;
	}

	public void set(String variable, String value) {
		this.variables.put(variable, value);
	}

	public String evaluate() throws MissingValueException {
		TemplateParse parser = new TemplateParse();
		List<Segment> segments = parser.parseSegments(templateText);
		return concatenate(segments);
	}

	private String concatenate(List<Segment> segments) throws MissingValueException {
		StringBuilder result = new StringBuilder();
		for (Segment segment : segments) {
			result.append(segment.evaluate(variables));
		}
		return result.toString();
	}
	


}
