package com.jaymen.candidate.ws;


import org.jdom.JDOMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.AbstractDomPayloadEndpoint;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.jaymen.spring.dao.CandidateDao;
import com.jaymen.spring.model.Candidate;

public class UpdateCandidateEndpoint extends AbstractDomPayloadEndpoint  {
	
	private static Logger logger = LoggerFactory.getLogger(UpdateCandidateEndpoint.class);
	
	private CandidateDao candidateDao;
		
	public UpdateCandidateEndpoint(CandidateDao candidateDao) throws JDOMException {
		super();
		this.candidateDao = candidateDao;		
	}

	protected Element invokeInternal(Element candidateRequest, Document document) throws Exception {
		Candidate candidate = new Candidate();
		candidate.setId(new Integer(candidateRequest.getElementsByTagName("id").item(0).getTextContent()));
		candidate.setName(candidateRequest.getElementsByTagName("name").item(0).getTextContent());
		candidate.setAddress(candidateRequest.getElementsByTagName("address").item(0).getTextContent());
		candidate.setPhone(candidateRequest.getElementsByTagName("phone").item(0).getTextContent());
		candidate.setEmail(candidateRequest.getElementsByTagName("email").item(0).getTextContent());
		
		if(candidateDao.updateCandidate(candidate).booleanValue()){
			return marshallResponse(candidate.getId(), document);
		}
		return null;
	}

	private Element marshallResponse(Integer candidateId, Document document){
		logger.info("Attempting to marshall a response");
		Candidate candidate = candidateDao.getCandidate(candidateId);
		if(candidate == null) {
			return null;
		}
		
		Element responseElement = document.createElementNS("http://www.jaymen.co.uk/cv/schemas/messages", "GetCandidateResponse");		
		
		//responseElement.addContent(candidate.getName());
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
	    
	    responseElement.appendChild(candidateElement);
	    
	    return responseElement;
	}

}
