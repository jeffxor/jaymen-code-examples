package com.jaymen.candidate.service.impl;

import java.util.List;

import javax.ejb.EJB;

import com.jaymen.candidate.dao.OrganisationDao;
import com.jaymen.candidate.dao.exceptions.DaoStoreException;
import com.jaymen.candidate.model.Organisation;
import com.jaymen.candidate.service.OrganisationService;

/**
 * Provides a fully working implementation of the organisation service.
 *
 */
public class OrganisationServiceImpl implements OrganisationService {
	
	@EJB(name="organisationDao")
	private OrganisationDao dao;

	/**
	 * EJB3.1 Dependency injection used.
	 * 
	 * @param dao
	 */	
	public OrganisationServiceImpl(OrganisationDao dao) {
		super();
		this.dao = dao;
	}
	
	@Override
	public List<Organisation> findAll() {
		return dao.findAll();
	}

	@Override
	public Organisation findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public Organisation persist(Organisation organisation) throws DaoStoreException {
		return dao.persist(organisation);
	}

	@Override
	public void remove(Organisation organisation) throws DaoStoreException {
		dao.remove(organisation);
	}

}
