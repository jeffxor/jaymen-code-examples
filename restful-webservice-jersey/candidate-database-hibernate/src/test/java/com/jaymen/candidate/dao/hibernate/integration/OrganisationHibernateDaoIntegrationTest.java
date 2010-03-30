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

import com.jaymen.candidate.dao.OrganisationDao;
import com.jaymen.candidate.domain.Organisation;

public class OrganisationHibernateDaoIntegrationTest extends
		AbstractTransactionalDataSourceSpringContextTests {
	
	private OrganisationDao dao;
	
	public OrganisationHibernateDaoIntegrationTest() {
		super();
        ApplicationContext ctx = super.getApplicationContext();
        dao = (OrganisationDao) ctx.getBean("organisationDao");
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
	 * A simple test to check we can retrieve all organisations.
	 */
	@Test
	public void testGetOrganisations(){				
		List<Organisation> found = dao.getOrganisations();		
		assertEquals("organisation should have 3 entries", found.size(), 3);
	}
	
	/**
	 * A simple test to check we can find an existing organisation.
	 */
	@Test
	public void testGetOrganisationId(){
		Integer organisationId = 1;
		Organisation found = dao.getOrganisation(organisationId);

		assertEquals("organisation should have id 1", organisationId, found.getId());
	}
	
	/**
	 * A simple test to check we can find an existing organisation.
	 */
	@Test
	public void testFindOrganisationByName(){
		String name = "IBM";
		List<Organisation> found = dao.findOrganisationsByName(name);		

		assertEquals("Entry name should match", name, found.get(0).getName());
	}
	
	@Test
	public void testInsertOrganisation(){
		Collection<Organisation> found = dao.getOrganisations();
		int initial = found.size();
		
		Organisation organisation = new Organisation();
		organisation.setName("test organisation");
		organisation.setAddress("test address");
		organisation.setEmail("test@test.com");
		
		dao.insertOrganisation(organisation);
		found = dao.getOrganisations();
		int after = found.size();
		
		assertEquals("organisation size should have increased", initial + 1, after);
		assertNotNull("organisation should have an id", organisation.getId());
	}
	
	@Test
	public void testUpdateOrganisation(){
		Organisation test = dao.getOrganisation(1);
		test.setName("test change");
		
		dao.updateOrganisation(test);
		Organisation actual = dao.getOrganisation(1);
		
		assertSame("Name should of been updates","test change", actual.getName());
	}
	
	@Test
	public void testRemoveOrganisation(){
		Collection<Organisation> found = dao.getOrganisations();
		int initial = found.size();
				
		dao.removeOrganisation(1);
		found = dao.getOrganisations();
		int after = found.size();
		
		assertEquals("organisation size should have decreased", initial - 1, after);
	}
}
