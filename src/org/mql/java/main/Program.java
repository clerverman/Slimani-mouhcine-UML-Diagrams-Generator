package org.mql.java.main;
 
import java.util.Vector;

import org.mql.java.classparser.ClassParser;
import org.mql.java.reflection.PackageExplorer;
import org.mql.java.reflection.ProjectExplorer;

public class Program {
	 
	public Program() { 
		displayPackagesAndSubpackages(); 
	}

	private void ex01() { 
		
		ProjectExplorer project = new ProjectExplorer("Slimani-mouhcine-UML-Diagrams-Generator") ; 
		
		for (String item : project.getPackagesTree()) {
			 	System.out.println("----------- "+item+" : "+project.getAbsolutePath(item)+" ----------------");
				Vector<String> content =  project.getPackageContent(item);
				if(content.size() == 0 )
					System.out.println("\tEmpty");
				else 
					for (String i : content) {
						System.out.println("\t"+i);
					}
			 
			/*
			for (String content : project.getPackageContent(item)) {
				if(content.endsWith(".class"))
				{ 
					String c = content.replace(".class", "");
					ClassParser parser = new ClassParser(item+"."+c);
					System.out.println(parser.generateClassContent());
					System.out.println("-----------------------------------");
				}
			} 
			*/
			//System.out.println(item);
		} 
		
	}
 	
	private void displayPackagesAndSubpackages()
	{
		ProjectExplorer project = new ProjectExplorer("Slimani-mouhcine-UML-Diagrams-Generator") ;  
		PackageExplorer pe ;
		for (String item : project.getPackagesTree()) {
			pe = new PackageExplorer(project.getAbsolutePath(item)); 
			String[] classes = pe.getPackageFiles();
			if(classes.length>0) {
				for (String string : classes) {
					System.out.println(item+" : "+string);
					ClassParser parser = new ClassParser(item+"."+string);
					if(parser.getMyClass().isAnnotation() || parser.getMyClass().isEnum() || parser.getMyClass().isInterface() )
					{ 
						System.out.println("isAnnotation : "+parser.getMyClass().isAnnotation()); 
						System.out.println("isEnum : "+parser.getMyClass().isEnum());
						System.out.println("isInterface : "+parser.getMyClass().isInterface());
					}
					else {
						System.out.println("isClass : "+true); 
					}
					System.out.println("+++++++++++++++++++++++++ " + string +" : ");
					System.out.println(parser.getFields()); 
				}
				System.out.println("-----------");
			} 
			 	//System.out.println("Package : "+item+" ----- Path absolute : "+project.getAbsolutePath(item));
		} 
	}
	public static void main(String[] args) {
		new Program();
	}
 	 
}
