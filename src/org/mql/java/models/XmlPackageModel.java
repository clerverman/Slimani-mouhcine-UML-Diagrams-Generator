package org.mql.java.models;

import java.util.List;
import java.util.Vector;

public class XmlPackageModel {
	private String name;
	private List<InterfaceContent> interfaces;
	private List<EnumContent> enums;
	private List<AnnotationContent> annotations;
	private List<ClassContent> classes;
	
	public XmlPackageModel() {
		interfaces = new Vector<InterfaceContent>() ; 
		enums = new Vector<EnumContent>() ; 
		annotations = new Vector<AnnotationContent>() ; 
		classes = new Vector<ClassContent>() ;  
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<InterfaceContent> getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(List<InterfaceContent> interfaces) {
		this.interfaces = interfaces;
	}

	public List<EnumContent> getEnums() {
		return enums;
	}

	public void setEnums(List<EnumContent> enums) {
		this.enums = enums;
	}

	public List<AnnotationContent> getAnnotations() {
		return annotations;
	}

	public void setAnnotations(List<AnnotationContent> annotations) {
		this.annotations = annotations;
	}

	public List<ClassContent> getClasses() {
		return classes;
	}

	public void setClasses(List<ClassContent> classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "XmlPackageModel [name=" + name + ", interfaces=" + interfaces + ", enums=" + enums + ", annotations="
				+ annotations + ", classes=" + classes + "]";
	}

}
