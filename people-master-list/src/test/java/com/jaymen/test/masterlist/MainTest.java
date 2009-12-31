package com.jaymen.test.masterlist;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.Test;


public class MainTest {
	
	@Test
	public void testGetResource(){
        URL url = MainTest.class.getResource(File.separator + "input_files" + File.separator + "pipe.txt");
        System.out.println("url is " + url);
        assertNotNull("url should not be null", url);
        
        File file = new File(url.getFile());
        
        assertNotNull(file);

	}
	@Test
	public void testMain() throws IOException, Exception{
		Main.main(null);
	}
}

	