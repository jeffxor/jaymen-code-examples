package org.jeffxor.problem1;


import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;



public class MissingLetters {
	
	private static final List<Character> alphabet = new ArrayList<Character>();
	static {
		//Build Set of control characters to test against
		for(int i= 97; i<= 122; i++){
			alphabet.add((char)i);
		}		
	}

	public String getMissingLetters(String testString) {
		
		List<Character> notSeenAlphabet = new ArrayList<Character>(alphabet);

		if(!StringUtils.isBlank(testString)){
			StringReader reader = new StringReader(testString);
			try{
				int data = reader.read();				
				while (data != -1) {					
					Character testChar =  Character.toLowerCase(new Character((char)data));
					if(isAsciiAlpha(testChar)){
						notSeenAlphabet.remove(testChar);
						if(notSeenAlphabet.isEmpty()){
							break;
						}
					}
					data = reader.read();
				}
			}
			catch(IOException exception){
				//Probably want to think a little more about this
				exception.printStackTrace();
			}
			finally{
				reader.close();
			}
		}
		
		return listToString(notSeenAlphabet);
	}
	
	/**
	 * Checks the charcter code if it is between 97-122 lowecase
	 * 0r between 65-90 uppercase. As we may get non ASCII chararters this is 
	 * safer than use something like isAlpha.
	 * 
	 * @param character
	 * @return True if this is an ASCII charater [A-Za-z]
	 */
	private boolean isAsciiAlpha(Character character){
		if((97<= (int)character && (int)character <= 122) || (65<= (int)character && (int)character <= 90)){
			return true;
		}
		return false;
	}
	
	/**
	 * Simple conversion of a list to string with no seperator.
	 * 
	 * @param list
	 * @return Returns all object as string using .toString() and no seperator.
	 */
	private String listToString(List<?> list){
		StringBuffer buffer = new StringBuffer();
		
		for(Object object : list){
			buffer.append(object.toString());
		}
		return buffer.toString();
	}

}
