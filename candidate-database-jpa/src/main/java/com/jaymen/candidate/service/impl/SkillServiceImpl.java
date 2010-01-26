package com.jaymen.candidate.service.impl;

import java.util.List;

import javax.ejb.EJB;

import com.jaymen.candidate.dao.SkillDao;
import com.jaymen.candidate.dao.exceptions.DaoStoreException;
import com.jaymen.candidate.model.Skill;
import com.jaymen.candidate.service.SkillService;

/**
 * Provides a fully working implementation of the skill service.
 *
 */
public class SkillServiceImpl implements SkillService{
	
	@EJB(name="skillDao")
	private SkillDao dao;
		
	/**
	 * Method for EJB autowired dependency injection.
	 * 
	 * @param dao
	 */
	public SkillServiceImpl(SkillDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<Skill> findAll() {
		return dao.findAll();
	}

	@Override
	public Skill findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public Skill persist(Skill skill) throws DaoStoreException {
		return dao.persist(skill);
	}

	@Override
	public void remove(Skill skill) throws DaoStoreException {
		dao.remove(skill);
	}

}
