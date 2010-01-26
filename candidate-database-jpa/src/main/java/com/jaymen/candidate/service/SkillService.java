package com.jaymen.candidate.service;

import java.util.List;

import com.jaymen.candidate.dao.exceptions.DaoStoreException;
import com.jaymen.candidate.model.Skill;

/**
 * Defines service level operations allowed for skill entities.
 */
public interface SkillService {
	Skill persist(Skill skill) throws DaoStoreException;
	void remove(Skill skill) throws DaoStoreException;
    Skill findById(Integer id);
    List<Skill> findAll();
}
