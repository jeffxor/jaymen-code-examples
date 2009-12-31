package com.jaymen.test.masterlist.compare;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import com.jaymen.test.masterlist.model.Gender;
import com.jaymen.test.masterlist.model.Person;

public class PersonLastNameComparatorTest {
	
	Person person1;//Should be smaller than person2
	Person person2;
	
	private String firstName = "Jeffrey";
	private String lastName = "Alpha";
	private String lastName2 = "Williams";
	private String middleInitial = "J";
	private Gender gender = Gender.Male;
	private String color = "tan";
	private Date dob = (new GregorianCalendar(1943, Calendar.MARCH, 16)).getTime();
	
	 
	@Before
	public void setUp() throws Exception {
		person1 = new Person();
		
		person1.setColor(color);
		person1.setDob(dob);
		person1.setFirstName(firstName);
		person1.setLastName(lastName);
		person1.setMiddleInitial(middleInitial);
		person1.setGender(gender);
		
		person2 = new Person();
		
		person2.setColor(color);
		person2.setDob(dob);
		person2.setFirstName(firstName);
		person2.setLastName(lastName2);
		person2.setMiddleInitial(middleInitial);
		person2.setGender(gender);		
	}
	@Test
	public void testCoamparatorEquals(){
		Comparator<Person> comparator = new PersonLastNameComparator();
		assertEquals("The Same Person shoudl return 0", 0, comparator.compare(person1, person1));
	}
	@Test
	public void testStringLessThan(){
		assertTrue("Expect Aplha to be less than Williams",  lastName.compareTo(lastName2) < 0);
	}
	@Test
	public void testStringGreaterThan(){
		assertTrue("Expect person2 to be greater than person1", lastName2.compareTo(lastName) > 0);
	}
	@Test
	public void testCoamparatorGreaterThan(){
		Comparator<Person> comparator = new PersonLastNameComparator();
		assertTrue("Expect person1 to be less than person2",  comparator.compare(person1, person2) > 0);
	}
	@Test
	public void testCoamparatorLessThan(){
		Comparator<Person> comparator = new PersonLastNameComparator();
		assertTrue("Expect person2 to be greater than person1", comparator.compare(person2, person1) < 0);
	}

}
