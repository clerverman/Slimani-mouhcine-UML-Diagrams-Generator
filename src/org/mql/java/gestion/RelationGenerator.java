package org.mql.java.gestion;

import java.util.List;
import java.util.Vector;
 
import org.mql.java.models.RelationShip;

public class RelationGenerator {
	
	private List<RelationShip> relations ; 
	
	public RelationGenerator() {
		relations = new Vector<RelationShip>() ; 
	}

	public RelationGenerator(List<RelationShip> relations) {
		super();
		this.relations = relations;
	}
	
	public void addRelation(RelationShip relationShip)
	{
		relations.add(relationShip);
	}

	@Override
	public String toString() {
		return "RelationGenerator [relations=" + relations + "]";
	}

	public List<RelationShip> getRelations() {
		return relations;
	}

	public void setRelations(List<RelationShip> relations) {
		this.relations = relations;
	}
	
	public void addToList(List<RelationShip> r)
	{
		relations.addAll(r);
	}
	
	public StringBuffer toXML()
	{
		StringBuffer c = new StringBuffer() ;  
		/*
		 * <relation name="" firstc="" secondc="" minval="" maxval="" > 
		 */
		c.append("\t<relations>\n");
		c.append(relationXML());
		c.append("\t</relations>\n");
		return c ; 
	}
	
	public StringBuffer relationXML()
	{
		StringBuffer a = new StringBuffer() ;  
		for (RelationShip relationShip : relations) { 
			a.append("\t\t<relation name=\""+relationShip.getName()+"\" firstc=\""+relationShip.getFirstC()+"\" secondc=\""+relationShip.getSecondC()+"\" minval=\""+relationShip.getMinVal()+"\" maxval=\""+relationShip.getMaxVal()+"\" type=\""+relationShip.getType()+"\" />\n"); 
		} 
		return a ;
	}
	
}
