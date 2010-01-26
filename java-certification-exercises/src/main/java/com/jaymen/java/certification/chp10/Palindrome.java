package com.jaymen.java.certification.chp10;

public class Palindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(isPalindrome(args[1])){
			System.out.println("String is a palindrome");
		}
		else{
			System.out.println("String is NOT a palindrome");
		}

	}

	public static boolean isPalindrome(String string){
		if(string == null) return false;
		StringBuffer stringBuffer = new StringBuffer(string);		
		return string.equalsIgnoreCase(stringBuffer.reverse().toString());
	}
}
