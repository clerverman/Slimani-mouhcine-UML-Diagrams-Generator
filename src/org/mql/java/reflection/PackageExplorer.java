package org.mql.java.reflection;

import java.io.File;
import java.util.Vector;

public class PackageExplorer {
	private String packageName ;
	public PackageExplorer(String packageName) { 
		this.packageName = packageName;
	} 
	
	public String[] getPackageFiles(){ ; 
		File dir = new File(packageName); 
		File f[] = dir.listFiles() ;
		Vector<String> v = new Vector<>();
		for(int i = 0 ; i<f.length ; i++)
		{ 
			if(f[i].isFile() && f[i].getName().endsWith(".class"))
			{
				String name = f[i].getName().replace(".class", "");
				v.add(name);
			}
		}
		String t[] = new String[v.size()];
		v.toArray(t); 
		return t ;
	}
	
}
