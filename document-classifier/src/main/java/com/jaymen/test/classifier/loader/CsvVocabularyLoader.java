package com.jaymen.test.classifier.loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.jaymen.test.classifier.builder.CsvCategoryBuilder;
import com.jaymen.test.classifier.model.Category;
import com.jaymen.test.classifier.model.Vocabulary;

public class CsvVocabularyLoader {
	
	public static Vocabulary load(File file) throws IOException{
		Vocabulary vocabulary = new Vocabulary();
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		CsvCategoryBuilder builder = new CsvCategoryBuilder();

		String string;
		// Process each line in the comma file
		while ((string = reader.readLine()) != null) {
			Category category = builder.createCategory(string);
			if(vocabulary.categoryExists(category)){
				//If category exists in vocab and the new phrase
				Category existCategory = vocabulary.getCategory(category.getName());
				existCategory.addPhrases(category.getPhrases());
			}
			else{
				//Else add the new category to our vocabulary
				vocabulary.addCategory(category);
			}
		}
		// Should close underlying file references
		reader.close();

		return vocabulary;
	}
	
}
