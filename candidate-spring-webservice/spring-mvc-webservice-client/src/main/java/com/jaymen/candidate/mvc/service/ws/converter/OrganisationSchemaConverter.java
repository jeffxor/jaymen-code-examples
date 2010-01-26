package com.jaymen.candidate.mvc.service.ws.converter;

import java.math.BigInteger;

import javax.xml.bind.JAXBElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jaymen.cv.schemas.messages.ObjectFactory;
import com.jaymen.cv.schemas.messages.SearchOrganisationsRequest;
import com.jaymen.cv.schemas.types.Organisation;


public abstract class OrganisationSchemaConverter {
	
	private static final Logger logger = LoggerFactory.getLogger(OrganisationSchemaConverter.class);
	
	private final static ObjectFactory objectFactory = new ObjectFactory();

	public static JAXBElement<BigInteger> createOrganisationRequest(Integer id) {
		logger.debug("creating organisation request");
		return objectFactory.createGetOrganisationRequest(new BigInteger(id.toString()));
	}

	public static JAXBElement<Object> createOrganisationsRequest() {
		logger.debug("creating organisations request");
		return objectFactory.createGetOrganisationsRequest(new BigInteger("0"));
	}

	public static JAXBElement<BigInteger> createDeleteOrganisationRequest(Integer id) {
		logger.debug("creating delete organisation request");
		return objectFactory.createDeleteOrganisationRequest(new BigInteger(id.toString()));
	}
	
	public static JAXBElement<Organisation> createUpdateOrganisationRequest(Organisation organisation){
		logger.debug("creating update organisation request");
		return objectFactory.createUpdateOrganisationRequest(organisation);
	}
	
	public static JAXBElement<Organisation> createInsertOrganisationRequest(Organisation organisation){
		logger.debug("creating insert organisation request");
		return objectFactory.createInsertOrganisationRequest(organisation);
	}

	public static SearchOrganisationsRequest createSearchOrganisationRequest(String name){
		logger.debug("creating search organisation request");
		SearchOrganisationsRequest request = objectFactory.createSearchOrganisationsRequest();
		if(name != null){
			request.setName(name);
		}
		return request;
	}
}
