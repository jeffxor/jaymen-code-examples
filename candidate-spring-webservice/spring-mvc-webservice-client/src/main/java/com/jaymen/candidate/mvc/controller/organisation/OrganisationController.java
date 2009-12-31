package com.jaymen.candidate.mvc.controller.organisation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jaymen.candidate.mvc.service.OrganisationService;
import com.jaymen.cv.schemas.types.Organisation;

@Controller
public class OrganisationController {
	
	private OrganisationService organisationService;

	@Autowired
	public OrganisationController(OrganisationService organisationService) {
		super();
		this.organisationService = organisationService;
	}

	@RequestMapping(value = "/organisation.do")
	public String getOrganisation(@RequestParam(value="organisationId", required=true)Integer organisationId, ModelMap modelMap ){
		Organisation organisation = organisationService.get(organisationId);
		modelMap.addAttribute(organisation);
		return "organisationView";
	}

	@RequestMapping(value = "/organisations.do")
	public String getOrganisationList(ModelMap modelMap ){
		List<Organisation> organisations = organisationService.getAll();
		modelMap.addAttribute(organisations);
		return "organisationList";
	}

}
