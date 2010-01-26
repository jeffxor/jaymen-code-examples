package com.jaymen.candidate.ws;


import org.jdom.JDOMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.AbstractDomPayloadEndpoint;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.jaymen.spring.dao.CandidateDao;
import com.jaymen.spring.model.Candidate;

public class GetCandidateEndpoint extends AbstractDomPayloadEndpoint  {
	
	private static Logger logger = LoggerFactory.getLogger(GetCandidateEndpoint.class);
	
	private CandidateDao candidateDao;
		
	public GetCandidateEndpoint(CandidateDao candidateDao) throws JDOMException {
		super();
		this.candidateDao = candidateDao;		
	}

	protected Element invokeInternal(Element candidateRequest, Document document) throws Exception {
		NodeList childNodes = candidateRequest.getElementsByTagName("id");
		String idElemenText = childNodes.item(0).getTextContent();
		logger.debug("candidate  idElemenText: " + idElemenText);
		Integer id = new Integer(idElemenText);
		
		Candidate candidate = candidateDao.getCandidate(id);
		
		Element responseElement = null;
		if(candidate != null){
			responseElement = marshallResponse(candidate, document);
		}	
		return responseElement;
	}

	private Element marshallResponse(Candidate candidate, Document document){
		if(candidate == null){
			return null;
		}
		logger.info("Attempting to marshall a response");
		
		Element responseElement = document.createElementNS("http://www.jaymen.co.uk/cv/schemas/messages", "GetCandidateResponse");
		
		
		//responseElement.addContent(candidate.getName());
		Element candidateElement = document.createElement("Candidate");
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
