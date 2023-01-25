package org.mql.java.xml.dom;
 
import java.util.List;
import java.util.Vector;
 

public class ProjectParser {
 
	
	public ProjectParser(String source) {
		parse(source);
	}

	public void parse(String source)
	{ 
		XMLNode root = new XMLNode(source) ; // le chemin est relatif
		XMLNode[] children = root.children() ;
		for (XMLNode child : children) { // chq child est document 
		}
	}
	
	 
}
