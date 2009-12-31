package com.jaymen.test.classifier.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jaymen.test.classifier.compare.CategoryScoreComparator;


/**
 * Document class provides the details for a document.
 * 
 * It provides methods to load a document details from a file handle.
 * The document also contains it scores, providing methods to add 
 * scores based on categories.
 * 
 * @author jeffxor
 *
 */
public class Document {
	
	private StringBuffer documentText;
	private String documentName;
	private Map<Category, CategoryScore> scores;
	
	public Document() {
		documentText = new StringBuffer(0);
		this.scores = new HashMap<Category, CategoryScore>();
	}
	
	/**
	 * Constructor for a Document which handles the loading of the
	 * file details.
	 * 
	 * @param file
	 * @throws IOException
	 */
	public Document(File file) throws IOException {
		documentText = new StringBuffer(0);
		this.scores = new HashMap<Category, CategoryScore>();
		documentName = file.getName();
		loadDocument(file);
	}
	
	/**
	 * Deals with the loading of a document details from a File handle.
	 * 
	 * This method opens the file for reading. Then reads every line of the file
	 * and adding the clean text to the Document text.
	 * 
	 * @param file
	 * @throws IOException
	 */
	public void loadDocument(File file) throws IOException{
		documentText.setLength(0);
		BufferedReader reader = new BufferedReader(new FileReader(file));

		String string;
		// Process each line in the text file
		while ((string = reader.readLine()) != null) {
			addDocumentText(string);
		}
		// Should close underlying file references
		reader.close();
	}
	
	/**
	 * Deals with cleaning the input to the document and storing 
	 * it in the correct format. In this case it is lower case with out
	 * Punctuation.
	 * 
	 * @param string
	 */
	public void addDocumentText(String string){
		String [] tokens = string.split("\\W");
		for(String token : tokens) {
			if(token != null && !"".equals(token))
			documentText.append(token.toLowerCase()).append(" ");
		}		
	}
	
	public String getDocumentText(){
		return documentText.toString();
	}
	
	/**
	 * Handles the scoring the document.
	 * 
	 * Looks up a category adding the new score to it's total. otherwise,
	 * adding the new category.
	 * 
	 * @param category
	 * @param score
	 */
	public void addToScores(Category category, Integer score){
		if(scores.containsKey(category)){
			CategoryScore categoryScore = scores.get(category);
			categoryScore.addToScore(score);
		}
		else{
			scores.put(category, new CategoryScore(category, score));			
		}
	}
	
	public void clearScores(){
		this.scores = new HashMap<Category, CategoryScore>();
	}
	
	/**
	 * Method for printing the scores of the document. It sorts the list of
	 * CategoryScores before printing.
	 * 
	 */
	public void printScores(){
		List<CategoryScore> categoryScores = new ArrayList<CategoryScore>(scores.values());
		Comparator<CategoryScore> categoryScoreComparator = new CategoryScoreComparator();
		Collections.sort(categoryScores, categoryScoreComparator);
		System.out.println(documentName);
		System.out.println("--------------------------------");
		if(!categoryScores.isEmpty()){
			for(CategoryScore categoryScore : categoryScores){
				System.out.println(categoryScore.getCategory().getName() + " : " + categoryScore.getScore());
			}
		}
	}
	
	@Override
	public String toString() {
		return getDocumentText();
	}

}
