package com.wonders.tool.autoGenCode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

public class CreateFile {
	private static String outFilePath = new File("").getAbsolutePath()
			+ "\\src\\main\\java\\";
	private static String fileSuffix = ".java";
	
	public static void fileOutPut(StringWriter writer, String outFile)
			throws UnsupportedEncodingException, IOException {
		// 输出信息
		System.out.println(writer.toString());
		// 输出到文件
		FileOutputStream of = new FileOutputStream(outFile);
		of.write(writer.toString().getBytes("UTF-8"));
		of.flush();
		of.close();
	}

	public static boolean checkFileExist(String classFullPath) {
		File file = new File(classFullPath);
		if (!file.exists()) {
			File foldPath = new File(classFullPath.substring(0, classFullPath.lastIndexOf("\\")));
			if  (!foldPath .exists()  && !foldPath .isDirectory()){
				foldPath .mkdir();
			}		
			return true;
		}else{
			return false;
		}
	}

	public static String outFile(String packagePath) {
		return outFilePath + packagePath.replace('.', '\\') + fileSuffix;
	}

}
