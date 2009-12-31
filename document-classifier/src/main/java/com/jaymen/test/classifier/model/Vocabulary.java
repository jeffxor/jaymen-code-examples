package com.jaymen.test.classifier.model;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

/**
 * This class models the vocabulary. A vocabulary consists of a
 * set of categories and it's associated phrases. 
 * 
 * This class provides methods to deal with loading and using the
 * vocabulary.
 * 
 * @author jeffxor
 *
 */

public class Vocabulary {
	
	private Map<String, Category> categories;
		
	public Vocabulary() {
		this.categories = new HashMap<String, Category>();
	}

	public Category getCategory(String name){
		return this.categories.get(name);
	}
	
	/**
	 * Adds a new category in to the vocabulary
	 * @param category
	 */
	public void addCategory(Category category){
		this.categories.put(category.getName(), category);
	}
	
	/**
	 * Retrieves a collection of Categories contained with in the
	 * vocabulary.
	 * @return
	 */
	public Collection<Category> getCategories(){
		return this.categories.values();
	}
	
	/**
	 * Tests whether the vocabulary already contains a category
	 * 
	 * @param category
	 * @return
	 */
	public boolean categoryExists(Category category){
		return categories.containsKey(category.getName());
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for(Category category : getCategories()){
			buffer.append("Category Name : ").append(category.getName()).append("\n");
			for(Phrase phrase : category.getPhrases()){
				buffer.append("\tPhrase : ").append(phrase.getPhrase()).append(" wieght : ").append(phrase.getWeight()).append("\n");
			}
		}
		return buffer.toString();
	}
	
	

}
