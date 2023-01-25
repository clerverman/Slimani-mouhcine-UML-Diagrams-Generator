package org.mql.java.gestion;

import java.io.FileInputStream;
import java.util.List;
import java.util.Vector;

import org.mql.java.classparser.ClassParser;
import org.mql.java.models.AssociationModel;
import org.mql.java.models.ClassAttribute;
import org.mql.java.models.ClassContent;
import org.mql.java.models.PackageContent;
import org.mql.java.models.PackageModel;
import org.mql.java.models.RelationShip;
import org.mql.java.relations.AssociationRelation;
import org.mql.java.relations.ImplementationRelation;
import org.mql.java.relations.ImportRelation;
import org.mql.java.relations.InheritanceRelation;

import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.ImportDeclaration;

public class RelationShipsGenerator {

	private PackageGenerator packageGenerator;
	private ClassParser parser;
	private List<RelationShip> relations;
	private ImplementationRelation impRelation;
	private InheritanceRelation inheritance;
	private RelationShip relationShip;
	private List<AssociationModel> associationModels;
	private AssociationRelation associationRelation;
	private List<PackageModel> packages;
	private ImportRelation importRelation;

	public RelationShipsGenerator() {
		relations = new Vector<RelationShip>();
		associationModels = new Vector<AssociationModel>();
		packages = new Vector<PackageModel>();

	}

	public RelationShipsGenerator(PackageGenerator packageGenerator) {
		this();
		this.packageGenerator = packageGenerator;
		generateImplementationRelation();
		generateHeritageRelation();
		generateAssociationRelation();
		generateImportRelation();
	}

	public PackageGenerator getPackageGenerator() {
		return packageGenerator;
	}

	public void setPackageGenerator(PackageGenerator packageGenerator) {
		this.packageGenerator = packageGenerator;
	}

	public void generateImplementationRelation() {
		for (PackageContent packageContent : packageGenerator.getPackages()) {
			for (ClassContent classContent : packageContent.getClasses()) {
				parser = new ClassParser(packageContent.getName() + "." + classContent.getName());
				impRelation = new ImplementationRelation(parser);
				addToRelations(impRelation.getRelations());
			}
		}
	}

	public void generateHeritageRelation() {
		inheritance = new InheritanceRelation();
		for (PackageContent packageContent : packageGenerator.getPackages()) {
			for (ClassContent classContent : packageContent.getClasses()) {
				parser = new ClassParser(packageContent.getName() + "." + classContent.getName());

				if (!parser.getParent().equals("no-parent")) {
					relationShip = new RelationShip();
					relationShip.setName("inheritance");
					relationShip.setFirstC(packageContent.getName() + "." + classContent.getName());
					relationShip.setSecondC(parser.getParent());
					inheritance.add(relationShip);
				}
			}
			addToRelations(inheritance.getRelations());
		}
	}

	public void generateAssociationRelation() {
		for (PackageContent pack : packageGenerator.getPackages()) {
			for (ClassContent c : pack.getClasses()) {
				AssociationModel asso = new AssociationModel();
				asso.setClassName(pack.getName() + "." + c.getName());
				for (ClassAttribute att : c.getAttributes()) {
					String multiplicite = "1";
					if (att.getGenericType().startsWith("java.util.List"))
						multiplicite = "n";
					asso.setMultiplicity(multiplicite);
					asso.addAttr(att);
				}
				associationModels.add(asso);
			}
		}
		associationRelation = new AssociationRelation(associationModels);
		addToRelations(associationRelation.getRelations());
	}

	public void generateImportRelation() {
		String projectPath = packageGenerator.getProjectExplorer().getProjectPath();
		PackageModel m = null;
		for (PackageContent packageContent : packageGenerator.getPackages()) {
			for (ClassContent c : packageContent.getClasses()) {
				String name = projectPath + "/" + packageContent.getName().replace(".", "/") + "/" + c.getName()
						+ ".java";
				FileInputStream in;
				try {
					in = new FileInputStream(name);
					CompilationUnit cu = JavaParser.parse(in);
					List<ImportDeclaration> imports = cu.getImports();
					if (imports.size() > 0) {
						for (ImportDeclaration anImport : imports) {
							m = new PackageModel();
							m.setName(packageContent.getName());
							m.add(anImport.getName() + "");
							packages.add(m);
						}
					}
				} catch (Exception e) {
				}
			}
		}

		importRelation = new ImportRelation();
		for (PackageModel p : packages) {
			for (String s : p.getPackages()) {
				relationShip = new RelationShip();
				relationShip.setName("import");
				relationShip.setFirstC(p.getName());
				relationShip.setSecondC(s);
				importRelation.add(relationShip);
			}
		}

		addToRelations(importRelation.getRelations());

	}

	public void addToRelations(List<RelationShip> r) {
		relations.addAll(r);
	}

	public List<RelationShip> getRelations() {
		return relations;
	}

	public void setRelations(List<RelationShip> relations) {
		this.relations = relations;
	}

}
