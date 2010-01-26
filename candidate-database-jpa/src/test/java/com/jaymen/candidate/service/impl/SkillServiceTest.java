/**
 * 
 */
package com.jaymen.candidate.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.jaymen.candidate.dao.SkillDao;
import com.jaymen.candidate.dao.exceptions.DaoStoreException;
import com.jaymen.candidate.dao.jpa.SkillDaoJpaTest;
import com.jaymen.candidate.model.Skill;
import com.jaymen.candidate.service.SkillService;

/**
 * @author jeffxor
 *
 */

public class SkillServiceTest {

	private SkillDao dao;
	private SkillService service;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {	
		dao = mock(SkillDao.class);
		service = new SkillServiceImpl(dao);
	}

	@Test
	public void findAll(){
		List<Skill> skills = SkillDaoJpaTest.createSkills();

		when(dao.findAll()).thenReturn(skills);

		Collection<Skill> result = service.findAll();

		verify(dao).findAll();
		assertEquals(3, result.size());		
	}

	@Test
	public void findById(){
		Skill skill = SkillDaoJpaTest.createSkill(1, "Test Skill One");

		when(dao.findById(1)).thenReturn(skill);

		Skill skillTest = service.findById(1);

		verify(dao).findById(1);
		assertSame(skill, skillTest);
	}

	@Test
	public void findByUnknownId(){
		when(dao.findById(2)).thenReturn(null);

		Skill result = service.findById(2);

		verify(dao).findById(2);
		assertNull(result);
	}
	
	@Test
	public void persist() throws DaoStoreException{
		
		Skill skill = SkillDaoJpaTest.createSkill(1, "test user");
				
		when(dao.persist(skill)).thenReturn(skill);
		
		Skill actual = service.persist(skill);

		verify(dao).persist(skill);
		assertSame(skill, actual);
	}
	
	@Test
	public void persistDaoStoreException() throws DaoStoreException{		
		Skill skill = SkillDaoJpaTest.createSkill(1, "test user");
		IllegalStateException illegalStateException = new IllegalStateException("");
				
		//Expectations
		doThrow(illegalStateException).when(dao).persist(skill);
		
		try{
			//Test
			service.persist(skill);
			fail("Should have thrown an IllegalStateException");
		}catch (Exception e) {
			assertSame(illegalStateException, e);
		}		
		verify(dao).persist(skill);		
	}
	
	@Test
	public void remove() throws DaoStoreException{
		
		Skill skill = SkillDaoJpaTest.createSkill(1, "test user");
				
		doNothing().when(dao).remove(skill);
		
		service.remove(skill);

		verify(dao).remove(skill);
	}
	
	@Test
	public void removeDaoStoreException() throws DaoStoreException{
		Skill skill = SkillDaoJpaTest.createSkill(1, "test user");
		IllegalStateException illegalStateException = new IllegalStateException("");
				
		doThrow(illegalStateException).when(dao).remove(skill);

		try{
			service.remove(skill);
			fail("Should have thrown an IllegalStateException");
		}catch (Exception e) {
			assertSame(illegalStateException, e);
		}		
		verify(dao).remove(skill);		
	}
}
