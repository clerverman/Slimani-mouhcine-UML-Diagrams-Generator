package org.mql.java.relations;

import java.util.List;
import java.util.Vector;

import org.mql.java.classparser.ClassParser;
import org.mql.java.models.RelationShip;

public class InheritanceRelation {

	private List<RelationShip> relations ;  
	public InheritanceRelation() {
		relations = new Vector<RelationShip>();   
	}
	public List<RelationShip> getRelations() {
		return relations;
	}
	public void setRelations(List<RelationShip> relations) {
		this.relations = relations;
	}
	
	public void add(RelationShip r)
	{ 
		/*
		 * relationShip.setName("inheritance");
		 * relationShip.setFirstC(parser.getClass().getName());
		 * relationShip.setSecondC(parser.getParent()); relations.add(relationShip);
		 */
		relations.add(r);
	}
}
