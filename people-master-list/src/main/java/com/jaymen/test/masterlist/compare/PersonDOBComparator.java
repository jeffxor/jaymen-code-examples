package com.jaymen.test.masterlist.compare;

import java.util.Comparator;

import com.jaymen.test.masterlist.model.Person;

/**
 * Simple implementation of Comparator to sort Persons according to their dob.
 * 
 * This instructions given simple to sort them by dob, however in the results supplied
 * persons with the same dob are sorted by the last names. This implementation also provides
 * this feature
 * 
 * @author jeffxor
 *
 */
public class PersonDOBComparator implements Comparator<Person> {

	public int compare(Person o1, Person o2) {
		int val = o1.getDob().compareTo(o2.getDob());
		
		if(val == 0){
			//If dobs are the same order by last name.
			int lnVal = o1.getLastName().compareTo(o2.getLastName());
			if(lnVal < 0) val = -1;
			if(lnVal > 0) val = 1;
		}

		return val;
	}

}
