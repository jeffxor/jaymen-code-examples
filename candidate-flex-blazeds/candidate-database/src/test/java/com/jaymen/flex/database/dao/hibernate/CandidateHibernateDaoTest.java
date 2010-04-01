package com.jaymen.flex.database.dao.hibernate;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jaymen.flex.database.dao.CandidateDao;
import com.jaymen.flex.database.domain.Candidate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:com/jaymen/flex/database/dao/hibernate/spring-dao-hibernate.xml"})
public class CandidateHibernateDaoTest extends TestCase{
	
	private CandidateDao candidateDao;

	@Autowired
	public void setCandidateDao(CandidateDao candidateDao) {
		this.candidateDao = candidateDao;
	}

	public CandidateHibernateDaoTest() {
		super();
	}

	@Test
	public void getCandidates(){
		List<Candidate> candidteList = candidateDao.getCandidates();
        assertNotNull("candidates should have been returned", candidteList);
        assertEquals("Number of items returned by doa is not correct", 5,candidteList.size());
	}
	
	@Test
	public void getCandidate(){
		Candidate candidte = candidateDao.getCandidate(1);
        assertNotNull("candidate should have been returned", candidte);
        assertEquals("Number of items returned by doa is not correct", 1L ,candidte.getId().longValue());
	}

}
