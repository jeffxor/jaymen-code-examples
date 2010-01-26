package com.jaymen.java.certification.chp03;

import org.junit.Test;
import static org.junit.Assert.*;


public class MarkTest {
	
	@Test
	public void getResultCorrect(){
		Mark mark = new Mark("A", "A");
		assertEquals(Result.CORRECT, mark.getResult());
	}

	@Test
	public void getResultWrong(){
		Mark mark = new Mark("A", "B");
		assertEquals(Result.WRONG, mark.getResult());
	}

	@Test
	public void getResultUnanswered(){
		Mark mark = new Mark("A", "X");
		assertEquals(Result.UNANSWERED, mark.getResult());
	}

}
