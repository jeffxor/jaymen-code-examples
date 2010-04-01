package com.jaymen.flex.business.dto {
import mx.collections.ArrayCollection;

import com.jaymen.flex.business.dto.Employment;

	[RemoteClass(alias="com.jaymen.flex.business.dto.OrganisationDto")];
	public class Organisation {
	    public var id:Number;
	    public var name:String;
	    public var address:String;
	    public var phone:String;
	    public var fax:String;
	    public var email:String;
	    public var employments:ArrayCollection = new ArrayCollection();
	    
	    public function Organisation() {
	    }
	    
	    public function addEmployment(employment:Employment):void {
	        employments.addItem(employment);
	    }	    
	}
}