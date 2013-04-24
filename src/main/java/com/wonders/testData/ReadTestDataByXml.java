package com.wonders.testData;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadTestDataByXml {
	/**
	 * 
	 * @param tableName: 表明
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("finally")
	public static Object[][] readData(String xmlFilePath) throws IOException {
		Object[][] result = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();	
			Document doc = builder.parse(new File(xmlFilePath));;					
			Element rootElement = doc.getDocumentElement();
			NodeList list = rootElement.getElementsByTagName("row");
			for(int i=0;i<list.getLength();i++){
				
				Element element = (Element) list.item(i);
				NodeList listValue = element.getElementsByTagName("value");
				if(null==result){
					result = new Object[list.getLength()][listValue.getLength()];
				}
				for(int j=0;j<listValue.getLength();j++){
					Element elementValue = (Element) listValue.item(j);
					result[i][j] = elementValue.getTextContent();
				}
			}		
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		finally{
			return result;
		}
	}
}
