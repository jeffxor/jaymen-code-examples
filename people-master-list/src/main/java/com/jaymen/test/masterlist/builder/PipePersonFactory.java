package com.jaymen.test.masterlist.builder;

import com.jaymen.test.masterlist.model.Person;

/**
 * Constructs a person from a string with fields delimited
 * with pipes and fields in the following format.
 * 
 * Last Name, First Name, MiddleInitial, Gender, Favorite Color, Date Of Birth
 * 
 * @author jeffxor
 *
 */
public class PipePersonFactory extends PersonFactory {
	
	@Override
	public Person createPerson(String string) {
		Person person = new Person();
		String [] tokens = string.split("\\|");
		if(tokens != null){
			person.setLastName(tokens[0].trim());
			person.setFirstName(tokens[1].trim());
			person.setMiddleInitial(tokens[2].trim());
			person.setGender(parseGender(tokens[3].trim()));
			person.setColor(tokens[4].trim());
			person.setDob(parseDate(tokens[5].trim()));
		}
		return person;
	}

}
