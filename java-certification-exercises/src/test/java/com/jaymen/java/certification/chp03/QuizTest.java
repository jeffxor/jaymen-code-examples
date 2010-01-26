package com.jaymen.java.certification.chp03;

import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;


public class QuizTest {
	
	Quiz quiz;
	public static String newline = System.getProperty("line.separator");
	private final String CORRECT_RESULTS = "Question Submitted Ans. Correct Ans. Result" + newline +
			"    1         C              C        CORRECT" + newline +
			"    2         B              A          WRONG" + newline +
			"    3         B              B        CORRECT" + newline +
			"    4         D              D        CORRECT" + newline +
			"    5         B              B        CORRECT" + newline +
			"    6         C              C        CORRECT" + newline +
			"    7         A              C          WRONG" + newline +
			"    8         X              A     UNANSWERED" + newline +
			"No. of correct answers: 5" + newline +
			"No. of wrong answers: 2" + newline +
			"No. of questions unanswered: 1" + newline +
			"The candidate PASSED";
			
	
	@Before
	public void initialize(){
		quiz = new Quiz();
		String [] anwsers = {"C", "B", "B", "D", "B", "C", "A", "X"};
		
		for(int i = 0; i < anwsers.length; i++){
			quiz.markQuestion(anwsers[i]);
		}
	}
	
	@Test
	public void testGrade(){
		assertEquals("Quiz results should have passed", "PASSED", quiz.getGrade());
	}
	
	@Test
	public void testLength(){
		assertEquals("Quiz should be 8", 8, quiz.length());
	}
	
	@Test
	public void testResults(){
		String results = quiz.getResults();
		assertEquals("Results are incorrect", CORRECT_RESULTS, results);
	}
	

}
