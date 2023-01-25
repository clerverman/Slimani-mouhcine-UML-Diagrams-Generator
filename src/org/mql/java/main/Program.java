package org.mql.java.main;

import java.util.List;
import java.util.Vector;

import org.mql.java.classparser.ClassParser;
import org.mql.java.gestion.PackageGenerator;
import org.mql.java.gestion.PersistenceXML;
import org.mql.java.gestion.RelationGenerator;
import org.mql.java.gestion.RelationShipsGenerator;
import org.mql.java.models.AssociationModel;
import org.mql.java.models.ClassAttribute;
import org.mql.java.models.ClassContent;
import org.mql.java.models.PackageContent;
import org.mql.java.models.RelationShip;
import org.mql.java.reflection.ProjectExplorer;
import org.mql.java.relations.AssociationRelation;
import org.mql.java.relations.ImplementationRelation;
import org.mql.java.relations.InheritanceRelation;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.ImportDeclaration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;


public class Program {

	public Program() throws ParseException {
		 ex01() ;
		// ex02();
		// ex03();
		//ex04();
		//ex05();
	}

	private void ex05() {
		// TODO Auto-generated method stub

		ClassReader classReader;
		try {
			classReader = new ClassReader("org.mql.java.main.Program");
			 ClassNode classNode = new ClassNode();
		        classReader.accept(classNode, true);

		        List<String> imports = classNode.interfaces;
		        for(String importName: imports) {
		            System.out.println(importName);
		        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}
	
	private void ex04() throws ParseException {
		ProjectExplorer explorer = new ProjectExplorer("Slimani-mouhcine-UML-Diagrams-Generator") ; 
		 System.out.println(explorer.getFullProjectPath());
		for (String item : explorer.getPackagesTree()) {
			System.out.println(item +"\n");
			 
		}
		System.out.println();
		/*
		FileInputStream in;
		try {
			in = new FileInputStream("D:\\Java ee Workshops\\Slimani-mouhcine-UML-Diagrams-Generator\\src\\org\\mql\\java\\main\\Program.java");
			CompilationUnit cu = JavaParser.parse(in);
			List<ImportDeclaration> imports = cu.getImports();
			for (ImportDeclaration anImport : imports) {
				System.out.println(anImport.getName());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/
	}

	private void ex01() {

		PackageGenerator packageGenerator = new PackageGenerator("Slimani-mouhcine-UML-Diagrams-Generator");

		// System.out.println("Veuillez-vous voir un exemple d'exécution en :
		// resource/projet.txt (un peu clair)");
		System.out.println(packageGenerator.toXML());
		PersistenceXML persist = new PersistenceXML(packageGenerator.toXML());
		persist.saveToXMlFile();
		// System.out.println(packageGenerator.getPackageContent().getClasses().get(0).getName());
	}

	private void ex03() {
		// TODO Auto-generated method stub
		PackageGenerator packageGenerator = new PackageGenerator("Slimani-mouhcine-UML-Diagrams-Generator");
		List<AssociationModel> associationModels = new Vector<AssociationModel>();
		for (PackageContent pack : packageGenerator.getPackages()) {
			// System.out.println(pack.getName());
			for (ClassContent c : pack.getClasses()) {
				// System.out.println("\t"+c.getName());
				AssociationModel asso = new AssociationModel();
				asso.setClassName(pack.getName() + "." + c.getName());
				for (ClassAttribute att : c.getAttributes()) {
					String multiplicite = "1";
					if (att.getGenericType().startsWith("java.util.List"))
						multiplicite = "n";
					asso.setMultiplicity(multiplicite);
					asso.addAttr(att);
					// associationModels.add(new AssociationModel(pack.getName()+"."+c.getName(),
					// att.getName() ,att.getGenericType() , multiplicite ));
					// System.out.println("\t\t"+att);
				}
				associationModels.add(asso);
			}
		}

		RelationGenerator generator = new RelationGenerator();
		AssociationRelation associationRelation = new AssociationRelation(associationModels);

		generator.setRelations(associationRelation.getRelations());
		System.out.println(generator.toXML());
	}

	private void ex02() {
		PackageGenerator packageGenerator = new PackageGenerator("Slimani-mouhcine-UML-Diagrams-Generator");
		// System.out.println(packageGenerator.getPackages().get(5).getName()+"."+packageGenerator.getPackages().get(5).getClasses().get(1).getName());
		RelationShipsGenerator relationShipsGenerator = new RelationShipsGenerator(packageGenerator);

		RelationGenerator generator = new RelationGenerator();
		generator.setRelations(relationShipsGenerator.getRelations());
		System.out.println(generator.toXML());

	}

	public static void main(String[] args) throws ParseException {
		new Program();
	}
}
