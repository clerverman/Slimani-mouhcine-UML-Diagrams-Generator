package org.mql.java.gestion;

import java.util.List;
import java.util.Vector;

import org.mql.java.classparser.ClassParser; 
import org.mql.java.models.PackageContent;
import org.mql.java.reflection.PackageExplorer;
import org.mql.java.reflection.ProjectExplorer;

public class PackageGenerator {
	
	private PackageContent packageContent ; 
	private ProjectExplorer projectExplorer ; 
	private PackageExplorer packageExplorer ; 
	private List<PackageContent> packages ; 
	
	public PackageGenerator(String projectName) {
		projectExplorer = new ProjectExplorer(projectName) ; 
		packages = new Vector<PackageContent>() ; 
		for (String item : projectExplorer.getPackagesTree()) {
			packageExplorer = new PackageExplorer(projectExplorer.getAbsolutePath(item)) ; 
			if(packageExplorer.getPackageFiles().length > 0)
			{
				packageContent = new PackageContent() ; 
				packageContent.setName(item);
				for (String c : packageExplorer.getPackageFiles()) {
					ClassGenerator classGenerator = new ClassGenerator(item, c);
					packageContent.addClass(classGenerator.generateClass());
					packageContent.setParser(classGenerator.getParser());
 				}
				packages.add(packageContent);
 			}
		}
	}

	public void setPackages(List<PackageContent> packages) {
		this.packages = packages;
	}

	@Override
	public String toString() {
		return "Project [packages=" + packages + "]";
	}

	public PackageContent getPackageContent() {
		return packageContent;
	}

	public void setPackageContent(PackageContent packageContent) {
		this.packageContent = packageContent;
	}

	public ProjectExplorer getProjectExplorer() {
		return projectExplorer;
	}

	public void setProjectExplorer(ProjectExplorer projectExplorer) {
		this.projectExplorer = projectExplorer;
	}

	public PackageExplorer getPackageExplorer() {
		return packageExplorer;
	}

	public void setPackageExplorer(PackageExplorer packageExplorer) {
		this.packageExplorer = packageExplorer;
	}

	public List<PackageContent> getPackages() {
		return packages;
	}
	
	public StringBuffer toXML()
	{
		StringBuffer c = new StringBuffer() ;  
		/*
		 * 
		 * 	<package name="">
		 * 		<class/> {*}
		 * 	</package>
		 * 
		 */
		c.append("<projet name=\""+projectExplorer.getProjectName()+"\">\n");
		c.append(packagesXML());
		c.append("</projet>");
		return c ; 
	}
	
	public StringBuffer packagesXML()
	{
		StringBuffer a = new StringBuffer() ; 
		a.append("\t<packages>\n");
		for (PackageContent packageContent : packages) { 
			a.append(packageContent.toXML()+"\n"); 
		}
		a.append("\t</packages>\n");
		return a ;
	}
	
	
}
