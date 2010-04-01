/*
 * 
 */
package com.jaymen.flex.business;

import java.util.List;

import com.jaymen.flex.database.domain.Candidate;

/**
 * The Interface CandidateService.
 */
public interface CandidateService {

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
