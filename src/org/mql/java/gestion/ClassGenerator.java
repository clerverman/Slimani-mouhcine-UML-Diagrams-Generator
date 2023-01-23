package org.mql.java.gestion;

import org.mql.java.classparser.ClassParser;
import org.mql.java.models.ClassContent;

public class ClassGenerator {

	private String packageName ;
	private String ClassName  ;
	private ClassContent myClass ; 
	private ClassParser parser ; 
	public ClassGenerator() {
		myClass = new ClassContent() ;  
	}

	public ClassGenerator(String packageName, String className) {
		this();
		this.packageName = packageName;
		ClassName = className;
	}
	
	
	public ClassContent generateClass()
	{
		parser = new ClassParser(packageName+"."+ClassName); 
		
		myClass.setAttributes(parser.getFields());
		myClass.setConstructors(parser.getConstructors());
		myClass.setMethods(parser.getMethods());
		myClass.setName(ClassName);
		myClass.setParser(parser);
		
		return myClass ;
	}
	
	

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	@Override
	public String toString() {
		return "Class [packageName=" + packageName + ", ClassName=" + ClassName + "]";
	}

	public ClassContent getMyClass() {
		return myClass;
	}

	public void setMyClass(ClassContent myClass) {
		this.myClass = myClass;
	}

	public ClassParser getParser() {
		return parser;
	}

	
	
	
	
	
}
