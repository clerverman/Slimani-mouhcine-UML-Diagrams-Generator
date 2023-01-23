package org.mql.java.gestion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

public class PersistenceXML {

	private StringBuffer xmlFormat;

	public PersistenceXML() {
		// TODO Auto-generated constructor stub
	}

	public PersistenceXML(StringBuffer xmlFormat) {
		super();
		this.xmlFormat = xmlFormat;
	}

	public void saveToXMlFile() {
		try {
			FileWriter myWriter = new FileWriter("resource/project.xml");
			myWriter.write(xmlFormat.toString());
			myWriter.close();
			System.out.println("\n\nPersistance is done.");
		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
