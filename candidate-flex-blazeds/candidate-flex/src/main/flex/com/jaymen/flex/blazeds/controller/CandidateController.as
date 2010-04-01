package com.jaymen.flex.blazeds.controller {

import com.adobe.cairngorm.control.FrontController;
import mx.controls.Alert;

import com.jaymen.flex.blazeds.command.CandidateGetAllCommand;
import com.jaymen.flex.blazeds.command.CandidateAddCommand;
import com.jaymen.flex.blazeds.event.candidate.CandidateGetAllEvent;
import com.jaymen.flex.blazeds.event.candidate.CandidateAddEvent;

	public class CandidateController extends FrontController {
	
	    /**
	     * Constructor
	     */
	    public function CandidateController() {
	        super();	        
	        addCommand(CandidateGetAllEvent.EVENT_ID, CandidateGetAllCommand);
	        addCommand(CandidateAddEvent.EVENT_ID, CandidateAddCommand);
	    }
	
	}
}