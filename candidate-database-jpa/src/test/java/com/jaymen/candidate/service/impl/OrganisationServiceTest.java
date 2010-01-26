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

import com.jaymen.candidate.dao.OrganisationDao;
import com.jaymen.candidate.dao.exceptions.DaoStoreException;
import com.jaymen.candidate.dao.jpa.OrganisationDaoJpaTest;
import com.jaymen.candidate.model.Organisation;
import com.jaymen.candidate.service.OrganisationService;

/**
 * @author jeffxor
 *
 */

public class OrganisationServiceTest {

	private OrganisationDao dao;
	private OrganisationService service;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {	
		dao = mock(OrganisationDao.class);
		service = new OrganisationServiceImpl(dao);
	}

	@Test
	public void findAll(){
		List<Organisation> organisations = OrganisationDaoJpaTest.createOrganisations();

		when(dao.findAll()).thenReturn(organisations);

		Collection<Organisation> result = service.findAll();

		verify(dao).findAll();
		assertEquals(3, result.size());		
	}

	@Test
	public void findById(){
		Organisation organisation = OrganisationDaoJpaTest.createOrganisation(1, "Test Organisation One");

		when(dao.findById(1)).thenReturn(organisation);

		Organisation organisationTest = service.findById(1);

		verify(dao).findById(1);
		assertSame(organisation, organisationTest);
	}

	@Test
	public void findByUnknownId(){
		when(dao.findById(2)).thenReturn(null);

		Organisation result = service.findById(2);

		verify(dao).findById(2);
		assertNull(result);
	}
	
	@Test
	public void persist() throws DaoStoreException{
		
		Organisation organisation = OrganisationDaoJpaTest.createOrganisation(1, "test user");
				
		when(dao.persist(organisation)).thenReturn(organisation);
		
		Organisation actual = service.persist(organisation);

		verify(dao).persist(organisation);
		assertSame(organisation, actual);
	}
	
	@Test
	public void persistDaoStoreException() throws DaoStoreException{		
		Organisation organisation = OrganisationDaoJpaTest.createOrganisation(1, "test user");
		IllegalStateException illegalStateException = new IllegalStateException("");
				
		//Expectations
		doThrow(illegalStateException).when(dao).persist(organisation);
		
		try{
			//Test
			service.persist(organisation);
			fail("Should have thrown an IllegalStateException");
		}catch (Exception e) {
			assertSame(illegalStateException, e);
		}		
		verify(dao).persist(organisation);		
	}
	
	@Test
	public void remove() throws DaoStoreException{
		
		Organisation organisation = OrganisationDaoJpaTest.createOrganisation(1, "test user");
				
		doNothing().when(dao).remove(organisation);
		
		service.remove(organisation);

		verify(dao).remove(organisation);
	}
	
	@Test
	public void removeDaoStoreException() throws DaoStoreException{
		Organisation organisation = OrganisationDaoJpaTest.createOrganisation(1, "test user");
		IllegalStateException illegalStateException = new IllegalStateException("");
				
		doThrow(illegalStateException).when(dao).remove(organisation);

		try{
			service.remove(organisation);
			fail("Should have thrown an IllegalStateException");
		}catch (Exception e) {
			assertSame(illegalStateException, e);
		}		
		verify(dao).remove(organisation);		
	}
}
