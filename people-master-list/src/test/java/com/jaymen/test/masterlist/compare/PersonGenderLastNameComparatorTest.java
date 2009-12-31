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

public class PersonGenderLastNameComparatorTest {
	
	Person malePerson1;	
	Person malePerson2;
	Person femalePerson1;
	
	private String maleFirstName = "Jeffrey";
	private String maleLastName = "Alpha";
	private String maleFirstName2 = "Jeffrey";
	private String maleLastName2 = "Zoo";
	private String femaleFirstName = "Alsion";
	private String femaleLastName = "Alpha";
	private String middleInitial = "J";
	private String color = "tan";
	private Date dob = (new GregorianCalendar(1943, Calendar.MARCH, 16)).getTime();
	
	 
	@Before
	public void setUp() throws Exception {
		malePerson1 = new Person();
		
		malePerson1.setColor(color);
		malePerson1.setDob(dob);
		malePerson1.setFirstName(maleFirstName);
		malePerson1.setLastName(maleLastName);
		malePerson1.setMiddleInitial(middleInitial);
		malePerson1.setGender(Gender.Male);

		malePerson2 = new Person();
		
		malePerson2.setColor(color);
		malePerson2.setDob(dob);
		malePerson2.setFirstName(maleFirstName2);
		malePerson2.setLastName(maleLastName2);
		malePerson2.setMiddleInitial(middleInitial);
		malePerson2.setGender(Gender.Male);
		
		femalePerson1 = new Person();
		
		femalePerson1.setColor(color);
		femalePerson1.setDob(dob);
		femalePerson1.setFirstName(femaleFirstName);
		femalePerson1.setLastName(femaleLastName);
		femalePerson1.setMiddleInitial(middleInitial);
		femalePerson1.setGender(Gender.Female);
		
	
	}
	@Test
	public void testCoamparatorEquals(){
		Comparator<Person> comparator = new PersonGenderLastNameComparator();
		assertEquals("The Same Person should return 0", 0, comparator.compare(malePerson1, malePerson1));
	}
	@Test
	public void testMaleGreaterThanFemale(){
		Comparator<Person> comparator = new PersonGenderLastNameComparator();
		assertTrue("Male should be greater than female", comparator.compare(malePerson1, femalePerson1) > 0);
	}
	@Test
	public void testFemaleLessThanMale(){
		Comparator<Person> comparator = new PersonGenderLastNameComparator();
		assertTrue("Female should be less than male", comparator.compare(femalePerson1, malePerson1) < 0);
	}
	@Test
	public void testSameSexDifferentLastNames(){
		Comparator<Person> comparator = new PersonGenderLastNameComparator();
		assertTrue("Alpha should be less than Zoo", comparator.compare(malePerson1, malePerson2) < 0);		

		assertTrue("Zoo should be less than Alpha", comparator.compare(malePerson2, malePerson1) > 0);		
	}

}
