package com.jaymen.candidate.mvc.controller.organisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jaymen.candidate.mvc.service.OrganisationService;
import com.jaymen.cv.schemas.types.Organisation;

/**
 * JavaBean Form controller that is used to delete an existing <code>Organisation</code>.
 */
@Controller
@RequestMapping("/deleteOrganisation.do")
@SessionAttributes(types = Organisation.class)
public class DeleteOrganisationForm {
	
	private OrganisationService organisationService;

	@Autowired
	public DeleteOrganisationForm(OrganisationService organisationService) {
		super();
		this.organisationService = organisationService;
	}

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields(new String[] {"id"});
    }
    
	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(@RequestParam("organisationId") Integer organisationId, Model model) {
		Organisation organisation = organisationService.get(organisationId);
		model.addAttribute(organisation);
		return "organisationDelete";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@RequestParam("organisationId") Integer organisationId) {
		Boolean success = organisationService.delete(organisationId);	
		if(!success){
			return "error";
		}
		return "redirect:organisations.do";
	}

}
