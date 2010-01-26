package com.jaymen.candidate.mvc.service.ws.converter;

import java.math.BigInteger;

import javax.xml.bind.JAXBElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jaymen.cv.schemas.messages.ObjectFactory;
import com.jaymen.cv.schemas.messages.SearchCandidatesRequest;
import com.jaymen.cv.schemas.types.Candidate;


public abstract class CandidateSchemaConverter {

	private static final Logger logger = LoggerFactory.getLogger(CandidateSchemaConverter.class);

	private final static ObjectFactory objectFactory = new ObjectFactory();

	public static JAXBElement<BigInteger> createCandidateRequest(Integer id) {
		logger.debug("creating candidates request");
		return objectFactory.createGetCandidateRequest(new BigInteger(id.toString()));
	}

	public static JAXBElement<Object> createCandidatesRequest() {
		logger.debug("creating candidates request");
		return objectFactory.createGetCandidatesRequest(new BigInteger("0"));
	}

	public static JAXBElement<BigInteger> createDeleteCandidateRequest(Integer id) {
		logger.debug("creating delete candidate request");
		return objectFactory.createDeleteCandidateRequest(new BigInteger(id.toString()));
	}

	public static JAXBElement<Candidate> createUpdateCandidateRequest(Candidate candidate){
		logger.debug("creating update candidate request");
		return objectFactory.createUpdateCandidateRequest(candidate);
	}

	public static JAXBElement<Candidate> createInsertCandidateRequest(Candidate candidate){
		logger.debug("creating insert candidate request");
		return objectFactory.createInsertCandidateRequest(candidate);
	}

	public static SearchCandidatesRequest createSearchCandidateRequest(String name){
		logger.debug("creating insert candidate request");
		SearchCandidatesRequest request = objectFactory.createSearchCandidatesRequest();
		if(name != null){
			request.setName(name);
		}
		return request;
	}

}
