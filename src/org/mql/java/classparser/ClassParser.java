package org.mql.java.classparser;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier; 
import java.util.List;
import java.util.Vector;

import org.mql.java.models.ClassAttribute;
import org.mql.java.models.ClassConstructor;
import org.mql.java.models.ClassMethod;
import org.mql.java.models.ParameterMethod; 

public class ClassParser {   
	private Class<?> myClass; 
	private List<ClassAttribute> attributes ; 
	private List<ClassMethod> methodes ; 
	private ClassMethod meth ;
	private List<ClassConstructor> constructors ; 
	private ClassConstructor cons ;
	
	public ClassParser(String className) {
		attributes = new Vector<ClassAttribute>();
		methodes = new Vector<ClassMethod>();
		constructors = new Vector<ClassConstructor>();
		try {
			myClass = Class.forName(className); 
		} catch (Exception e) {
			System.out.println("Error : "+e.getMessage());
		}
	}

	private String getModifier(int modifier) {
		String modificator = null; 
		if(Modifier.isPublic(modifier))
			modificator = "public" ; 
		else if(Modifier.isPrivate(modifier))
			modificator = "private" ; 
		else if(Modifier.isProtected(modifier))
			modificator = "protected" ;
		else if(Modifier.isAbstract(modifier))
			modificator = "abstract" ;
		else if(Modifier.isFinal(modifier))
			modificator = "final" ; 
		else if(Modifier.isPrivate(modifier))
			modificator = "private" ; 
		else if(Modifier.isSynchronized(modifier))
			modificator = "synchronized" ; 
		else if(Modifier.isStatic(modifier))
			modificator = "static" ;  
		
		
		if(Modifier.isPublic(modifier) && Modifier.isStatic(modifier))
			modificator = "public static" ; 
		else if(Modifier.isPublic(modifier) && Modifier.isFinal(modifier))
			modificator = "public final" ; 
		else if(Modifier.isPublic(modifier) && Modifier.isAbstract(modifier))
			modificator = "public abstract" ; 
		else if(Modifier.isPublic(modifier) && Modifier.isSynchronized(modifier))
			modificator = "public synchronized" ; 
		else if(Modifier.isPublic(modifier) && Modifier.isFinal(modifier) && Modifier.isStatic(modifier))
			modificator = "public static final" ;
		return modificator;
	}

	public List<ClassAttribute> getFields() {
 		Field[] fields = myClass.getDeclaredFields(); 
		for (Field field : fields) {
			ClassAttribute attr = new ClassAttribute() ; 
			attr.setName(field.getName()); 
			attr.setType(field.getType().toString());
			attr.setModifier(getModifier(field.getModifiers()));
			attributes.add(attr);
 		}
		return attributes;
	}
	
	public List<ClassMethod> getMethods() { 
		Method[] methods = myClass.getDeclaredMethods(); 
		for (Method m : methods) {
			Class<?> returnType = m.getReturnType();
			meth = new ClassMethod();
			meth.setModifier(getModifier(m.getModifiers()));
			meth.setName(m.getName());
			meth.setReturnType(returnType.getSimpleName());
			getMethodParam(m);
			methodes.add(meth); 
		}
		return methodes;
	}

	private void getMethodParam(Method m) { 
		ParameterMethod p = new ParameterMethod() ; 
		Class<?>[] params = m.getParameterTypes();
		for (int i = 0; i < params.length; i++) {
			p.setType(params[i].getTypeName());
			p.setArgName(params[i].getSimpleName()); 
			meth.addArg(p);
		} 
	}
	
	public List<ClassConstructor> getConstructors() {
		
		Constructor<?>[] constr = myClass.getDeclaredConstructors();
		for (Constructor<?> c : constr) {  
			cons = new ClassConstructor();
			cons.setName(c.getName());
			cons.setType(getModifier(c.getModifiers()));
			getConstructorParam(c);
			constructors.add(cons);
 		}
		return constructors;
	}

	private void getConstructorParam(Constructor<?> c) { 
		Class<?>[] parameters = c.getParameterTypes();
		ParameterMethod p = new ParameterMethod() ; 
		for (int i = 0; i < parameters.length; i++) {
			p.setArgName(parameters[i].getSimpleName());;
			p.setType(parameters[i].getTypeName());  
			cons.addArgs(p);
		} 
	}



	
	
	
	
	public StringBuffer getInternalClasses() {
		StringBuffer internalClasses = new StringBuffer(); 
		Class<?>[] classes = myClass.getDeclaredClasses(); 
		for (Class<?> c : classes) { 
			internalClasses.append("\t"+getModifier(c.getModifiers())+" "+c.getSimpleName()+" extends "+ c.getSuperclass().getSimpleName());
			if(getInterfaces(c).length()>0)
				internalClasses.append(" implements "+getInterfaces(c)+"{}\n");
			else 
				internalClasses.append("{}\n");
		}
		return internalClasses; 
	}

	public StringBuffer getInterfaces(Class<?> myClass) { 
		StringBuffer interfaces = new StringBuffer();
		Class<?>[] superInterfaces = myClass.getInterfaces();
		for (int i = 0; i < superInterfaces.length; i++) {
			if(i < superInterfaces.length - 1)
				interfaces.append(superInterfaces[i].getSimpleName()+" , ");
			else 
				interfaces.append(superInterfaces[i].getSimpleName());
		} 
		return interfaces;
	}

 

	  
}
