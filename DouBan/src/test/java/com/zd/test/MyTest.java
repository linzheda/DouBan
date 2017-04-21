package com.zd.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import junit.framework.TestCase;

public class MyTest extends TestCase {
	public void test(){
		Map<String,String> map=new HashMap<String,String>();

		String filePath=this.getClass().getClassLoader().getResource("task.xml").toString();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(filePath);
			doc.getDocumentElement().normalize();
			Element  rootElement = doc.getDocumentElement();//获取根元素
			NodeList childNodes = rootElement.getChildNodes();//获取下一级元素
			for(int i=0;i<childNodes.getLength();i++){
				Node childNode=childNodes.item(i);
				if(childNode.getNodeType() == Node.ELEMENT_NODE ){
					NodeList childNodes_2 = childNode.getChildNodes();   
					for(int j = 0;j < childNodes_2.getLength();j++){
						Node childNode_2=childNodes_2.item(j);
						if(childNode_2.getNodeName()=="name"){
							//System.out.println(childNode_2.getParentNode().getNodeName()+"下面的name是："+childNode_2.getTextContent());
							map.put(childNode_2.getParentNode().getNodeName()+"_name:", childNode_2.getTextContent());
						}
						if(childNode_2.getNodeName()=="id"){
							//System.out.println(childNode_2.getParentNode().getNodeName()+"下面的id是："+childNode_2.getTextContent());
							map.put(childNode_2.getParentNode().getNodeName()+"_id:", childNode_2.getTextContent());
						}
						if(childNode_2.getNodeName()=="status"){
							//System.out.println(childNode_2.getParentNode().getNodeName()+"下面的status是："+childNode_2.getTextContent());
							map.put(childNode_2.getParentNode().getNodeName()+"_status:", childNode_2.getTextContent());
						}
						if(childNode_2.getNodeName()=="gropuid"){
							//System.out.println(childNode_2.getParentNode().getNodeName()+"下面的gropuid是："+childNode_2.getTextContent());
							map.put(childNode_2.getParentNode().getNodeName()+"_groupid:", childNode_2.getTextContent());
						}
						if(childNode_2.getNodeName()=="time"){
							//System.out.println(childNode_2.getParentNode().getNodeName()+"下面的time是："+childNode_2.getTextContent());
							map.put(childNode_2.getParentNode().getNodeName()+"_time:", childNode_2.getTextContent());
						}
					}
				}
			}



		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(map);
	}



	public void  lookTest(){
		String filePath=this.getClass().getClassLoader().getResource("task.xml").toString();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(filePath);
			doc.getDocumentElement().normalize();
			Element  rootElement = doc.getDocumentElement();//获取根元素
			NodeList childNodes = rootElement.getChildNodes();//获取下一级元素
			for(int i=0;i<childNodes.getLength();i++){
				Node childNode=childNodes.item(i);
				//System.out.println(childNode.getNodeName());

				if(childNode.getNodeType() == Node.ELEMENT_NODE ){
					NodeList childNodes_2 = childNode.getChildNodes();   
					for(int j = 0;j < childNodes_2.getLength();j++){
						Node childNode_2=childNodes_2.item(j);
						//System.out.println(childNode_2.getNodeName());
						//System.out.println(childNode_2.getTextContent());
						if(childNode_2.getNodeName()=="name"){
							System.out.println(childNode_2.getParentNode().getNodeName()+"下面的name是："+childNode_2.getTextContent());
						}
						if(childNode_2.getNodeName()=="id"){
							System.out.println(childNode_2.getParentNode().getNodeName()+"下面的id是："+childNode_2.getTextContent());
						}
						if(childNode_2.getNodeName()=="status"){
							System.out.println(childNode_2.getParentNode().getNodeName()+"下面的status是："+childNode_2.getTextContent());
						}
						if(childNode_2.getNodeName()=="gropuid"){
							System.out.println(childNode_2.getParentNode().getNodeName()+"下面的gropuid是："+childNode_2.getTextContent());
						}
						if(childNode_2.getNodeName()=="time"){
							System.out.println(childNode_2.getParentNode().getNodeName()+"下面的time是："+childNode_2.getTextContent());
						}
					}
				}
			}



		} catch (Exception e) {
			e.printStackTrace();
		}



	}
}
