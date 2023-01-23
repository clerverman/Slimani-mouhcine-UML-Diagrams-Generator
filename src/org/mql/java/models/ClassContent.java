package org.mql.java.models;

import java.util.List;

public class ClassContent {
	private String name ; 
	private List<ClassAttribute> attributes ; 
	private List<ClassConstructor> constructors  ; 
	private List<ClassMethod> methods ; 
	
	public ClassContent() {
		// TODO Auto-generated constructor stub
	}

	public ClassContent(String name, List<ClassAttribute> attributes, List<ClassMethod> methods , List<ClassConstructor> constructors) {
		super();
		this.name = name;
		this.attributes = attributes;
		this.methods = methods;
		this.constructors = constructors;
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

	public List<ClassConstructor> getConstructors() {
		return constructors;
	}

	public void setConstructors(List<ClassConstructor> constructors) {
		this.constructors = constructors;
	}

	@Override
	public String toString() {
		return "ClassContent [name=" + name + ", attributes=" + attributes + ", constructors=" + constructors
				+ ", methods=" + methods + "]";
	}
	
}
