package com.jaymen.test.masterlist.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.jaymen.test.masterlist.model.Gender;
import com.jaymen.test.masterlist.model.Person;

public class CommaPersonBuilderTest {
	
	private String firstName = "Jeffrey";
	private String lastName = "Williams";
	private String gender = "Male";
	private String color = "tan";
	private String dob = "02/13/1943";
	//Last Name, First Name, Gender, Favourite Colour, Date Of Birth
	private String testString = lastName + ", " + firstName  + ", " + gender + ", " + color + ", " + dob;
	
	Person person;
	
	@Before
	public void setUp() throws Exception {
		PersonFactory builder = new CommaPersonFactory();
		person = builder.createPerson(testString);
	}
	@Test
	public void testCreatePerson(){
		assertNotNull("Should recieve object back", person);
	}
	@Test
	public void testFirstName(){
		assertEquals("Should have set the same string", firstName, person.getFirstName());
	}
	@Test
	public void testLastName(){
		assertEquals("Should have set the same string", lastName, person.getLastName());
	}
	@Test
	public void testMiddleInitial(){
		assertNull("Should be null", person.getMiddleInitial());
	}
	@Test
	public void testGender(){
		assertEquals("Should have set the same string", Gender.Male, person.getGender());
	}
	@Test
	public void testColor(){
		assertEquals("Should have set the same string", color, person.getColor());
	}
	@Test
	public void testDOB() throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date testDate = format.parse(dob);
		assertEquals("Should have set the same string", testDate, person.getDob());
	}
}
