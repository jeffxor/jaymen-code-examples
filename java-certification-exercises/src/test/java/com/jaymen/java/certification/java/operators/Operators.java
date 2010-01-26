package com.jaymen.java.certification.java.operators;

import org.junit.Test;

import static org.junit.Assert.*;

public class Operators {

	/**
	 * This is a question I continually got wrong.
	 * It test the difference between short cut logical
	 * operators and pre and post incrementors
	 */
	@Test
	public void ShortCircuitOperators() {
		int mask = 0;
		int count = 0;
		if( ((5<7) || (++count < 10)) | mask++ < 10 ) mask = mask + 1;
		if( (6 > 8) ^ false) mask = mask + 10;
		if( !(mask > 1) && ++count > 1) mask = mask + 100;

		assertEquals("mask" ,2, mask);
		assertEquals("count", 0, count);		
	}

	/**
	 * Test what happens with post incrementers in array references
	 */
	@Test
	public void postIncrementOperatorsArrayReference()  {
		int index = 1;
		int [][] dd = {{9,8,7}, {6,5,4}, {3,2,1,0}};
		assertEquals(4,dd[index++][index++]);
	}

	/**
	 * Test what happened in an assignment statement involving post-increment
	 */
	@Test
	public void postIncrementOperatorsInStatement()  {
		int x = 5;		
		assertEquals("Post increment in assigment statement",30,(x++)*x);
	}

	/**
	 * Test what happened in an assignment statement involving pre-increment
	 */
	@Test
	public void preIncrementOperatorsInStatement()  {
		int x = 5;		
		assertEquals("Pre increment in assigment statement",36,(++x)*x);
	}

	/**
	 * Test whether weird syntax code actually compiles
	 */
	@Test
	public void testThisCompiles()  {
		assertEquals(true, true);
		Object o = new char[0][];
		if (true | true) {
			for (;;)break;
		} else if (false & false) {
			do; while (false);
		}
		ftp://ftp.foo.com
			while (true)break;
	}

	/**
	 * Test the assignment of a char to an int and then to a string
	 */
	@Test
	public void testCharToIntAssignment(){
		int $ = '$';
		String actual = "" + ('$' + $);
		assertEquals("72", actual);
	}

	/** 
	 * Test float division by zero.
	 * If one operand is a float then we use float arithmetic.
	 */
	@Test
	public void testFloatDivisionByZero(){
		int myInt = 0;
		float myFloat = 0;

		float result =  myInt / myFloat;

		assertEquals("float divsion by zero is nan", Float.NaN, result, 0.0);
	}

	/**
	 * Test the labeled continue statement
	 */
	@Test
	public void testLabeledContinue(){
		int i=0,j=0;
		a:
			for (i=0;i<10 ;i++ ){
				for (j=0;j<10 ;j++ ){
					continue a;
				}
			}
		assertEquals("i is 10",10, i);
		assertEquals("j is 0" ,0, j);
	}

	/**
	 * Test if we can compare ints to doubles and what happens
	 */
	@Test
	public void testIntToDoubleComparison(){
		int i = 6;
		double d = 7.7;
		assertEquals(d, (i < d) ? d : i, 0);
	}
	
}
