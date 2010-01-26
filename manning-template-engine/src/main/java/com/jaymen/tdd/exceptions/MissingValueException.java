package com.jaymen.tdd.exceptions;

public class MissingValueException extends Exception {

	private static final long serialVersionUID = 1L;

	public MissingValueException(String string) {
		super(string);
	}
}
