package com.jaymen.java.certification.chp10;

public final class Pair {
	
	Object object1;
	Object object2;
	
	public Pair(Object object1, Object object2) {
		super();
		this.object1 = object1;
		this.object2 = object2;
	}

	public Object getObject1() {
		return object1;
	}

	public void setObject1(Object object1) {
		this.object1 = object1;
	}

	public Object getObject2() {
		return object2;
	}

	public void setObject2(Object object2) {
		this.object2 = object2;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(!(obj instanceof Pair))
			return false;
		Pair other = (Pair)obj;
		if(!this.object1.equals(other.object1))
			return false;
		if(!this.object2.equals(other.object2))
			return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int hashCode = 0;
		int hashCodeValue = 7;
		
		if(this.object1 != null)
			hashCode = hashCodeValue * object1.hashCode();
		if(this.object2 != null)
			hashCode = hashCodeValue * object2.hashCode() + hashCode;
		
		return hashCode;
	}

	@Override
	public String toString() {
		String string = "";
		
		if(this.object1 != null)
			string += this.object1.toString();
		if(this.object2 != null)
			string += this.object2.toString();
		
		return string;
	}
}
