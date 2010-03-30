package com.jaymen.candidate.rest.webservice;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jaymen.candidate.dao.OrganisationDao;
import com.jaymen.candidate.domain.Organisation;

@Path(OrganisationService.PATH)
@Component
@Scope("request")
public class OrganisationService {
	
	/**
	 * Use slf4j for logging purposes
	 */
	private static final Logger logger = LoggerFactory.getLogger(OrganisationService.class);
	
	/**
	 * Path to our service.
	 */
	public static final String PATH = "/organisationService";
	
	/**
	 * Organisation service dependency auto wired by spring IOC.
	 */	
	private OrganisationDao organisationDao;
	
	@Autowired
	public OrganisationService(OrganisationDao organisationDao) {
		super();
		this.organisationDao = organisationDao;
	}

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
	public Collection<Organisation> getOragnisation(){
		logger.debug("Request recieved to retrieve all Organisations");
		return organisationDao.getOrganisations();
	}
	
	@GET
	@Path("{organisation}")
	@Produces({MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Organisation getOragnisation( @PathParam("organisation") Integer organisationId){
		logger.debug("Request recieved to retrieve Organisation " + organisationId);
		return organisationDao.getOrganisation(organisationId);
	}

	@PUT	
	@Produces({MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Organisation saveOrganisation(Organisation organisation){
		logger.debug("Request recieved to save Organisation " + organisation.getName());
		return organisationDao.updateOrganisation(organisation);
	}
	
	@DELETE
	@Path("{organisation}")
	@Produces({MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Boolean deleteOragnisation( @PathParam("organisation") Integer organisationId){
		logger.debug("Request recieved to delete organisation " + organisationId);
		return organisationDao.removeOrganisation(organisationId);
	}
}
