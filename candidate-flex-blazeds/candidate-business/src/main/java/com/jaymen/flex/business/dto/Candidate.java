package com.jaymen.flex.business.dto;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

/**
 * The Class CandidateDto.
 */
public class Candidate {
	
	/** The id. */
	Integer id;
	
	/** The name. */
	String name;
	
	/** The address. */
	String address;
	
	/** The phone. */
	String phone;
	
	/** The email. */
	String email;
	
	/** The employments. */
	List<EmploymentDto> employments;
	
	//Use slf4j for logging purposes
	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(Candidate.class);
	
	/**
	 * Instantiates a new candidate dto.
	 */
	public Candidate() {
		super();
	}
	
	/**
	 * Instantiates a new candidate dto.
	 * 
	 * @param candidate the candidate
	 */
	public Candidate(com.jaymen.flex.database.domain.Candidate candidate) {
		super();
		logger.debug("CandidateDto Constructor called");
		BeanUtils.copyProperties(candidate, this, new String[] {"employments"});		
	}
	
	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 * 
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 * 
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the address.
	 * 
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Sets the address.
	 * 
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Gets the phone.
	 * 
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Sets the phone.
	 * 
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 * 
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the employments.
	 * 
	 * @return the employments
	 */
	public List<EmploymentDto> getEmployments() {
		return employments;
	}
	
	/**
	 * Sets the employments.
	 * 
	 * @param employments the new employments
	 */
	public void setEmployments(List<EmploymentDto> employments) {
		this.employments = employments;
	}
}
