package com.jaymen.java.certification.java.threads;

/**
 * A class posed by a question in an exam.
 * It test knowledge of how threads work
 * 
 * @author jeffxor
 *
 */
public class NoGo implements Runnable {
	private int i;
	public static String output = "";

	public synchronized void run() {
		if (i % 10 != 0) {
			i++;
		}
		for (int x = 0; x < 10; x++, i++) {
			if (x == 4)
				Thread.yield();
		}
		output += (i + " ");
	}

	public static void main(String[] args) {
		NoGo n = new NoGo();
		for (int x = 0; x < 101; x++) {
			new Thread(n).start();
		}
	}
}