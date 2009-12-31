package com.jaymen.candidate.mvc.controller.organisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping("/organisation/search.do")
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
	public String processSubmit(@RequestParam("organisationId") Integer organisationId, @RequestParam("organisationName") String organisationName) {		
		return "redirect:organisation.do?organisationId=" + 1;
	}

}
