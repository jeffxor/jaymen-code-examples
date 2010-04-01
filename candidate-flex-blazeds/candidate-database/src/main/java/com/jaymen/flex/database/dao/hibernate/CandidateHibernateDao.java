package com.jaymen.flex.database.dao.hibernate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jaymen.flex.database.dao.CandidateDao;
import com.jaymen.flex.database.domain.Candidate;



public class CandidateHibernateDao extends HibernateDaoSupport implements
		CandidateDao {
	
	//Use slf4j for logging purposes
	private static Logger logger = LoggerFactory.getLogger(CandidateHibernateDao.class);
	
	@SuppressWarnings("unchecked")
	public List<Candidate> findCandidatesByName(String name) {
		logger.debug("searching for candidates matching name: " + name);
		return this.getHibernateTemplate().find("FROM com.jaymen.flex.database.domain.Candidate candidate " +
				"WHERE name like ?", name);
	}

	public Candidate getCandidate(Integer id) {
		logger.debug("finding candidate with id: " + id);
		return (Candidate) this.getHibernateTemplate().get(Candidate.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Candidate> getCandidates() {
		logger.debug("getting all candidates");
		return this.getHibernateTemplate().find("FROM com.jaymen.flex.database.domain.Candidate candidate");
	}

	public Boolean insertCandidate(Candidate candidate) {
		logger.debug("adding a new candidate");
		this.getHibernateTemplate().saveOrUpdate(candidate);
		return true;
	}

	public Boolean removeCandidate(Integer id) {
		logger.debug("removing candidate with id: " + id);
		this.getHibernateTemplate().delete(getCandidate(id));
		return true;
	}

	public Boolean updateCandidate(Candidate candidate) {
		logger.debug("updating candidate with id: " + candidate.getId());
		return this.insertCandidate(candidate);
	}

}
