package com.jaymen.candidate.dao.hibernate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jaymen.candidate.dao.OrganisationDao;
import com.jaymen.candidate.domain.Organisation;

public class OrganisationHibernateDao extends HibernateDaoSupport implements
		OrganisationDao {
	
	//Use slf4j for logging purposes
	private static Logger logger = LoggerFactory.getLogger(OrganisationHibernateDao.class);
	
	@SuppressWarnings("unchecked")
	public List<Organisation> findOrganisationsByName(String name) {
		logger.debug("searching for organisations matching name: " + name);
		return this.getHibernateTemplate().find("FROM com.jaymen.candidate.domain.Organisation organisation " +
				"WHERE name like ?", name);
	}

	public Organisation getOrganisation(Integer id) {
		logger.debug("finding organisation with id: " + id);
		return (Organisation) this.getHibernateTemplate().get(Organisation.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Organisation> getOrganisations() {
		logger.debug("getting all organisations");
		return this.getHibernateTemplate().find("FROM com.jaymen.candidate.domain.Organisation organisation");
	}

	public Organisation insertOrganisation(Organisation organisation) {
		logger.debug("adding a new organisation");
		this.getHibernateTemplate().saveOrUpdate(organisation);
		return organisation;
	}

	public Boolean removeOrganisation(Integer id) {
		logger.debug("removing organisation with id: " + id);
		this.getHibernateTemplate().delete(getOrganisation(id));
		return true;
	}

	public Organisation updateOrganisation(Organisation organisation) {
		logger.debug("updating organisation with id: " + organisation.getId());
		return this.insertOrganisation(organisation);
	}
}
