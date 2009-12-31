/**
 * 
 */
package com.jaymen.test.classifier.builder;

import com.jaymen.test.classifier.model.Category;
import com.jaymen.test.classifier.model.Phrase;

/**
 * @author jeffxor
 *
 */
public class CsvCategoryBuilder extends CategoryBuilder {

	/* (non-Javadoc)
	 * @see com.jaymen.test.classifier.builder.CategoryBuilder#createCategory(java.lang.String)
	 */
	@Override
	public Category createCategory(String string) {
		Category category = new Category();
		
		String [] tokens = string.split(",");
		if(tokens != null){
			category.setName(tokens[1].trim());
			category.addPhrase(new Phrase(tokens[0].trim(), new Integer(tokens[2].trim())));
		}
		
		return category;
	}

}
