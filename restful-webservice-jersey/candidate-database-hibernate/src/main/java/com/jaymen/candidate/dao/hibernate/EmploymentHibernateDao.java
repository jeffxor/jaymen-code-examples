package com.jaymen.candidate.dao.hibernate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jaymen.candidate.dao.EmploymentDao;
import com.jaymen.candidate.domain.Employment;

public class EmploymentHibernateDao extends HibernateDaoSupport implements
		EmploymentDao {
	
	//Use slf4j for logging purposes
	private static Logger logger = LoggerFactory.getLogger(EmploymentHibernateDao.class);
	
	@SuppressWarnings("unchecked")
	public List<Employment> getEmploymentsByCandidateId(Integer candidateId) {
		logger.debug("find all employments for candidate id: " + candidateId);
		return this.getHibernateTemplate().find("FROM com.jaymen.candidate.domain.Employment " +
				"WHERE candidate.id = ?", candidateId);
	}

	@SuppressWarnings("unchecked")
	public List<Employment> getEmploymentsByOrganisationId(
			Integer organisationId) {
		logger.debug("find all employments for organisation id: " + organisationId);
		return this.getHibernateTemplate().find("FROM com.jaymen.candidate.domain.Employment " +
				"WHERE organisation.id = ?", organisationId);
	}

	@SuppressWarnings("unchecked")
	public List<Employment> getEmploymentsBySkillId(Integer skillId) {
		logger.debug("find all employments for skill id: " + skillId);
		return this.getHibernateTemplate().find("SELECT e FROM com.jaymen.candidate.domain.Employment e " +
				"JOIN e.skills s "  +
				"WHERE s.id = ?", skillId);
	}

}
