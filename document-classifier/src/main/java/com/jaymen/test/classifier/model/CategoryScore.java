package com.jaymen.test.classifier.model;

/**
 * This is a simple container for scoring a document.
 * It holds the Category and it's current score for a document.
 * 
 * @author jeffxor
 *
 */
public class CategoryScore {

	private Category category;
	private Integer score;
	
	public CategoryScore(Category category, Integer score) {
		super();
		this.category = category;
		this.score = score;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getScore() {
		return score;
	}

	/**
	 * Adds the new score to the total score for the category
	 * 
	 * @param score
	 */
	public void addToScore(Integer score) {
		this.score += score;
	}
	
	/**
	 * Resets the category score to 0 
	 */
	public void resetScore(){
		this.score = 0;
	}
	
}
