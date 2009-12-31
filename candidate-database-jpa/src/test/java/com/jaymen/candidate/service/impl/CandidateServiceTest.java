/**
 * 
 */
package com.jaymen.candidate.service.impl;


import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jaymen.candidate.dao.CandidateDao;
import com.jaymen.candidate.model.Candidate;

/**
 * @author jeffxor
 *
 */

public class CandidateServiceTest {
	
	private CandidateServiceImp candidateService;
	private CandidateDao candidateDao;
	


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		candidateService = new CandidateServiceImp();
		candidateDao = createStrictMock(CandidateDao.class);
		candidateService.setDao(candidateDao);		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testFindAll(){
		//Mock what we expected returned
		@SuppressWarnings("unchecked")
		Collection<Candidate> candidates = createMock(List.class);
		
		//expected calls
		expect(candidateDao.findAll()).andReturn(candidates);
				
		replay(candidateDao);
		
		//Call the service
		candidateService.findAll();
		
		verify(candidateDao);		
	}

	@Test
	public void testFindById(){
		Candidate candidate = new Candidate();
		//expected calls
		
		expect(candidateDao.findById(new Integer("1"))).andReturn(candidate);
		replay(candidateDao);
		
		//Call the service
		Candidate candidateTest = candidateService.findById(new Integer("1"));
		
		verify(candidateDao);
		Assert.assertEquals("Bol object should be the same",candidate, candidateTest);
	}
}
