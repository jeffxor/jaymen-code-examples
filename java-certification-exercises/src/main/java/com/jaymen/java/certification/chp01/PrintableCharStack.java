package com.jaymen.java.certification.chp01;

public class PrintableCharStack extends CharStack {

	// Instance method
	public void printStackElements() { // (2)
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		
		for (int i = 0; i <= topOfStack; i++){
			stringBuffer.append(stackArray[i]);
		}
		
		return stringBuffer.toString();
	}

	// Constructor calls the constructor of the superclass explicitly.
	PrintableCharStack(int capacity) { super(capacity); } // (3)
}
