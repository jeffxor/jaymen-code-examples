package com.jaymen.candidate.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
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
	
	@XmlTransient
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
