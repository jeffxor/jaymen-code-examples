package com.jaymen.candidate.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value="/mvc/*.do")
public class CandidateController {
	

	@RequestMapping(value = "candidate.do")
	public String getCandidate(@RequestParam(value="candidateId", required=true)Integer candidateId, ModelMap modelMap){
		modelMap.addAttribute(candidateId);
		return "candidateView";
	}

	@RequestMapping(value = "candidates.do")
	public String getCandidateList(ModelMap modelMap){
		return "candidateList";
	}

}
