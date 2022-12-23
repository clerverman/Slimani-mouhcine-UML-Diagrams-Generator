package org.mql.java.reflection;

import java.util.Vector;

public class ProjectExplorer {

	public ProjectExplorer() {}
	
	public String[] getPackages()
	{
		Vector<String> pack = new Vector<String>() ;  
		Package[] pa = Package.getPackages();
		for (int i = 0; i < pa.length; i++) {
		    Package p = pa[i]; 
		    if(p.getName().startsWith("org.mql"))
		    	pack.add(p.getName());
		}
		String t[] = new String[pack.size()] ; 
		pack.toArray(t) ; 
		return t ;
	}   
}
