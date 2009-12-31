package com.jaymen.test.classifier.process;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jaymen.test.classifier.model.Category;
import com.jaymen.test.classifier.model.Document;
import com.jaymen.test.classifier.model.Phrase;
import com.jaymen.test.classifier.model.Vocabulary;

/**
 * This document processes a document scoring it against a vocabulary.
 * 
 * @author jeffxor
 *
 */
public class DocumentProcessor {
	
	public static void scoreDocument(Document document, Vocabulary vocabulary){
		String documentText = document.getDocumentText();
		for(Category category : vocabulary.getCategories()){
			for(Phrase phrase : category.getPhrases()){
				
				//Simply use regex to find how many times a phrase appears in the documents text
				Matcher matcher = Pattern.compile("\\Q" + phrase.getPhrase() + "\\E").matcher(documentText);
		        int occurences = 0;
		        while (matcher.find()) occurences++;

			     if(occurences > 0){
			    	 //If phrase appears add the phrase's score to the document's total
			    	 document.addToScores(category, occurences * phrase.getWeight());
			     }
			}
		}
	}

}
