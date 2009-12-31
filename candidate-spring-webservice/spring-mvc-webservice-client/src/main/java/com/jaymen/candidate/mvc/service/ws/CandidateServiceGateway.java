package com.jaymen.candidate.mvc.service.ws;

import java.util.List;

import javax.xml.bind.JAXBElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.jaymen.candidate.mvc.service.AbstractService;
import com.jaymen.candidate.mvc.service.CandidateService;
import com.jaymen.candidate.mvc.service.ws.converter.CandidateSchemaConverter;
import com.jaymen.cv.schemas.types.Candidate;
import com.jaymen.cv.schemas.messages.GetCandidatesResponse;

public class CandidateServiceGateway extends WebServiceGatewaySupport implements
		CandidateService {
	
	private static final Logger logger = LoggerFactory.getLogger(CandidateServiceGateway.class);

	@Override
	public Boolean delete(Integer id) {
		System.err.println("attempting to delete candidate id: " + id);
		JAXBElement<Boolean> response = (JAXBElement<Boolean>) getWebServiceTemplate().marshalSendAndReceive(CandidateSchemaConverter.createDeleteCandidateRequest(id));
		System.err.println("response object is " + response);
		return (Boolean)response.getValue();
	}

	@Override
	public Candidate get(Integer id) {
		System.err.println("attempting to get candidate id: " + id);
		JAXBElement<Candidate> response = (JAXBElement<Candidate>) getWebServiceTemplate().marshalSendAndReceive(CandidateSchemaConverter.createCandidateRequest(id));
		System.err.println("response object is " + response);
		return (Candidate)response.getValue();
	}

	@Override
	public List<Candidate> getAll() {
		System.err.println("attempting to get candidate list ");
		GetCandidatesResponse candidatesResponse  = (GetCandidatesResponse) getWebServiceTemplate().marshalSendAndReceive(CandidateSchemaConverter.createCandidatesRequest());
		System.err.println("response object is " + candidatesResponse);
		return candidatesResponse.getCandidate();
	}

}
