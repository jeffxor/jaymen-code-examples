package com.jaymen.java.certification.chp07;

public class ClientApplication {
	
	public static int [] fullArray = {2,4,8,16,32};
	public static int [] halfedArray = {1,2,4,8,16};

	public static void main(String[] args){
		System.out.println("Intial int array: ");
		Print print = new Print();
		Half half = new Half();
		
		System.out.println("Initial int array: ");
		functionArray(print, fullArray);
				
		System.out.println("Halfed int array passing array: ");
		int [] results = functionArray(half, fullArray);
		functionArray(print, results);
	}
	
	public static int[] halfArray(int [] values){
		Half half = new Half();
		int [] halfed = new int[values.length];
		for(int i = 0; i < values.length; i++){
			halfed[i] = half.evaluate(values[i]);
		}		
		return halfed;
	}
	
	public static int[] functionArray(Function function, int [] values){
		int [] halfed = new int[values.length];
		for(int i = 0; i < values.length; i++){
			halfed[i] = function.evaluate(values[i]);
		}		
		return halfed;
	}
	
}
