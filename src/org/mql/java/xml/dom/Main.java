package org.mql.java.xml.dom;
 
public class Main {

	public Main() {
		ex01();
	}
	 
	public void ex01()
	{
		ProjectParser parser = new ProjectParser("resource/project.xml"); 
	}
 
	public static void main(String[] args) {
		new Main();
	}
	
}
