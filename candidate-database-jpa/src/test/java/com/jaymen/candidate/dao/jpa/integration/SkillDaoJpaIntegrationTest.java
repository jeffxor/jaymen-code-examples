package com.jaymen.candidate.dao.jpa.integration;

import java.util.Collection;

import org.junit.Test;
import static  org.junit.Assert.*;

import com.jaymen.candidate.dao.exceptions.DaoStoreException;
import com.jaymen.candidate.dao.jpa.SkillDaoJpa;
import com.jaymen.candidate.model.Skill;

/**
 * Test skill dao functionality using the Java Persistence API.
 * 
 * The class extends {@link com.jaymen.candidate.dao.jpa.BaseDaoTest, BaseDaoTest}
 * which provides all the necessary setup and tear down operations.
 * 
 * @see com.jaymen.candidate.dao.jpa.integration.BaseDaoIntegrationTest
 */
public class SkillDaoJpaIntegrationTest extends BaseDaoIntegrationTest {

	/**
	 * A simple test to check we can find an existing Skill.
	 */
	@Test
	public void testFindById(){
		SkillDaoJpa dao = new SkillDaoJpa();
		dao.setEntityManager(this.em);
		
		Skill found = dao.findById(1);
		
		assertNotNull("candidate should not be null", found);
		assertEquals("candidate should have id 1", found.getId(), new Integer(1));
	}
	
	/**
	 * A simple test to check we can retrieve all candidates.
	 */
	@Test
	public void testFindByAll(){
		SkillDaoJpa dao = new SkillDaoJpa();
		dao.setEntityManager(this.em);
		
		Collection<Skill> found = dao.findAll();
		
		assertNotNull("Skill list should not be null", found);
		assertFalse("Skill list should not be null", found.isEmpty());
		assertEquals("Skill should have id 1", found.size(), 9);
	}
	/**
	 * Test to check we can remove a Skill from the database.
	 * @throws DaoStoreException 
	 */
	@Test
	public void testRemove() throws DaoStoreException{
		SkillDaoJpa dao = new SkillDaoJpa();
		dao.setEntityManager(this.em);
		
		Collection<Skill> found = dao.findAll();
		int initial = found.size();
		
		//remove the Skill
		Skill skill = dao.findById(new Integer(1));
		dao.remove(skill);
		
		found = dao.findAll();
		int after = found.size();
		
		assertEquals("Skill size should have decreased", initial - 1, after);
	}
	
	/**
	 * Test to check we can add a simple Skill to the database and 
	 * then retrieve it back. Simple Skill means it has no relationships.
	 * @throws DaoStoreException 
	 */
	@Test
	public void testPersit() throws DaoStoreException{
		SkillDaoJpa dao = new SkillDaoJpa();
		dao.setEntityManager(this.em);
		
		Collection<Skill> found = dao.findAll();
		int initial = found.size();
		
		Skill skill = new Skill();
		skill.setName("test Skill");
		
		dao.persist(skill);
		found = dao.findAll();
		int after = found.size();
		
		assertEquals("Skill size should have increased", initial + 1, after);
	}

}
