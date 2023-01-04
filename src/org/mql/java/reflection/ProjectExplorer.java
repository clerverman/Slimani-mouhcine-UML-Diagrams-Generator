package org.mql.java.reflection;

import java.io.File; 
import java.util.List; 
import java.util.Vector;

public class ProjectExplorer {

	private String projectName;
	private String path;
	private String[] pathPart;
	private String fullProjectPath;
	private String projectPath;
	private List<String> packages; 
	private String line = "";

	public ProjectExplorer(String projectName) {
		this.projectName = projectName;
		path = System.getProperty("java.class.path");
		pathPart = path.split("\\\\");
		projectPath = pathPart[0] + "/" + pathPart[1];
		if (isProjectExist())
			this.fullProjectPath = projectPath + "/" + projectName + "/bin";
	}

	public boolean isProjectExist() {
		boolean isExist = false;
		// get the project location
		File dir = new File(projectPath);
		File f[] = dir.listFiles();
		for (File file : f) {
			// check if the project name exists or no
			if (file.isDirectory() && file.getName().equals(projectName)) {
				isExist = true;
				break;
			}
		}
		return isExist;
	}

	public List<String> getProjectPackages() {
		File maindir = new File(fullProjectPath);
		packages = new Vector<String>();
		if (maindir.exists() && maindir.isDirectory()) {
			File arr[] = maindir.listFiles();
			for (File file : arr) {
				packages.add(file.getName());
			}
		}
		return packages;
	}

	public List<String> getProjectSubPackages(String name) {
		File maindir = new File(fullProjectPath + "/" + name);
		packages = new Vector<String>();
		if (maindir.exists() && maindir.isDirectory()) {
			File arr[] = maindir.listFiles();
			for (File file : arr) {
				packages.add(file.getName());
			}
		}
		return packages;
	}

	public List<String> getProjectPackagesAndSubPackagesPath() {
		File maindir = new File(fullProjectPath);
		packages = new Vector<String>();
		if (maindir.exists() && maindir.isDirectory()) {
			File arr[] = maindir.listFiles();
			RecursivePackage(arr, 0, 0, packages);
		}
		return packages;
	}
	 
	private void RecursivePackage(File[] arr, int index, int level, List<String> packages) {
		if (index == arr.length)
			return;
		if (arr[index].isDirectory()) { 
			packages.add(arr[index].getPath());  
			RecursivePackage(arr[index].listFiles(), 0, level + 1, packages);
			 
		}
		RecursivePackage(arr, ++index, level, packages);
	}

	public List<String> getPackages() {
		return packages;
	}

	public Vector<String> getPack(String name) {
		Vector<String> pack = new Vector<String>();
		File dir = new File(fullProjectPath + "/" + name);
		File f[] = dir.listFiles();
		for (int i = 0; i < f.length; i++) {
			if (f[i].isDirectory())
				pack.add(f[i].getName());
		}
		return pack;
	}

	
	public List<String> getPackagesTree()
	{
		StringBuffer s = new StringBuffer() ; 
		List<String> packageList = new Vector<String>();
		List<String> packs = getProjectPackagesAndSubPackagesPath() ;
		for (String p : packs) {
			String[] path = p.split("\\\\");
			for (int i = 4 ; i < path.length ; i++) { 
				if(i==path.length-1)
					s.append(path[i]);
				else 
					s.append(path[i]+".");
			}
			packageList.add(s.toString()); 
			s = new StringBuffer() ;
		}
		return packageList;
	}
	
	public String getProjectName() {
		return projectName;
	}

	public String getFullProjectPath() {
		return fullProjectPath;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
