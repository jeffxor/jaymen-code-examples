package com.jaymen.candidate.dao;

import java.util.List;

import com.jaymen.candidate.model.Candidate;
import com.jaymen.candidate.model.Employment;
import com.jaymen.candidate.model.Organisation;

/**
 * Defines operations provided for employment entities by implementing Daos 
 */

public interface EmploymentDao extends Dao<Integer, Employment> {
	/**
	 * Finds all Employment records based of the supplied candidate entity.
	 * 
	 * @param candidate the candidate we are using to search for employment records.
	 * @return Collection of Employment entities for the particular candidate.
	 */
	List<Employment> findByCandidate(Candidate candidate);
	
	/**
	 * Finds all Employment records based of the supplied candidate id.
	 * 
	 * @param candidateId Id of the candidate in the database that we are 
	 * using to search for employment records.
	 * @return Collection of Employment entities for the particular candidate.
	 */
	List<Employment> findByCandidate(Integer candidateId);

	/**
	 * Finds all Employment records based of the supplied organisation entity.
	 * 
	 * @param organisation the organisation we are using to search for employment records.
	 * @return Collection of Employment entities for the particular organisation.
	 */
	List<Employment> findByOrganisation(Organisation organisation);
	
	/**
	 * Finds all Employment records based of the supplied organisation id.
	 * 
	 * @param organisationId Id of the organisation in the database that we are 
	 * using to search for employment records.
	 * @return Collection of Employment entities for the particular organisation.
	 */
	List<Employment> findByOrganisation(Integer organisationId);

}
