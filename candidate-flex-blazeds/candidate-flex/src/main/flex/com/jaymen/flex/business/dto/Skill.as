package com.jaymen.flex.business.dto {
import mx.collections.ArrayCollection;

import com.jaymen.flex.business.dto.Employment;

	[RemoteClass(alias="com.jaymen.flex.business.dto.Skill.Dto")];
	public class Skill {
	    public var id:Number;
	    public var name:String;
   	    public var employments:ArrayCollection = new ArrayCollection();
	    
	    public function Skill() {
	    }
	    
	    public function addEmployment(employment:Employment):void {
	        employments.addItem(employment);
	    }	  
	}
}