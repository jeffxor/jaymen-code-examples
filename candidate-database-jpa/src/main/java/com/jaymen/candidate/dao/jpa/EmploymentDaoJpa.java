package com.jaymen.candidate.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import com.jaymen.candidate.dao.EmploymentDao;
import com.jaymen.candidate.model.Candidate;
import com.jaymen.candidate.model.Employment;
import com.jaymen.candidate.model.Organisation;

/**
 * Implementation using Java Persistence API of the employment dao interface.
 * 
 * The basic API function find, update, delete have been abstracted out to a base class
 * @see com.jaymen.candidate.dao.jpa.AbstractDao
 * 
 */
public class EmploymentDaoJpa extends AbstractDao<Integer, Employment> implements EmploymentDao{

	@Override
	public List<Employment> findByCandidate(Candidate candidate) {
		return findByCandidate(candidate.getId());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employment> findByCandidate(Integer candidateId) {
		/* For testing HSQLDB does not support schema or catalog causing JPA to fail with
		   java.sql.SQLException: Three part identifiers prohibited in statement
		   It has been replaced with a native sql query which is not ideal 
		 Query query = entityManager.createNativeQuery("SELECT e FROM " + entityClass.getName() + " e" +
			" WHERE e.candidate.id = ?");
		*/
		
		Query query = entityManager.createNativeQuery("SELECT e.* FROM employment e WHERE e.candidate_id = ?", entityClass);		
		query.setParameter(1, candidateId);
		return query.getResultList();
	}

	@Override
	public List<Employment> findByOrganisation(Organisation organisation) {
		return findByOrganisation(organisation.getId());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employment> findByOrganisation(Integer organisationId) {
		Query query = entityManager.createNativeQuery("SELECT e.* FROM employment e WHERE e.organisation_id = ?", entityClass);		
		query.setParameter(1, organisationId);
		return query.getResultList();
	}

}
