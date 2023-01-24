package org.mql.java.relations;

import java.util.List;
import java.util.Vector;

import org.mql.java.classparser.ClassParser;
import org.mql.java.models.RelationShip;

public class ImplementationRelation {
	
	private List<RelationShip> relations ; 
	public ImplementationRelation(ClassParser parser) {
		relations = new Vector<RelationShip>();
		for (String item : parser.getInterfaces()) {
			RelationShip relationShip = new RelationShip() ;
			relationShip.setName("implementation");
			relationShip.setFirstC(parser.getClassName());
			relationShip.setSecondC(item); 
			relations.add(relationShip);
		} 
	}
	public List<RelationShip> getRelations() {
		return relations;
	}
	public void setRelations(List<RelationShip> relations) {
		this.relations = relations;
	}
}
