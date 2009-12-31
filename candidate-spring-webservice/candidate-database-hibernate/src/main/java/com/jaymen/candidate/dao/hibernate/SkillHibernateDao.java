package com.jaymen.candidate.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jaymen.candidate.dao.SkillDao;
import com.jaymen.candidate.domain.Skill;

public class SkillHibernateDao extends HibernateDaoSupport implements SkillDao {

	@SuppressWarnings("unchecked")
	public List<Skill> findSkillByName(String name) {
		logger.debug("searching for skills matching name: " + name);
		return this.getHibernateTemplate().find("FROM com.jaymen.candidate.domain.Skill skill" +
				" WHERE name like ?", name);
	}

}
