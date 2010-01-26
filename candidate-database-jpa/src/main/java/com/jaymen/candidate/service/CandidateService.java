package com.jaymen.candidate.service;

import java.util.List;

import com.jaymen.candidate.dao.exceptions.DaoStoreException;
import com.jaymen.candidate.model.Candidate;

/**
 * Defines service level operations allowed for candidate entities.
 */
public interface CandidateService {
	Candidate persist(Candidate candidate) throws DaoStoreException;
	void remove(Candidate candidate) throws DaoStoreException;
    Candidate findById(Integer id);
    List<Candidate> findAll();
}
