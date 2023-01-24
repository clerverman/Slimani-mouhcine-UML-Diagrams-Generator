package org.mql.java.gestion;

import java.util.List;
import java.util.Vector;

import org.mql.java.classparser.ClassParser;
import org.mql.java.models.ClassContent;
import org.mql.java.models.PackageContent;
import org.mql.java.models.RelationShip;
import org.mql.java.relations.ImplementationRelation;
import org.mql.java.relations.InheritanceRelation;

public class RelationShipsGenerator {
	
	private PackageGenerator packageGenerator ; 
	private ClassParser parser ; 
	private List<RelationShip> relations ; 
	private ImplementationRelation impRelation  ;
	private InheritanceRelation inheritance ; 
	private RelationShip relationShip ; 
	public RelationShipsGenerator() {  
		relations = new Vector<RelationShip>() ; 
	}
	
	public RelationShipsGenerator(PackageGenerator packageGenerator) {
		this();
		this.packageGenerator = packageGenerator ; 
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
