package com.jaymen.candidate.dao.jpa.integration;

import java.util.Collection;

import org.junit.Test;
import static  org.junit.Assert.*;

import com.jaymen.candidate.dao.exceptions.DaoStoreException;
import com.jaymen.candidate.dao.jpa.OrganisationDaoJpa;
import com.jaymen.candidate.model.Organisation;


/**
 * Test organisation dao functionality using the Java Persistence API.
 * 
 * The class extends {@link com.jaymen.candidate.dao.jpa.BaseDaoTest, BaseDaoTest}
 * which provides all the necessary setup and tear down operations.
 * 
 * @see com.jaymen.candidate.dao.jpa.integration.BaseDaoIntegrationTest
 */
public class OrganisationDaoJpaIntegrationTest extends BaseDaoIntegrationTest {

	/**
	 * A simple test to check we can find an existing Organisation.
	 */
	@Test
	public void testFindById(){
		OrganisationDaoJpa dao = new OrganisationDaoJpa();
		dao.setEntityManager(this.em);
		
		Organisation found = dao.findById(1);
		
		assertNotNull("candidate should not be null", found);
		assertEquals("candidate should have id 1", found.getId(), new Integer(1));
	}
	
	/**
	 * A simple test to check we can retrieve all candidates.
	 */
	@Test
	public void testFindByAll(){
		OrganisationDaoJpa dao = new OrganisationDaoJpa();
		dao.setEntityManager(this.em);
		
		Collection<Organisation> found = dao.findAll();
		
		assertNotNull("Organisation list should not be null", found);
		assertFalse("Organisation list should not be null", found.isEmpty());
		assertEquals("Organisation should have id 1", found.size(), 3);
	}
	/**
	 * Test to check we can remove a Organisation from the database.
	 * @throws DaoStoreException 
	 */
	@Test
	public void testRemove() throws DaoStoreException{
		OrganisationDaoJpa dao = new OrganisationDaoJpa();
		dao.setEntityManager(this.em);
		
		Collection<Organisation> found = dao.findAll();
		int initial = found.size();
		
		//remove the Organisation
		Organisation organisation = dao.findById(new Integer(1));
		dao.remove(organisation);
		
		found = dao.findAll();
		int after = found.size();
		
		assertEquals("Organisation size should have decreased", initial - 1, after);
	}
	
	/**
	 * Test to check we can add a simple Organisation to the database and 
	 * then retrieve it back. Simple Organisation means it has no relationships.
	 * @throws DaoStoreException 
	 */
	@Test
	public void testPersit() throws DaoStoreException{
		OrganisationDaoJpa dao = new OrganisationDaoJpa();
		dao.setEntityManager(this.em);
		
		Collection<Organisation> found = dao.findAll();
		int initial = found.size();
		
		Organisation organisation = new Organisation();
		organisation.setName("test Organisation");
		organisation.setAddress("test address");
		organisation.setEmail("test@test.com");
		
		dao.persist(organisation);
		found = dao.findAll();
		int after = found.size();
		
		assertEquals("Organisation size should have increased", initial + 1, after);
	}

}
