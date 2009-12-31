package com.jaymen.candidate.service.impl;

import java.util.Collection;

import javax.ejb.EJB;

import com.jaymen.candidate.dao.CandidateDao;
import com.jaymen.candidate.model.Candidate;
import com.jaymen.candidate.service.CandidateService;

public class CandidateServiceImp implements CandidateService {
	
	@EJB(name="canidateDao")
	private CandidateDao dao;
		
	/**
	 * Method for EJB autowired dependency injection.
	 * 
	 * @param dao
	 */
	public void setDao(CandidateDao dao) {
		this.dao = dao;
	}

	@Override
	public Collection<Candidate> findAll() {
		return dao.findAll();
	}

	@Override
	public Candidate findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public void persist(Candidate candidate) {
		dao.persist(candidate);		
	}

	@Override
	public void remove(Candidate candidate) {
		dao.remove(candidate);
	}

}
