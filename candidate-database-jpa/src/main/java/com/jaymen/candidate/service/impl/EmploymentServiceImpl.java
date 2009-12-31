package com.jaymen.candidate.service.impl;

import java.util.Collection;

import javax.ejb.EJB;

import com.jaymen.candidate.dao.EmploymentDao;
import com.jaymen.candidate.model.Employment;
import com.jaymen.candidate.service.EmploymentService;

public class EmploymentServiceImpl implements EmploymentService {

	@EJB(name="employmentDao")
	private EmploymentDao dao;
		
	/**
	 * Method for EJB autowired dependency injection.
	 * 
	 * @param dao
	 */
	public void setDao(EmploymentDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Collection<Employment> findAll() {
		return dao.findAll();
	}

	@Override
	public Employment findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public void persist(Employment employment) {
		dao.persist(employment);
	}

	@Override
	public void remove(Employment employment) {
		dao.remove(employment);
	}

}
