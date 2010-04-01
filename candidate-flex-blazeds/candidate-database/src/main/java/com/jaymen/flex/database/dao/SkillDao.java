package com.jaymen.flex.database.dao;

import java.util.List;

import com.jaymen.flex.database.domain.Skill;


public interface SkillDao {

	public List<Skill> findSkillByName(String name);
}
