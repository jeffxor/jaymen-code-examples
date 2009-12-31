package com.jaymen.test.masterlist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.jaymen.test.masterlist.builder.PersonFactory;
import com.jaymen.test.masterlist.compare.PersonDOBComparator;
import com.jaymen.test.masterlist.compare.PersonGenderLastNameComparator;
import com.jaymen.test.masterlist.compare.PersonLastNameComparator;
import com.jaymen.test.masterlist.model.Person;

/**
 * Simple application that looks for the input files in the resources directory
 * of the jar file and then prints its results to the console.
 * 
 * @author jeffxor
 * 
 */
public class Main {

	public static void main(String[] args) throws IOException, Exception {
		List<Person> persons = new ArrayList<Person>();

		URL url = Main.class.getResource(File.separator + "input_files" + File.separator + "comma.txt");
		File commaFile = new File(url.getFile());
		url = Main.class.getResource(File.separator + "input_files"
				+ File.separator + "pipe.txt");
		System.out.println("url is " + url);
		System.out.println("url is " + url.getFile());
		File pipeFile = new File(url.getFile());
		url = Main.class.getResource(File.separator + "input_files"
				+ File.separator + "space.txt");
		File spaceFile = new File(url.getFile());

		// Load files into master list of persons
		addToMaterList(persons, commaFile);
		addToMaterList(persons, pipeFile);
		addToMaterList(persons, spaceFile);
		printResults(persons, System.out);

	}

	private static void addToMaterList(List<Person> master, File file)
			throws Exception {
		// Open the comma file for reading
		BufferedReader reader = new BufferedReader(new FileReader(file));

		String string;
		// Process each line in the comma file
		while ((string = reader.readLine()) != null) {
			// Get the correct factory and then add the person to the master
			// list
			PersonFactory factory = PersonFactory.getFactory(string);
			master.add(factory.createPerson(string));
		}
		// Should close underlying file references
		reader.close();

	}

	private static void printResults(List<Person> persons, PrintStream out) {
		Comparator<Person> dobComparator = new PersonDOBComparator();
		Comparator<Person> lastNameComparator = new PersonLastNameComparator();
		Comparator<Person> genderLastNameComparator = new PersonGenderLastNameComparator();

		out.println("Output 1:");
		Collections.sort(persons, genderLastNameComparator);
		for (Person person : persons) {
			out.println(person);
		}
		out.println();

		out.println("Output 2:");
		Collections.sort(persons, dobComparator);
		for (Person person : persons) {
			out.println(person);
		}
		out.println();

		out.println("Output 3:");
		Collections.sort(persons, lastNameComparator);
		for (Person person : persons) {
			out.println(person);
		}
		out.println();
	}

}
