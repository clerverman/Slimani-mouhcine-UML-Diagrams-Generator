package org.mql.java.models;

import java.util.List;
import java.util.Vector;

public class EnumContent {
	private String name ; 
	private List<ClassAttribute> attributes ; 
	private List<ClassConstructor> contructors ; 
	private List<ClassMethod> methods ; 
	
	public EnumContent() {
		attributes = new Vector<ClassAttribute>() ; 
		contructors = new Vector<ClassConstructor>() ; 
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

	public List<ClassConstructor> getContructors() {
		return contructors;
	}

	public void setContructors(List<ClassConstructor> contructors) {
		this.contructors = contructors;
	}

	public List<ClassMethod> getMethods() {
		return methods;
	}

	public void setMethods(List<ClassMethod> methods) {
		this.methods = methods;
	}

	@Override
	public String toString() {
		return "EnumContent [name=" + name + ", attributes=" + attributes + ", contructors=" + contructors
				+ ", methods=" + methods + "]";
	}
	
	
}
