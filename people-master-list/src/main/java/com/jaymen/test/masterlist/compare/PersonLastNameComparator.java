package com.jaymen.test.masterlist.compare;

import java.util.Comparator;

import com.jaymen.test.masterlist.model.Person;

/**
 * Simple implementation of the comparator interface
 * This implementation sort person according to their last names
 * descending.
 * 
 * @author jeffxor
 *
 */
public class PersonLastNameComparator implements Comparator<Person> {

	public int compare(Person arg0, Person arg1) {
		//Simply invert the results of sting compare to get the reverse order required
		return arg0.getLastName().compareTo(arg1.getLastName()) * -1;
	}

}
