package org.mql.java.main;
 
import org.mql.java.reflection.PackageExplorer;
import org.mql.java.reflection.ProjectExplorer;

public class Program {
	 
	public Program() { 
		ex01(); 
	}

	private void ex01() { 
		
		ProjectExplorer project = new ProjectExplorer("Slimani-mouhcine-UML-Diagrams-Generator") ; 
		PackageExplorer pe = new PackageExplorer(); 
		for (String item : project.getPackagesTree()) {
			System.out.println(item);
		}
		 
		
	}
 	public static void main(String[] args) {
		new Program();
	}
 	 
}
