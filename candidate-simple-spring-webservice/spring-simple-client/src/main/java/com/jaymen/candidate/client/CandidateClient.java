package com.jaymen.candidate.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.transform.Source;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.xml.transform.ResourceSource;
import org.springframework.xml.transform.StringResult;

public class CandidateClient extends WebServiceGatewaySupport {

	private static Logger logger = LoggerFactory.getLogger(CandidateClient.class);

	private Resource candidateRequest;
	private Resource candidatesRequest;
	private Resource insertCandidateRequest;
	private Resource updateCandidateRequest;

	public void setCandidateRequest(Resource request) {    	
		this.candidateRequest = request;
	}

	public void setCandidatesRequest(Resource request) {    	
		this.candidatesRequest = request;
	}

	public void setInsertCandidateRequest(Resource insertCandidateRequest) {
		this.insertCandidateRequest = insertCandidateRequest;
	}

	public void setUpdateCandidateRequest(Resource updateCandidateRequest) {
		this.updateCandidateRequest = updateCandidateRequest;
	}

	public static void main(String[] args) throws IOException {
		ApplicationContext applicationContext =
			new ClassPathXmlApplicationContext("applicationContext.xml", CandidateClient.class);
		CandidateClient candidateClient = (CandidateClient) applicationContext.getBean("candidateClient");


		InputStreamReader isr = new InputStreamReader ( System.in );
		BufferedReader br = new BufferedReader ( isr );
		String s = null;
		try {
			printMenu();
			while ( (s = br.readLine ()) != null ) {
				char c = s.charAt(0);
				switch(c){
				case '1':
					candidateClient.getCandidate();
					break;
				case '2':
					candidateClient.getCandidates();
					break;
				case '3':
					candidateClient.updateCandidate();
					break;
				case '4':
					candidateClient.insertCandidate();
					break;
				case '?':
					printMenu();
					break;        	   
				}
				printMenu();
			}
		}
		catch ( IOException ioe ) {
			// won't happen too often from the keyboard
		}
	}

	private static void printMenu() {
		System.out.println("Simple Command Line Webservice Client");
		System.out.println("\tEnter '1' To Get a Candidate");
		System.out.println("\tEnter '2' To Get All Candidates");
		System.out.println("\tEnter '3' To Update Existing Candidate");
		System.out.println("\tEnter '4' To Insert New Candidate");
	}

	private void getCandidate() throws IOException {
		logger.debug("Attempting to send request");
		Source requestSource = new ResourceSource(candidateRequest);
		StringResult result = new StringResult();
		getWebServiceTemplate().sendSourceAndReceiveToResult(requestSource, result);
		System.out.println(result);
	}

	private void getCandidates() throws IOException {
		logger.debug("Attempting to send request");
		Source requestSource = new ResourceSource(candidatesRequest);
		StringResult result = new StringResult();
		getWebServiceTemplate().sendSourceAndReceiveToResult(requestSource, result);
		System.out.println(result);
	}
	
	private void updateCandidate() throws IOException {
		logger.debug("Attempting to send request");
		Source requestSource = new ResourceSource(updateCandidateRequest);
		StringResult result = new StringResult();
		getWebServiceTemplate().sendSourceAndReceiveToResult(requestSource, result);
		System.out.println(result);
	}

	private void insertCandidate() throws IOException {
		logger.debug("Attempting to send request");
		Source requestSource = new ResourceSource(insertCandidateRequest);
		StringResult result = new StringResult();
		getWebServiceTemplate().sendSourceAndReceiveToResult(requestSource, result);
		System.out.println(result);
	}
}
