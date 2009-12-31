package com.jaymen.test.classifier.model;

/**
 * Represents a phrase in our vocabulary plus the weight it 
 * has for scoring of a document
 * 
 * @author jeffxor
 *
 */
public class Phrase {
	
	private String phrase;
	private Integer weight;
	
	public Phrase(String phrase, Integer wieght) {
		super();
		this.phrase = phrase;
		this.weight = wieght;
	}
	
	public String getPhrase() {
		return phrase;
	}
	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
	

}
