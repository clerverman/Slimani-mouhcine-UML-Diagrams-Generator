package org.mql.java.models;

import java.util.List;
import java.util.Vector;

public class ClassMethod {
	private String name ; 
	private String modifier ; 
	private String returnType ;  
	private List<ParameterMethod> args ;
	public ClassMethod() { 
		args = new Vector<ParameterMethod>() ; 
	}

	public ClassMethod(String name, String modifier, String returnType) {
		this();
		this.name = name;
		this.modifier = modifier;
		this.returnType = returnType; 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	 

	public List<ParameterMethod> getArgs() {
		return args;
	}

	public void setArgs(List<ParameterMethod> args) {
		this.args = args;
	}
	
	public void addArg(ParameterMethod p)
	{
		args.add(p);
	}

	@Override
	public String toString() {
		return "ClassMethod [name=" + name + ", modifier=" + modifier + ", returnType=" + returnType + ", args=" + args
				+ "]";
	}
	
	
}
