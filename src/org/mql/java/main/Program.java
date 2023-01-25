package org.mql.java.main;
 
import org.mql.java.gestion.PackageGenerator;
import org.mql.java.gestion.PersistenceXML;
 


public class Program {

	public Program() {
		 ex01() ; 
	}
 
	private void ex01() {

		PackageGenerator packageGenerator = new PackageGenerator("Slimani-mouhcine-UML-Diagrams-Generator"); 
		System.out.println(packageGenerator.toXML());
		PersistenceXML persist = new PersistenceXML(packageGenerator.toXML());
		persist.saveToXMlFile(); 
	}
 
	public static void main(String[] args)  {
		new Program();
	}
}
