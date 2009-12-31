package com.jaymen.candidate.service.impl;

import java.util.Collection;

import javax.ejb.EJB;

import com.jaymen.candidate.dao.OrganisationDao;
import com.jaymen.candidate.model.Organisation;
import com.jaymen.candidate.service.OrganisationService;

public class OrganisationServiceImpl implements OrganisationService {
	
	@EJB(name="organisationDao")
	private OrganisationDao dao;
		
	/**
	 * Method for EJB autowired dependency injection.
	 * 
	 * @param dao
	 */
	public void setDao(OrganisationDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Collection<Organisation> findAll() {
		return dao.findAll();
	}

	@Override
	public Organisation findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public void persist(Organisation organisation) {
		dao.persist(organisation);
	}

	@Override
	public void remove(Organisation organisation) {
		dao.remove(organisation);
	}

}
