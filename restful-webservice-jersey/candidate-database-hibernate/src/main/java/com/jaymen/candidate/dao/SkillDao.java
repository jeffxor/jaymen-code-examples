package com.jaymen.candidate.dao;

import java.util.List;

import com.jaymen.candidate.domain.Skill;

public interface SkillDao {

	public List<Skill> findSkillByName(String name);
}
