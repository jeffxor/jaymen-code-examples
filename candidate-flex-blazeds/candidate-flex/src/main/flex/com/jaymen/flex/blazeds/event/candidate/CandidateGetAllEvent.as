package com.jaymen.flex.blazeds.event.candidate {

import com.adobe.cairngorm.control.CairngormEvent;
import mx.controls.Alert;

public class CandidateGetAllEvent extends CairngormEvent {

    public static var EVENT_ID:String = "com.jaymen.flex.blazeds.event.candidate.CandidateGetAllEvent"; 
    
	    /**
	     * Constructor
	     */
	    public function CandidateGetAllEvent() {
	        super(EVENT_ID); 
	    }

	}
}