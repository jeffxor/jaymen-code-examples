package com.jaymen.flex.business.impl;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.jaymen.flex.business.CandidateServiceDto;
import com.jaymen.flex.business.dto.Candidate;
import com.jaymen.flex.database.dao.CandidateDao;

/**
 * The Class CandidateServiceDtoImpl.
 */
public class CandidateServiceDtoImpl implements CandidateServiceDto {
	/** The logger. Use slf4j for logging purposes*/
	private static Logger logger = LoggerFactory.getLogger(CandidateServiceDtoImpl.class);

	/** The candidate dao. */
	private final CandidateDao candidateDao;
		
	/**
	 * Instantiates a new candidate service dto impl.
	 * 
	 * @param candidateDao the candidate dao
	 */
	public CandidateServiceDtoImpl(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	/* (non-Javadoc)
	 * @see com.jaymen.flex.business.CandidateServiceDto#getCandidate(java.lang.Integer)
	 */
	public Candidate getCandidate(Integer id) {
		logger.debug("getCandidate() has been called");
		return new Candidate(candidateDao.getCandidate(id));
	}

	/* (non-Javadoc)
	 * @see com.jaymen.flex.business.CandidateServiceDto#getCandidates()
	 */
	public List<Candidate> getCandidates() {
		logger.debug("getCandidates() Dto Impl has been called");
		List<com.jaymen.flex.database.domain.Candidate> candidateList = candidateDao.getCandidates(); 
		List<Candidate> candidateDtoList = new LinkedList<Candidate>();
		
		if(candidateList != null){
			for(com.jaymen.flex.database.domain.Candidate candidate : candidateList){
				candidateDtoList.add(new Candidate(candidate));
			}
		}
		logger.debug("getCandidates() Dto Impl returning dto list");
		return candidateDtoList;
	}

	/* (non-Javadoc)
	 * @see com.jaymen.flex.business.CandidateServiceDto#addCandidate()
	 */
	public Boolean addCandidate(Candidate candidate) {
		logger.debug("addCandidate() Dto Impl has been called");
		com.jaymen.flex.database.domain.Candidate candidateDomain = new com.jaymen.flex.database.domain.Candidate();
		BeanUtils.copyProperties(candidate, candidateDomain, new String[] {"employments"});
		return candidateDao.insertCandidate(candidateDomain);
	}

}
