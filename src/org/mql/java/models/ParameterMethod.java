package org.mql.java.models;

public class ParameterMethod {
	private String argName ; 
	private String type ; 
	
	public ParameterMethod() {
		// TODO Auto-generated constructor stub
	}

	
	public ParameterMethod( String type , String argName) {
		super();
		this.argName = argName;
		this.type = type;
	}


	public String getArgName() {
		return argName;
	}

	public void setArgName(String argName) {
		this.argName = argName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Args [argName=" + argName + ", type=" + type + "]";
	}
	
}
