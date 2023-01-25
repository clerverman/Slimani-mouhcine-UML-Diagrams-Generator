package org.mql.java.models;

import java.util.List;
import java.util.Vector;

public class PackageModel {
	private String name ; 
	private List<ClassAttribute> attributes ; 
	
	public PackageModel() {
		attributes = new Vector<ClassAttribute>() ; 
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

	@Override
	public String toString() {
		return "PackageModel [name=" + name + ",  attributes=" + attributes + "]";
	}
}
