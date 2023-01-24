package org.mql.java.main;
 
import java.util.List;
import java.util.Vector;

import org.mql.java.classparser.ClassParser; 
import org.mql.java.gestion.PackageGenerator;
import org.mql.java.gestion.PersistenceXML;
import org.mql.java.gestion.RelationGenerator;
import org.mql.java.models.AssociationModel;
import org.mql.java.models.ClassAttribute;
import org.mql.java.models.ClassContent;
import org.mql.java.models.PackageContent;
import org.mql.java.models.RelationShip;
import org.mql.java.relations.AssociationRelation;
import org.mql.java.relations.ImplementationRelation;
import org.mql.java.relations.InheritanceRelation;


public class Program {
	 
	public Program() {  
		//ex01() ;
		//ex02();
		ex03();
	}

	private void ex01() {  
		
		PackageGenerator packageGenerator = new PackageGenerator("Slimani-mouhcine-UML-Diagrams-Generator");
		//System.out.println("Veuillez-vous voir un exemple d'exécution en : resource/projet.txt (un peu clair)");
		System.out.println(packageGenerator.toXML());
		PersistenceXML persist = new PersistenceXML(packageGenerator.toXML()) ; 
		persist.saveToXMlFile();
		//System.out.println(packageGenerator.getPackageContent().getClasses().get(0).getName());
	}
	
	private void ex03() {
		// TODO Auto-generated method stub
		PackageGenerator packageGenerator = new PackageGenerator("Slimani-mouhcine-UML-Diagrams-Generator"); 
		List<AssociationModel> associationModels = new Vector<AssociationModel>() ;
		for (PackageContent pack : packageGenerator.getPackages() ) {
			//System.out.println(pack.getName());
			for (ClassContent c : pack.getClasses()) {
				//System.out.println("\t"+c.getName()); 
				for (ClassAttribute att : c.getAttributes()) { 
					String multiplicite = "1" ; 
					if(att.getGenericType().startsWith("java.util.List"))
						multiplicite = "n" ;  
					associationModels.add(new AssociationModel(pack.getName()+"."+c.getName(), att.getName() ,att.getGenericType() , multiplicite ));
					//System.out.println("\t\t"+att);
				}
			}
		}
		// compare className and attrType : associationModels
		/*
		for (AssociationModel associationModel : associationModels) {
			System.out.println(associationModel);
		}
		*/
		RelationGenerator generator = new RelationGenerator() ; 
		AssociationRelation associationRelation = new AssociationRelation(associationModels) ; 
		associationRelation.getRelations(); 
		for (RelationShip r : associationRelation.getRelations()) {
			System.out.println(r);
		} 
		//generator.setRelations(associationRelation.getRelations());
		//System.out.println(generator.toXML());
	}
 	
	private void ex02() {
		PackageGenerator packageGenerator = new PackageGenerator("Slimani-mouhcine-UML-Diagrams-Generator");
		System.out.println(packageGenerator.getPackages().get(3).getClasses().get(0).getAttributes().size());
		System.out.println("-----------------------------------------------------------------------");
		System.out.println(packageGenerator.getPackages().get(5).getName()+"."+packageGenerator.getPackages().get(5).getClasses().get(1).getName());
		ClassParser parser = new ClassParser(packageGenerator.getPackages().get(5).getName()+"."+packageGenerator.getPackages().get(5).getClasses().get(1).getName()) ;
		ImplementationRelation imp = new ImplementationRelation(parser) ;
		
		RelationGenerator generator = new RelationGenerator() ; 
		generator.setRelations(imp.getRelations());
		//System.out.println(generator.toXML());
		
		RelationShip relationShip = new RelationShip() ; 
		relationShip.setName("inheritance");
		relationShip.setFirstC(parser.getMyClass().getName());
		relationShip.setSecondC(parser.getParent()); 
		
		InheritanceRelation inheritance = new InheritanceRelation(parser) ;
		inheritance.add(relationShip);
		inheritance.add(relationShip);
		inheritance.add(relationShip);
		inheritance.add(relationShip);
		generator.addToList(inheritance.getRelations()); 
		System.out.println(generator.toXML());
		
	}
	
	public static void main(String[] args) {
		new Program();
	}
}
