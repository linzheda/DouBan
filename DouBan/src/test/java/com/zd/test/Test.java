package com.zd.test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import junit.framework.TestCase;

public class Test extends TestCase{

	
	public void  lookTest(){
		String filePath=this.getClass().getClassLoader().getResource("task.xml").toString();
		System.out.println(filePath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(filePath);
			doc.getDocumentElement().normalize();
			NodeList timerTasks = doc.getElementsByTagName("TimerTasks");
			Element emp = null;
			for(int i=0; i<timerTasks.getLength();i++){
				emp = (Element) timerTasks.item(i);
				System.out.println(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}



	}
	

}
