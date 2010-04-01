package com.jaymen.flex.business.dto;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.jaymen.flex.database.domain.Organisation;


// TODO: Auto-generated Javadoc
/**
 * The Class OrganisationDto.
 */
public class OrganisationDto {

	/** The id. */
	Integer id;
	
	/** The name. */
	String name;
	
	/** The address. */
	String address;
	
	/** The phone. */
	String phone;
	
	/** The fax. */
	String fax;
	
	/** The email. */
	String email;
	
	/** The employments. */
	List<EmploymentDto> employments;
	
	/**
	 * Instantiates a new organisation dto.
	 */
	public OrganisationDto() {
		super();
	}
	
	/**
	 * Instantiates a new organisation dto.
	 * 
	 * @param organisation the organisation
	 */
	public OrganisationDto(Organisation organisation) {
		super();
		BeanUtils.copyProperties(organisation, this);
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
	 * Gets the fax.
	 * 
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}
	
	/**
	 * Sets the fax.
	 * 
	 * @param fax the new fax
	 */
	public void setFax(String fax) {
		this.fax = fax;
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
