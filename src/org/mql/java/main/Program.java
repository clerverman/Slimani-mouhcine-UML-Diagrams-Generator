package org.mql.java.main;
 
import org.mql.java.gestion.PackageGenerator;


public class Program {
	 
	public Program() {  
		ex01() ;
	}

	private void ex01() {  
		
		PackageGenerator packageGenerator = new PackageGenerator("Slimani-mouhcine-UML-Diagrams-Generator");
		//System.out.println("Veuillez-vous voir un exemple d'ex�cution en : resource/projet.txt (un peu clair)");
		System.out.println(packageGenerator.toXML());
		//System.out.println(packageGenerator.getPackageContent().getClasses().get(0).getName());
	}
 	
	public static void main(String[] args) {
		new Program();
	}
}
