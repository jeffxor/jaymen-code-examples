package com.jaymen.candidate.rest.webservice;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jaymen.candidate.dao.CandidateDao;
import com.jaymen.candidate.domain.Candidate;
import com.sun.jersey.api.json.JSONWithPadding;

@Path(CandidateService.PATH)
@Component
@Scope("request")
public class CandidateService {
	
	/**
	 * Use slf4j for logging purposes
	 */
	private static final Logger logger = LoggerFactory.getLogger(CandidateService.class);
	
	/**
	 * Path to our service.
	 */
	public static final String PATH = "/candidateService";
	
	/**
	 * Candidate service dependency auto wired by spring IOC.
	 */	
	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateService(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.TEXT_XML})
	public Candidate [] getCandidates(){
		logger.debug("Request recieved to retrieve all candidates");
		return candidateDao.getCandidates().toArray( new Candidate []{});
	}
	
	@GET
	@Path("/json")
	@Produces({MediaType.APPLICATION_JSON})
	public Candidate [] getCandidatesAsJSON(){
		logger.debug("Request recieved to retrieve all candidates with json");
		return getCandidates();
	}
	
	@GET
	@Path("/jsonp")
	@Produces({"application/x-javascript"})
	public JSONWithPadding getCandidatesAsJSONP(@QueryParam("callback") String callback){
		logger.debug("Request recieved to retrieve all candidates with jsonp");
		return new JSONWithPadding(getCandidates(), callback);
	}
	

	@GET
	@Path("/name")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Candidate> getCandidatesByName(@QueryParam("q") String name, @QueryParam("limit") Integer limit){
		logger.debug("Request recieved to retrieve all candidates");
		return candidateDao.findCandidatesByName(name + "%");
	}
	
	@GET
	@Path("{candidate}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Candidate getCandidate( @PathParam("candidate") Integer candidateId){
		logger.debug("Request recieved to retrieve candidate" + candidateId);
		return candidateDao.getCandidate(candidateId);
	}

	@PUT	
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Candidate saveCandidate( Candidate candidate){
		logger.debug("Request recieved to save candidate" + candidate.getName());
		return candidateDao.updateCandidate(candidate);
	}
	
	@DELETE
	@Path("{candidate}")
	@Produces({MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Boolean deleteCandidate( @PathParam("candidate") Integer candidateId){
		logger.debug("Request recieved to delete candidate" + candidateId);
		return candidateDao.removeCandidate(candidateId);
	}
}
