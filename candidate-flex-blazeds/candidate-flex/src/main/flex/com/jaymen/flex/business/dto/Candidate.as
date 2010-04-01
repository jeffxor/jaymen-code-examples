package com.jaymen.flex.business.dto {
import mx.collections.ArrayCollection;

import com.jaymen.flex.business.dto.Employment;
import com.adobe.cairngorm.vo.IValueObject;
	
	[RemoteClass(alias="com.jaymen.flex.business.dto.Candidate")]
	[Bindable]
	public class Candidate implements IValueObject{

	    public var id:Number;
	    
	    public var name:String;
	    
	    public var address:String;
	    
	    public var phone:String;
	    
	    public var email:String;
	    
	    
	    public var employments:ArrayCollection = new ArrayCollection();
	    
	    public function Candidate() {
	    }
	    
	    public function addEmployment(employment:Employment):void {
	        employments.addItem(employment);
	    }	    
	}
}