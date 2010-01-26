package com.jaymen.tdd.model;

import java.util.Map;

import com.jaymen.tdd.exceptions.MissingValueException;


public class Variable implements Segment {
	private String name;

	public Variable(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object other) {
		return name.equals(((Variable) other).name);
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public String evaluate(Map<String, String> variables) throws MissingValueException {
		if (!variables.containsKey(name)) {
			throw new MissingValueException("No value for ${" + name + "}");
		}
		return variables.get(name);
	}
}
