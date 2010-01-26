package com.jaymen.java.certification.java.operators;


import org.junit.Test;

import static org.junit.Assert.*;

public class BitWise {

	/**
	 * Test to confirm what is assignable to what primitives.
	 * Also displays what requires an explicit cast.
	 */
	@Test
	public void testAssignent(){
		short s = 2;
		byte b = 3;
		int i = 1;
		char c = 'c';

		//Assign short to int
		i = s;
		//Assign byte to int
		i = b;
		//Assign char to int
		i = c;
		//Assign byte to short
		s = b;
		//b = c; Assign char to byte requires explicit cast
		b = (byte)c;
		//s = c; Assign char to short requires explicit cast
		s = (short)c;
		//c = s; Assign short to char requires explicit cast
		c = (char)s;
	}
	
	/**
	 * Simple Test for the logical or operator
	 * 
	 */
	@Test
	public void testLogicalOr(){
		assertEquals("logical or",7, (5 | 7));
	}	
	
	/**
	 * Simple Test for the logical and operator
	 */	
	@Test
	public void testLogicalAnd(){
		assertEquals("logical and",5, (5 & 7));
	}

	/**
	 * Simple Test for the logical Xor operator
	 */	
	@Test
	public void testLogicalXor(){
		assertEquals("logical Xor",2, (5 ^ 7));
	}

	/**
	 * Simple Test for the logical Negate operator
	 */	
	@Test
	public void testLogicalNegate(){
		assertEquals("logical negate",-8, (~7));
	}

	/**
	 * Simple Test for the signed right shift operator
	 */	
	@Test
	public void testSignedRightShift(){
		assertEquals("signed right shift",1, 7>>2);
	}

	/**
	 * Simple Test for the signed left shift operator
	 */	
	@Test
	public void testSignedLeftShift(){
		assertEquals("signed left shift",28, 7<<2);
	}

	/**
	 * Simple Test for the unsigned right shift operator
	 */	
	@Test
	public void testUnsignedRightShift(){
		assertEquals("unsigned right shift", 1073741822, -7>>>2);
		
	}

	/**
	 * Test for a question I got wrong. This is a combination of
	 * bit wise and logical operators.
	 */	
	@Test
	public void testBitWise(){
		int x = 1;
		if((4 > x) ^ ((++x +2) > 3)) x++;
		if((4 > ++x) ^ !(++x ==5 )) x++;
		
		assertEquals(4, x);		
	}
	
	/**
	 * Test for a question I got wrong. What happens if we are
	 * using the unsigned shift on a negative number
	 */	
	@Test
	public void testNegativeUnsignedShift(){
		int a =  -8;
	    int b = ~ -33;
	    a>>>=b;
		
		assertEquals(-8, a);
		
	}
	
	/**
	 * Test the overridden compareTo method for Bytes
	 */
	@Test
	public void testByteComparison(){
		byte a = 10;
        Byte b    = new Byte(a);
        Byte c    = new Byte((byte) 11);
        
		assertEquals(-1, b.compareTo(c));
		
	}
	
	/**
	 * Test the overridden equals method for Integer. Here
	 * we prove that we can compare and Integer to a Float.
	 */	
	@Test
	public void testNumberFloatEquality(){
		//Number n = new Number(16);
		Integer i = new Integer(16);
	    Float f  = new Float(16);
		
		assertEquals(false, i.equals(f));
		
	}
}
