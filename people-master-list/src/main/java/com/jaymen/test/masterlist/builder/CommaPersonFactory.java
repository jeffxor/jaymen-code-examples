package com.jaymen.test.masterlist.builder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jaymen.test.masterlist.model.Person;

/**
 * Constructs a person from a string with fields delimited
 * with pipes and fields in the following format.
 * 
 * Last Name, First Name, Gender, Favorite Color, Date Of Birth
 * 
 * @author jeffxor
 *
 */
public class CommaPersonFactory extends PersonFactory {

	@Override
	public Person createPerson(String string) {
		Person person = new Person();
		
		String [] tokens = string.split(",");
		if(tokens != null){
			person.setLastName(tokens[0].trim());
			person.setFirstName(tokens[1].trim());
			person.setGender(parseGender(tokens[2].trim()));
			person.setColor(tokens[3].trim());
			person.setDob(parseDate(tokens[4].trim()));
		}
		
		return person;
	}
	
	protected Date parseDate(String date){
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date dob = null;
		try {
			dob = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dob;
	}
	

}
