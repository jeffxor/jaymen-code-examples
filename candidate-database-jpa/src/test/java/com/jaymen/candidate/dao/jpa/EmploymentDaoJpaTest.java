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
import com.jaymen.candidate.model.Employment;

public class EmploymentDaoJpaTest {
	
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
		Employment employment = createEmployment(1, "test user");
		
		//Expectations
		when(entityManager.getTransaction()).thenReturn(transaction);
		doNothing().when(entityManager).persist(employment);
		
		EmploymentDaoJpa daoJpa = new EmploymentDaoJpa();
		daoJpa.setEntityManager(entityManager);
		Employment actual = daoJpa.persist(employment);
		
		assertSame(employment, actual);		
		verify(entityManager).persist(employment);		
	}
	
	@Test
	public void persistDaoStoreException(){		
		Employment employment = createEmployment(1, "test user");
		IllegalStateException illegalStateException = new IllegalStateException("");
				
		//Expectations
		when(entityManager.getTransaction()).thenReturn(transaction);
		doThrow(illegalStateException).when(entityManager).persist(employment);
		
		EmploymentDaoJpa daoJpa = new EmploymentDaoJpa();
		daoJpa.setEntityManager(entityManager);
		try{
			//Test
			daoJpa.persist(employment);
			fail("Should have thrown an EntityExistsException");
		}catch (Exception e) {
			assertSame(illegalStateException, e.getCause());
		}		
		verify(entityManager).persist(employment);		
	}
	
	@Test
	public void remove() throws DaoStoreException{
		Employment employment = createEmployment(1, "test user");
		
		when(entityManager.getTransaction()).thenReturn(transaction);
		doNothing().when(entityManager).remove(employment);
		
		EmploymentDaoJpa daoJpa = new EmploymentDaoJpa();
		daoJpa.setEntityManager(entityManager);
		daoJpa.remove(employment);
		
		verify(entityManager).remove(employment);		
	}	

	@Test
	public void removeDaoStoreException(){
		Employment employment = createEmployment(1, "test user");
		IllegalStateException illegalStateException = new IllegalStateException("");
				
		when(entityManager.getTransaction()).thenReturn(transaction);
		doThrow(illegalStateException).when(entityManager).remove(employment);
		
		EmploymentDaoJpa daoJpa = new EmploymentDaoJpa();
		daoJpa.setEntityManager(entityManager);

		try{
			daoJpa.remove(employment);
			fail("Should have thrown an EntityExistsException");
		}catch (Exception e) {
			assertSame(illegalStateException, e.getCause());
		}		
		verify(entityManager).remove(employment);		
	}
	
	@Test
	public void findAll(){
		List<Employment> employments = createEmployments();
		String queryString = "SELECT e FROM " + Employment.class.getName() + " e";
		
		when(query.getResultList()).thenReturn(employments);
		when(entityManager.createQuery(queryString)).thenReturn(query);		
		
		EmploymentDaoJpa daoJpa = new EmploymentDaoJpa();
		daoJpa.setEntityManager(entityManager);
		List<Employment> actual = daoJpa.findAll();

		verify(query).getResultList();
		verify(entityManager).createQuery(queryString);
		
		assertEquals(employments, actual);
	}
	
	@Test
	public void findById(){
		Employment employment = createEmployment(1, "Test Employment");
		
		when(entityManager.find(Employment.class, employment.getId())).thenReturn(employment);		
		
		EmploymentDaoJpa daoJpa = new EmploymentDaoJpa();
		daoJpa.setEntityManager(entityManager);
		Employment actual = daoJpa.findById(employment.getId());

		verify(entityManager).find(Employment.class, employment.getId());
		assertSame(employment, actual);
	}
	
	@Test
	public void findByUnknownId(){
		Integer id = -1;
		when(entityManager.find(Employment.class, id)).thenReturn(null);		
		
		EmploymentDaoJpa daoJpa = new EmploymentDaoJpa();
		daoJpa.setEntityManager(entityManager);
		Employment actual = daoJpa.findById(id);

		verify(entityManager).find(Employment.class, id);
		assertNull(actual);
	}
	
	/**
	 * Method used for testing to construct test instances
	 * of Employment.
	 * 
	 * @param id Mocked primary id for the Employment.
	 * @param name Mocked name for the Employment.
	 * @return Mocked instance of a Employment.
	 */
	public static Employment createEmployment(Integer id, String name){
		Employment employment = new Employment();
		employment.setId(id);
		employment.setJobTitle(name);
		
		return employment;
	}
	
	/**
	 * This method creates a mocked list of Employment for testing 
	 * purposes only.
	 * 
	 * @return List of mocked Employment objects.
	 */
	public static List<Employment> createEmployments(){
		List<Employment> employments = new ArrayList<Employment>();
		employments.add(createEmployment(1, "One Employment"));
		employments.add(createEmployment(2, "Two Employment"));
		employments.add(createEmployment(3, "Three Employment"));
		
		return employments;
	}
}
