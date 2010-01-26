package com.jaymen.candidate.ws.schema.support;

import java.math.BigInteger;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jaymen.cv.schemas.messages.GetCandidatesResponse;
import com.jaymen.cv.schemas.messages.GetOrganisationsResponse;
import com.jaymen.cv.schemas.messages.SearchCandidatesResponse;
import com.jaymen.cv.schemas.messages.SearchOrganisationsResponse;
import com.jaymen.cv.schemas.types.Candidate;
import com.jaymen.cv.schemas.types.Organisation;


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
    
    public static com.jaymen.candidate.domain.Candidate toDomainType(Candidate candidate){
    	logger.debug("Attempting to convert Jaxb Candidate to domain Candidate: " + candidate + " with id: " + candidate.getId());
    	if(candidate == null){
    		return null;
    	}
    	com.jaymen.candidate.domain.Candidate domainCandidate = new com.jaymen.candidate.domain.Candidate();
    	if(candidate.getId() != null){
    		//when inserting this field will be empty
    		domainCandidate.setId(new Integer(candidate.getId().toString()));
    	}
    	domainCandidate.setName(candidate.getName());
    	domainCandidate.setAddress(candidate.getAddress());
    	domainCandidate.setEmail(candidate.getEmail());
    	domainCandidate.setPhone(candidate.getPhone());

		return domainCandidate;    	
    }
    
    public static void toSchemaType(GetCandidatesResponse candidatesResponse,Collection<com.jaymen.candidate.domain.Candidate> domainCandidates){
    	logger.debug("Attempting to convert list of domain object Candidates to wsdl type");
    	if(domainCandidates == null || domainCandidates.isEmpty()){
    		return;
    	}
    	//Add candidates to the response
    	for(com.jaymen.candidate.domain.Candidate domainCandidate : domainCandidates){
    		candidatesResponse.getCandidates().add(toSchemaType(domainCandidate));
    	}    	    		
    }
    
    public static void toSchemaType(SearchCandidatesResponse candidatesResponse,Collection<com.jaymen.candidate.domain.Candidate> domainCandidates){
    	logger.debug("Attempting to convert list of domain object Candidates to wsdl type");
    	if(domainCandidates == null || domainCandidates.isEmpty()){
    		return;
    	}
    	//Add candidates to the response
    	for(com.jaymen.candidate.domain.Candidate domainCandidate : domainCandidates){
    		candidatesResponse.getCandidates().add(toSchemaType(domainCandidate));
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
    
    public static com.jaymen.candidate.domain.Organisation toDomainType(Organisation organisation){
    	logger.debug("Attempting to convert Jaxb Organisation to domain Organisation: " + organisation + " with id: " + organisation.getId());
    	if(organisation == null){
    		return null;
    	}
    	com.jaymen.candidate.domain.Organisation domainOrganisation = new com.jaymen.candidate.domain.Organisation();
    	if(organisation.getId() != null){
    		//when inserting this field will be empty
    		domainOrganisation.setId(new Integer(organisation.getId().toString()));
    	}
    	domainOrganisation.setName(organisation.getName());
    	domainOrganisation.setAddress(organisation.getAddress());
    	domainOrganisation.setEmail(organisation.getEmail());
    	domainOrganisation.setPhone(organisation.getPhone());
    	domainOrganisation.setFax(organisation.getFax());

		return domainOrganisation;    	
    }    

    public static void toSchemaType(GetOrganisationsResponse organisationResponse, Collection<com.jaymen.candidate.domain.Organisation> domainOrganisations){
    	logger.debug("Attempting to convert list of domain object Candidates to wsdl type");
    	if(domainOrganisations == null || domainOrganisations.isEmpty()){
    		return;
    	}
    	//Add candidates to the response
    	for(com.jaymen.candidate.domain.Organisation domainOrganisation : domainOrganisations){
    		organisationResponse.getOrganisations().add(toSchemaType(domainOrganisation));
    	}    	    		
    }
    
    public static void toSchemaType(SearchOrganisationsResponse organisationResponse, Collection<com.jaymen.candidate.domain.Organisation> domainOrganisations){
    	logger.debug("Attempting to convert list of domain object Candidates to wsdl type");
    	if(domainOrganisations == null || domainOrganisations.isEmpty()){
    		return;
    	}
    	//Add candidates to the response
    	for(com.jaymen.candidate.domain.Organisation domainOrganisation : domainOrganisations){
    		organisationResponse.getOrganisations().add(toSchemaType(domainOrganisation));
    	}    	    		
    }

}
