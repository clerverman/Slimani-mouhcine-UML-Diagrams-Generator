package org.mql.java.models;

import java.util.List;

public class ClassContent {
	private String name ; 
	private List<ClassAttribute> attributes ; 
	private List<ClassConstructor> constructors  ; 
	private List<ClassMethod> methods ; 
	
	public ClassContent() {
		// TODO Auto-generated constructor stub
	}

	public ClassContent(String name, List<ClassAttribute> attributes, List<ClassMethod> methods , List<ClassConstructor> constructors) {
		super();
		this.name = name;
		this.attributes = attributes;
		this.methods = methods;
		this.constructors = constructors;
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

	public List<ClassMethod> getMethods() {
		return methods;
	}

	public void setMethods(List<ClassMethod> methods) {
		this.methods = methods;
	}

	public List<ClassConstructor> getConstructors() {
		return constructors;
	}

	public void setConstructors(List<ClassConstructor> constructors) {
		this.constructors = constructors;
	}

	@Override
	public String toString() {
		return "ClassContent [name=" + name + ", attributes=" + attributes + ", constructors=" + constructors
				+ ", methods=" + methods + "]";
	}
	
	public StringBuffer toXML()
	{
		StringBuffer c = new StringBuffer() ;  
		/*
		 * <class name="">
		 * 		<attributes>
		 * 			<attribute name="" type="" modifier=""/> 
		 * 		</attributes>
		 * 		<constructors>
		 * 			<constructor name="" modifier="public"/> 
		 * 		</constructors>
		 * 		<methods>
		 * 			<method name="" modifier="" return-type="" />
		 * 		</methods>
		 * </class>		
		 */
		c.append("\t\t\t\t<class name=\""+getName()+"\">\n");
		c.append(attributesXML());
		c.append(constuctorXML());
		c.append(methodXML());
		c.append("\t\t\t\t</class>");
		return c ; 
	}
	
	private StringBuffer attributesXML()
	{
		StringBuffer a = new StringBuffer() ; 
		a.append("\t\t\t\t\t<attributes>\n");
		for (ClassAttribute classAttribute : attributes) {
			a.append("\t\t\t\t\t\t<attribute name=\""+classAttribute.getName()+"\" type=\""+classAttribute.getType()+"\" modifier=\""+classAttribute.getModifier()+"\"/>\n");
		}
		a.append("\t\t\t\t\t</attributes>\n");
		return a ; 
	}
	
	private StringBuffer constuctorXML()
	{
		StringBuffer a = new StringBuffer() ; 
		a.append("\t\t\t\t\t<constructors>\n");
		for (ClassConstructor classConstructor : constructors) {
			a.append("\t\t\t\t\t\t<constructor name=\""+classConstructor.getName()+"\" modifier=\"public\"/>\n");
		}
		a.append("\t\t\t\t\t</constructors>\n");
		return a ; 
	}
	
	private StringBuffer methodXML()
	{
		StringBuffer a = new StringBuffer() ; 
		a.append("\t\t\t\t\t<methods>\n");
		for (ClassMethod classMethod : methods) {
			a.append("\t\t\t\t\t\t<method name=\""+classMethod.getName()+"\" modifier=\""+classMethod.getModifier()+"\"  return-type=\""+classMethod.getReturnType()+"\" />\n");
		}
		a.append("\t\t\t\t\t</methods>\n");
		return a ; 
	}
	
}
