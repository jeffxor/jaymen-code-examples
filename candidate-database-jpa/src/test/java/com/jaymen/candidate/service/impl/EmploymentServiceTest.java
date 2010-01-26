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

import com.jaymen.candidate.dao.EmploymentDao;
import com.jaymen.candidate.dao.exceptions.DaoStoreException;
import com.jaymen.candidate.dao.jpa.EmploymentDaoJpaTest;
import com.jaymen.candidate.model.Employment;
import com.jaymen.candidate.service.EmploymentService;

/**
 * @author jeffxor
 *
 */

public class EmploymentServiceTest {

	private EmploymentDao dao;
	private EmploymentService service;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {	
		dao = mock(EmploymentDao.class);
		service = new EmploymentServiceImpl(dao);
	}

	@Test
	public void findAll(){
		List<Employment> employments = EmploymentDaoJpaTest.createEmployments();

		when(dao.findAll()).thenReturn(employments);

		Collection<Employment> result = service.findAll();

		verify(dao).findAll();
		assertEquals(3, result.size());		
	}

	@Test
	public void findById(){
		Employment employment = EmploymentDaoJpaTest.createEmployment(1, "Test Employment One");

		when(dao.findById(1)).thenReturn(employment);

		Employment employmentTest = service.findById(1);

		verify(dao).findById(1);
		assertSame(employment, employmentTest);
	}

	@Test
	public void findByUnknownId(){
		when(dao.findById(2)).thenReturn(null);

		Employment result = service.findById(2);

		verify(dao).findById(2);
		assertNull(result);
	}
	
	@Test
	public void persist() throws DaoStoreException{
		
		Employment employment = EmploymentDaoJpaTest.createEmployment(1, "test user");
				
		when(dao.persist(employment)).thenReturn(employment);
		
		Employment actual = service.persist(employment);

		verify(dao).persist(employment);
		assertSame(employment, actual);
	}
	
	@Test
	public void persistDaoStoreException() throws DaoStoreException{		
		Employment employment = EmploymentDaoJpaTest.createEmployment(1, "test user");
		IllegalStateException illegalStateException = new IllegalStateException("");
				
		//Expectations
		doThrow(illegalStateException).when(dao).persist(employment);
		
		try{
			//Test
			service.persist(employment);
			fail("Should have thrown an IllegalStateException");
		}catch (Exception e) {
			assertSame(illegalStateException, e);
		}		
		verify(dao).persist(employment);		
	}
	
	@Test
	public void remove() throws DaoStoreException{
		
		Employment employment = EmploymentDaoJpaTest.createEmployment(1, "test user");
				
		doNothing().when(dao).remove(employment);
		
		service.remove(employment);

		verify(dao).remove(employment);
	}
	
	@Test
	public void removeDaoStoreException() throws DaoStoreException{
		Employment employment = EmploymentDaoJpaTest.createEmployment(1, "test user");
		IllegalStateException illegalStateException = new IllegalStateException("");
				
		doThrow(illegalStateException).when(dao).remove(employment);

		try{
			service.remove(employment);
			fail("Should have thrown an IllegalStateException");
		}catch (Exception e) {
			assertSame(illegalStateException, e);
		}		
		verify(dao).remove(employment);		
	}
}
