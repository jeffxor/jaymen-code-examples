/*
 * 
 */
package com.jaymen.flex.business;

import java.util.List;

import com.jaymen.flex.business.dto.Candidate;

/**
 * The Interface CandidateServiceDto.
 */
public interface CandidateServiceDto {

	/**
	 * Gets the candidates.
	 * 
	 * @return the candidates
	 */
	List<Candidate> getCandidates();
	
	/**
	 * Gets the candidate.
	 * 
	 * @param id the id
	 * 
	 * @return the candidate
	 */
	Candidate getCandidate(Integer id);
	
	/**
	 * Adds a new Candidate
	 * 
	 * @param candidate the candidate
	 * 
	 * @return boolean true if added successfully
	 */
	Boolean addCandidate(Candidate candidate);	
}
