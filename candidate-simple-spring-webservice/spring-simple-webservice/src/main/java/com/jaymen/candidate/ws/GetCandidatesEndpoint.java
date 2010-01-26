package com.jaymen.candidate.ws;


import java.util.Iterator;
import java.util.List;

import org.jdom.JDOMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.AbstractDomPayloadEndpoint;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.jaymen.spring.dao.CandidateDao;
import com.jaymen.spring.model.Candidate;

public class GetCandidatesEndpoint extends AbstractDomPayloadEndpoint  {
	
	private static Logger logger = LoggerFactory.getLogger(GetCandidatesEndpoint.class);
	
	private CandidateDao candidateDao;
		
	public GetCandidatesEndpoint(CandidateDao candidateDao) throws JDOMException {
		super();
		this.candidateDao = candidateDao;		
	}

	protected Element invokeInternal(Element candidateRequest, Document document) throws Exception {
		
		List candidates = candidateDao.getCandidates();

		return marshallResponse(candidates, document);		
	}

	private Element marshallResponse(List candidates, Document document){
		logger.info("Attempting to marshall a response");
		
		Element responseElement = document.createElementNS("http://www.jaymen.co.uk/cv/schemas/messages", "GetCandidatesResponse");
		Element candidatesElement = document.createElement("candidates");
		
		for(Iterator iterator = candidates.iterator(); iterator.hasNext();){
			Candidate candidate = (Candidate)iterator.next();
			Element candidateElement = document.createElement("candidate");
			
			Element id = document.createElement("id");
			Element name = document.createElement("name");
		    Element address = document.createElement("address");
		    Element phone = document.createElement("phone");
		    Element email = document.createElement("email");
		    
		    id.setTextContent(candidate.getId().toString());
		    name.setTextContent(candidate.getName());
		    address.setTextContent(candidate.getAddress());
		    phone.setTextContent(candidate.getPhone());
		    email.setTextContent(candidate.getEmail());
		    

		    candidateElement.appendChild(id);
		    candidateElement.appendChild(name);
		    candidateElement.appendChild(address);
		    candidateElement.appendChild(phone);
		    candidateElement.appendChild(email);
		    
		    candidatesElement.appendChild(candidateElement);
		}	
		responseElement.appendChild(candidatesElement);

	    return responseElement;
	}

}
