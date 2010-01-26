package com.jaymen.java.certification.chp01;


/**
 * Modify the program (Client.class) from Example 1.4 to use the PrintableCharStack class, 
 * rather than the CharStack class from Example 1.2. Utilize the printStackElements() method 
 * from the PrintableCharStack class. Is the new program behavior-wise 
 * any different from Example 1.4?
 * 
 * The difference with using the printStackElements is the stack is printed in order
 * and it not reversed using the pop method. Hence is is the same as the initial string.
 * 
 * @author exitut
 *
 */
public class ClientSolution {

	public static void main(String[] args) {
		// Create a stack.
		PrintableCharStack stack = new PrintableCharStack(40);
		// Create a string to push on the stack:
		String str = "!no tis ot nuf era skcatS";
		int length = str.length();
		System.out.println("Original string: " + str);
		// Push the string char by char onto the stack:
		for (int i = 0; i < length; i++) {
			stack.push(str.charAt(i));
		}
		System.out.print("Reversed string: ");
		//Use the printStackElements method to print stack
		stack.printStackElements();
	}
}
