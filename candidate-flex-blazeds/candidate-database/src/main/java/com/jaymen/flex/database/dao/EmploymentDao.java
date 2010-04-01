package com.jaymen.flex.database.dao;

import java.util.List;

import com.jaymen.flex.database.domain.Employment;

public interface EmploymentDao {
	
	public List<Employment> getEmploymentsByCandidateId(Integer candidateId);
	public List<Employment> getEmploymentsByOrganisationId(Integer organisationId);
	public List<Employment> getEmploymentsBySkillId(Integer skillId);	
}
