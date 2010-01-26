package com.jaymen.candidate.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.jaymen.candidate.domain.Employment;


public class EmploymentHibernateDaoTest {

	private HibernateTemplate hibernateTemplate;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		hibernateTemplate = mock(HibernateTemplate.class);
	}
	
	@Test
	public void getEmploymentsByCandidateId(){
		Integer candidateId = 1;
		String query = "FROM com.jaymen.candidate.domain.Employment WHERE candidate.id = ?";
		List<Employment> employments = createEmployments();
		
		when(hibernateTemplate.find(query, candidateId)).thenReturn(employments);
		
		EmploymentHibernateDao dao = new EmploymentHibernateDao();		
		dao.setHibernateTemplate(hibernateTemplate);
		List<Employment> actual = dao.getEmploymentsByCandidateId(candidateId);
		
		verify(hibernateTemplate).find(query, candidateId);
		assertSame(employments, actual);
	}

	@Test
	public void getEmploymentsByOrganisationId(){
		Integer organisationId = 1;
		String query = "FROM com.jaymen.candidate.domain.Employment WHERE organisation.id = ?";
		List<Employment> employments = createEmployments();
		
		when(hibernateTemplate.find(query, organisationId)).thenReturn(employments);
		
		EmploymentHibernateDao dao = new EmploymentHibernateDao();		
		dao.setHibernateTemplate(hibernateTemplate);
		List<Employment> actual = dao.getEmploymentsByOrganisationId(organisationId);
		
		verify(hibernateTemplate).find(query, organisationId);
		assertSame(employments, actual);
	}

	@Test
	public void getEmploymentsBySkillId(){
		Integer skillId = 1;
		String query = "SELECT e FROM com.jaymen.candidate.domain.Employment e " +
				"JOIN e.skills s WHERE s.id = ?";
		List<Employment> employments = createEmployments();
		
		when(hibernateTemplate.find(query, skillId)).thenReturn(employments);
		
		EmploymentHibernateDao dao = new EmploymentHibernateDao();		
		dao.setHibernateTemplate(hibernateTemplate);
		List<Employment> actual = dao.getEmploymentsBySkillId(skillId);
		
		verify(hibernateTemplate).find(query, skillId);
		assertSame(employments, actual);
	}
	
	/**
	 * Method used for testing to construct test instances
	 * of Employment.
	 * 
	 * @param id Mocked primary id for the Employment.
	 * @param name Mocked name for the Employment.
	 * @return Mocked instance of a Employment.
	 */
	public static Employment createEmployment(Integer id, String name){
		Employment employment = new Employment();
		employment.setId(id);
		employment.setJobTitle(name);
		
		return employment;
	}
	
	/**
	 * This method creates a mocked list of Employment for testing 
	 * purposes only.
	 * 
	 * @return List of mocked Employment objects.
	 */
	public static List<Employment> createEmployments(){
		List<Employment> employments = new ArrayList<Employment>();
		employments.add(createEmployment(1, "One Employment"));
		employments.add(createEmployment(2, "Two Employment"));
		employments.add(createEmployment(3, "Three Employment"));
		
		return employments;
	}
}
