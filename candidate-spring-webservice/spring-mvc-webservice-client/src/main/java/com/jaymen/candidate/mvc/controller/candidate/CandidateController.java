package com.jaymen.candidate.mvc.controller.candidate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jaymen.candidate.mvc.service.CandidateService;
import com.jaymen.cv.schemas.types.Candidate;

@Controller
public class CandidateController {
	
	private CandidateService candidateService;

	@Autowired
	public CandidateController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}

	@RequestMapping(value = "/candidate.do")
	public String getCandidate(@RequestParam(value="candidateId", required=true)Integer candidateId, ModelMap modelMap ){
		Candidate candidate = candidateService.get(candidateId);
		modelMap.addAttribute(candidate);
		return "candidateView";
	}

	@RequestMapping(value = "/candidates.do")
	public String getCandidateList(ModelMap modelMap ){
		List<Candidate> candidates = candidateService.getAll();
		modelMap.addAttribute(candidates);
		return "candidateList";
	}

}
