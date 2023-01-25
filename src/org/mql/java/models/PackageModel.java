package org.mql.java.models;

import java.util.List;
import java.util.Vector;

public class PackageModel {
	private String name ; 
	private List<String> packages ; 
	
	public PackageModel() {
		packages = new Vector<String>() ; 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPackages() {
		return packages;
	}

	public void setPackages(List<String> packages) {
		this.packages = packages;
	}
	
	public void add(String importedPack)
	{
		packages.add(importedPack);
	}

	@Override
	public String toString() {
		return "PackageModel [name=" + name + ",  packages=" + packages + "]";
	}
}
