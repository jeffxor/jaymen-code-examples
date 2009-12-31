package com.jaymen.candidate.service.impl;

import java.util.Collection;

import javax.ejb.EJB;

import com.jaymen.candidate.dao.SkillDao;
import com.jaymen.candidate.model.Skill;
import com.jaymen.candidate.service.SkillService;

public class SkillServiceImpl implements SkillService{
	
	@EJB(name="skillDao")
	private SkillDao dao;
		
	/**
	 * Method for EJB autowired dependency injection.
	 * 
	 * @param dao
	 */
	public void setDao(SkillDao dao) {
		this.dao = dao;
	}

	@Override
	public Collection<Skill> findAll() {
		return dao.findAll();
	}

	@Override
	public Skill findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public void persist(Skill skill) {
		dao.persist(skill);
	}

	@Override
	public void remove(Skill skill) {
		dao.remove(skill);
	}

}
