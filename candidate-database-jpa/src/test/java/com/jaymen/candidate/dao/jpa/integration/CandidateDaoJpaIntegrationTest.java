package com.jaymen.candidate.dao.jpa.integration;

import java.util.Collection;

import org.junit.Test;
import static  org.junit.Assert.*;

import com.jaymen.candidate.dao.exceptions.DaoStoreException;
import com.jaymen.candidate.dao.jpa.CandidateDaoJpa;
import com.jaymen.candidate.model.Candidate;

/**
 * Test candidate dao functionality using the Java Persistence API.
 * 
 * The class extends {@link com.jaymen.candidate.dao.jpa.BaseDaoIntegrationTest, BaseDaoTest}
 * which provides all the necessary setup and tear down operations.
 * 
 * @see com.jaymen.candidate.dao.jpa.integration.BaseDaoIntegrationTest
 */
public class CandidateDaoJpaIntegrationTest extends BaseDaoIntegrationTest {

	/**
	 * A simple test to check we can find an existing candidate.
	 */
	@Test
	public void testFindById(){
		CandidateDaoJpa dao = new CandidateDaoJpa();
		dao.setEntityManager(this.em);
		
		Candidate found = dao.findById(1);
		
		assertNotNull("candidate should not be null", found);
		assertEquals("candidate should have id 1", found.getId(), new Integer(1));
	}
	
	/**
	 * A simple test to check we can retrieve all candidates.
	 */
	@Test
	public void testFindByAll(){
		CandidateDaoJpa dao = new CandidateDaoJpa();
		dao.setEntityManager(this.em);
		
		Collection<Candidate> found = dao.findAll();
		
		assertEquals("candidate should have 3 entries", found.size(), 3);
	}
	/**
	 * Test to check we can remove a candidate from the database.
	 * @throws DaoStoreException 
	 */
	@Test
	public void testRemove() throws DaoStoreException{
		CandidateDaoJpa dao = new CandidateDaoJpa();
		dao.setEntityManager(this.em);
		
		Collection<Candidate> found = dao.findAll();
		int initial = found.size();
		
		//remove the candidate
		Candidate candidate = dao.findById(new Integer(1));
		dao.remove(candidate);
		
		found = dao.findAll();
		int after = found.size();
		
		assertEquals("candidate size should have decreased", initial - 1, after);
	}
	
	/**
	 * Test to check we can add a simple candidate to the database and 
	 * then retrieve it back. Simple candidate means it has no relationships.
	 * @throws DaoStoreException 
	 */
	@Test
	public void testPersit() throws DaoStoreException{
		CandidateDaoJpa dao = new CandidateDaoJpa();
		dao.setEntityManager(this.em);
		
		Collection<Candidate> found = dao.findAll();
		int initial = found.size();
		
		Candidate candidate = new Candidate();
		candidate.setName("test candidate");
		candidate.setAddress("test address");
		candidate.setEmail("test@test.com");
		
		dao.persist(candidate);
		found = dao.findAll();
		int after = found.size();
		
		assertEquals("candidate size should have increased", initial + 1, after);
	}

}
