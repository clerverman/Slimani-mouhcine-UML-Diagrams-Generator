package org.mql.java.models;

public class AssociationModel {
	private String className ; 
	private String attrName ; 
	private String attrType ; 
	private String multiplicity = "1" ;
	
	public AssociationModel() {
		// TODO Auto-generated constructor stub
	}

	public AssociationModel(String className, String attrName ,String type, String multiplicity ) {
		super();
		this.className = className;
		this.attrType = type;
		this.multiplicity = multiplicity;
		this.attrName = attrName ; 
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getType() {
		return attrType;
	}

	public void setType(String type) {
		this.attrType = type;
	}

	public String getMultiplicite() {
		return multiplicity;
	}

	public void setMultiplicite(String multiplicity) {
		this.multiplicity = multiplicity;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getAttrType() {
		return attrType;
	}

	public void setAttrType(String attrType) {
		this.attrType = attrType;
	}

	public String getMultiplicity() {
		return multiplicity;
	}

	public void setMultiplicity(String multiplicity) {
		this.multiplicity = multiplicity;
	}

	@Override
	public String toString() {
		return "AssociationModel [className=" + className + ", attrName=" + attrName + ", attrType=" + attrType
				+ ", multiplicity=" + multiplicity + "]";
	}

}
