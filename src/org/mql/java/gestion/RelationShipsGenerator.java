package org.mql.java.gestion;

import java.util.List;
import java.util.Vector;

import org.mql.java.classparser.ClassParser;
import org.mql.java.models.AssociationModel;
import org.mql.java.models.ClassAttribute;
import org.mql.java.models.ClassContent;
import org.mql.java.models.PackageContent;
import org.mql.java.models.RelationShip;
import org.mql.java.relations.AssociationRelation;
import org.mql.java.relations.ImplementationRelation;
import org.mql.java.relations.InheritanceRelation;

public class RelationShipsGenerator {
	
	private PackageGenerator packageGenerator ; 
	private ClassParser parser ; 
	private List<RelationShip> relations ; 
	private ImplementationRelation impRelation  ;
	private InheritanceRelation inheritance ; 
	private RelationShip relationShip ;
	private List<AssociationModel> associationModels ; 
	private AssociationRelation associationRelation ; 
	
	public RelationShipsGenerator() {  
		relations = new Vector<RelationShip>() ; 
		associationModels = new Vector<AssociationModel>();
	}
	
	public RelationShipsGenerator(PackageGenerator packageGenerator) {
		this();
		this.packageGenerator = packageGenerator ; 
		generateImplementationRelation();
		generateHeritageRelation();
		generateAssociationRelation();
	}

	public PackageGenerator getPackageGenerator() {
		return packageGenerator;
	}

	public void setPackageGenerator(PackageGenerator packageGenerator) {
		this.packageGenerator = packageGenerator;
	}
	
	public void generateImplementationRelation()
	{
		for (PackageContent packageContent : packageGenerator.getPackages()) {
			for (ClassContent classContent : packageContent.getClasses()) {
				parser = new ClassParser(packageContent.getName()+"."+classContent.getName()) ;
 				impRelation = new ImplementationRelation(parser) ;
				addToRelations(impRelation.getRelations());
			}
		}
	}
	
	public void generateHeritageRelation()
	{ 
		inheritance = new InheritanceRelation() ; 
		for (PackageContent packageContent : packageGenerator.getPackages()) {
			for (ClassContent classContent : packageContent.getClasses()) {
				parser = new ClassParser(packageContent.getName()+"."+classContent.getName()) ;
				
				if(!parser.getParent().equals("no-parent")) {
					relationShip = new RelationShip() ; 
					relationShip.setName("inheritance");
					relationShip.setFirstC(packageContent.getName()+"."+classContent.getName());
					relationShip.setSecondC(parser.getParent());
					inheritance.add(relationShip);
				}  
			}
			addToRelations(inheritance.getRelations());
		}
	}
	
	public void generateAssociationRelation()
	{
		for (PackageContent pack : packageGenerator.getPackages() ) { 
			for (ClassContent c : pack.getClasses()) { 
				AssociationModel asso = new AssociationModel() ; 
				asso.setClassName(pack.getName()+"."+c.getName());
				for (ClassAttribute att : c.getAttributes()) { 
					String multiplicite = "1" ; 
					if(att.getGenericType().startsWith("java.util.List"))
						multiplicite = "n" ; 
					asso.setMultiplicity(multiplicite);
					asso.addAttr(att); 
				}
				associationModels.add(asso);
			}
		}
		associationRelation = new AssociationRelation(associationModels) ; 
		addToRelations(associationRelation.getRelations());
	}
	
	public void addToRelations(List<RelationShip> r)
	{
		relations.addAll(r);
	}

	public List<RelationShip> getRelations() {
		return relations;
	}

	public void setRelations(List<RelationShip> relations) {
		this.relations = relations;
	}
	
	
	
	
}
