package com.jaymen.candidate.dao.hibernate.integration;

import java.sql.Connection;
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

import com.jaymen.candidate.dao.EmploymentDao;
import com.jaymen.candidate.domain.Employment;
import com.jaymen.candidate.domain.Skill;

public class EmploymentHibernateDaoIntegrationTest extends
		AbstractTransactionalDataSourceSpringContextTests {
	
	private EmploymentDao dao;
	
	public EmploymentHibernateDaoIntegrationTest() {
		super();
        ApplicationContext ctx = super.getApplicationContext();
        dao = (EmploymentDao) ctx.getBean("employmentDao");
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
	 * A simple test to check we can find an existing candidate.
	 */
	@Test
	public void testEmploymentsByCandidateId(){
		Integer candidateId = 1;
		List<Employment> found = dao.getEmploymentsByCandidateId(candidateId);

		assertEquals("list should contain elements", 3, found.size());
		assertEquals("candidate should have id 1", candidateId, found.get(0).getCandidate().getId());		
	}
	
	/**
	 * A simple test to check we can find an existing candidate.
	 */
	@Test
	public void testEmploymentsByOrganisationId(){
		Integer organisationId = 1;
		List<Employment> found = dao.getEmploymentsByCandidateId(organisationId);

		assertEquals("list should contain elements", 3, found.size());
		assertEquals("organisation should have id 1", organisationId, found.get(0).getOrganisation().getId());		
	}
	
	/**
	 * A simple test to check we can find an existing candidate.
	 */
	@Test
	public void testEmploymentsBySkillId(){
		Integer skillId = 1;
		List<Employment> found = dao.getEmploymentsBySkillId(skillId);
		
		assertEquals("list should contain elements", 5, found.size());
		Employment e = found.get(0);
		Skill s = e.getSkills().get(0); 		
		assertEquals("skill should have id 1", skillId, s.getId());		
	}
}
