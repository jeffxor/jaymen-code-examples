package com.jaymen.candidate.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.jaymen.candidate.domain.Skill;


public class SkillHibernateDaoTest {

	private HibernateTemplate hibernateTemplate;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		hibernateTemplate = mock(HibernateTemplate.class);
	}

	@Test
	public void findSkillByName(){

		String queryString = "FROM com.jaymen.candidate.domain.Skill skill WHERE name like ?";
		String name = "Test Candidate";

		List<Skill> candidates = createSkills();

		when(hibernateTemplate.find(queryString, name)).thenReturn(candidates);

		SkillHibernateDao dao = new SkillHibernateDao();
		dao.setHibernateTemplate(hibernateTemplate);
		List<Skill> actual = dao.findSkillByName(name);

		verify(hibernateTemplate).find(queryString, name);
		assertSame(candidates, actual);
	}
	
	/**
	 * Method used for testing to construct test instances
	 * of Skill.
	 * 
	 * @param id Mocked primary id for the Skill.
	 * @param name Mocked name for the Skill.
	 * @return Mocked instance of a Skill.
	 */
	public static Skill createSkill(Integer id, String name){
		Skill skill = new Skill();
		skill.setId(id);
		skill.setName(name);
		
		return skill;
	}
	
	/**
	 * This method creates a mocked list of Skill for testing 
	 * purposes only.
	 * 
	 * @return List of mocked Skill objects.
	 */
	public static List<Skill> createSkills(){
		List<Skill> skills = new ArrayList<Skill>();
		skills.add(createSkill(1, "One Skill"));
		skills.add(createSkill(2, "Two Skill"));
		skills.add(createSkill(3, "Three Skill"));
		
		return skills;
	}
}
