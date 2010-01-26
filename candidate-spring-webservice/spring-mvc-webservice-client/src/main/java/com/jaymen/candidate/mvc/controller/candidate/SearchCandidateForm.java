package com.jaymen.candidate.mvc.controller.candidate;

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

import com.jaymen.candidate.mvc.service.CandidateService;
import com.jaymen.cv.schemas.types.Candidate;

/**
 * JavaBean Form controller that is used to delete an existing <code>Candidate</code>.
 */
@Controller
@RequestMapping("/candidateSeach.do")
@SessionAttributes(types = Candidate.class)
public class SearchCandidateForm {
	
	private CandidateService candidateService;

	@Autowired
	public SearchCandidateForm(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields(new String[] {"id"});
    }
    
	@RequestMapping(method = RequestMethod.GET)
	public String setupForm() {
		return "candidateSearch";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@RequestParam(value = "candidateName", required = false) String candidateName,
			@RequestParam(value = "_cancel", required = false) String cancel,
			ModelMap modelMap) {
		String returnValue;
        if ("CANCEL".equalsIgnoreCase(cancel)) {
            returnValue = "redirect:candidates.do";
        } else {
        	List<Candidate> candidates = candidateService.searchCandidates(candidateName);
        	modelMap.addAttribute(candidates);
            returnValue = "candidateResults";
        }
        return returnValue;
	}

}
