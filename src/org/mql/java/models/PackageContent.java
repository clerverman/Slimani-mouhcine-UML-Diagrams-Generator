package org.mql.java.models;

import java.util.List;
import java.util.Vector;

public class PackageContent {
	private String name ; 
	private List<ClassContent> classes ; 
	
	public PackageContent() {
		classes = new Vector<ClassContent>() ; 
	}

	public PackageContent(String name, List<ClassContent> classes) {
		this() ; 
		this.name = name;
		this.classes = classes;
	}
	
	public void addClass(ClassContent classContent)
	{
		classes.add(classContent) ; 
	}

	public int size() {
		return classes.size();
	}

	public boolean remove(Object o) {
		return classes.remove(o);
	}

	public void clear() {
		classes.clear();
	}

	public ClassContent get(int index) {
		return classes.get(index);
	}

	public ClassContent remove(int index) {
		return classes.remove(index);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ClassContent> getClasses() {
		return classes;
	}

	public void setClasses(List<ClassContent> classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "PackageContent [name=" + name + ", classes=" + classes + "]";
	}
	
	public StringBuffer toXML()
	{
		StringBuffer c = new StringBuffer() ;  
		/*
		 * 
		 * 	<package name="">
		 * 		<class/>
		 * 	</package>
		 * 
		 */
		c.append("\t\t<package name=\""+getName()+"\">\n");
		c.append(packageXML());
		c.append("\t\t</package>");
		return c ; 
	}
	
	public StringBuffer packageXML()
	{
		StringBuffer a = new StringBuffer() ; 
		a.append("\t\t\t<classes>\n");
		for (ClassContent classContent : classes) { 
			a.append(classContent.toXML()+"\n"); 
		}
		a.append("\t\t\t</classes>\n");
		return a ;
	}
	
	
	
	
}
