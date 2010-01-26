package com.jaymen.candidate.dao.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

import com.jaymen.candidate.dao.exceptions.DaoStoreException;
import com.jaymen.candidate.model.Skill;

public class SkillDaoJpaTest {
	
	private EntityManager entityManager;
	private EntityTransaction transaction;
	private Query query;

	@Before
	public void setUp(){
		entityManager = mock(EntityManager.class);
		transaction = mock(EntityTransaction.class);
		query = mock(Query.class);
	}

	@Test
	public void persist() throws DaoStoreException{		
		Skill skill = createSkill(1, "test user");
		
		//Expectations
		when(entityManager.getTransaction()).thenReturn(transaction);
		doNothing().when(entityManager).persist(skill);
		
		SkillDaoJpa daoJpa = new SkillDaoJpa();
		daoJpa.setEntityManager(entityManager);
		Skill actual = daoJpa.persist(skill);
		
		assertSame(skill, actual);		
		verify(entityManager).persist(skill);		
	}
	
	@Test
	public void persistDaoStoreException(){		
		Skill skill = createSkill(1, "test user");
		IllegalStateException illegalStateException = new IllegalStateException("");
				
		//Expectations
		when(entityManager.getTransaction()).thenReturn(transaction);
		doThrow(illegalStateException).when(entityManager).persist(skill);
		
		SkillDaoJpa daoJpa = new SkillDaoJpa();
		daoJpa.setEntityManager(entityManager);
		try{
			//Test
			daoJpa.persist(skill);
			fail("Should have thrown an EntityExistsException");
		}catch (Exception e) {
			assertSame(illegalStateException, e.getCause());
		}		
		verify(entityManager).persist(skill);		
	}
	
	@Test
	public void remove() throws DaoStoreException{
		Skill skill = createSkill(1, "test user");
		
		when(entityManager.getTransaction()).thenReturn(transaction);
		doNothing().when(entityManager).remove(skill);
		
		SkillDaoJpa daoJpa = new SkillDaoJpa();
		daoJpa.setEntityManager(entityManager);
		daoJpa.remove(skill);
		
		verify(entityManager).remove(skill);		
	}	

	@Test
	public void removeDaoStoreException(){
		Skill skill = createSkill(1, "test user");
		IllegalStateException illegalStateException = new IllegalStateException("");
				
		when(entityManager.getTransaction()).thenReturn(transaction);
		doThrow(illegalStateException).when(entityManager).remove(skill);
		
		SkillDaoJpa daoJpa = new SkillDaoJpa();
		daoJpa.setEntityManager(entityManager);

		try{
			daoJpa.remove(skill);
			fail("Should have thrown an EntityExistsException");
		}catch (Exception e) {
			assertSame(illegalStateException, e.getCause());
		}		
		verify(entityManager).remove(skill);		
	}
	
	@Test
	public void findAll(){
		List<Skill> skills = createSkills();
		String queryString = "SELECT e FROM " + Skill.class.getName() + " e";
		
		when(query.getResultList()).thenReturn(skills);
		when(entityManager.createQuery(queryString)).thenReturn(query);		
		
		SkillDaoJpa daoJpa = new SkillDaoJpa();
		daoJpa.setEntityManager(entityManager);
		List<Skill> actual = daoJpa.findAll();

		verify(query).getResultList();
		verify(entityManager).createQuery(queryString);
		
		assertEquals(skills, actual);
	}
	
	@Test
	public void findById(){
		Skill skill = createSkill(1, "Test Skill");
		
		when(entityManager.find(Skill.class, skill.getId())).thenReturn(skill);		
		
		SkillDaoJpa daoJpa = new SkillDaoJpa();
		daoJpa.setEntityManager(entityManager);
		Skill actual = daoJpa.findById(skill.getId());

		verify(entityManager).find(Skill.class, skill.getId());
		assertSame(skill, actual);
	}
	
	@Test
	public void findByUnknownId(){
		Integer id = -1;
		when(entityManager.find(Skill.class, id)).thenReturn(null);		
		
		SkillDaoJpa daoJpa = new SkillDaoJpa();
		daoJpa.setEntityManager(entityManager);
		Skill actual = daoJpa.findById(id);

		verify(entityManager).find(Skill.class, id);
		assertNull(actual);
	}
	
	/**
	 * Method used for testing to construct test instances
	 * of Skill.
	 * 
	 * @param id Mocked primary id for the skill.
	 * @param name Mocked name for the skill.
	 * @return Mocked instance of a skill.
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
	 * @return List of mocked skill objects.
	 */
	public static List<Skill> createSkills(){
		List<Skill> skills = new ArrayList<Skill>();
		skills.add(createSkill(1, "One Skill"));
		skills.add(createSkill(2, "Two Skill"));
		skills.add(createSkill(3, "Three Skill"));
		
		return skills;
	}
}
