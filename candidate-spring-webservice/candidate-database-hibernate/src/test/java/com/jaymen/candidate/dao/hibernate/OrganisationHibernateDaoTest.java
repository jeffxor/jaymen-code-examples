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

import com.jaymen.candidate.domain.Organisation;
/**
 * @author exitut
 *
 */
public class OrganisationHibernateDaoTest {
	
	private HibernateTemplate hibernateTemplate;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		hibernateTemplate = mock(HibernateTemplate.class);

	}
	
	@Test
	public void getOrganisations(){
		List<Organisation> organisations = createOrganisations();
		String queryString = "FROM com.jaymen.candidate.domain.Organisation organisation";
		
		when(hibernateTemplate.find(queryString)).thenReturn(organisations);
		
		OrganisationHibernateDao dao = new OrganisationHibernateDao();		
		dao.setHibernateTemplate(hibernateTemplate);
		List<Organisation> actual = dao.getOrganisations();
		
		verify(hibernateTemplate).find(queryString);
		assertSame(organisations, actual);
	}
	
	@Test
	public void getOrganisationById(){
		Organisation organisation = createOrganisation(1, "Test Organisation");
		
		when(hibernateTemplate.get(Organisation.class, 1)).thenReturn(organisation);
		
		OrganisationHibernateDao dao = new OrganisationHibernateDao();		
		dao.setHibernateTemplate(hibernateTemplate);
		Organisation actual = dao.getOrganisation(1);
		
		verify(hibernateTemplate).get(Organisation.class, 1);
		assertSame(organisation, actual);
	}
	
	@Test
	public void findOrganisationByName(){						
		String queryString = "FROM com.jaymen.candidate.domain.Organisation organisation " +
				"WHERE name like ?";
		String name = "Test Organisation";
		
		List<Organisation> organisations = createOrganisations();
		
		when(hibernateTemplate.find(queryString, name)).thenReturn(organisations);
		
		OrganisationHibernateDao dao = new OrganisationHibernateDao();		
		dao.setHibernateTemplate(hibernateTemplate);
		List<Organisation> actual = dao.findOrganisationsByName(name);
		
		verify(hibernateTemplate).find(queryString, name);
		assertSame(organisations, actual);
	}
	
	@Test
	public void insertOrganisation(){						
		Organisation organisation = createOrganisation(1, "Test Organisation");
		
		doNothing().when(hibernateTemplate).saveOrUpdate(organisation);
		
		OrganisationHibernateDao dao = new OrganisationHibernateDao();		
		dao.setHibernateTemplate(hibernateTemplate);
		Organisation actual = dao.insertOrganisation(organisation);
		
		verify(hibernateTemplate).saveOrUpdate(organisation);
		assertSame(organisation, actual);
	}
	
	@Test
	public void insertOrganisationDataAccessException(){						
		Organisation organisation = createOrganisation(1, "Test Organisation");
		DataAccessException dataAccessException = new DataIntegrityViolationException("");
		
		doThrow(dataAccessException).when(hibernateTemplate).saveOrUpdate(organisation);
		
		OrganisationHibernateDao dao = new OrganisationHibernateDao();		
		dao.setHibernateTemplate(hibernateTemplate);
		try{
			dao.insertOrganisation(organisation);
			fail("Should of thrown a DataAccessException");
		}
		catch (Exception e) {
			assertSame(dataAccessException, e);
		}		
		verify(hibernateTemplate).saveOrUpdate(organisation);
	}
	
	@Test
	public void updateOrganisation(){						
		Organisation organisation = createOrganisation(1, "Test Organisation");
		
		doNothing().when(hibernateTemplate).saveOrUpdate(organisation);
		
		OrganisationHibernateDao dao = new OrganisationHibernateDao();		
		dao.setHibernateTemplate(hibernateTemplate);
		Organisation actual = dao.updateOrganisation(organisation);
		
		verify(hibernateTemplate).saveOrUpdate(organisation);
		assertSame(organisation, actual);
	}	
	
	@Test
	public void updateOrganisationDataAccessException(){						
		Organisation organisation = createOrganisation(1, "Test Organisation");
		DataAccessException dataAccessException = new DataIntegrityViolationException("");
		
		doThrow(dataAccessException).when(hibernateTemplate).saveOrUpdate(organisation);
		
		OrganisationHibernateDao dao = new OrganisationHibernateDao();		
		dao.setHibernateTemplate(hibernateTemplate);
		try{
			dao.updateOrganisation(organisation);
			fail("Should of thrown a DataAccessException");
		}
		catch (Exception e) {
			assertSame(dataAccessException, e);
		}		
		verify(hibernateTemplate).saveOrUpdate(organisation);
	}	

	@Test
	public void removeOrganisation(){						
		Organisation organisation = createOrganisation(1, "Test Organisation");
		
		when(hibernateTemplate.get(Organisation.class, 1)).thenReturn(organisation);
		doNothing().when(hibernateTemplate).delete(organisation);
		
		OrganisationHibernateDao dao = new OrganisationHibernateDao();		
		dao.setHibernateTemplate(hibernateTemplate);
		Boolean actual = dao.removeOrganisation(organisation.getId());
		
		verify(hibernateTemplate).get(Organisation.class, 1);
		verify(hibernateTemplate).delete(organisation);
		assertTrue(actual);
	}	
	
	@Test
	public void removeOrganisationDataAccessException(){						
		Organisation organisation = createOrganisation(1, "Test Organisation");
		DataAccessException dataAccessException = new DataIntegrityViolationException("");
		
		when(hibernateTemplate.get(Organisation.class, 1)).thenReturn(organisation);
		doThrow(dataAccessException).when(hibernateTemplate).delete(organisation);
		
		OrganisationHibernateDao dao = new OrganisationHibernateDao();		
		dao.setHibernateTemplate(hibernateTemplate);
		try{
			dao.removeOrganisation(organisation.getId());
			fail("Should have thrown an DataAccessException");
		}catch (Exception e) {
			assertSame(dataAccessException, e);
		}
		verify(hibernateTemplate).get(Organisation.class, 1);
		verify(hibernateTemplate).delete(organisation);
	}
	
	/**
	 * Method used for testing to construct test instances
	 * of Organisation.
	 * 
	 * @param id Mocked primary id for the Organisation.
	 * @param name Mocked name for the Organisation.
	 * @return Mocked instance of a Organisation.
	 */
	public static Organisation createOrganisation(Integer id, String name){
		Organisation organisation = new Organisation();
		organisation.setId(id);
		organisation.setName(name);
		
		return organisation;
	}
	
	/**
	 * This method creates a mocked list of Organisation for testing 
	 * purposes only.
	 * 
	 * @return List of mocked Organisation objects.
	 */
	public static List<Organisation> createOrganisations(){
		List<Organisation> organisations = new ArrayList<Organisation>();
		organisations.add(createOrganisation(1, "One Organisation"));
		organisations.add(createOrganisation(2, "Two Organisation"));
		organisations.add(createOrganisation(3, "Three Organisation"));
		
		return organisations;
	}
}
