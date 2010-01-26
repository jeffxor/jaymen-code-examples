package com.jaymen.candidate.service.impl;

import java.util.List;

import javax.ejb.EJB;

import com.jaymen.candidate.dao.CandidateDao;
import com.jaymen.candidate.dao.exceptions.DaoStoreException;
import com.jaymen.candidate.model.Candidate;
import com.jaymen.candidate.service.CandidateService;

/**
 * Provides a fully working implementation of the candidate service.
 *
 */
public class CandidateServiceImp implements CandidateService {
	
	@EJB(name="candidateDao")
	private CandidateDao dao;
		
	/**
	 * Constructor using EJB auto-wiring dependency injection.
	 * 
	 * @param dao
	 */
	public CandidateServiceImp(CandidateDao dao) {
		super();
		this.dao = dao;
	}	

	@Override
	public List<Candidate> findAll() {
		return dao.findAll();
	}

	@Override
	public Candidate findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public Candidate persist(Candidate candidate) throws DaoStoreException {
		return dao.persist(candidate);		
	}

	@Override
	public void remove(Candidate candidate) throws DaoStoreException {
		dao.remove(candidate);
	}

}
