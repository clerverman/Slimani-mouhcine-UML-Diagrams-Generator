package org.mql.java.xml.dom;

import java.io.IOException;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory; 

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList; 
public class XMLNode {
	
	private Node node ; // est un wrapper
	
	public XMLNode(Node node) { 
		this.node = node;
	}


	public XMLNode(String source) { 
		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance() ;
		try {
			DocumentBuilder builder = factory.newDocumentBuilder() ;  
			Document document = builder.parse(source);  
			node = document.getFirstChild(); 
			while(node.getNodeType() != Node.ELEMENT_NODE)
				node = node.getNextSibling();
			 
		} catch (Exception e) {
			System.out.println("Erreur : "+e.getMessage());  
		}  
	}
	
	
	public XMLNode[] children()
	{
		NodeList list = node.getChildNodes() ;
		Vector<XMLNode> nodes = new Vector<XMLNode>();
		for (int i = 0; i < list.getLength(); i++) {
			if(list.item(i).getNodeType() == Node.ELEMENT_NODE)
				nodes.add(new XMLNode(list.item(i)));
		}	 
		return nodes.toArray(new XMLNode[nodes.size()]) ; 
	}
	
	public XMLNode child(String name)
	{
		NodeList list = node.getChildNodes() ; 
		for (int i = 0; i < list.getLength(); i++) {
			if(list.item(i).getNodeName().equals(name)) 
				return new XMLNode(list.item(i));
		}	
		return null ; 
	}
	
	public String value()
	{
		if(node.getNodeType() == Node.ELEMENT_NODE)
			return node.getFirstChild().getNodeValue();
		return node.getNodeValue();
	}
	
	public String name()
	{
		return node.getNodeName();
	}
	
	public boolean isElement()
	{
		return node.getNodeType() == Node.ELEMENT_NODE;
	}
	
	public String attribute(String name)
	{
		NamedNodeMap attrs = node.getAttributes();
		return attrs.getNamedItem(name).getNodeValue();
	}
	
	public int intAttribute(String name)
	{
		NamedNodeMap attrs = node.getAttributes();
		try {
			return Integer.parseInt(attrs.getNamedItem(name).getNodeValue());
		}
		catch(Exception e)
		{
			return -1 ; 
		}
	}
	
	public NamedNodeMap getAttributes() {
		NamedNodeMap attrs = node.getAttributes();
		if(attrs != null)
			return attrs;
		return null;
	}
	
	public void print()
	{
		System.out.println(node.getNodeName()+" , "+node.getNodeType()+" , "+node.getNodeValue());
	}

}
