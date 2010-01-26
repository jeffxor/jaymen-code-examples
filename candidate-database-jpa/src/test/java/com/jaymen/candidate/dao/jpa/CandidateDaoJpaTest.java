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
import com.jaymen.candidate.model.Candidate;

/**
 * Simple unit testing for the CandidateDaoJpa class. The testing
 * uses mocking to provide unit testing. Mocking engine used is 
 * {@link  http://mockito.org/ Mockito}.
 * 
 * @author exitut
 *
 */
public class CandidateDaoJpaTest {
	
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
		Candidate candidate = createCandidate(1, "test user");
		
		//Expectations
		when(entityManager.getTransaction()).thenReturn(transaction);
		doNothing().when(entityManager).persist(candidate);
		
		CandidateDaoJpa daoJpa = new CandidateDaoJpa();
		daoJpa.setEntityManager(entityManager);
		Candidate actual = daoJpa.persist(candidate);
		
		assertSame(candidate, actual);		
		verify(entityManager).persist(candidate);		
	}
	
	@Test
	public void persistDaoStoreException(){		
		Candidate candidate = createCandidate(1, "test user");
		IllegalStateException illegalStateException = new IllegalStateException("");
				
		//Expectations
		when(entityManager.getTransaction()).thenReturn(transaction);
		doThrow(illegalStateException).when(entityManager).persist(candidate);
		
		CandidateDaoJpa daoJpa = new CandidateDaoJpa();
		daoJpa.setEntityManager(entityManager);
		try{
			//Test
			daoJpa.persist(candidate);
			fail("Should have thrown an IllegalStateException");
		}catch (Exception e) {
			assertSame(illegalStateException, e.getCause());
		}		
		verify(entityManager).persist(candidate);		
	}
	
	@Test
	public void remove() throws DaoStoreException{
		Candidate candidate = createCandidate(1, "test user");
		
		when(entityManager.getTransaction()).thenReturn(transaction);
		doNothing().when(entityManager).remove(candidate);
		
		CandidateDaoJpa daoJpa = new CandidateDaoJpa();
		daoJpa.setEntityManager(entityManager);
		daoJpa.remove(candidate);
		
		verify(entityManager).remove(candidate);		
	}	

	@Test
	public void removeDaoStoreException(){
		Candidate candidate = createCandidate(1, "test user");
		IllegalStateException illegalStateException = new IllegalStateException("");
				
		when(entityManager.getTransaction()).thenReturn(transaction);
		doThrow(illegalStateException).when(entityManager).remove(candidate);
		
		CandidateDaoJpa daoJpa = new CandidateDaoJpa();
		daoJpa.setEntityManager(entityManager);

		try{
			daoJpa.remove(candidate);
			fail("Should have thrown an IllegalStateException");
		}catch (Exception e) {
			assertSame(illegalStateException, e.getCause());
		}		
		verify(entityManager).remove(candidate);		
	}
	
	@Test
	public void findAll(){
		List<Candidate> candidates = createCandidates();
		String queryString = "SELECT e FROM " + Candidate.class.getName() + " e";
		
		when(query.getResultList()).thenReturn(candidates);
		when(entityManager.createQuery(queryString)).thenReturn(query);		
		
		CandidateDaoJpa daoJpa = new CandidateDaoJpa();
		daoJpa.setEntityManager(entityManager);
		List<Candidate> actual = daoJpa.findAll();

		verify(query).getResultList();
		verify(entityManager).createQuery(queryString);
		
		assertEquals(candidates, actual);
	}
	
	@Test
	public void findById(){
		Candidate candidate = createCandidate(1, "Test Candidate");
		
		when(entityManager.find(Candidate.class, candidate.getId())).thenReturn(candidate);		
		
		CandidateDaoJpa daoJpa = new CandidateDaoJpa();
		daoJpa.setEntityManager(entityManager);
		Candidate actual = daoJpa.findById(candidate.getId());

		verify(entityManager).find(Candidate.class, candidate.getId());
		assertSame(candidate, actual);
	}
	
	@Test
	public void findByUnknownId(){
		Integer id = -1;
		when(entityManager.find(Candidate.class, id)).thenReturn(null);		
		
		CandidateDaoJpa daoJpa = new CandidateDaoJpa();
		daoJpa.setEntityManager(entityManager);
		Candidate actual = daoJpa.findById(id);

		verify(entityManager).find(Candidate.class, id);
		assertNull(actual);
	}	
	
	/**
	 * Method used for testing to construct test instances
	 * of Candidate.
	 * 
	 * @param id Mocked primary id for the Candidate.
	 * @param name Mocked name for the Candidate.
	 * @return Mocked instance of a Candidate.
	 */
	public static Candidate createCandidate(Integer id, String name){
		Candidate candidate = new Candidate();
		candidate.setId(id);
		candidate.setName(name);
		
		return candidate;
	}
	
	/**
	 * This method creates a mocked list of Candidate for testing 
	 * purposes only.
	 * 
	 * @return List of mocked Candidate objects.
	 */
	public static List<Candidate> createCandidates(){
		List<Candidate> candidates = new ArrayList<Candidate>();
		candidates.add(createCandidate(1, "One Candidate"));
		candidates.add(createCandidate(2, "Two Candidate"));
		candidates.add(createCandidate(3, "Three Candidate"));
		
		return candidates;
	}
}
