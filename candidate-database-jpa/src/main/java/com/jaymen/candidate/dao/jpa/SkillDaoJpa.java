package com.jaymen.candidate.dao.jpa;

import com.jaymen.candidate.dao.SkillDao;
import com.jaymen.candidate.model.Skill;

/**
 * Implementation using Java Persistence API of the skill dao interface.
 * 
 * The basic API function find, update, delete have been abstracted out to a base class
 * @see com.jaymen.candidate.dao.jpa.AbstractDao
 * 
 */
public class SkillDaoJpa extends AbstractDao<Integer, Skill> implements SkillDao {

}
