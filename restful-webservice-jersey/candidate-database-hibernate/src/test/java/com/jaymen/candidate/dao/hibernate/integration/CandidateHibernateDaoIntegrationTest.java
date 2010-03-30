package com.jaymen.candidate.dao.hibernate.integration;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import com.jaymen.candidate.dao.CandidateDao;
import com.jaymen.candidate.domain.Candidate;

public class CandidateHibernateDaoIntegrationTest extends
		AbstractTransactionalDataSourceSpringContextTests {
	
	private CandidateDao dao;
	
	public CandidateHibernateDaoIntegrationTest() {
		super();
        ApplicationContext ctx = super.getApplicationContext();
        dao = (CandidateDao) ctx.getBean("candidateDao");
        assertNotNull(dao);
	}

	@Override
    protected String[] getConfigLocations() {
        return new String[] { "classpath:com/jaymen/candidate/dao/hibernate/test-applicationContext-hibernate.xml" };
    }
	
	@Override
    protected void onSetUpInTransaction() throws Exception {
        DataSource dataSource = jdbcTemplate.getDataSource();
        Connection con = DataSourceUtils.getConnection(dataSource);
        IDatabaseConnection dbUnitCon = new DatabaseConnection(con);
        IDataSet dataSet = new FlatXmlDataSet(getClass().getClassLoader().getResourceAsStream("seed-data.xml"));
 
        try {
            DatabaseOperation.CLEAN_INSERT.execute(dbUnitCon, dataSet);
        } finally {
            DataSourceUtils.releaseConnection(con, dataSource);
        }
    }
	
	/**
	 * A simple test to check we can retrieve all candidates.
	 */
	@Test
	public void testGetCandidates(){				
		List<Candidate> found = dao.getCandidates();		
		assertEquals("candidate should have 3 entries", found.size(), 3);
	}
	
	/**
	 * A simple test to check we can find an existing candidate.
	 */
	@Test
	public void testGetCandidateId(){
		Integer candidateId = 1;
		Candidate found = dao.getCandidate(candidateId);

		assertEquals("candidate should have id 1", candidateId, found.getId());
	}
	
	/**
	 * A simple test to check we can find an existing candidate.
	 */
	@Test
	public void testFindCandidateByName(){
		String name = "Jeffrey Williams";
		List<Candidate> found = dao.findCandidatesByName(name);		

		assertEquals("Entry name should match", name, found.get(0).getName());
	}
	
	@Test
	public void testInsertCandidate(){
		Collection<Candidate> found = dao.getCandidates();
		int initial = found.size();
		
		Candidate candidate = new Candidate();
		candidate.setName("test candidate");
		candidate.setAddress("test address");
		candidate.setEmail("test@test.com");
		
		dao.insertCandidate(candidate);
		found = dao.getCandidates();
		int after = found.size();
		
		assertEquals("candidate size should have increased", initial + 1, after);
		assertNotNull("candidate should have an id", candidate.getId());
	}
	
	@Test
	public void testUpdateCandidate(){
		Candidate test = dao.getCandidate(1);
		test.setName("test change");
		
		dao.updateCandidate(test);
		Candidate actual = dao.getCandidate(1);
		
		assertSame("Name should of been updates","test change", actual.getName());
	}
	
	@Test
	public void testRemoveCandidate(){
		Collection<Candidate> found = dao.getCandidates();
		int initial = found.size();
				
		dao.removeCandidate(1);
		found = dao.getCandidates();
		int after = found.size();
		
		assertEquals("candidate size should have decreased", initial - 1, after);
	}
}
