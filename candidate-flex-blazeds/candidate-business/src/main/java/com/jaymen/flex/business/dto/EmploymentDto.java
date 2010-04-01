package com.jaymen.flex.business.dto;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.jaymen.flex.database.domain.Employment;
import com.jaymen.flex.database.domain.Skill;


// TODO: Auto-generated Javadoc
/**
 * The Class EmploymentDto.
 */
public class EmploymentDto {

	/** The id. */
	Integer id;
	
	/** The job title. */
	String jobTitle;
	
	/** The start date. */
	Date startDate;
	
	/** The end date. */
	Date endDate;
	
	/** The candidate. */
	Candidate candidate;
	
	/** The organisation. */
	OrganisationDto organisation;	
	
	/** The skills. */
	List<SkillDto> skills;
		
	/**
	 * Instantiates a new employment dto.
	 */
	public EmploymentDto() {
		super();
	}
	
	/**
	 * Instantiates a new employment dto.
	 * 
	 * @param employment the employment
	 */
	public EmploymentDto(Employment employment) {
		super();
		BeanUtils.copyProperties(employment, this);
		BeanUtils.copyProperties(employment.getCandidate(), this.candidate);
		BeanUtils.copyProperties(employment.getOrganisation(), this.organisation);
		if(employment.getSkills() != null){
			for(Skill skill :  employment.getSkills()){
				skills.add(new SkillDto(skill));
			}
		}
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
	 * Gets the job title.
	 * 
	 * @return the job title
	 */
	public String getJobTitle() {
		return jobTitle;
	}
	
	/**
	 * Sets the job title.
	 * 
	 * @param jobTitle the new job title
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	/**
	 * Gets the start date.
	 * 
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
	}
	
	/**
	 * Sets the start date.
	 * 
	 * @param startDate the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * Gets the end date.
	 * 
	 * @return the end date
	 */
	public Date getEndDate() {
		return endDate;
	}
	
	/**
	 * Sets the end date.
	 * 
	 * @param endDate the new end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * Gets the candidate.
	 * 
	 * @return the candidate
	 */
	public Candidate getCandidate() {
		return candidate;
	}
	
	/**
	 * Sets the candidate.
	 * 
	 * @param candidate the new candidate
	 */
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
	/**
	 * Gets the organisation.
	 * 
	 * @return the organisation
	 */
	public OrganisationDto getOrganisation() {
		return organisation;
	}
	
	/**
	 * Sets the organisation.
	 * 
	 * @param organisation the new organisation
	 */
	public void setOrganisation(OrganisationDto organisation) {
		this.organisation = organisation;
	}
	
	/**
	 * Gets the skills.
	 * 
	 * @return the skills
	 */
	public List<SkillDto> getSkills() {
		return skills;
	}
	
	/**
	 * Sets the skills.
	 * 
	 * @param skills the new skills
	 */
	public void setSkills(List<SkillDto> skills) {
		this.skills = skills;
	}		
}
