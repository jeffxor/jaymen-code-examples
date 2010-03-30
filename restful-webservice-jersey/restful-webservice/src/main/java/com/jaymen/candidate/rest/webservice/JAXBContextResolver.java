package com.jaymen.candidate.rest.webservice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;

import com.jaymen.candidate.domain.Candidate;
import com.jaymen.candidate.domain.Organisation;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;

@Provider
public class JAXBContextResolver implements ContextResolver<JAXBContext> {

	private JAXBContext context;
	
	private final Set<Class> types;
	
	private final Class[] cTypes = {Candidate.class, Organisation.class};

	public JAXBContextResolver() throws Exception {
		this.types = new HashSet<Class>(Arrays.asList(cTypes));
		this.context = new JSONJAXBContext(JSONConfiguration.mapped().arrays("candidate", "email").build(), cTypes);

	}
	
	@Override
	public JAXBContext getContext(Class<?> objectType) {
		 return (types.contains(objectType)) ? context : null;
	}

}
