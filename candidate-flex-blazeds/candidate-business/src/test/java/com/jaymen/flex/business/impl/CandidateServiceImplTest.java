package com.jaymen.flex.business.impl;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.jaymen.flex.business.CandidateService;
import com.jaymen.flex.database.dao.CandidateDao;
import com.jaymen.flex.database.domain.Candidate;

public class CandidateServiceImplTest {
	private CandidateDao mockCandidateDao;
	private CandidateService mockCandidateService;
	
	@Before
	public void initialize(){
		mockCandidateDao = createMock(CandidateDao.class);
		mockCandidateService = new CandidateServiceImpl(mockCandidateDao);
	}

	@Test
	public void getCandidates(){
		List<Candidate> returnedCandidates = new ArrayList<Candidate>();
		returnedCandidates.add(createCandidate());
		expect(mockCandidateDao.getCandidates()).andReturn(returnedCandidates);
		
		replay(mockCandidateDao);
		
		List<Candidate> foundCandidates = mockCandidateService.getCandidates();
		
		verify(mockCandidateDao);
		
        assertNotNull("A non null List object should have been returned",foundCandidates);
        assertEquals("Number of found candidates is not corect",1,foundCandidates.size());
	}
	
	@Test
	public void getCandidate(){
		Candidate returnedCandidate = createCandidate();
		expect(mockCandidateDao.getCandidate(1)).andReturn(returnedCandidate);
		
		replay(mockCandidateDao);
		
		Candidate foundCandidate = mockCandidateService.getCandidate(1);
		
		verify(mockCandidateDao);

        assertNotNull("A non null object should have been returned",foundCandidate);
        assertEquals("Id of found candidate is not corect",1L,foundCandidate.getId().longValue());				
	}
	
	private Candidate createCandidate(){
		Candidate candidate = new Candidate();
		candidate.setId(1);
		candidate.setName("Jeffrey Williams");
		candidate.setAddress("address 1");
		candidate.setEmail("email@email.com");
		return candidate;
	}
}
