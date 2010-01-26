package com.jaymen.tdd.model;

import java.util.Map;


public class PlainText implements Segment {

	private String text;

	public PlainText(String text) {
		this.text = text;
	}

	@Override
	public boolean equals(Object other) {
		return text.equals(((PlainText) other).text);
	}
	
	@Override
	public int hashCode() {
		return this.text.hashCode();
	}

	@Override
	public String evaluate(Map<String, String> variables) {
		return text;
	}
}
