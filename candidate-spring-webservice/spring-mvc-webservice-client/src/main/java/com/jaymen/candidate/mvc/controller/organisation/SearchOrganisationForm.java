package com.jaymen.candidate.mvc.controller.organisation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
@RequestMapping("/organisationSearch.do")
@SessionAttributes(types = Organisation.class)
public class SearchOrganisationForm {
	
	private OrganisationService organisationService;

	@Autowired
	public SearchOrganisationForm(OrganisationService organisationService) {
		super();
		this.organisationService = organisationService;
	}

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields(new String[] {"id"});
    }
    
	@RequestMapping(method = RequestMethod.GET)
	public String setupForm() {
		return "organisationSearch";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@RequestParam(value = "organisationId", required = false) Integer organisationId, 
			@RequestParam(value = "organisationName", required = false) String name,
			@RequestParam(value = "_cancel", required = false) String cancel,
			ModelMap modelMap) {
		String returnValue;
        if ("CANCEL".equalsIgnoreCase(cancel)) {
            returnValue = "redirect:organisations.do";
        } else {
        	List<Organisation> organisations = organisationService.searchOrganisations(name);
        	modelMap.addAttribute(organisations);
            returnValue = "organisationResults";
        }
        return returnValue;
	}

}
