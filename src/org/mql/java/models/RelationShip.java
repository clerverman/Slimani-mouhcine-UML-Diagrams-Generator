package org.mql.java.models;

public class RelationShip {
	private String name ; 
	private String firstC ; // class ou package ; 
	private String secondC ; 
	private int minVal = 1 ; 
	private int maxVal = 1 ;  // multiplicité 
	
	public RelationShip() {
		// TODO Auto-generated constructor stub
	}

	public RelationShip(String name, String firstC, String secondC, int minVal, int maxVal) {
		super();
		this.name = name;
		this.firstC = firstC;
		this.secondC = secondC;
		this.minVal = minVal;
		this.maxVal = maxVal;
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

	public int getMinVal() {
		return minVal;
	}

	public void setMinVal(int minVal) {
		this.minVal = minVal;
	}

	public int getMaxVal() {
		return maxVal;
	}

	public void setMaxVal(int maxVal) {
		this.maxVal = maxVal;
	}

	@Override
	public String toString() {
		return "RelationShip [name=" + name + ", firstC=" + firstC + ", secondC=" + secondC + ", minVal=" + minVal
				+ ", maxVal=" + maxVal + "]";
	}
 
}
