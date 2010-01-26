package com.jaymen.candidate.mvc.service.ws;

import java.util.List;

import javax.xml.bind.JAXBElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.jaymen.candidate.mvc.service.CandidateService;
import com.jaymen.candidate.mvc.service.ws.converter.CandidateSchemaConverter;
import com.jaymen.cv.schemas.messages.GetCandidatesResponse;
import com.jaymen.cv.schemas.messages.SearchCandidatesResponse;
import com.jaymen.cv.schemas.types.Candidate;

public class CandidateServiceGateway extends WebServiceGatewaySupport implements
		CandidateService {
	
	private static final Logger logger = LoggerFactory.getLogger(CandidateServiceGateway.class);

	@SuppressWarnings("unchecked")
	@Override
	public Boolean delete(Integer id) {
		logger.debug("attempting to delete candidate id: " + id);
		JAXBElement<Boolean> response = (JAXBElement<Boolean>) getWebServiceTemplate().marshalSendAndReceive(CandidateSchemaConverter.createDeleteCandidateRequest(id));
		logger.debug("response object is " + response);
		return response.getValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Candidate get(Integer id) {
		logger.debug("attempting to get candidate id: " + id);
		JAXBElement<Candidate> response = (JAXBElement<Candidate>) getWebServiceTemplate().marshalSendAndReceive(CandidateSchemaConverter.createCandidateRequest(id));
		logger.debug("response object is " + response);
		return response.getValue();
	}

	@Override
	public List<Candidate> getAll() {
		logger.debug("attempting to get candidate list ");
		GetCandidatesResponse candidatesResponse  = (GetCandidatesResponse) getWebServiceTemplate().marshalSendAndReceive(CandidateSchemaConverter.createCandidatesRequest());
		logger.debug("response object is " + candidatesResponse);
		return candidatesResponse.getCandidates();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Candidate update(Candidate candidate) {
		logger.debug("attempting to update candidate id: " + candidate.getId());
		JAXBElement<Candidate> response = (JAXBElement<Candidate>)getWebServiceTemplate().marshalSendAndReceive(CandidateSchemaConverter.createUpdateCandidateRequest(candidate));
		return response.getValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Candidate insert(Candidate candidate) {
		logger.debug("attempting to insert candidate: " + candidate.getName());
		JAXBElement<Candidate> response = (JAXBElement<Candidate>)getWebServiceTemplate().marshalSendAndReceive(CandidateSchemaConverter.createInsertCandidateRequest(candidate));
		return response.getValue();
	}

	@Override
	public List<Candidate> searchCandidates(String name) {
		logger.debug("attempting to search for candidate with name: " + name);
		SearchCandidatesResponse response = (SearchCandidatesResponse)getWebServiceTemplate().marshalSendAndReceive(CandidateSchemaConverter.createSearchCandidateRequest(name));
		return response.getCandidates();
	}

}
