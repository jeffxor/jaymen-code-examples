package com.jaymen.candidate.ws.candidate;

import java.math.BigInteger;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

import com.jaymen.candidate.dao.CandidateDao;

import com.jaymen.candidate.ws.schema.support.SchemaConversionUtils;
import com.jaymen.cv.schemas.messages.GetCandidatesResponse;
import com.jaymen.cv.schemas.messages.ObjectFactory;
import com.jaymen.cv.schemas.messages.SearchCandidatesRequest;
import com.jaymen.cv.schemas.messages.SearchCandidatesResponse;
import com.jaymen.cv.schemas.types.Candidate;

@Endpoint
public class CandidateMarshallingEndPoint implements
CandidateWebServiceConstants {

	private static final Logger logger = LoggerFactory.getLogger(CandidateMarshallingEndPoint.class);

	private final CandidateDao candidateDao;

	private ObjectFactory objectFactory = new ObjectFactory();

	public CandidateMarshallingEndPoint(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	/**
	 * This endpoint method uses marshaling to handle message with a <code>&lt;GetCandidateRequest&gt;</code> payload.
	 *
	 * @param request the JAXB2 representation of a <code>&lt;GetCandidateRequest&gt;</code>
	 */
	@PayloadRoot(localPart = GET_CANDIDATE_REQUEST, namespace = MESSAGES_NAMESPACE)
	public JAXBElement<Candidate> getCandidate(JAXBElement<BigInteger> jaxbBigInteger){
		Integer candidateId = jaxbBigInteger.getValue().intValue();
		logger.debug("Attempting to get Candidate for id: " + candidateId);
		com.jaymen.candidate.domain.Candidate candidate = candidateDao.getCandidate(candidateId);
		logger.debug("Found doamin object Candidate: " + candidateId + " with id: " + candidate.getId());
		return objectFactory.createGetCandidateResponse(SchemaConversionUtils.toSchemaType(candidate));		
	}

	/**
	 * This endpoint method uses marshaling to handle message with a <code>&lt;GetCandidatesRequest&gt;</code> payload.
	 *
	 * @param request the JAXB2 representation of a <code>&lt;GetCandidateRequest&gt;</code>
	 */
	@PayloadRoot(localPart = GET_CANDIDATES_REQUEST, namespace = MESSAGES_NAMESPACE)
	public GetCandidatesResponse getCandidates(JAXBElement<Object> jaxbObject){    	
		logger.debug("Attempting to get Candidate list");
		List<com.jaymen.candidate.domain.Candidate> candidates = candidateDao.getCandidates();
		logger.debug("Found " + candidates.size() + " doamin object Candidates");
		GetCandidatesResponse candidatesResponse = objectFactory.createGetCandidatesResponse();
		SchemaConversionUtils.toSchemaType(candidatesResponse, candidates);
		return candidatesResponse;
	}

	/**
	 * This endpoint method uses marshaling to handle message with a <code>&lt;DeleteCandidateRequest&gt;</code> payload.
	 *
	 * @param request the JAXB2 representation of a <code>&lt;DeleteCandidateRequest&gt;</code>
	 */
	@PayloadRoot(localPart = DELETE_CANDIDATE_REQUEST, namespace = MESSAGES_NAMESPACE)
	public JAXBElement<Boolean> deleteCandidate(JAXBElement<BigInteger> jaxbBigInteger){
		Integer candidateId = jaxbBigInteger.getValue().intValue();
		logger.debug("Attempting to delete Candidate with id: " + candidateId);
		Boolean success = candidateDao.removeCandidate(candidateId);
		return objectFactory.createDeleteCandidateResponse(success);		
	}
	
	/**
	 * This endpoint method uses marshaling to handle message with a <code>&lt;UpdateCandidateRequest&gt;</code> payload.
	 *
	 * @param request the JAXB2 representation of a <code>&lt;UpdateCandidateRequest&gt;</code>
	 */
	@PayloadRoot(localPart = UPDATE_CANDIDATE_REQUEST, namespace = MESSAGES_NAMESPACE)
	public JAXBElement<Candidate> updateCandidate(JAXBElement<Candidate> jaxbCandidate){
		logger.debug("Update Candidate Request recieved");
		Candidate candidate = jaxbCandidate.getValue();
		
		logger.debug("Attempting to update Candidate with id: " + candidate.getId());
		com.jaymen.candidate.domain.Candidate domainCandidate = SchemaConversionUtils.toDomainType(candidate);
		domainCandidate = candidateDao.updateCandidate(domainCandidate);
		
		return objectFactory.createGetCandidateResponse(SchemaConversionUtils.toSchemaType(domainCandidate));
	}
	
	/**
	 * This endpoint method uses marshaling to handle message with a <code>&lt;InsertCandidateRequest&gt;</code> payload.
	 *
	 * @param request the JAXB2 representation of a <code>&lt;InsertCandidateRequest&gt;</code>
	 */
	@PayloadRoot(localPart = INSERT_CANDIDATE_REQUEST, namespace = MESSAGES_NAMESPACE)
	public JAXBElement<Candidate> insertCandidate(JAXBElement<Candidate> jaxbCandidate){
		Candidate candidate = jaxbCandidate.getValue();
		
		logger.debug("Attempting to insert Candidate: " + candidate.getName());
		com.jaymen.candidate.domain.Candidate domainCandidate = SchemaConversionUtils.toDomainType(candidate);
		domainCandidate = candidateDao.insertCandidate(domainCandidate);
		
		return objectFactory.createGetCandidateResponse(SchemaConversionUtils.toSchemaType(domainCandidate));
	}
	
	/**
	 * This endpoint method uses marshaling to handle message with a <code>&lt;SearchCandidatesRequest&gt;</code> payload.
	 *
	 * @param request the JAXB2 representation of a <code>&lt;SearchCandidatesRequest&gt;</code>
	 */
	@PayloadRoot(localPart = SEARCH_CANDIDATES_REQUEST, namespace = MESSAGES_NAMESPACE)
	public SearchCandidatesResponse searchCandidate(SearchCandidatesRequest searchCandidatesRequest){
		logger.debug("Search Candidate request recieved");
		String name = searchCandidatesRequest.getName();
		
		logger.debug("Attempting to search Candidates for: " + name);
		List<com.jaymen.candidate.domain.Candidate> domainCandidates = candidateDao.findCandidatesByName(name);
		
		SearchCandidatesResponse candidatesResponse = new SearchCandidatesResponse();
		SchemaConversionUtils.toSchemaType(candidatesResponse, domainCandidates);
		return candidatesResponse;
	}
}
