package org.mql.java.classparser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassParser {

	private StringBuffer classBody;
	private Class<?> myClass;
	private int methodsNumber;
	private int fieldsNumber;
	private String error = "";

	public ClassParser(String className) {
		try {
			myClass = Class.forName(className);
		} catch (Exception e) {
			error = new String("Erreur : " + e.getMessage());
		}
	}

	 
	private String getModifier(int modifier) {
		String modificator = null;
		switch (modifier) {
		case Modifier.PRIVATE:
			modificator = "private";
			break;
		case Modifier.PROTECTED:
			modificator = "protected";
			break;
		case Modifier.ABSTRACT:
			modificator = "absctract";
			break;
		case Modifier.FINAL:
			modificator = "final";
			break;
		case Modifier.PUBLIC:
			modificator = "public";
			break;
		case Modifier.SYNCHRONIZED:
			modificator = "synchronized";
			break;
		case Modifier.STATIC:
			modificator = "static";
			break;
		default:
			modificator = "";
			break;
		}
		return modificator;
	}

	public StringBuffer getFields() {
		StringBuffer attributes = new StringBuffer();
		Field[] fields = myClass.getDeclaredFields();
		fieldsNumber = fields.length;
		for (Field field : fields) {  
			attributes.append("\t" + field.getType() + " " + field.getName() + " ; \n");

		}
		return attributes;
	}

	public StringBuffer getMethods() {
		StringBuffer methodes = new StringBuffer();
		Method[] methods = myClass.getDeclaredMethods();
		methodsNumber = methods.length;
		for (Method m : methods) {
			Class<?> returnType = m.getReturnType();
			methodes.append("\t" + getModifier(m.getModifiers()) + " " + returnType.getSimpleName() + " " + m.getName()
					+ " (" + getMethodParam(m) + ");\n");
		}
		return methodes;
	}

	private StringBuffer getMethodParam(Method m) {
		StringBuffer p = new StringBuffer();
		Class<?>[] params = m.getParameterTypes();
		for (int i = 0; i < params.length; i++) {
			if (i < params.length - 1)
				p.append(params[i].getTypeName() + " " + params[i].getSimpleName() + " , ");
			else
				p.append(params[i].getTypeName() + " " + params[i].getSimpleName());
		}
		return p;
	}

	public StringBuffer getInternalClasses() {
		StringBuffer internalClasses = new StringBuffer();
		Class<?>[] classes = myClass.getDeclaredClasses();
		for (Class<?> c : classes) {
			internalClasses.append("\t" + getModifier(c.getModifiers()) + " " + c.getSimpleName() + " extends "
					+ c.getSuperclass().getSimpleName());
			if (getInterfaces(c).length() > 0)
				internalClasses.append(" implements " + getInterfaces(c) + "{}\n");
			else
				internalClasses.append("{}\n");
		}
		return internalClasses;
	}

	public StringBuffer getInterfaces(Class<?> myClass) {
		StringBuffer interfaces = new StringBuffer();
		Class<?>[] superInterfaces = myClass.getInterfaces();
		for (int i = 0; i < superInterfaces.length; i++) {
			if (i < superInterfaces.length - 1)
				interfaces.append(superInterfaces[i].getSimpleName() + " , ");
			else
				interfaces.append(superInterfaces[i].getSimpleName());
		}
		return interfaces;
	}

	public StringBuffer getConstructors() {
		StringBuffer cons = new StringBuffer();
		Constructor<?>[] constructors = myClass.getDeclaredConstructors();
		for (Constructor<?> c : constructors) {
			cons.append(
					"\t" + getModifier(c.getModifiers()) + " " + c.getName() + "(" + getConstructorParam(c) + ");\n");
		}
		return cons;
	}

	private StringBuffer getConstructorParam(Constructor<?> c) {
		StringBuffer params = new StringBuffer();
		Class<?>[] parameters = c.getParameterTypes();
		for (int i = 0; i < parameters.length; i++) {
			if (i < parameters.length - 1)
				params.append(parameters[i].getSimpleName() + " , ");
			else
				params.append(parameters[i].getSimpleName());
		}
		return params;
	}

	public StringBuffer ownClassInf() {
		StringBuffer classHeader = new StringBuffer();
		if (myClass.getSuperclass() != null || myClass !=null) {
			classHeader.append(getModifier(myClass.getModifiers()) + " " + myClass.getSimpleName() + " extends "
					+ myClass.getSuperclass().getSimpleName());
			if (getInterfaces(myClass).length() > 0)
				classHeader.append(" implements " + getInterfaces(myClass));
		}
		return classHeader;
	}

	public StringBuffer generateClassContent() {
		classBody = new StringBuffer();
		classBody.append(ownClassInf());
		classBody.append("\n{\n");
		classBody.append(getFields());
		classBody.append(getConstructors());
		classBody.append(getMethods());
		classBody.append(getInternalClasses());
		classBody.append("}");
		return classBody;
	}

	public int getMethodsNumber() {
		return methodsNumber;
	}

	public int getFieldsNumber() {
		return fieldsNumber;
	}

	public boolean isAnnotation() {
		return myClass.isAnnotation();
	}
	
	public boolean isInterface()
	{
		return myClass.isInterface() ; 
	}
	
	public boolean isEnumeration () {
		return myClass.isEnum();
	}
	
	

	public Class<?> getMyClass() {
		return myClass;
	}

	public String getError() {
		return error;
	}

}
