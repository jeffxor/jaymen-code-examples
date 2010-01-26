package com.jaymen.candidate.dao.jpa.integration;

import java.util.Collection;

import org.junit.Test;
import static  org.junit.Assert.*;

import com.jaymen.candidate.dao.exceptions.DaoStoreException;
import com.jaymen.candidate.dao.jpa.CandidateDaoJpa;
import com.jaymen.candidate.dao.jpa.EmploymentDaoJpa;
import com.jaymen.candidate.dao.jpa.OrganisationDaoJpa;
import com.jaymen.candidate.model.Candidate;
import com.jaymen.candidate.model.Employment;
import com.jaymen.candidate.model.Organisation;

/**
 * Test employment dao functionality using the Java Persistence API.
 * 
 * The class extends {@link com.jaymen.candidate.dao.jpa.BaseDaoTest, BaseDaoTest}
 * which provides all the necessary setup and tear down operations.
 * 
 * @see com.jaymen.candidate.dao.jpa.integration.BaseDaoIntegrationTest
 */
public class EmploymentDaoJpaIntegrationTest extends BaseDaoIntegrationTest {

	/**
	 * A simple test to check we can find an existing Employment.
	 */
	@Test
	public void testFindById(){
		EmploymentDaoJpa dao = new EmploymentDaoJpa();
		dao.setEntityManager(this.em);
		
		Employment found = dao.findById(1);
		
		assertNotNull("employment should not be null", found);
		assertEquals("employment should have id 1", found.getId(), new Integer(1));
	}
	
	/**
	 * A simple test to check we can retrieve all candidates.
	 */
	@Test
	public void testFindByAll(){
		EmploymentDaoJpa dao = new EmploymentDaoJpa();
		dao.setEntityManager(this.em);
		
		Collection<Employment> found = dao.findAll();
		
		assertNotNull("Employment list should not be null", found);
		assertFalse("Employment list should not be null", found.isEmpty());
		assertEquals("Employment should have id 1", found.size(), 7);
	}
	/**
	 * Test to check we can remove a Employment from the database.
	 * @throws DaoStoreException 
	 */
	@Test
	public void testRemove() throws DaoStoreException{
		EmploymentDaoJpa dao = new EmploymentDaoJpa();
		dao.setEntityManager(this.em);
		
		Collection<Employment> found = dao.findAll();
		int initial = found.size();
		
		//remove the Employment
		Employment employment = dao.findById(new Integer(1));
		dao.remove(employment);
		
		found = dao.findAll();
		int after = found.size();
		
		assertEquals("Employment size should have decreased", initial - 1, after);
	}
	
	/**
	 * Test to check we can add a simple Employment to the database and 
	 * then retrieve it back. Simple Employment means it has no relationships.
	 * @throws DaoStoreException 
	 */
	@Test
	public void testPersit() throws DaoStoreException{
		EmploymentDaoJpa dao = new EmploymentDaoJpa();
		dao.setEntityManager(this.em);
		
		Collection<Employment> found = dao.findAll();
		int initial = found.size();
		
		Employment employment = new Employment();
		employment.setJobTitle("test Employment");
		
		dao.persist(employment);
		found = dao.findAll();
		int after = found.size();
		
		assertEquals("Employment size should have increased", initial + 1, after);
	}

	/**
	 * Test to check that we can search for a candidates employments.
	 */
	@Test
	public void testFindByCandidate(){
		EmploymentDaoJpa dao = new EmploymentDaoJpa();
		CandidateDaoJpa candidateDaoJpa = new CandidateDaoJpa();
		dao.setEntityManager(this.em);
		candidateDaoJpa.setEntityManager(this.em);
		
		Candidate candidate = candidateDaoJpa.findById(1);
		
		Collection<Employment> found = dao.findByCandidate(candidate);
		
		assertFalse("should return a list", found.isEmpty());
		assertEquals("list should contain", 3, found.size());
	}
	
	/**
	 * Test to check that we can search for a Organisations employments.
	 */
	@Test
	public void testFindByOrganisation(){
		EmploymentDaoJpa dao = new EmploymentDaoJpa();
		OrganisationDaoJpa OrganisationDaoJpa = new OrganisationDaoJpa();
		dao.setEntityManager(this.em);
		OrganisationDaoJpa.setEntityManager(this.em);
		
		Organisation Organisation = OrganisationDaoJpa.findById(1);
		
		Collection<Employment> found = dao.findByOrganisation(Organisation);
		
		assertFalse("should return a list", found.isEmpty());
		assertEquals("list should contain", 2, found.size());
	}	
}
