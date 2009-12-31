package com.jaymen.test.classifier.builder;

import com.jaymen.test.classifier.model.Category;

public abstract class CategoryBuilder {
	
    /**
     * Handles the construction of Category object based of a String
     * 
     * @param string to turn into a Category
     * @return Category constructed from the String parameter
     */

	public abstract Category createCategory(String string);

}
