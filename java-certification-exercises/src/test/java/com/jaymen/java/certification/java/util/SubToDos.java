package com.jaymen.java.certification.java.util;

/**
 * Sub class to use for testing hierarchies in collections
 * and inheritance.
 * @author jeffxor
 *
 */
public class SubToDos extends ToDos {

	protected int num = 3;
	public SubToDos(String t) {
		super(t);
	}
	public String drive(){ 
        return "SubToDo Drive"; 
    }
	
	public String drive(String string){ 
        return "SubToDo Drive " + string; 
    } 
}
