package com.jaymen.java.certification.chp08;

import com.jaymen.java.certification.chp07.Function;
import com.jaymen.java.certification.chp07.Half;
import com.jaymen.java.certification.chp07.Print;

public class PrintFuncApplication {

	public static int [] fullArray = {2,4,8,16,32};
	public static int [] halfedArray = {1,2,4,8,16};

	public static void main(String[] args){		
		Half half = new Half();
		PrintFunc printFunc = new PrintFunc(half);
		
		System.out.println("Initial int array: ");
		for(int value : fullArray){
			System.out.print(value);
		}
		System.out.println();
		System.out.println("Halfed int array: ");
		for(int value : fullArray){
			printFunc.evaluate(value);
		}
	}

	static class PrintFunc extends Print {
		private Function function;

		public PrintFunc(Function function) {
			super();
			this.function = function;
		}
		
		@Override
		public int evaluate(int value) {			
			return super.evaluate(function.evaluate(value));
		}		
	}	
}
