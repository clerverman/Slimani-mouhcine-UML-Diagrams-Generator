package org.mql.java.models;

import java.util.List;
import java.util.Vector;

public class AssociationModel {
	private String className ; 
	private List<ClassAttribute> attributes ; 
	private String multiplicity = "1" ;
	
	public AssociationModel() {
		// TODO Auto-generated constructor stub
		attributes = new Vector<ClassAttribute>() ;
	}

	public AssociationModel(String className, List<ClassAttribute> attributes, String multiplicity ) {
		super();
		this.className = className; 
		this.multiplicity = multiplicity;
		this.attributes = attributes ; 
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<ClassAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<ClassAttribute> attributes) {
		this.attributes = attributes;
	}

	public String getMultiplicity() {
		return multiplicity;
	}

	public void setMultiplicity(String multiplicity) {
		this.multiplicity = multiplicity;
	}

	@Override
	public String toString() {
		return "AssociationModel [className=" + className + ", attributes=" + attributes + ", multiplicity="
				+ multiplicity + "]";
	}

	
	public void addAttr(ClassAttribute attr)
	{
		attributes.add(attr);
	}

}
