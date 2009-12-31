package com.jaymen.test.masterlist.model;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {
	
	private String testString = "Hingis Martina Female 4/2/1979 Green";
	
	private String lastName = "Hingis";
	private String firstName = "Martina";
	private String color = "Green";
	private Date dob = (new GregorianCalendar(1979, Calendar.APRIL, 2)).getTime();
	
	Person person;
	
	@Before
	public void setUp() throws Exception {

		person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setGender(Gender.Female);
		person.setDob(dob);
		person.setColor(color);
	}
	@Test
	public void testPersonToString(){
		assertEquals(testString, person.toString());
	}
}
