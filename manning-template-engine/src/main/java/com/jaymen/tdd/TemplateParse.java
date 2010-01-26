package com.jaymen.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jaymen.tdd.model.PlainText;
import com.jaymen.tdd.model.Segment;
import com.jaymen.tdd.model.Variable;

public class TemplateParse {

	private List<String> parse(String template) {
		List<String> segments = new ArrayList<String>();
		int index = collectSegments(segments, template);
		addTail(segments, template, index);
		addEmptyStringIfTemplateWasEmpty(segments);
		return segments;
	}

	private int collectSegments(List<String> segs, String src) {
		Pattern pattern = Pattern.compile("\\$\\{[^}]*\\}");
		Matcher matcher = pattern.matcher(src);
		int index = 0;
		while (matcher.find()) {
			addPrecedingPlainText(segs, src, matcher, index);
			addVariable(segs, src, matcher);
			index = matcher.end();
		}
		return index;
	}

	private static boolean isVariable(String segment) {
		return segment.startsWith("${") && segment.endsWith("}");
	}
	
	private void addTail(List<String> segs, String template, int index) {
		if (index < template.length()) {
			segs.add(template.substring(index));
		}
	}

	private void addVariable(List<String> segs, String src,Matcher m) {
		segs.add(src.substring(m.start(), m.end()));
	}

	private void addPrecedingPlainText(List<String> segs, String src,
			Matcher m, int index) {
		if (index != m.start()) {
			segs.add(src.substring(index, m.start()));
		}
	}

	private void addEmptyStringIfTemplateWasEmpty(List<String> segs) {
		if (segs.isEmpty()) {
			segs.add("");
		}
	}

	public List<Segment> parseSegments(String template) {
		List<Segment> segments = new ArrayList<Segment>();
		List<String> strings = parse(template);
		for (String s : strings) {
			if (isVariable(s)) {
				String name = s.substring(2, s.length() - 1);
				segments.add(new Variable(name));
			} else {
				segments.add(new PlainText(s));
			}
		}
		return segments;
	}
}
