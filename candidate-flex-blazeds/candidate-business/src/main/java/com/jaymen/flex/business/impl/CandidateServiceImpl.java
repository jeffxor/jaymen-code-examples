package com.jaymen.flex.business.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jaymen.flex.business.CandidateService;
import com.jaymen.flex.database.dao.CandidateDao;
import com.jaymen.flex.database.domain.Candidate;

/**
 * The Class CandidateServiceImpl.
 */
public class CandidateServiceImpl implements CandidateService {
	/** The logger. Use slf4j for logging purposes*/
	private static Logger logger = LoggerFactory.getLogger(CandidateServiceImpl.class);

	/** The candidate dao. */
	private final CandidateDao candidateDao;
		
	/**
	 * Instantiates a new candidate service impl.
	 * 
	 * @param candidateDao the candidate dao
	 */
	public CandidateServiceImpl(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	/* (non-Javadoc)
	 * @see com.jaymen.flex.business.CandidateService#getCandidate(java.lang.Integer)
	 */
	public Candidate getCandidate(Integer id) {
		logger.debug("getCandidate() has been called");
		return candidateDao.getCandidate(id);
	}

	/* (non-Javadoc)
	 * @see com.jaymen.flex.business.CandidateService#getCandidates()
	 */
	public List<Candidate> getCandidates() {
		logger.debug("getCandidates() has been called");
		return candidateDao.getCandidates();
	}
	/* (non-Javadoc)
	 * @see com.jaymen.flex.business.CandidateService#addCandidate(com.jaymen.flex.database.domain.Candidate)
	 */
	public Boolean addCandidate(Candidate candidate) {
		logger.debug("addCandidate() has been called");
		return candidateDao.insertCandidate(candidate);
	}

}
