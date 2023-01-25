package org.mql.java.gestion;

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
import org.mql.java.relations.InheritanceRelation;

public class RelationShipsGenerator {

	private PackageGenerator packageGenerator;
	private ClassParser parser;
	private List<RelationShip> relations;
	private ImplementationRelation impRelation;
	private InheritanceRelation inheritance;
	private RelationShip relationShip;
	private List<AssociationModel> associationModels;
	private AssociationRelation associationRelation;
	private List<PackageModel> packageModels;

	public RelationShipsGenerator() {
		relations = new Vector<RelationShip>();
		associationModels = new Vector<AssociationModel>();
		packageModels = new Vector<PackageModel>();
	}

	public RelationShipsGenerator(PackageGenerator packageGenerator) {
		this();
		this.packageGenerator = packageGenerator;
		// generateImplementationRelation();
		// generateHeritageRelation();
		// generateAssociationRelation();
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
		for (PackageContent packageContent : packageGenerator.getPackages()) {
			for (ClassContent c : packageContent.getClasses()) {
				PackageModel packageModel = new PackageModel();
				packageModel.setName(packageContent.getName());
				packageModel.setAttributes(c.getAttributes());
				packageModels.add(packageModel);
			}
		}

		for (int i = 0; i < packageModels.size(); i++) {
			isImoprted(i);
		}
	}

	public void isImoprted(int packIndex) {
		for (int i = 0; i < packageModels.get(packIndex).getAttributes().size() ;i++) {
			String typ = packageModels.get(packIndex).getAttributes().get(i).getGenericType().startsWith("java.util.List")
					? packageModels.get(packIndex).getAttributes().get(i).getGenericType().substring(15, packageModels.get(packIndex).getAttributes().get(i).getGenericType().length() - 1)
					: packageModels.get(packIndex).getAttributes().get(i).getGenericType();
			for (int j = 0; j < packageModels.size(); j++) {
				if(j != packIndex)
				{
					for (int l = 0; l < packageModels.get(j).getAttributes().size(); l++) {
						String type = packageModels.get(j).getAttributes().get(l).getGenericType().startsWith("java.util.List")
								? packageModels.get(j).getAttributes().get(l).getGenericType().substring(15, packageModels.get(j).getAttributes().get(l).getGenericType().length() - 1)
								: packageModels.get(j).getAttributes().get(l).getGenericType();
						if(type.equals(typ))
						{
							System.out.println(packageModels.get(packIndex).getName()+"\n\t"+packageModels.get(j).getName());
							break ; 
						}
					}
				}
			}
		}
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
