package com.jaymen.java.certification.chp03;

import java.io.OutputStreamWriter;

/**
 * Application that takes a list of marks from the console
 * and generates a formatted output for the results of the quiz.
 * 
 * @see QuizMarkerApplication.txt for requirments.
 *
 */
public class QuizMarkerApplication {

	public void main(String [] args) {
		Quiz quiz = new Quiz();
		for(int i = 0; i < args.length && i < quiz.length(); i++){
			quiz.markQuestion(args[i]);
		}
		quiz.printResults(new OutputStreamWriter(System.out));
	}
}
