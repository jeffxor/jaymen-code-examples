package com.jaymen.candidate.service.impl;

import java.util.List;

import javax.ejb.EJB;

import com.jaymen.candidate.dao.EmploymentDao;
import com.jaymen.candidate.dao.exceptions.DaoStoreException;
import com.jaymen.candidate.model.Employment;
import com.jaymen.candidate.service.EmploymentService;

/**
 * Provides a fully working implementation of the employment service.
 *
 */
public class EmploymentServiceImpl implements EmploymentService {

	@EJB(name="employmentDao")
	private EmploymentDao dao;
		
	/**
	 * Method for EJB autowired dependency injection.
	 * 
	 * @param dao
	 */
	public EmploymentServiceImpl(EmploymentDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<Employment> findAll() {
		return dao.findAll();
	}

	@Override
	public Employment findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public Employment persist(Employment employment) throws DaoStoreException {
		return dao.persist(employment);
	}

	@Override
	public void remove(Employment employment) throws DaoStoreException {
		dao.remove(employment);
	}

}
