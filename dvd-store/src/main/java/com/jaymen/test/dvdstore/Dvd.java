package com.jaymen.test.dvdstore;

public interface Dvd {

	public static final Integer SUMMARY_LENGTH = new Integer(10);
	/**
	 * @return Returns the description.
	 */
	public abstract String getReview();

	/**
	 * @return Returns the reference.
	 */
	public abstract String getReference();

	/**
	 * @return Returns the title.
	 */
	public abstract String getTitle();
	
	/**
	 * 
	 * @return Return the summary of the dvd
	 */
	public abstract String getSummary();

}