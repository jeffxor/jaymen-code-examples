package com.jaymen.flex.blazeds.command {
import com.adobe.cairngorm.commands.ICommand;
import com.adobe.cairngorm.control.CairngormEvent;
import com.adobe.cairngorm.commands.SequenceCommand;

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
import com.jaymen.flex.blazeds.event.candidate.CandidateAddEvent;
import com.jaymen.flex.blazeds.event.candidate.CandidateGetAllEvent;



	public class CandidateAddCommand extends SequenceCommand implements ICommand, IResponder {
	        
	    /**
	     * Implementation of <code>ICommand</code>.
	     */
	    public override function execute(event:CairngormEvent):void {	    	
	        var delegate : CandidateDelegate = new CandidateDelegate( this );
	        var candidateAddEvent:CandidateAddEvent = CandidateAddEvent(event);
			delegate.addCandidate(candidateAddEvent.candidate);
	    }
	    
	   public function result( event : Object ) : void {	  
	        var addedCandidate : Boolean = ( event.result == true );
      		if ( addedCandidate )
      		{      		
	        	executeNextCommand();
      		}
      		else
      		{        	
   	     		Alert.show("Failed to add the candidate");
      		}				      
	    }
	    
	    public function fault( event : Object ) : void {
	        Alert.show(event.fault.faultString);
	    }
	    
	    public override function executeNextCommand() : void {
	    	var candidateGetAllEvent : CandidateGetAllEvent = new CandidateGetAllEvent();
	    	nextEvent = candidateGetAllEvent;
	    	super.executeNextCommand();		
			// Clear the event.
			nextEvent = null;
	    }
	    
	    
	    	
	}
}