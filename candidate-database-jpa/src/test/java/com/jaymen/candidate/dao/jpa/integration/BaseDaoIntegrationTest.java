package com.jaymen.candidate.dao.jpa.integration;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base test class for checking database operations. It starts
 * up HsqlDb initializing the database schema. DbUnit is used to 
 * populate the schema with test data.
 * 
 * This class should be extended when writing tests that require database access.
 *
 */
public class BaseDaoIntegrationTest {
	private Logger log = LoggerFactory.getLogger(BaseDaoIntegrationTest.class);

	protected EntityManagerFactory emf;
    protected EntityManager em;
    
    private static final String DB_URL = "jdbc:hsqldb:mem:candidate-database-test";
    private static final String DB_DRIVER = "org.hsqldb.jdbcDriver";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";
 
    @Before
    public void initEmfAndEm() throws Exception {
    	log.debug("Attempting to create entity manager factory");
        emf = Persistence.createEntityManagerFactory("candidate-database-test");
        em = emf.createEntityManager();
        
        log.debug("Seeding the test database");
        seedDatabase();        
    }
 
    @After
    public void cleanup() throws Exception {
    	log.debug("Cleaning up entity manager factory");
        em.close();
        
        log.debug("shutdown database");
        final Connection connection = getDatabaseConnection();
        try
        {
            connection.createStatement().execute("SHUTDOWN");
        }
        finally
        {
            connection.close();
        }
    }
    
    @Test
    public void testEntityManagerFactoryCreation(){
    	
    }
    
    private Connection getDatabaseConnection() throws Exception
    {
        Class.forName(DB_DRIVER);
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
    
    private void seedDatabase() throws Exception
    {
    	// Setup the seed data
        final IDataSet dataSet = 
            new FlatXmlDataSet(getClass().getClassLoader().getResourceAsStream("seed-data.xml"));
        final IDatabaseConnection connection = new DatabaseConnection(getDatabaseConnection());        
        try
        {
            DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
        }
        finally
        {
            connection.close();
        }    
     }
}
