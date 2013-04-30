package com.wonders.tool.autoGenCode;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import com.wonders.utils.DateManage;

public class PreContext {
	public static void genPage(VelocityEngine ve, String pageClass, String modelFile) throws ResourceNotFoundException, ParseErrorException, MethodInvocationException, Exception  {
		String classFullPath = CreateFile.outFile(pageClass);
		if(CreateFile.checkFileExist(classFullPath)){
			// 取得velocity的上下文context
			VelocityContext context = new VelocityContext();
			// 把数据填入上下文
			context.put("package", pageClass.substring(0 ,pageClass.lastIndexOf(".")));
			context.put("pageClass", pageClass.substring(pageClass.lastIndexOf(".") + 1));
			// 输出流
			StringWriter writer = new StringWriter();
			// 取得velocity的模版
			Template t = ve.getTemplate(modelFile, "utf-8");
			// 转换输出
			t.merge(context, writer);
			CreateFile.fileOutPut(writer, classFullPath);
		}		
	}
	
	public static void genService(VelocityEngine ve, String serviceClass, String pageClass, String modelFile) throws ResourceNotFoundException, ParseErrorException, MethodInvocationException, Exception  {
		String classFullPath = CreateFile.outFile(serviceClass);
		if(CreateFile.checkFileExist(classFullPath)){
			// 取得velocity的上下文context
			VelocityContext context = new VelocityContext();
			// 把数据填入上下文
			context.put("package", serviceClass.substring(0 ,serviceClass.lastIndexOf(".")));
			context.put("serviceClass", serviceClass.substring(serviceClass.lastIndexOf(".") + 1));
			context.put("pageClassPackage", pageClass);
			context.put("pageClass", pageClass.substring(pageClass.lastIndexOf(".") + 1));
			context.put("pageClassVar", convertToVar(pageClass.substring(pageClass.lastIndexOf(".") + 1)));
			// 输出流
			StringWriter writer = new StringWriter();
			// 取得velocity的模版
			Template t = ve.getTemplate(modelFile, "utf-8");
			// 转换输出
			t.merge(context, writer);
			CreateFile.fileOutPut(writer, classFullPath);
		}		
	}
	public static void genCase(VelocityEngine ve, String caseClass, String caseMethod, String serviceClass, String modelFile) throws ResourceNotFoundException, ParseErrorException, MethodInvocationException, Exception  {
		String classFullPath = CreateFile.outFile(caseClass);
		if(CreateFile.checkFileExist(classFullPath)){
			// 取得velocity的上下文context
			VelocityContext context = new VelocityContext();
			// 把数据填入上下文
			context.put("package", caseClass.substring(0 ,caseClass.lastIndexOf(".")));
			context.put("caseClass", caseClass.substring(caseClass.lastIndexOf(".") + 1));
			context.put("servicePackage", serviceClass);
			context.put("caseMethod", caseMethod);
			context.put("serviceClass", serviceClass.substring(serviceClass.lastIndexOf(".") + 1));
			context.put("serviceClassVar", convertToVar(serviceClass.substring(serviceClass.lastIndexOf(".") + 1)));
			context.put("date", DateManage.getNowTime());
			// 输出流
			StringWriter writer = new StringWriter();
			// 取得velocity的模版
			Template t = ve.getTemplate(modelFile, "utf-8");
			// 转换输出
			t.merge(context, writer);
			CreateFile.fileOutPut(writer, classFullPath);
		}		
	}
	public static String convertToVar(String str){
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}
}
