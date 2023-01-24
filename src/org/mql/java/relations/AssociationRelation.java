package org.mql.java.relations;

import java.util.List;
import java.util.Vector;

import org.mql.java.models.AssociationModel;
import org.mql.java.models.RelationShip;

public class AssociationRelation {
	
	private List<AssociationModel> associationModels ; 
	private List<RelationShip> relations ;
	public AssociationRelation() {
		associationModels = new Vector<AssociationModel>() ; 
	}

	public AssociationRelation(List<AssociationModel> associationModels) {
		super();
		this.associationModels = associationModels;
	}

	public List<RelationShip> getRelations(){
		relations = new Vector<RelationShip>() ; 
		AssociationModel assoModels  ; 
		int i = 0 ; 
		for (AssociationModel assoModel : associationModels) { 
			assoModels = isInstanceOfClass(assoModel.getAttrType()) ;
			if(assoModels != null) {
				RelationShip relationShip = new RelationShip() ;
				relationShip.setName("association");
				relationShip.setFirstC(assoModel.getClassName());
				relationShip.setSecondC(assoModels.getClassName());
				relationShip.setMaxVal(assoModel.getMultiplicity());
				String type = isDirectional(assoModel, assoModels) == true ? "bidirectional" : "unidirectional" ; 
				relationShip.setType(type);
				relations.add(relationShip);
			}
				//System.out.println(assoModel+"\n\t\t"+assoModels);
		} 
		return relations ; 
	}
	
	public AssociationModel isInstanceOfClass(String attrType)
	{
		AssociationModel assoModel = null ; 
		attrType = attrType.startsWith("java.util.List") ? attrType.substring(15, attrType.length()-1) : attrType ;  
		for (AssociationModel associationModel : associationModels) { 
			if(associationModel.getClassName().equals(attrType)) {
				assoModel = associationModel ;
				break ; 
			} 
		}
		return assoModel ; 
	}
	
	public boolean isDirectional(AssociationModel asso1 ,  AssociationModel asso2)
	{
		System.out.println(asso2);
		return asso1.getClassName().equals(asso2.getAttrType());
	}

	public List<AssociationModel> getAssociationModels() {
		return associationModels;
	}

	public void setAssociationModels(List<AssociationModel> associationModels) {
		this.associationModels = associationModels;
	}
  
}
