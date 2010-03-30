package com.jaymen.candidate.dao;

import java.util.List;

import com.jaymen.candidate.domain.Employment;

public interface EmploymentDao {
	
	public List<Employment> getEmploymentsByCandidateId(Integer candidateId);
	public List<Employment> getEmploymentsByOrganisationId(Integer organisationId);
	public List<Employment> getEmploymentsBySkillId(Integer skillId);	
}
