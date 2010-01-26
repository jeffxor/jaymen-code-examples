package com.jaymen.java.certification.chp07;

import org.junit.Test;
import static org.junit.Assert.*;

public class ClientTest extends ClientApplication {
			
	@Test
	public void testHalfArray(){
		int [] result = ClientApplication.halfArray(fullArray);
		assertArrayEquals(ClientApplication.halfedArray, result);
	}

	@Test
	public void testHalfArrayWithReference(){
		Half half = new Half();
		int [] result = ClientApplication.functionArray(half, fullArray);
		assertArrayEquals(ClientApplication.halfedArray, result);
	}

}
