package org.mql.java.models;

import java.util.List;
import java.util.Vector;

public class ClassConstructor {
	private String name; 
	private String type ; 
	private List<ParameterMethod> args ;
	
	public ClassConstructor() {
		args = new Vector<ParameterMethod>() ; 
	}
	
	public ClassConstructor(String type , String name, List<ParameterMethod> args) {
		this();
		this.type = type ;
		this.name = name;
		this.args = args;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ParameterMethod> getArgs() {
		return args;
	}
	public void setArgs(List<ParameterMethod> args) {
		this.args = args;
	}

	
	public void addArgs(ParameterMethod p)
	{
		args.add(p) ; 
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ClassConstructor [name=" + name + ", type=" + type + ", args=" + args + "]";
	}
	
	
	
	
}
