package com.jaymen.candidate.ws.schema.support;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jaymen.candidate.ws.schema.Candidate;
import com.jaymen.candidate.ws.schema.Organisation;
import com.jaymen.candidate.ws.schema.GetCandidatesResponse;
import com.jaymen.candidate.ws.schema.GetOrganisationsResponse;

public abstract class SchemaConversionUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(SchemaConversionUtils.class);
	
    private SchemaConversionUtils() {
    }

    public static Candidate toSchemaType(com.jaymen.candidate.domain.Candidate domainCandidate){
    	logger.debug("Attempting to convert doamin object Candidate: " + domainCandidate + " with id: " + domainCandidate.getId());
    	if(domainCandidate == null){
    		return null;
    	}
    	Candidate candidate = new Candidate();
    	candidate.setId(new BigInteger(domainCandidate.getId().toString()));
    	candidate.setName(domainCandidate.getName());
    	candidate.setAddress(domainCandidate.getAddress());
    	candidate.setEmail(domainCandidate.getEmail());
    	candidate.setPhone(domainCandidate.getPhone());

		return candidate;    	
    }
    
    public static void toSchemaType(GetCandidatesResponse candidatesResponse,Collection<com.jaymen.candidate.domain.Candidate> domainCandidates){
    	logger.debug("Attempting to convert list of domain object Candidates to wsdl type");
    	if(domainCandidates == null || domainCandidates.isEmpty()){
    		return;
    	}
    	//Add candidates to the response
    	for(com.jaymen.candidate.domain.Candidate domainCandidate : domainCandidates){
    		candidatesResponse.getCandidate().add(toSchemaType(domainCandidate));
    	}    	    		
    }
    
    public static Organisation toSchemaType(com.jaymen.candidate.domain.Organisation domainOrganisation){
    	logger.debug("Attempting to convert domain object Organisation: " + domainOrganisation.getName() +
    			" with id: " + domainOrganisation.getId());
    	if(domainOrganisation == null){
    		return null;
    	}
    	
    	Organisation organisation = new Organisation();
    	organisation.setId(new BigInteger(domainOrganisation.getId().toString()));
    	organisation.setName(domainOrganisation.getName());
    	organisation.setAddress(domainOrganisation.getAddress());
    	organisation.setEmail(domainOrganisation.getEmail());
    	organisation.setPhone(domainOrganisation.getPhone());
    	organisation.setFax(domainOrganisation.getFax());

		return organisation;    	
    }

    public static void toSchemaType(GetOrganisationsResponse organisationResponse, Collection<com.jaymen.candidate.domain.Organisation> domainOrganisations){
    	logger.debug("Attempting to convert list of domain object Candidates to wsdl type");
    	if(domainOrganisations == null || domainOrganisations.isEmpty()){
    		return;
    	}
    	//Add candidates to the response
    	for(com.jaymen.candidate.domain.Organisation domainOrganisation : domainOrganisations){
    		organisationResponse.getOrganisation().add(toSchemaType(domainOrganisation));
    	}    	    		
    }

}
