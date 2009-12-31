package com.jaymen.candidate.service;

import java.util.Collection;

import com.jaymen.candidate.model.Skill;

public interface SkillService {
	void persist(Skill skill);
    void remove(Skill skill);
    Skill findById(Integer id);
    Collection<Skill> findAll();
}
