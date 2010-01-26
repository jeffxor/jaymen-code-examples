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

import com.jaymen.candidate.dao.SkillDao;
import com.jaymen.candidate.domain.Skill;

public class SkillHibernateDaoIntegrationTest extends
		AbstractTransactionalDataSourceSpringContextTests {
	
	private SkillDao dao;
	
	public SkillHibernateDaoIntegrationTest() {
		super();
        ApplicationContext ctx = super.getApplicationContext();
        dao = (SkillDao) ctx.getBean("skillDao");
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
	public void testFindSkillByName(){
		String name = "AJAX";
		List<Skill> found = dao.findSkillByName(name);

		assertEquals("Entry name should match", name, found.get(0).getName());
	}

}
