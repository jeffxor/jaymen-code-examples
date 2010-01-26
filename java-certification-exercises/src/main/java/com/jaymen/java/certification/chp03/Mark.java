package com.jaymen.java.certification.chp03;
/**
 * This is a class that holds the results of a question
 * on the quiz.
 * 
 */
public class Mark {
	
	String correct;
	String answered;
	
	public Mark(String correct, String answered) {
		super();
		this.correct = correct;
		this.answered = answered;
	}
		
	public String getCorrect() {
		return correct;
	}
	
	public void setCorrect(String correct) {
		this.correct = correct;
	}

	public String getAnswered() {
		return answered;
	}

	public void setAnswered(String answered) {
		this.answered = answered;
	}

	/**
	 * Returns the result of the question.
	 * @return an enum (Result) representation of the result
	 */
	public Result getResult(){
		if(answered.equals(correct)){
			return Result.CORRECT;
		}
		else if(answered.equals("X")){
			return Result.UNANSWERED;
		}
		else{
			return Result.WRONG;
		}
	}
}
