package com.jaymen.candidate.ws.organisation;

import java.math.BigInteger;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

import com.jaymen.candidate.dao.OrganisationDao;
import com.jaymen.candidate.ws.schema.support.SchemaConversionUtils;
import com.jaymen.cv.schemas.messages.GetOrganisationsResponse;
import com.jaymen.cv.schemas.messages.ObjectFactory;
import com.jaymen.cv.schemas.messages.SearchOrganisationsRequest;
import com.jaymen.cv.schemas.messages.SearchOrganisationsResponse;
import com.jaymen.cv.schemas.types.Organisation;

@Endpoint
public class OrganisationMarshallingEndPoint implements OrganistaionWebServiceConstants{

	private static final Logger logger = LoggerFactory.getLogger(OrganisationMarshallingEndPoint.class);
	
	private final OrganisationDao organisationDao;
	
	private ObjectFactory objectFactory = new ObjectFactory();
	
	public OrganisationMarshallingEndPoint(OrganisationDao organisationDao) {
		super();
		this.organisationDao = organisationDao;
	}

	/**
	 * This endpoint method uses marshalling to handle message with a <code>&lt;GetOrganisationRequest&gt;</code> payload.
	 *
	 * @param request the JAXB2 representation of a <code>&lt;GetOrganisationRequest&gt;</code>
	 */
	@PayloadRoot(localPart = GET_ORGANISATION_REQUEST, namespace = MESSAGES_NAMESPACE)
	public JAXBElement<Organisation> getOrganisation(JAXBElement<BigInteger> jaxbBigInteger){
		Integer organisationId = jaxbBigInteger.getValue().intValue();
		logger.debug("Attempting to get Organisation for id: " + organisationId);
		com.jaymen.candidate.domain.Organisation organisation = organisationDao.getOrganisation(organisationId);
		logger.debug("Found doamin object Organisation: " + organisationId + " with id: " + organisation.getId());
		return objectFactory.createGetOrganisationResponse(SchemaConversionUtils.toSchemaType(organisation));		
	}	

	/**
	 * This endpoint method uses marshalling to handle message with a <code>&lt;GetOrganisationsRequest&gt;</code> payload.
	 *
	 * @param request the JAXB2 representation of a <code>&lt;GetOrganisationsRequest&gt;</code>
	 */
	@PayloadRoot(localPart = GET_ORGANISATIONS_REQUEST, namespace = MESSAGES_NAMESPACE)
	public GetOrganisationsResponse getOrganisations(JAXBElement<Object> jaxbObject){    	
		logger.debug("Attempting to get Organisation list");
		List<com.jaymen.candidate.domain.Organisation> organisations = organisationDao.getOrganisations();
		logger.debug("Found " + organisations.size() + " domain object Organisations");
		GetOrganisationsResponse organisationsResponse = objectFactory.createGetOrganisationsResponse();
		SchemaConversionUtils.toSchemaType(organisationsResponse, organisations);
		return organisationsResponse;
	}

	/**
	 * This endpoint method uses marshalling to handle message with a <code>&lt;DeleteOrganisationRequest&gt;</code> payload.
	 *
	 * @param request the JAXB2 representation of a <code>&lt;DeleteOrganisationRequest&gt;</code>
	 */
	@PayloadRoot(localPart = DELETE_ORGANISATION_REQUEST, namespace = MESSAGES_NAMESPACE)
	public JAXBElement<Boolean> deleteOrganisation(JAXBElement<BigInteger> jaxbBigInteger){
		Integer organisationId = jaxbBigInteger.getValue().intValue();
		logger.debug("Attempting to delete Organisation with id: " + organisationId);
		Boolean success = organisationDao.removeOrganisation(organisationId);
		return objectFactory.createDeleteOrganisationResponse(success);		
	}	
	
	/**
	 * This endpoint method uses marshaling to handle message with a <code>&lt;UpdateOrganisationRequest&gt;</code> payload.
	 *
	 * @param request the JAXB2 representation of a <code>&lt;UpdateOrganisationRequest&gt;</code>
	 */
	@PayloadRoot(localPart = UPDATE_ORGANISATION_REQUEST, namespace = MESSAGES_NAMESPACE)
	public JAXBElement<Organisation> updateOrganisation(JAXBElement<Organisation> jaxbOrganisation){
		logger.debug("Update Organisation Request recieved");
		Organisation organisation = jaxbOrganisation.getValue();
		
		logger.debug("Attempting to convert Organisation to model domain");
		com.jaymen.candidate.domain.Organisation domainOrganisation = SchemaConversionUtils.toDomainType(organisation);
		logger.debug("Attempting to update Organisation with id: " + organisation.getId());
		domainOrganisation = organisationDao.updateOrganisation(domainOrganisation);
		
		return objectFactory.createGetOrganisationResponse(SchemaConversionUtils.toSchemaType(domainOrganisation));
	}
	
	/**
	 * This endpoint method uses marshaling to handle message with a <code>&lt;InsertOrganisationRequest&gt;</code> payload.
	 *
	 * @param request the JAXB2 representation of a <code>&lt;InsertOrganisationRequest&gt;</code>
	 */
	@PayloadRoot(localPart = INSERT_ORGANISATION_REQUEST, namespace = MESSAGES_NAMESPACE)
	public JAXBElement<Organisation> insertOrganisation(JAXBElement<Organisation> jaxbOrganisation){
		Organisation organisation = jaxbOrganisation.getValue();
		
		logger.debug("Attempting to convert Organisation to model domain");
		com.jaymen.candidate.domain.Organisation domainOrganisation = SchemaConversionUtils.toDomainType(organisation);
		logger.debug("Attempting to insert Organisation: " + organisation.getName());
		domainOrganisation = organisationDao.insertOrganisation(domainOrganisation);
		
		return objectFactory.createGetOrganisationResponse(SchemaConversionUtils.toSchemaType(domainOrganisation));
	}

	/**
	 * This endpoint method uses marshaling to handle message with a <code>&lt;SearchOrganisationRequest&gt;</code> payload.
	 *
	 * @param request the JAXB2 representation of a <code>&lt;SearchOrganisationRequest&gt;</code>
	 */
	@PayloadRoot(localPart = SEARCH_ORGANISATIONS_REQUEST, namespace = MESSAGES_NAMESPACE)
	public SearchOrganisationsResponse searchOrganisation(SearchOrganisationsRequest searchOrganisationsRequest){
		logger.debug("Search Organisation request recieved");
		String name = searchOrganisationsRequest.getName();
		
		logger.debug("Attempting to search Organisations for: " + name);
		List<com.jaymen.candidate.domain.Organisation> domainOrganisations = organisationDao.findOrganisationsByName(name);
		
		SearchOrganisationsResponse organisationResponse = new SearchOrganisationsResponse();
		SchemaConversionUtils.toSchemaType(organisationResponse, domainOrganisations);
		return organisationResponse;
	}
}
