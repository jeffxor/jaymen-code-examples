package com.jaymen.flex.business.dto {
import mx.collections.ArrayCollection;
import com.jaymen.flex.business.dto.Candidate;
import com.jaymen.flex.business.dto.Organisation;
import com.jaymen.flex.business.dto.Skill;

	[RemoteClass(alias="com.jaymen.flex.business.dto.EmploymentDto")];
	public class Employment {
	    public var id:Number;
	    public var jobTitle:String;
	    public var startDate:Date;
	    public var endDate:Date;
	    public var candidate:Candidate;
	    public var organisation:Organisation;
	    public var skills:ArrayCollection = new ArrayCollection();
	    
	    public function Employment() {
	    }
	    
	    public function addSkill(skill:Skill):void {
	        skills.addItem(skill);
	    }    
	}
}