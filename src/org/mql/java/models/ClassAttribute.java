package org.mql.java.models;

import java.util.List;

import org.mql.java.classparser.ClassParser;

public class ClassAttribute {
	private String name ; 
	private String modifier ; // publi final/static ..
	private String type ; 
	private String genericType = "" ; 
	private List<ClassParser> parser ; // pour le test
	public ClassAttribute() {
		// TODO Auto-generated constructor stub
	}

	public ClassAttribute(String modifier, String type , String name , String genericType) {
		super();
		this.name = name;
		this.modifier = modifier;
		this.type = type ; 
		this.genericType = genericType ; 
	}

	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getGenericType() {
		return genericType;
	}

	public void setGenericType(String genericType) {
		this.genericType = genericType;
	}

	@Override
	public String toString() {
		return "ClassAttribute [name=" + name + ", modifier=" + modifier + ", type=" + type + ", genericType="
				+ genericType + "]";
	}

	

	
}	
