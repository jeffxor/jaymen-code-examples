package com.jaymen.test.masterlist.compare;

import java.util.Comparator;

import com.jaymen.test.masterlist.model.Person;

/**
 * Simple implementation of the Comparator interface.
 * It sorts the people by gender and last names
 * 
 * @author jeffxor
 *
 */
public class PersonGenderLastNameComparator implements Comparator<Person> {

	public int compare(Person o1, Person o2) {
		/*
		 * As we have used a enum the gender values are constant,
		 * so for simplicity we add these to the start of the lastnames
		 */
		String o1Val = o1.getGender() + o1.getLastName();
		String o2Val = o2.getGender() + o2.getLastName();

		return o1Val.compareTo(o2Val);
	}

}
