package com.jaymen.flex.blazeds.event.candidate {

import com.adobe.cairngorm.control.CairngormEvent;

import com.jaymen.flex.business.dto.Candidate;

public class CandidateAddEvent extends CairngormEvent {

    public static var EVENT_ID:String = "com.jaymen.flex.blazeds.event.candidate.CandidateAddEvent";
    
    public var candidate:Candidate; 
    
	    /**
	     * Constructor
	     */
	    public function CandidateAddEvent() {
	        super(EVENT_ID); 
	    }

	}
}