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
 * JavaBean Form controller that is used to delete an existing <code>Candidate</code>.
 */
@Controller
@RequestMapping("/insertOrganisation.do")
@SessionAttributes(types = Organisation.class)
public class InsertOrganisationForm {
	
	private OrganisationService organisationService;

	@Autowired
	public InsertOrganisationForm(OrganisationService organisationService) {
		super();
		this.organisationService = organisationService;
	}

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields(new String[] {"id"});
    }
    
	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		Organisation organisation = new Organisation();
		model.addAttribute(organisation);
		return "organisationInsert";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@RequestParam(value = "_cancel", required = false) String cancel,
			@ModelAttribute("organisation") Organisation organisation,
			BindingResult bindingResult) {
		
		String returnValue;
        if ("CANCEL".equalsIgnoreCase(cancel)) {
            returnValue = "redirect:organisations.do";
        } else if (bindingResult.hasErrors()) {
            returnValue = "organisationUpdate";
        } else {
        	organisation = organisationService.insert(organisation);
            returnValue = "redirect:organisation.do?organisationId=" + organisation.getId();
        }
        return returnValue;
	}

}
