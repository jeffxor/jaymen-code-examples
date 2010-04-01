package com.jaymen.flex.blazeds.business
{
	import mx.rpc.IResponder;	
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.AbstractOperation;
	
	import com.adobe.cairngorm.business.ServiceLocator;
	
	import com.jaymen.flex.business.dto.Candidate;


	public class CandidateDelegate
	{
		public function CandidateDelegate( responder : IResponder )
		{		
			this.service = ServiceLocator.getInstance().getRemoteObject( "candidateService" );
			this.responder = responder;
		}
		
		public function getCandidates() : void
		{			
			var call : Object = service.getCandidates();
			call.addResponder( responder );
		}
		
		public function addCandidate(candidate : Candidate) : void
		{			
			var call : Object = service.addCandidate(candidate);
			call.addResponder( responder );
		}	
		private var responder : IResponder;
		private var service : Object;
	}

}