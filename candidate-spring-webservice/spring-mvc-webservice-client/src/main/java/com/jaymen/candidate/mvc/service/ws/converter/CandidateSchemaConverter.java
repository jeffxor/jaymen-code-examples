package com.jaymen.candidate.mvc.service.ws.converter;

import java.math.BigInteger;

import javax.xml.bind.JAXBElement;

import com.jaymen.cv.schemas.messages.ObjectFactory;


public abstract class CandidateSchemaConverter {
	
	private final static ObjectFactory objectFactory = new ObjectFactory();

	public static JAXBElement<BigInteger> createCandidateRequest(Integer id) {
		return objectFactory.createGetCandidateRequest(new BigInteger(id.toString()));
	}

	public static JAXBElement<Object> createCandidatesRequest() {
		System.err.println("creating candidates request");
		return objectFactory.createGetCandidatesRequest(new BigInteger("0"));
	}

	public static JAXBElement<BigInteger> createDeleteCandidateRequest(Integer id) {
		return objectFactory.createDeleteCandidateRequest(new BigInteger(id.toString()));
	}
}
