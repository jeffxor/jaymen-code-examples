package com.jaymen.flex.blazeds.command {
import com.adobe.cairngorm.commands.ICommand;
import com.adobe.cairngorm.control.CairngormEvent;

import mx.controls.Alert;
import mx.rpc.IResponder;
import mx.collections.ArrayCollection;
import mx.rpc.events.ResultEvent;
import mx.rpc.events.FaultEvent;
import mx.rpc.remoting.mxml.RemoteObject;
import mx.collections.ICollectionView;
import com.jaymen.flex.blazeds.business.CandidateDelegate;
import com.jaymen.flex.business.dto.Candidate;
import com.jaymen.flex.blazeds.model.locator.CandidateModelLocator;

	public class CandidateGetAllCommand implements ICommand, IResponder {
	        
	    /**
	     * Implementation of <code>ICommand</code>.
	     */
	    public function execute(event:CairngormEvent):void {	    	
	        var delegate : CandidateDelegate = new CandidateDelegate( this );
			    delegate.getCandidates();
	    }
	    
	   public function result( event : Object ) : void {	  
	        var cml:CandidateModelLocator = CandidateModelLocator.getInstance();
	        var candidates: ICollectionView = ICollectionView( event.result );
	        cml.candidateData = candidates;
	        cml.candidateData = candidates[0];				      
	    }
	    
	    public function fault( event : Object ) : void {
	        Alert.show(event.fault.faultString);
	    }
	    
	    	
	}
}