package com.jaymen.candidate.mvc.service.ws;

import java.util.List;

import javax.xml.bind.JAXBElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.jaymen.candidate.mvc.service.OrganisationService;
import com.jaymen.candidate.mvc.service.ws.converter.OrganisationSchemaConverter;
import com.jaymen.cv.schemas.types.Organisation;
import com.jaymen.cv.schemas.messages.GetOrganisationsResponse;

public class OrganisationServiceGateway extends WebServiceGatewaySupport implements
		OrganisationService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrganisationServiceGateway.class);

	@Override
	public Boolean delete(Integer id) {
		System.err.println("attempting to delete organisation id: " + id);
		JAXBElement<Boolean> response = (JAXBElement<Boolean>) getWebServiceTemplate().marshalSendAndReceive(OrganisationSchemaConverter.createDeleteOrganisationRequest(id));
		System.err.println("response object is " + response);
		return (Boolean)response.getValue();
	}

	@Override
	public Organisation get(Integer id) {
		System.err.println("attempting to get organisation id: " + id);
		JAXBElement<Organisation> response = (JAXBElement<Organisation>) getWebServiceTemplate().marshalSendAndReceive(OrganisationSchemaConverter.createOrganisationRequest(id));
		System.err.println("response object is " + response);
		return (Organisation)response.getValue();
	}

	@Override
	public List<Organisation> getAll() {
		System.err.println("attempting to get organisation list ");
		GetOrganisationsResponse organisationsResponse = (GetOrganisationsResponse) getWebServiceTemplate().marshalSendAndReceive(OrganisationSchemaConverter.createOrganisationsRequest());
		System.err.println("response object is " + organisationsResponse);
		return organisationsResponse.getOrganisation();
	}

}
