package com.jaymen.candidate.mvc.service.ws;

import java.util.List;

import javax.xml.bind.JAXBElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.jaymen.candidate.mvc.service.OrganisationService;
import com.jaymen.candidate.mvc.service.ws.converter.OrganisationSchemaConverter;
import com.jaymen.cv.schemas.messages.GetOrganisationsResponse;
import com.jaymen.cv.schemas.messages.SearchOrganisationsResponse;
import com.jaymen.cv.schemas.types.Organisation;

public class OrganisationServiceGateway extends WebServiceGatewaySupport implements
		OrganisationService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrganisationServiceGateway.class);

	@SuppressWarnings("unchecked")
	@Override
	public Boolean delete(Integer id) {
		logger.debug("attempting to delete organisation id: " + id);
		JAXBElement<Boolean> response = (JAXBElement<Boolean>) getWebServiceTemplate().marshalSendAndReceive(OrganisationSchemaConverter.createDeleteOrganisationRequest(id));
		logger.debug("response object is " + response);
		return (Boolean)response.getValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Organisation get(Integer id) {
		logger.debug("attempting to get organisation id: " + id);
		JAXBElement<Organisation> response = (JAXBElement<Organisation>) getWebServiceTemplate().marshalSendAndReceive(OrganisationSchemaConverter.createOrganisationRequest(id));
		logger.debug("response object is " + response);
		return (Organisation)response.getValue();
	}

	@Override
	public List<Organisation> getAll() {
		logger.debug("attempting to get organisation list ");
		GetOrganisationsResponse organisationsResponse = (GetOrganisationsResponse) getWebServiceTemplate().marshalSendAndReceive(OrganisationSchemaConverter.createOrganisationsRequest());
		logger.debug("response object is " + organisationsResponse);
		return organisationsResponse.getOrganisations();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Organisation update(Organisation organisation) {
		logger.debug("attempting to update organisation id: " + organisation.getId());
		JAXBElement<Organisation> response = (JAXBElement<Organisation>)getWebServiceTemplate().marshalSendAndReceive(OrganisationSchemaConverter.createUpdateOrganisationRequest(organisation));
		return response.getValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Organisation insert(Organisation organisation) {
		logger.debug("attempting to insert organisation: " + organisation.getName());
		JAXBElement<Organisation> response = (JAXBElement<Organisation>)getWebServiceTemplate().marshalSendAndReceive(OrganisationSchemaConverter.createInsertOrganisationRequest(organisation));
		return response.getValue();
	}

	@Override
	public List<Organisation> searchOrganisations(String name) {
		logger.debug("attempting to search organisation: " + name);
		SearchOrganisationsResponse response = (SearchOrganisationsResponse) getWebServiceTemplate().marshalSendAndReceive(OrganisationSchemaConverter.createSearchOrganisationRequest(name));
		return response.getOrganisations();
	}

}
