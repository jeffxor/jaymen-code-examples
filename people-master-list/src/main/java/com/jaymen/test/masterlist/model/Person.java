package com.jaymen.test.masterlist.model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Person {
	
	private String lastName;
	private String firstName;
	private String middleInitial;
	private Gender gender;
	private String color;
	private Date dob;
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String toString() {
		//Last Name, First Name, Gender, Date Of Birth, Favorite Color.
		SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
		return getLastName() + " " + getFirstName() + " " + getGender() + " " + dateFormat.format(getDob()) + " " + getColor();
	}

}
