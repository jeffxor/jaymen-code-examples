package com.jaymen.java.certification.java.exceptions;

import org.junit.Test;

import com.jaymen.java.certification.java.util.SubToDos;
import com.jaymen.java.certification.java.util.ToDos;

import static org.junit.Assert.*;

public class ClassCastExceptionTest {


	/**
	 * Test to show class cast exception is thrown when 
	 * incorrectly downcasting.
	 */
	@Test(expected=ClassCastException.class)
	public void testClassCastWithInheritance(){
		ToDos dos = new ToDos("Monday");
		
		SubToDos subToDos = (SubToDos)dos;
		subToDos.go(5, 10);

	}
	
	/**
	 * Test to show that overriding only exits for methods.
	 * Here we can not call overload methods through incorrect reference.
	 */
	@Test
	public void testOverloadVsOverride(){
		ToDos dos = new SubToDos("Monday");
		
		assertEquals("SubToDo Drive", dos.drive());
		//Compilation error due to overload method not existing in the Super class
		//assertEquals("SubToDo Drive", dos.drive("Test")); 
	}	
	/**
	 * Test to check what gets returned when a method has a
	 * return statement in both the try and finally block.
	 */
	@Test
	public void testFinallyReturn(){
		assertEquals("Finally return should take precedence","BABE", finallyReturn());
		
	}
	
	/**
	 * Method to test what gets return from a try catch block
	 * @return a string
	 */
	@SuppressWarnings("finally")
	public String finallyReturn(){
		try { 
            return "CAFE"; 
        } catch (Exception e) { 
            // .. 
        } finally{ 
            return "BABE"; 
        } 
	}
}
