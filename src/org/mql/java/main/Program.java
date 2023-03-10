package org.mql.java.main;
 
import org.mql.java.gestion.PackageGenerator;
import org.mql.java.gestion.PersistenceXML;
import org.mql.java.models.RelationShip;
import org.mql.java.models.XmlPackageModel;
import org.mql.java.xml.dom.ProjectParser;
 


public class Program {

	public Program() {
		 //ex01() ; 
		ex02();
	}
 
	private void ex01() {

		PackageGenerator packageGenerator = new PackageGenerator("Slimani-mouhcine-UML-Diagrams-Generator"); 
		System.out.println(packageGenerator.toXML());
		PersistenceXML persist = new PersistenceXML(packageGenerator.toXML());
		persist.saveToXMlFile(); 
	}
	
	private void ex02() { 
		ProjectParser projectParser = new ProjectParser("resource/project.xml") ; 
		 
		for (XmlPackageModel pack : projectParser.getPackages()) {
			System.out.println(pack);
		}
		 
		for (RelationShip r : projectParser.getRelationShips()) {
			System.out.println(r);
		}
		 
	}
 
	public static void main(String[] args)  {
		new Program();
	}
}
