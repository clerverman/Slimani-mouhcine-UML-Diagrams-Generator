package org.mql.java.models;

public class RelationShip {
	private String name ; 
	private String firstC ; // class ou package : on commence par celle-ci en lecture; 
	private String secondC ; 
	private String minVal = "1" ; 
	private String maxVal = "1" ;  // multiplicité 
	private String type = ""; // type d'association : uni-directionnelle ou bi-directionnelle  entre firstClass et secondClass
	
	public RelationShip() {
		// TODO Auto-generated constructor stub
	}

	public RelationShip(String name, String firstC, String secondC, String minVal, String maxVal,String type) {
		super();
		this.name = name;
		this.firstC = firstC;
		this.secondC = secondC;
		this.minVal = minVal;
		this.maxVal = maxVal;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstC() {
		return firstC;
	}

	public void setFirstC(String firstC) {
		this.firstC = firstC;
	}

	public String getSecondC() {
		return secondC;
	}

	public void setSecondC(String secondC) {
		this.secondC = secondC;
	}

	public String getMinVal() {
		return minVal;
	}

	public void setMinVal(String minVal) {
		this.minVal = minVal;
	}

	public String getMaxVal() {
		return maxVal;
	}

	public void setMaxVal(String maxVal) {
		this.maxVal = maxVal;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "RelationShip [name=" + name + ", firstC=" + firstC + ", secondC=" + secondC + ", minVal=" + minVal
				+ ", maxVal=" + maxVal + ", type=" + type + "]";
	}
 
}
