package org.mql.java.reflection;

import java.io.File;
import java.util.Vector;

public class PackageExplorer {

	public PackageExplorer() { 
	} 
	
	public String[] getClassList(String packageName){
		String classpath = System.getProperty("java.class.path");  
		String packagePath = packageName.replace(".","/"); 
		File dir = new File(classpath+"/"+packagePath); 
		File f[] = dir.listFiles() ;
		Vector<String> v = new Vector<>();
		for(int i = 0 ; i<f.length ; i++)
		{
			if(f[i].isFile() && f[i].getName().endsWith(".class"))
			{
				String name = f[i].getName().replace(".class", "");
				v.add(packageName+"."+name);
			}
		}
		String t[] = new String[v.size()];
		v.toArray(t); 
		return t ;
	}
	
}
