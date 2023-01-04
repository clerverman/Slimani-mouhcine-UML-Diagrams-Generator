package org.mql.java.main;

import java.io.File;
import java.io.FileFilter;
import java.util.Stack;
import java.util.Vector;
import java.util.stream.Stream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.mql.java.reflection.MyCustomClass;
import org.mql.java.reflection.ProjectExplorer;

public class Program {
	 
	public Program() { 
		ex01(); 
	}

	private void ex01() {
		/*
		PackageExplorer pack = new PackageExplorer();
		String list[] = pack.getClassList("org.mql.java.reflection");
		for (String item : list) {
			System.out.println(item);
		}
		*/
		ProjectExplorer project = new ProjectExplorer("Slimani-mouhcine-UML-Diagrams-Generator") ;
		project.getProjectPackages();
		Vector<MyCustomClass> v = project.getMaps();
		for (MyCustomClass myCustomClass : v) {
			System.out.println(myCustomClass);
		}
	}
 	public static void main(String[] args) {
		new Program();
	}
 	 
}
