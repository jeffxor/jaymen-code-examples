package com.jaymen.test.classifier.model;


import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DocumentTest {
	
	private Document document;
	
	private String testData = "rethink the \"Poverty: it's cool to have no money!\" campaign. Meanwhile, lung cancer";
	private String corrected = "rethink the poverty it s cool to have no money campaign meanwhile lung cancer ";
	@Before 
	public void initialize() {
		document = new Document();
	}
	
	@After 
	public void cleanUp() {
		document = null;
	}
	
	@Test
	public void addDocumentText(){
		document.addDocumentText(testData);
		System.out.println(document);
		
		assertEquals(corrected, document.getDocumentText());
		
	}
	
	@Test
	public void loadDocument() throws IOException{
		URL url = DocumentTest.class.getResource(File.separator + "test_data.txt");
		File file = new File(url.getFile());
		assertNotNull("test file is not null", file);
		assertTrue("test file is exists", file.exists());
		
		document.loadDocument(file);

		assertEquals(corrected, document.getDocumentText());
	}
	

}
