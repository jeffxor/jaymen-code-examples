package com.jaymen.java.certification.java.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Test;


import static org.junit.Assert.*;

public class CollectionsTest {

	/**
	 * Test what happens to maps when equal is not implmented
	 */
	@Test
	public void testNonImplementedEquals(){
		Map<ToDos, String> map = new java.util.HashMap<ToDos, String>();
		ToDos toDos1 = new ToDos("Monday");
		ToDos toDos2 = new ToDos("Monday");
		ToDos toDos3 = new ToDos("Tuesday");
		
		map.put(toDos1, "laundry");
		map.put(toDos2, "shooping");
		map.put(toDos3, "homework");
		
		assertEquals(3, map.size());
	}
	
	/**
	 * Test what process is used to determine method called
	 * when vargs are used.
	 */
	@Test
	public void testVargs(){
		ToDos toDos = new ToDos("Monday");
		
		assertEquals(2, toDos.go(9, 27));
		assertEquals(1, toDos.go(9));
	}
	
	/** 
	 * Test what happens when trying to sort unrelated types.
	 */
	@Test(expected=ClassCastException.class)
	public void testCollectionSortLongValue(){
		List list = new ArrayList();
		
		list.add(5);
		list.add(new Integer(42));
		list.add(new Integer("17"));
		list.add(new Integer("812").longValue());
		
		java.util.Collections.sort(list);
						
		assertEquals("[5, 17, 42, 812]", list.toString());
	}
	
	/** 
	 * Here we see that autoboxing is used in collections.
	 */
	@Test
	public void testCollectionSort(){
		List list = new ArrayList();
		
		list.add(5);
		list.add(new Integer(42));
		list.add(new Integer("17"));
		list.add(Integer.parseInt("812"));
		
		java.util.Collections.sort(list);
						
		assertEquals("[5, 17, 42, 812]", list.toString());
	}

	/**
	 * Test what happens when adding unrelated types to a treeset.
	 * Remember that tree set are sorted
	 */
	@Test(expected=ClassCastException.class)
	public void testTreeSetCollection(){
		Set set = new TreeSet();
		
		set.add("2");
		set.add(3);
		set.add("1");

		
		assertEquals("[1, 2, 3]", set.toString());
	}
	
	/**
	 * Test what happens when adding unrelated types to a tree set.
	 * Remember that tree set are sorted
	 */
	public void testGenericTreeSetCollection(){
		Set<String> set = new TreeSet<String>();
		
		set.add("2");
		//set.add(3); //This is picked up by the compiler!
		set.add("1");
		
		assertEquals("[1, 2]", set.toString());
	}
	/**
	 * This was to test an question in a mock exam.
	 * I proved to myself I was correct and that the exam
	 * was incorrect.
	 */
	public void testTreeSet(){
		TreeMap<String, String> myMap = new TreeMap<String, String>();
		myMap.put("a", "apple"); 
		myMap.put("d", "date");
		myMap.put("f", "fig"); 
		myMap.put("p", "pear");
		
		assertEquals("d", myMap.higherKey("f"));
		assertEquals("f", myMap.ceilingKey("f"));
		assertEquals("f", myMap.floorKey("f"));
				
		SortedMap<String, String> sub = new TreeMap<String, String>();
		sub = myMap.tailMap("f");
		
		assertEquals("f", sub.firstKey());
	}
}

