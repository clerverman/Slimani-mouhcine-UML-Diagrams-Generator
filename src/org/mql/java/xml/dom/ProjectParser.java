package org.mql.java.xml.dom;

import java.util.List;
import java.util.Vector;

import org.mql.java.models.AnnotationContent;
import org.mql.java.models.ClassAttribute;
import org.mql.java.models.ClassConstructor;
import org.mql.java.models.ClassContent;
import org.mql.java.models.ClassMethod;
import org.mql.java.models.EnumContent;
import org.mql.java.models.InterfaceContent;
import org.mql.java.models.RelationShip;
import org.mql.java.models.XmlPackageModel;

public class ProjectParser {
	private List<XmlPackageModel> packages;
	private List<RelationShip> relationShips ; 
	public ProjectParser(String source) {
		parse(source);
	}

	public void parse(String source) {
		XMLNode root = new XMLNode(source); // le chemin est relatif 
		XMLNode[] children = root.children();
		AllPackages(children[0]);
		AllRelationsShips(children[1]);
	}

	public void AllPackages(XMLNode packs) {
		packages = new Vector<XmlPackageModel>();
		for (XMLNode pack : packs.children()) {
			XmlPackageModel p = new XmlPackageModel();
			p.setName(pack.attribute("name"));
			p.setAnnotations(getAnnotations(pack.attribute("name"), pack.children()));
			p.setEnums(getEnums(pack.attribute("name"), pack.children()));
			p.setInterfaces(getInterfaces(pack.attribute("name"), pack.children()));
			p.setClasses(getClasses(pack.attribute("name"), pack.children()));
			packages.add(p);
		}
	}

	private List<AnnotationContent> getAnnotations(String name, XMLNode[] packages) {
		List<AnnotationContent> annotations = new Vector<AnnotationContent>();
		for (XMLNode p : packages) {
			if (p.name().equals("annotations")) {
				for (XMLNode annotation : p.children()) {
					AnnotationContent a = new AnnotationContent();
					a.setName(annotation.attribute("name"));
					a.setMethods(getClassMethods(annotation.children()));
					annotations.add(a);
				}
			}
		}
		return annotations;
	}

	private List<EnumContent> getEnums(String name, XMLNode[] packages) {
		List<EnumContent> enums = new Vector<EnumContent>();
		for (XMLNode p : packages) {
			if (p.name().equals("enums")) {
				for (XMLNode enu : p.children()) {
					EnumContent e = new EnumContent();
					e.setName(enu.attribute("name"));
					e.setAttributes(getClassAttributes(enu.children()));
					e.setContructors(getClassConstructors(enu.children()));
					e.setMethods(getClassMethods(enu.children()));
					enums.add(e);
				}
			}
		}
		return enums;
	}
	
	private List<ClassContent> getClasses(String name, XMLNode[] packages) {
		List<ClassContent> classes = new Vector<ClassContent>();
		for (XMLNode p : packages) {
			if (p.name().equals("classes")) {
				for (XMLNode enu : p.children()) {
					ClassContent c = new ClassContent();
					c.setName(enu.attribute("name"));
					c.setAttributes(getClassAttributes(enu.children()));
					c.setConstructors(getClassConstructors(enu.children()));
					c.setMethods(getClassMethods(enu.children()));
					classes.add(c);
				}
			}
		}
		return classes;
	}

	private List<InterfaceContent> getInterfaces(String name, XMLNode[] packages) {
		List<InterfaceContent> interfaces = new Vector<InterfaceContent>();
		for (XMLNode p : packages) {
			if (p.name().equals("interfaces")) {
				for (XMLNode enu : p.children()) {
					InterfaceContent i = new InterfaceContent();
					i.setName(enu.attribute("name"));
					i.setAttributes(getClassAttributes(enu.children())); 
					i.setMethods(getClassMethods(enu.children()));
					interfaces.add(i);
				}
			}
		}
		return interfaces;
	}
	
	private List<ClassMethod> getClassMethods(XMLNode[] meth) {
		List<ClassMethod> methods = new Vector<ClassMethod>();
		for (XMLNode c : meth) {
			if (c.name().equals("methods")) {
				for (XMLNode methode : c.children()) {
					ClassMethod m = new ClassMethod();
					m.setName(methode.attribute("name"));
					m.setModifier(methode.attribute("modifier"));
					m.setReturnType(methode.attribute("return-type"));
					methods.add(m);
				}
			}
		}
		return methods;
	}

	private List<ClassConstructor> getClassConstructors(XMLNode[] cons) {
		List<ClassConstructor> constructors = new Vector<ClassConstructor>();
		for (XMLNode c : cons) {
			if (c.name().equals("constructors")) {
				for (XMLNode constructor : c.children()) {
					ClassConstructor con = new ClassConstructor();
					con.setName(constructor.attribute("name"));
					con.setType(constructor.attribute("modifier"));
					constructors.add(con);
				}
			}
		}
		return constructors;
	}

	private List<ClassAttribute> getClassAttributes(XMLNode[] attrs) {
		List<ClassAttribute> attributes = new Vector<ClassAttribute>();
		for (XMLNode a : attrs) {
			if (a.name().equals("attributes")) {
				for (XMLNode att : a.children()) {
					ClassAttribute attr = new ClassAttribute();
					attr.setName(att.attribute("name"));
					attr.setModifier(att.attribute("modifier"));
					attr.setType(att.attribute("type"));
					attributes.add(attr);
				}
			}
		}
		return attributes;
	}

	public void AllRelationsShips(XMLNode relations) {
		relationShips = new Vector<RelationShip>() ; 
		for (XMLNode relation : relations.children()) {
			RelationShip r = new RelationShip();
			r.setName(relation.attribute("name"));
			r.setFirstC(relation.attribute("firstc"));
			r.setSecondC(relation.attribute("secondc"));
			r.setMaxVal(relation.attribute("maxval"));
			r.setMinVal(relation.attribute("minval"));
			r.setType(relation.attribute("type"));
			relationShips.add(r) ; 
		}
	}

	public List<XmlPackageModel> getPackages() {
		return packages;
	}

	public void setPackages(List<XmlPackageModel> packages) {
		this.packages = packages;
	}

	public List<RelationShip> getRelationShips() {
		return relationShips;
	}

	public void setRelationShips(List<RelationShip> relationShips) {
		this.relationShips = relationShips;
	}
	

}
