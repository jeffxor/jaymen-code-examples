package com.jaymen.test.classifier.compare;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import com.jaymen.test.classifier.model.Category;
import com.jaymen.test.classifier.model.CategoryScore;
import com.jaymen.test.classifier.model.Phrase;

public class CategoryScoreComparatorTest {
	
	private String economics = "economics";
	private String politics = "politics";
	
	private Category catEconomics;
	private Category catPolitics;
	
	private CategoryScore catScoreEconomics;
	private CategoryScore catScoreEconomics2;
	private CategoryScore catScorePolitics;
	
	@Before 
	public void initialize() {
		catEconomics = new Category();
		catEconomics.setName(economics);
		catEconomics.addPhrase(new Phrase(economics, new Integer(5)));
		
		catScoreEconomics = new CategoryScore(catEconomics,  new Integer(5));

		catScoreEconomics2 = new CategoryScore(catEconomics,  new Integer(10));

		catPolitics = new Category();
		catPolitics.setName(politics);
		catPolitics.addPhrase(new Phrase(politics, new Integer(5)));	
		
		catScorePolitics = new CategoryScore(catPolitics,  new Integer(5));
	}
	
	@After 
	public void cleanUp() {
	}
	
	@Test
	public void comparatorEquals(){
		Comparator<CategoryScore> comparator = new CategoryScoreComparator();
		assertEquals("The Same CategoryScore should return 0", 0, comparator.compare(catScoreEconomics, catScoreEconomics));		
	}
	
	@Test
	public void comparatorInteger(){
		Comparator<CategoryScore> comparator = new CategoryScoreComparator();
		assertEquals(1, comparator.compare(catScoreEconomics, catScoreEconomics2));		
	}
	
	@Test
	public void comparatorAlphabetiacl(){
		Comparator<CategoryScore> comparator = new CategoryScoreComparator();
		assertEquals(1, comparator.compare(catScorePolitics, catScoreEconomics));		
	}

}
