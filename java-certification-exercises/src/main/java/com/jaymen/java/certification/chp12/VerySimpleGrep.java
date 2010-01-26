package com.jaymen.java.certification.chp12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerySimpleGrep {
	public static void main(String[] args) throws IOException {
		// Test file
		FileWriter fw = new FileWriter("test.txt");
		fw.write("To be or not to be.\n");
		fw.write("Only A's, no B's.\n");
		fw.write("A bee movie is not funny.\n");
		fw.write("Bessy was a beautiful beatnik from Bern.\n");
		fw.close();
		String fileName = "test.txt";
		String regexStr = "[bB]e";
		grepFile(fileName, regexStr);
	}
	
	/**
	 * Finds and prints matches for the regex in the text file.
	 * @param fileName
	 * @param regex
	 * @throws IOException
	 */
	public static void grepFile(String fileName, String regex) throws IOException {
		Pattern pattern = Pattern.compile(regex);
		BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
		
		String strLine;
		int lineNumber = 0;
	    //Read File Line By Line
	    while ((strLine = bufferedReader.readLine()) != null)   {
	    	lineNumber++;
	    	List<String> matchs = grepLine(pattern, strLine);
	    	if(matchs.size() > 0){
	    		System.out.println(lineNumber + " : " + matchs);
	    	}
		}
		bufferedReader.close();
	}
	/**
	 * Finds the matches for the pattern in the target.
	 * @param pattern
	 * @param target
	 * @return List<String> with the matches found in the target
	 */
	public static List<String> grepLine(Pattern pattern, String target) {
		Matcher matcher = pattern.matcher(target);
		List<String> matchs = new LinkedList<String>();
		while (matcher.find()) {
			int startCharIndex = matcher.start();
			int lastPlus1Index = matcher.end();
			int lastCharIndex = startCharIndex == lastPlus1Index ?
			lastPlus1Index : lastPlus1Index-1;
			String matchedStr = matcher.group();
			matchs.add("(" + startCharIndex + "," + lastCharIndex + ":" + matchedStr + ")");
		}
		
		return matchs;
	}
}
