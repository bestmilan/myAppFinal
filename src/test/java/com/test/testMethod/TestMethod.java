package com.test.testMethod;

import com.wonders.testData.ReadTestDataByXml;


public class TestMethod  {
	public static void main(String[] arg) {		
		try {
			ReadTestDataByXml.readData("dataXml/data/searchIssue.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
