package com.jaymen.test.classifier.builder;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jaymen.test.classifier.model.Category;
import com.jaymen.test.classifier.model.Phrase;


public class CsvCategoryBuilderTest {
	
	private String csv = "money, economics, 5";
	private CsvCategoryBuilder builder;
	
	@Before 
	public void initialize() {
		builder = new CsvCategoryBuilder();
	}
	
	@After 
	public void cleanUp() {
	}
	
	@Test
	public void createCategory(){
		Category category = builder.createCategory(csv);
		assertEquals("Test category name", "economics", category.getName());
		
		Set<Phrase> phrases = category.getPhrases();
		assertFalse("Test that we have phrases", phrases.isEmpty());
		assertEquals(1, phrases.size());
		
		for(Phrase phrase : phrases){
			assertEquals("money", phrase.getPhrase());
			assertEquals(new Integer(5), phrase.getWeight());
		}
		
	}

}

