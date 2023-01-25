package org.mql.java.models;

import java.util.List;
import java.util.Vector;

public class AnnotationContent {
	private String name ; 
	private List<ClassMethod> methods ;
	
	public AnnotationContent() {
		methods = new Vector<ClassMethod>() ; 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ClassMethod> getMethods() {
		return methods;
	}

	public void setMethods(List<ClassMethod> methods) {
		this.methods = methods;
	}

	@Override
	public String toString() {
		return "AnnotationContent [name=" + name + ", methods=" + methods + "]";
	}
	
	
}
