package com.jaymen.candidate.ws;


import org.jdom.JDOMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.AbstractDomPayloadEndpoint;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.jaymen.spring.dao.CandidateDao;
import com.jaymen.spring.model.Candidate;

public class InsertCandidateEndpoint extends AbstractDomPayloadEndpoint  {
	
	private static Logger logger = LoggerFactory.getLogger(InsertCandidateEndpoint.class);
	
	private CandidateDao candidateDao;
		
	public InsertCandidateEndpoint(CandidateDao candidateDao) throws JDOMException {
		super();
		this.candidateDao = candidateDao;		
	}

	protected Element invokeInternal(Element candidateRequest, Document document) throws Exception {
		Candidate candidate = new Candidate();
		candidate.setName(candidateRequest.getElementsByTagName("name").item(0).getTextContent());
		candidate.setAddress(candidateRequest.getElementsByTagName("address").item(0).getTextContent());
		candidate.setPhone(candidateRequest.getElementsByTagName("phone").item(0).getTextContent());
		candidate.setEmail(candidateRequest.getElementsByTagName("email").item(0).getTextContent());
		
		Boolean inserted = candidateDao.addCandidate(candidate);
		
		return marshallResponse(inserted, document);	
	}

	private Element marshallResponse(Boolean inserted, Document document){
		logger.info("Attempting to marshall a response");

		
		Element responseElement = document.createElementNS("http://www.jaymen.co.uk/cv/schemas/messages", "GetCandidateResponse");		
		
		//responseElement.addContent(candidate.getName());
		Element insertedElement = document.createElement("inserted");	    
	    insertedElement.setTextContent(inserted.toString());	    
	    responseElement.appendChild(insertedElement);
	    
	    return responseElement;
	}

}
