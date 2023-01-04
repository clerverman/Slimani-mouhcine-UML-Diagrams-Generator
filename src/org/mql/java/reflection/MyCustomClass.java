package org.mql.java.reflection;

public class MyCustomClass {
	private int index ; 
	private int level ; 
	private String name ; 
	
	public MyCustomClass() {}

	public MyCustomClass(int index, int level, String name) { 
		this.index = index;
		this.level = level;
		this.name = name;
	}

	@Override
	public String toString() {
		return "MyCustomClass [index=" + index + ", level=" + level + ", name=" + name + "]";
	} 

}
