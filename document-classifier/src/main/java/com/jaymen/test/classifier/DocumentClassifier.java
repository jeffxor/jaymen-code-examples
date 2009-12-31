package com.jaymen.test.classifier;

import java.io.File;
import java.io.IOException;


import com.jaymen.test.classifier.loader.CsvVocabularyLoader;
import com.jaymen.test.classifier.model.Document;
import com.jaymen.test.classifier.model.Vocabulary;
import com.jaymen.test.classifier.process.DocumentProcessor;

/**
 * Simple Application that takes to files, one a vocabulary file and anther
 * a simple text document. The text document is then scored against the vocabulary
 * to rank the document based on Catgories.
 * 
 * @author jeffxor
 *
 */
public class DocumentClassifier {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		if(args != null && args.length < 2){
			//If not enough args print usage and fail
			printUsage();
			System.exit(1);
		}
		
		File vocab = new File(args[0]);
		File doc = new File(args[1]);
		
		if(!vocab.exists() || !doc.exists()){
			//if one of the files does not exist print usage and fail
			System.err.println("One of the files supplied could not be found");
			printUsage();
			System.exit(1);
		}
		
		Vocabulary vocabulary = CsvVocabularyLoader.load(vocab);		
		Document document = new Document(doc);		
		DocumentProcessor.scoreDocument(document, vocabulary);
		document.printScores();
	}
	
	private static void printUsage(){
		System.out.println("Usage for Document Classifer \n" +
				"\t arg1 vocabulary csv file \n" +
				"\t arg1 document txt file \n" +
				"\t eg. java DocumentClassifier vocab.csv doc.txt");
	}
}
