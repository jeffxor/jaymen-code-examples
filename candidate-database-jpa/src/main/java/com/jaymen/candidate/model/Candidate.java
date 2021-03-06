package com.jaymen.candidate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

/**
 * Represents candidate entries in the database. Provides
 * the entity mappings for the candidate table
 *
 */
@Entity
public class Candidate {
	
	Integer id;
	String name;
	String address;
	String phone;
	String email;
	List<Employment> employments;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="candidate")
    @OrderBy("startDate")
	public List<Employment> getEmployments() {
		return employments;
	}
	public void setEmployments(List<Employment> employments) {
		this.employments = employments;
	}
}
