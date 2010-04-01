package com.jaymen.flex.business.dto;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.jaymen.flex.database.domain.Skill;

// TODO: Auto-generated Javadoc
/**
 * The Class SkillDto.
 */
public class SkillDto {	
	
	/** The id. */
	Integer id;
	
	/** The name. */
	String name;
	
	/** The employments. */
	List<EmploymentDto> employments;
		
	/**
	 * Instantiates a new skill dto.
	 */
	public SkillDto() {
		super();
	}	
	
	/**
	 * Instantiates a new skill dto.
	 * 
	 * @param skill the skill
	 */
	public SkillDto(Skill skill) {
		super();
		BeanUtils.copyProperties(skill, this);		
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
