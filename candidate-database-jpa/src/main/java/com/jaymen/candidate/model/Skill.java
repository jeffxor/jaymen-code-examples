package com.jaymen.candidate.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Represents skill entries in the database. Provides
 * the entity mappings for the skill table.
 */
@Entity
public class Skill {
	
	Integer id;
	String name;
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
	@ManyToMany  
	@JoinTable(name = "employment_skill",    
	    joinColumns = { @JoinColumn(name = "skill_id")},  
	      inverseJoinColumns={@JoinColumn(name="employment_id")}) 
	public List<Employment> getEmployments() {
		return employments;
	}
	public void setEmployments(List<Employment> employments) {
		this.employments = employments;
	}
	
	
}
