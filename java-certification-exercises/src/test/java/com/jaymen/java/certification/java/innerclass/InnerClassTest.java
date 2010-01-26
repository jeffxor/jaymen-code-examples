package com.jaymen.java.certification.java.innerclass;

import org.junit.Test;

import static org.junit.Assert.*;

public class InnerClassTest {

	@Test
	public void testVargs(){
		Object o = new Object() {
			public boolean equals(Object obj) {
				return true;
			}
		};
		
		assertEquals(true, o.equals("Fred"));
	}
}

class High{
	public static String go(int... x){
		return "hi";
	}
	
	public High(String... s){
		
	}
	
	public High createHigh(){
		return new High();
	}
}

class Low extends High{
	public static String go(Integer x, Integer y){
		return "low";
	}

	public static void main(String... args){
		System.out.println(Low.go(9,27));
		System.out.println(Low.go(81));
	}

}