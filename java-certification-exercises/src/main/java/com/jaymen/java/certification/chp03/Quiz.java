package com.jaymen.java.certification.chp03;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Class containing the logic to mark a quiz.
 * 
 * It contains the correct list of answers as well as
 * a list of the answers supplied. The results can be 
 * provided in a formatted output.
 * 
 */
public class Quiz {

	private String [] correctAnswers = {"C", "A", "B", "D", "B", "C", "C", "A"};

	//Holds the pass mark. How many answers need to be correct
	private static final int PASS_MARK = 5;

	int correct;
	int wrong;
	int unanswered;

	//List of marks for each question on the quiz
	List<Mark> results;

	public Quiz() {
		super();
		correct = 0;
		wrong = 0;
		unanswered = 0;
		results = new ArrayList<Mark>();
	}
	
	/**
	 * How many questions are on the quiz
	 * @return the number of questions on the quiz
	 */
	public int length(){
		return correctAnswers.length;
	}

	/**
	 * Handles the marking of answers on the quiz. Creates
	 * a new mark for each questions with the mark being checked
	 * against the array of correct answers.
	 * 
	 * @param submittedAnswer the answer supplied for the question
	 */
	public void markQuestion(String submittedAnswer){
		int correctAnswer = results.size();
		Mark mark = new Mark(correctAnswers[correctAnswer], submittedAnswer);
		updateCounts(mark);
		results.add(mark);		
	}

	/**
	 * Updates the internal counts of correct, wrong and unanswered. 
	 * @param mark for the question
	 */
	private void updateCounts(Mark mark){
		switch (mark.getResult()) {
			case CORRECT:
				correct++;				
				break;
			case WRONG:
				wrong++;
				break;
			case UNANSWERED:
				unanswered++;
				break;
		}		
	}
	
	/**
	 * Determines if the quiz has been passed or failed
	 * @return "PASSED" if the quiz has been passed. "FAILED" otherwise.
	 */
	public String getGrade(){
		if(correct >= PASS_MARK){
			return "PASSED";
		}
		return "FAILED";
	}
	
	/**
	 * Generates a formatted string containing the results of the quiz. 
	 * 
	 * @return formatted string containing the results of the quiz.
	 */
	public String getResults(){
		StringWriter stringWriter = new StringWriter();
		printResults(stringWriter);		
		return stringWriter.toString();
	}

	/**
	 * Generates a formatted output of the results. Adding them to the
	 * writer.
	 * 
	 * @param writer where the results should be written.
	 */
	public void printResults(Writer writer){
		PrintWriter printWriter = new PrintWriter(writer);
		printWriter.println("Question Submitted Ans. Correct Ans. Result");
		for(int i = 0; i < results.size(); i++){
			Mark mark = results.get(i);
			printWriter.printf("%5d%10s%15s%15s%n", i+1, mark.getAnswered(), mark.getCorrect(), mark.getResult());
		}
		printWriter.println("No. of correct answers: " + correct);
		printWriter.println("No. of wrong answers: " + wrong);
		printWriter.println("No. of questions unanswered: " + unanswered);
		printWriter.print("The candidate " + getGrade());
		printWriter.close();
	}
}
