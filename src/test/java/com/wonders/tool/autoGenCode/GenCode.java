package com.wonders.tool.autoGenCode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import com.wonders.utils.Common;

@SuppressWarnings("unused")
public class GenCode {
	private static String pageClass = "com.wonders.pagewrapper.issue.MainPageService" ;
	private static String serviceClass = "com.wonders.service.base.MainPageService" ;
	private static String testClass = "com.wonders.testcases.issueFields.TC_JIRA_ISSUE_005";
	private static String testMethod = "JIRA_ISSUE_005";
	private static String modelloadPath = new File("").getAbsolutePath() + "\\vm\\";
	
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// 初始化并取得Velocity引擎
		VelocityEngine ve = new VelocityEngine();
		Properties p = new Properties();
		p.put(Velocity.FILE_RESOURCE_LOADER_PATH, modelloadPath);
		ve.init(p);
		PreContext.genPage(ve, pageClass, "page.vm");
		PreContext.genService(ve, serviceClass, pageClass, "service.vm");
		PreContext.genCase(ve, testClass, testMethod, serviceClass, "case.vm");
	}



}
