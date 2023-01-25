package org.mql.java.relations;

import java.util.List;
import java.util.Vector;

import org.mql.java.models.RelationShip;

public class ImportRelation {
	private List<RelationShip> relations ;  
	
	public ImportRelation() {
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
		relations.add(r);
	}
}
