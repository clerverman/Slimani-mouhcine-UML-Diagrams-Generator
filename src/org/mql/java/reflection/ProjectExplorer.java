package org.mql.java.reflection;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class ProjectExplorer {

	private String projectName;
	private String path;
	private String[] pathPart;
	private String fullProjectPath;
	private String projectPath;
	private List<String> packages;
	private Map<String, String> maps = new HashMap<String, String>();

	public ProjectExplorer(String projectName) {
		this.projectName = projectName;
		packages = new Vector<String>();
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
		if (maindir.exists() && maindir.isDirectory()) {
			File arr[] = maindir.listFiles();
			RecursivePrint(arr, 0, 0);
		}
		return new Vector<String>();
	}

	String line = "";
	int oldIndex = 0; 
	Vector<MyCustomClass> v = new Vector<MyCustomClass>();
	void RecursivePrint(File[] arr, int index, int level) { 
		if (index == arr.length)
			return;
		// System.out.println("----------"+arr[index].getName());
		// for sub-directories
		oldIndex = index ; 
		v.add(new MyCustomClass(index,level,arr[index].getName()));
		
		if (arr[index].isDirectory()) {
			System.out.println(arr[index].getName());
			// s.append("."+arr[index].getName());
			// recursion for sub-directories 
			RecursivePrint(arr[index].listFiles(), 0 , level + 1);
			// v.add(s.toString());
			// s = new
			// StringBuffer(s.substring(0,s.length()-arr[index].getName().length()-1)) ;
			// System.out.println("------------after :
			// "+(s.length()-arr[index].getName().length()));
		}
		
		// packages.add(line);
		// System.out.println("M : "+v.toString());
		RecursivePrint(arr, ++index, level);
		//oldIndex=0;
		// System.out.println("-------------------------");
		// System.out.println(line);
		// recursion for main directory
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

	public Vector<MyCustomClass> getMaps() {
		return v;
	}

	
}
