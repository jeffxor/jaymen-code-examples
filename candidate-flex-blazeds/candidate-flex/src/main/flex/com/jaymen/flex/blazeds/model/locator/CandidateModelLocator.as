package com.jaymen.flex.blazeds.model.locator {
import mx.collections.ICollectionView;	
import com.adobe.cairngorm.model.ModelLocator;
import mx.collections.ArrayCollection;
import mx.controls.Alert;

import com.jaymen.flex.business.dto.Candidate;
         
	[Bindable]
	public class CandidateModelLocator implements ModelLocator {
		
		public static var CANDIDATE_SEARCH_RESULTS : Number = 0;
		public static var SEARCH_CANDIDATE : Number = 1;
		public static var ADD_CANDIDATE : Number = 2;
		public static var EDIT_CANDIDATE : Number = 3;
		public static var VIEW_CANDIDATE : Number = 4;
    	    	   		

	    public var candidateData: ICollectionView;
	    public var selectedCandidate:Candidate;
	    public var editCandidate:Candidate;
	    public var candidateName:String;
	    public var candidateWorkFlowState: Number = SEARCH_CANDIDATE;
	    
	    private static var _instance:CandidateModelLocator = null; 
	    
	    /**
	     * Implementation of <code>ModelLocator</code>.
	     */
	    public static function getInstance():CandidateModelLocator { 
	    	if (_instance == null)  { 
	    		_instance = new CandidateModelLocator(); 
	        } 
	            
	        return _instance; 
	    }	
	}
}