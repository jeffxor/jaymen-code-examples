package com.jaymen.test.classifier.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Simple holder for a category in our vocabulary. It holds the
 * name of the category and the phrases that belong to the category.
 * 
 * Provides helper methods for adding new phrases to the Categories 
 * vocabulary, as well as retrieving the current list of phrases in the 
 * category.
 * 
 * @author jeffxor
 *
 */
public class Category {
	private String name;
	private Set<Phrase> phrases;
	
	public Category() {
		this.phrases = new HashSet<Phrase>();
	}

	public Category(String name, Set<Phrase> phrases) {
		this.phrases = new HashSet<Phrase>();
		this.name = name;
		this.phrases.addAll(phrases);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Adds a new phrase into the vocabulary for this category
	 * 
	 * @param phrase
	 */
	public void addPhrase(Phrase phrase){
		this.phrases.add(phrase);
	}
	
	public void addPhrases(Set<Phrase> phrase){
		this.phrases.addAll(phrase);
	}
	
	/**
	 * Returns the set of the current phrases associated to the 
	 * category
	 * 
	 * @return
	 */
	public Set<Phrase> getPhrases(){
		return this.phrases;
	}
}
