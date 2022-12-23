package org.mql.java.main;

import org.mql.java.classparser.ClassParser;
import org.mql.java.reflection.PackageExplorer;
import org.mql.java.reflection.ProjectExplorer;

public class Program {

	public Program() {
		ex01() ; 
	}

	private void ex01() {
		 PackageExplorer pack = new PackageExplorer() ;
		 ProjectExplorer project = new ProjectExplorer() ; 
		 ClassParser parser ;
		 String[] packag = project.getPackages() ; 
		 for (String p : packag) {
			String[] classes = pack.getClassList(p) ; 
			System.out.println(p + " : ");
			for (String item : classes) {
				parser = new ClassParser(item);
				if(parser.isAnnotation())
					System.out.println("\t\t"+parser.getMyClass());
			}
		 }
	}
	
	
	public static void main(String[] args) {
		new Program(); 
	}
	

}
