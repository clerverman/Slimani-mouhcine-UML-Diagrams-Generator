package org.mql.java.relations;

import java.util.List;
import java.util.Vector;

import org.mql.java.models.AssociationModel;
import org.mql.java.models.ClassAttribute;
import org.mql.java.models.RelationShip;

public class AssociationRelation {

	private List<AssociationModel> associationModels;
	private List<RelationShip> relations;

	public AssociationRelation() {
		associationModels = new Vector<AssociationModel>();
	}

	public AssociationRelation(List<AssociationModel> associationModels) {
		super();
		this.associationModels = associationModels;
	}

	public List<RelationShip> getRelations() {
		relations = new Vector<RelationShip>();
		AssociationModel model = null;
		for (AssociationModel associationModel : associationModels) {
			// System.out.println(associationModel.getClassName());
			for (ClassAttribute attr : associationModel.getAttributes()) {

				String type = attr.getGenericType().startsWith("java.util.List")
						? attr.getGenericType().substring(15, attr.getGenericType().length() - 1)
						: attr.getGenericType();
				// System.out.println("\t\t"+type);
				String multiplicity = attr.getGenericType().startsWith("java.util.List") ? "n" : "1" ; 
				model = isInstanceOfClass(type); // important
				if (model != null) {
					RelationShip relationShip = new RelationShip();
					relationShip.setName("association");
					relationShip.setFirstC(associationModel.getClassName());
					relationShip.setSecondC(model.getClassName());
					relationShip.setMaxVal(multiplicity);
					if (associationType(associationModel, model))
						relationShip.setType("bidirectionnelle");
					else
						relationShip.setType("unidirectionnelle");
					relations.add(relationShip);
				}
			}
		}
		return relations;
	}

	public AssociationModel isInstanceOfClass(String type) {
		AssociationModel assoModel = null;
		for (AssociationModel associationModel : associationModels) {
			if (associationModel.getClassName().equals(type)) {
				assoModel = associationModel;
				break;
			}
		}
		return assoModel;
	}

	public boolean associationType(AssociationModel current, AssociationModel objectAssoc) { // bi ou uni directionnel
		boolean isYes = false;
 		for (ClassAttribute attr : objectAssoc.getAttributes()) {
			String type = attr.getGenericType().startsWith("java.util.List")
					? attr.getGenericType().substring(15, attr.getGenericType().length() - 1)
					: attr.getGenericType();
			if (type.compareTo(current.getClassName()) == 0) {
				isYes = true;
 				break;
			}
		}
		return isYes;
	}

	
	
	public List<AssociationModel> getAssociationModels() {
		return associationModels;
	}

	public void setAssociationModels(List<AssociationModel> associationModels) {
		this.associationModels = associationModels;
	}

}
