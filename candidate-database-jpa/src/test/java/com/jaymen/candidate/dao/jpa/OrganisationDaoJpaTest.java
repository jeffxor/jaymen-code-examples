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
import com.jaymen.candidate.model.Organisation;

public class OrganisationDaoJpaTest {
	
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
		Organisation organisation = createOrganisation(1, "test user");
		
		//Expectations
		when(entityManager.getTransaction()).thenReturn(transaction);
		doNothing().when(entityManager).persist(organisation);
		
		OrganisationDaoJpa daoJpa = new OrganisationDaoJpa();
		daoJpa.setEntityManager(entityManager);
		Organisation actual = daoJpa.persist(organisation);
		
		assertSame(organisation, actual);		
		verify(entityManager).persist(organisation);		
	}
	
	@Test
	public void persistDaoStoreException(){		
		Organisation organisation = createOrganisation(1, "test user");
		IllegalStateException illegalStateException = new IllegalStateException("");
				
		//Expectations
		when(entityManager.getTransaction()).thenReturn(transaction);
		doThrow(illegalStateException).when(entityManager).persist(organisation);
		
		OrganisationDaoJpa daoJpa = new OrganisationDaoJpa();
		daoJpa.setEntityManager(entityManager);
		try{
			//Test
			daoJpa.persist(organisation);
			fail("Should have thrown an EntityExistsException");
		}catch (Exception e) {
			assertSame(illegalStateException, e.getCause());
		}		
		verify(entityManager).persist(organisation);		
	}
	
	@Test
	public void remove() throws DaoStoreException{
		Organisation organisation = createOrganisation(1, "test user");
		
		when(entityManager.getTransaction()).thenReturn(transaction);
		doNothing().when(entityManager).remove(organisation);
		
		OrganisationDaoJpa daoJpa = new OrganisationDaoJpa();
		daoJpa.setEntityManager(entityManager);
		daoJpa.remove(organisation);
		
		verify(entityManager).remove(organisation);		
	}	

	@Test
	public void removeDaoStoreException(){
		Organisation organisation = createOrganisation(1, "test user");
		IllegalStateException illegalStateException = new IllegalStateException("");
				
		when(entityManager.getTransaction()).thenReturn(transaction);
		doThrow(illegalStateException).when(entityManager).remove(organisation);
		
		OrganisationDaoJpa daoJpa = new OrganisationDaoJpa();
		daoJpa.setEntityManager(entityManager);

		try{
			daoJpa.remove(organisation);
			fail("Should have thrown an EntityExistsException");
		}catch (Exception e) {
			assertSame(illegalStateException, e.getCause());
		}		
		verify(entityManager).remove(organisation);		
	}
	
	@Test
	public void findAll(){
		List<Organisation> organisations = createOrganisations();
		String queryString = "SELECT e FROM " + Organisation.class.getName() + " e";
		
		when(query.getResultList()).thenReturn(organisations);
		when(entityManager.createQuery(queryString)).thenReturn(query);		
		
		OrganisationDaoJpa daoJpa = new OrganisationDaoJpa();
		daoJpa.setEntityManager(entityManager);
		List<Organisation> actual = daoJpa.findAll();

		verify(query).getResultList();
		verify(entityManager).createQuery(queryString);
		
		assertEquals(organisations, actual);
	}
	
	@Test
	public void findById(){
		Organisation organisation = createOrganisation(1, "Test Organisation");
		
		when(entityManager.find(Organisation.class, organisation.getId())).thenReturn(organisation);		
		
		OrganisationDaoJpa daoJpa = new OrganisationDaoJpa();
		daoJpa.setEntityManager(entityManager);
		Organisation actual = daoJpa.findById(organisation.getId());

		verify(entityManager).find(Organisation.class, organisation.getId());
		assertSame(organisation, actual);
	}
	
	@Test
	public void findByUnknownId(){
		Integer id = -1;
		when(entityManager.find(Organisation.class, id)).thenReturn(null);		
		
		OrganisationDaoJpa daoJpa = new OrganisationDaoJpa();
		daoJpa.setEntityManager(entityManager);
		Organisation actual = daoJpa.findById(id);

		verify(entityManager).find(Organisation.class, id);
		assertNull(actual);
	}
	
	/**
	 * Method used for testing to construct test instances
	 * of Organisation.
	 * 
	 * @param id Mocked primary id for the Organisation.
	 * @param name Mocked name for the Organisation.
	 * @return Mocked instance of a Organisation.
	 */
	public static Organisation createOrganisation(Integer id, String name){
		Organisation organisation = new Organisation();
		organisation.setId(id);
		organisation.setName(name);
		
		return organisation;
	}
	
	/**
	 * This method creates a mocked list of Organisation for testing 
	 * purposes only.
	 * 
	 * @return List of mocked Organisation objects.
	 */
	public static List<Organisation> createOrganisations(){
		List<Organisation> organisations = new ArrayList<Organisation>();
		organisations.add(createOrganisation(1, "One Organisation"));
		organisations.add(createOrganisation(2, "Two Organisation"));
		organisations.add(createOrganisation(3, "Three Organisation"));
		
		return organisations;
	}
}
