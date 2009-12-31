package com.jaymen.test.masterlist.builder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jaymen.test.masterlist.model.Gender;
import com.jaymen.test.masterlist.model.Person;

/**
 * This class follows the abstract Factory Pattern. 
 * It takes a string and determines what Factory 
 * should be used to turn the string into a person. 
 * 
 * @author jeffxor
 *
 */
public abstract class PersonFactory {

	/**
	 * This method checks for a delimiter in the string and determines
	 * what is the best factory. It is a simple implementation and does not
	 * handle instances where two delimiters appear in the same string. 
	 * In this case the order of if statements determines the factory returned.
	 * 
	 * @param string to turn into a person
	 * @return A concrete implementation of PersonFactory that will be able to handle the string.
	 * @throws Exception If a factory can not be found to handle the string
	 */
    public static PersonFactory getFactory(String string) throws Exception {
        
    	//Order here is important as some string contain both delimiters
        if (string.contains("|")) {
            return new PipePersonFactory();
        } 
        else if (string.contains(",")){
            return new CommaPersonFactory();
        }
        else if (string.contains(" ")){
            return new SpacePersonFactory();
        }
        
        throw new Exception("No Factory could be found for this string");
    }
    
    /**
     * Handles the construction of Person object based of a String
     * 
     * @param string to turn into a person
     * @return Person constructed from the String parameter
     */
    public abstract Person createPerson(String string);
    
	/**
	 * Performs the parsing of a string according to set and returns a Date object
	 * 
	 * @param  date
	 * @return Date constructed using the string param
	 */
	protected Date parseDate(String date){
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date dob = null;
		try {
			dob = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dob;
	}
    
    /**
     * Parses a string and determines the Gender
     * 
     * @param gender string that may contain a certain sex.
     * @return Gender
     */
	protected Gender parseGender(String gender){
		if("M".equals(gender) || "Male".equalsIgnoreCase(gender)) return Gender.Male;
		else if("F".equals(gender) || "Female".equalsIgnoreCase(gender)) return Gender.Female;
		else return null;
	}

}
