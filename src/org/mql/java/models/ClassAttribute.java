package org.mql.java.models;

import java.util.List;

public class ClassAttribute {
	private String name ; 
	private String modifier ; // publi final/static ..
	private String type ; 
	
	public ClassAttribute() {
		// TODO Auto-generated constructor stub
	}

	public ClassAttribute(String modifier, String type , String name) {
		super();
		this.name = name;
		this.modifier = modifier;
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

	@Override
	public String toString() {
		return "Attribute [name=" + name + ", modifier=" + modifier + "]";
	}
	 
}	
