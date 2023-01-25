package org.mql.java.models;

import java.util.List;
import java.util.Vector;

public class InterfaceContent {
	private String name ; 
	private List<ClassAttribute> attributes ; 
	private List<ClassMethod> methods ; 
	
	public InterfaceContent() {
		attributes = new Vector<ClassAttribute>() ; 
		methods = new Vector<ClassMethod>() ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ClassAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<ClassAttribute> attributes) {
		this.attributes = attributes;
	}

	public List<ClassMethod> getMethods() {
		return methods;
	}

	public void setMethods(List<ClassMethod> methods) {
		this.methods = methods;
	}

	@Override
	public String toString() {
		return "InterfaceContent [name=" + name + ", attributes=" + attributes + ", methods=" + methods + "]";
	}
	 
	
}
