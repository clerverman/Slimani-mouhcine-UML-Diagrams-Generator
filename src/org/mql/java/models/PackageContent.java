package org.mql.java.models;

import java.util.List;
import java.util.Vector;

import org.mql.java.classparser.ClassParser;

public class PackageContent {
	private String name ; 
	private List<ClassContent> classes ; 
	private ClassParser parser ; 
	public PackageContent() {
		classes = new Vector<ClassContent>() ; 
	}

	public PackageContent(String name, List<ClassContent> classes,ClassParser parser) { 
		this.name = name;
		this.classes = classes;
		this.parser = parser ; 
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
		a.append(startTag());
		for (ClassContent classContent : classes) { 
			a.append(classContent.toXML()+"\n"); 
		}
		a.append(endTag());
		return a ;
	}
	
	public StringBuffer startTag()
	{
		StringBuffer s = new StringBuffer() ; 
		if(parser.isAnnotation()) 
			s.append("\t\t\t<annotations>\n") ; 
		else if(parser.isEnum()) 
			s.append("\t\t\t<enums>\n") ; 
		else if(parser.isRecord()) 
			s.append("\t\t\t<records>\n") ; 
		else if(parser.isPrimitive()) 
			s.append("\t\t\t<primitives>\n") ;
		else if(parser.isInterface()) 
			s.append("\t\t\t<interfaces>\n") ;
		else 
			s.append("\t\t\t<classes>\n") ; 
		return s ; 
	}
	
	public StringBuffer endTag()
	{
		StringBuffer s = new StringBuffer() ; 
		if(parser.isAnnotation()) 
			s.append("\t\t\t</annotations>\n") ; 
		else if(parser.isEnum()) 
			s.append("\t\t\t</enums>\n") ; 
		else if(parser.isRecord()) 
			s.append("\t\t\t</records>\n") ; 
		else if(parser.isPrimitive()) 
			s.append("\t\t\t</primitives>\n") ;
		else if(parser.isInterface()) 
			s.append("\t\t\t</interfaces>\n") ;
		else 
			s.append("\t\t\t</classes>\n") ; 
		return s ; 
	}

	public ClassParser getParser() {
		return parser;
	}

	public void setParser(ClassParser parser) {
		this.parser = parser;
	}
	
	
	
	
	
	
}
