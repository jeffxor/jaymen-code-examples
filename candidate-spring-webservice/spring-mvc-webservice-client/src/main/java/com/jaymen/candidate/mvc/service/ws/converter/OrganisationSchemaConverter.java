package com.jaymen.candidate.mvc.service.ws.converter;

import java.math.BigInteger;

import javax.xml.bind.JAXBElement;

import com.jaymen.cv.schemas.messages.ObjectFactory;


public abstract class OrganisationSchemaConverter {
	
	private final static ObjectFactory objectFactory = new ObjectFactory();

	public static JAXBElement<BigInteger> createOrganisationRequest(Integer id) {
		return objectFactory.createGetOrganisationRequest(new BigInteger(id.toString()));
	}

	public static JAXBElement<Object> createOrganisationsRequest() {
		System.err.println("creating candidates request");
		return objectFactory.createGetOrganisationsRequest(new BigInteger("0"));
	}

	public static JAXBElement<BigInteger> createDeleteOrganisationRequest(Integer id) {
		return objectFactory.createDeleteOrganisationRequest(new BigInteger(id.toString()));
	}
}
