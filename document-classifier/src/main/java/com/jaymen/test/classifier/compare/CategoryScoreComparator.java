package com.jaymen.test.classifier.compare;

import java.util.Comparator;

import com.jaymen.test.classifier.model.CategoryScore;

/**
 * Simple implementation of comparator to allow for sorting of CategoryScores.
 * 
 * It appears that the list of categories need to be first sorted by thier score and then 
 * alphabetically by their category name.
 * 
 * 
 * @author jeffxor
 *
 */
public class CategoryScoreComparator implements Comparator<CategoryScore> {

	/**
	 * Simple uses the Integer compareTo for scores and the the String compareTo
	 * method for names if scores are equal.
	 */
	public int compare(CategoryScore arg0, CategoryScore arg1) {
		int compare = arg1.getScore().compareTo(arg0.getScore());
		if(compare == 0){
			int nameCompare = arg1.getCategory().getName().compareTo(arg0.getCategory().getName());
			if(nameCompare < 0) compare = 1;
			if(nameCompare > 0) compare = -1;
		}
		return compare;
		
	}

}
