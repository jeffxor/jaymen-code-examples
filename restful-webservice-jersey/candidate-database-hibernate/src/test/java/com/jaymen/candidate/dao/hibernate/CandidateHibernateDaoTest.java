/**
 * 
 */
package com.jaymen.candidate.dao.hibernate;


import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.jaymen.candidate.domain.Candidate;
/**
 * @author exitut
 *
 */
public class CandidateHibernateDaoTest {
	
	private HibernateTemplate hibernateTemplate;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		hibernateTemplate = mock(HibernateTemplate.class);

	}
	
	@Test
	public void getCandidates(){
		List<Candidate> candidates = createCandidates();
		String queryString = "FROM com.jaymen.candidate.domain.Candidate candidate";
		
		when(hibernateTemplate.find(queryString)).thenReturn(candidates);
		
		CandidateHibernateDao dao = new CandidateHibernateDao();		
		dao.setHibernateTemplate(hibernateTemplate);
		List<Candidate> actual = dao.getCandidates();
		
		verify(hibernateTemplate).find(queryString);
		assertSame(candidates, actual);
	}
	
	@Test
	public void getCandidateById(){
		Candidate candidate = createCandidate(1, "Test Candidate");
		
		when(hibernateTemplate.get(Candidate.class, 1)).thenReturn(candidate);
		
		CandidateHibernateDao dao = new CandidateHibernateDao();		
		dao.setHibernateTemplate(hibernateTemplate);
		Candidate actual = dao.getCandidate(1);
		
		verify(hibernateTemplate).get(Candidate.class, 1);
		assertSame(candidate, actual);
	}
	
	@Test
	public void findCandidateByName(){						
		String queryString = "FROM com.jaymen.candidate.domain.Candidate candidate " +
				"WHERE lower(name) like ?";
		String name = "Test Candidate".toLowerCase();
		
		List<Candidate> candidates = createCandidates();
		
		when(hibernateTemplate.find(queryString, name)).thenReturn(candidates);
		
		CandidateHibernateDao dao = new CandidateHibernateDao();		
		dao.setHibernateTemplate(hibernateTemplate);
		List<Candidate> actual = dao.findCandidatesByName(name);
		
		verify(hibernateTemplate).find(queryString, name);
		assertSame(candidates, actual);
	}
	
	@Test
	public void insertCandidate(){						
		Candidate candidate = createCandidate(1, "Test Candidate");
		
		doNothing().when(hibernateTemplate).saveOrUpdate(candidate);
		
		CandidateHibernateDao dao = new CandidateHibernateDao();		
		dao.setHibernateTemplate(hibernateTemplate);
		Candidate actual = dao.insertCandidate(candidate);
		
		verify(hibernateTemplate).saveOrUpdate(candidate);
		assertSame(candidate, actual);
	}
	
	@Test
	public void insertCandidateDataAccessException(){						
		Candidate candidate = createCandidate(1, "Test Candidate");
		DataAccessException dataAccessException = new DataIntegrityViolationException("");
		
		doThrow(dataAccessException).when(hibernateTemplate).saveOrUpdate(candidate);
		
		CandidateHibernateDao dao = new CandidateHibernateDao();		
		dao.setHibernateTemplate(hibernateTemplate);
		try{
			dao.insertCandidate(candidate);
			fail("Should of thrown a DataAccessException");
		}
		catch (Exception e) {
			assertSame(dataAccessException, e);
		}		
		verify(hibernateTemplate).saveOrUpdate(candidate);
	}
	
	@Test
	public void updateCandidate(){						
		Candidate candidate = createCandidate(1, "Test Candidate");
		
		doNothing().when(hibernateTemplate).saveOrUpdate(candidate);
		
		CandidateHibernateDao dao = new CandidateHibernateDao();		
		dao.setHibernateTemplate(hibernateTemplate);
		Candidate actual = dao.updateCandidate(candidate);
		
		verify(hibernateTemplate).saveOrUpdate(candidate);
		assertSame(candidate, actual);
	}	
	
	@Test
	public void updateCandidateDataAccessException(){						
		Candidate candidate = createCandidate(1, "Test Candidate");
		DataAccessException dataAccessException = new DataIntegrityViolationException("");
		
		doThrow(dataAccessException).when(hibernateTemplate).saveOrUpdate(candidate);
		
		CandidateHibernateDao dao = new CandidateHibernateDao();		
		dao.setHibernateTemplate(hibernateTemplate);
		try{
			dao.updateCandidate(candidate);
			fail("Should of thrown a DataAccessException");
		}
		catch (Exception e) {
			assertSame(dataAccessException, e);
		}		
		verify(hibernateTemplate).saveOrUpdate(candidate);
	}	

	@Test
	public void removeCandidate(){						
		Candidate candidate = createCandidate(1, "Test Candidate");
		
		when(hibernateTemplate.get(Candidate.class, 1)).thenReturn(candidate);
		doNothing().when(hibernateTemplate).delete(candidate);
		
		CandidateHibernateDao dao = new CandidateHibernateDao();		
		dao.setHibernateTemplate(hibernateTemplate);
		Boolean actual = dao.removeCandidate(candidate.getId());
		
		verify(hibernateTemplate).get(Candidate.class, 1);
		verify(hibernateTemplate).delete(candidate);
		assertTrue(actual);
	}	
	
	@Test
	public void removeCandidateDataAccessException(){						
		Candidate candidate = createCandidate(1, "Test Candidate");
		DataAccessException dataAccessException = new DataIntegrityViolationException("");
		
		when(hibernateTemplate.get(Candidate.class, 1)).thenReturn(candidate);
		doThrow(dataAccessException).when(hibernateTemplate).delete(candidate);
		
		CandidateHibernateDao dao = new CandidateHibernateDao();		
		dao.setHibernateTemplate(hibernateTemplate);
		try{
			dao.removeCandidate(candidate.getId());
			fail("Should have thrown an DataAccessException");
		}catch (Exception e) {
			assertSame(dataAccessException, e);
		}
		verify(hibernateTemplate).get(Candidate.class, 1);
		verify(hibernateTemplate).delete(candidate);
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
