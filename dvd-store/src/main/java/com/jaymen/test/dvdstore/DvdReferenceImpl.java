/*
 * Copyright Easynet 2006
 */
package com.jaymen.test.dvdstore;

/**
 * @author Jonathan Rogers
 */
public class DvdReferenceImpl implements Dvd {
	
	private String reference;
	private String title;
	private String review;
	
	/**
	 * Default Ctor
	 * 
	 * @param reference
	 * @param title
	 * @param description
	 */
	public DvdReferenceImpl(String reference, String title, String description) {
		this.reference = reference;
		this.title = title;
		this.review = description;
	}
	
	/* (non-Javadoc)
	 * @see com.easynet.dvdstore.Dvd#getDescription()
	 */
	public String getReview() {
		return review;
	}
	/* (non-Javadoc)
	 * @see com.easynet.dvdstore.Dvd#getReference()
	 */
	public String getReference() {
		return reference;
	}
	/* (non-Javadoc)
	 * @see com.easynet.dvdstore.Dvd#getTitle()
	 */
	public String getTitle() {
		return title;
	}
	
	public String getSummary(){
		return  "[" + getReference() + "]" + getTitle() + " - " + shortenReview();
	}
	
	/**
	 * Takes the DVD review and splits into words based on whitespace
	 * in the review counting as delimiters also has a limit of 10 words.
	 * 
	 * @return Returns a short review with the first 10 words of the review
	 */
	private String shortenReview(){
		String [] words = review.split("\\W");		
		
		StringBuffer shortReview = new StringBuffer(0);
		if(words != null){
			for(int i = 0; i < words.length && i < Dvd.SUMMARY_LENGTH; i++){
				shortReview.append(words[i]);
				if(i < (words.length -1) && i < (Dvd.SUMMARY_LENGTH -1)) shortReview.append(" ");
			}
			if(words.length > 10) shortReview.append("...");
		}
		
		return shortReview.toString();
	}
	
}
