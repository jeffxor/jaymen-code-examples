package com.jaymen.candidate.mvc.controller.candidate;

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

import com.jaymen.candidate.mvc.service.CandidateService;
import com.jaymen.cv.schemas.types.Candidate;

/**
 * JavaBean Form controller that is used to delete an existing <code>Candidate</code>.
 */
@Controller
@RequestMapping("/insertCandidate.do")
@SessionAttributes(types = Candidate.class)
public class InsertCandidateForm {
	
	private CandidateService candidateService;

	@Autowired
	public InsertCandidateForm(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields(new String[] {"id"});
    }
    
	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		Candidate candidate = new Candidate();
		model.addAttribute(candidate);
		return "candidateInsert";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@RequestParam(value = "_cancel", required = false) String cancel,
			@ModelAttribute("candidate") Candidate candidate,
			BindingResult bindingResult) {
		
		String returnValue;
        if ("CANCEL".equalsIgnoreCase(cancel)) {
            returnValue = "redirect:candidates.do";
        } else if (bindingResult.hasErrors()) {
            returnValue = "candidateUpdate";
        } else {
        	candidate = candidateService.insert(candidate);
            returnValue = "redirect:candidate.do?candidateId=" + candidate.getId();
        }
        return returnValue;
	}

}
