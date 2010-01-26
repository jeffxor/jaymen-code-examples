package com.jaymen.tdd.model;

import java.util.Map;

import com.jaymen.tdd.exceptions.MissingValueException;

public interface Segment {
	String evaluate(Map<String, String> variables) throws MissingValueException;
}
