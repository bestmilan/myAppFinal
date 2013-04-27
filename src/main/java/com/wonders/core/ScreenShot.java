package com.wonders.core;

import java.io.File;
import java.io.IOException;

import browser.common.IGenericWebDriver;

import com.wonders.configuration.Config;
import com.wonders.utils.RandomManage;

public class ScreenShot{
	
	public static void genScreenShot(IGenericWebDriver driver, String testClassName){
		try {
			String preFileName = "screenshot_" + testClassName;
			driver.takeScreenShotToFile(new File(genScreenFullPath(preFileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String genScreenFullPath(String filename) {
		try {
			return genPath() + genFileName(filename);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String genFileName(String filename) {
		return filename + "_" + RandomManage.getUuid() + ".png";
	}
	
	public static String genPath() {
		String targetFilePath = Config.getScreenPath() + "/";
		return targetFilePath;
	}
	
	public static void delAllFile(String filePath){
		 File file = new File(filePath);     
	     File[] fileList = file.listFiles();
       /**
        * 初始化子目录路径
        */
       String dirPath = null;   
       if(fileList != null)
       for(int i = 0 ; i < fileList.length; i++)
       {
           /**
            * 如果是文件就将其删除
            */
           if(fileList[i].isFile())
               fileList[i].delete();
           /**
            * 如果是目录,那么将些目录下所有文件删除后再将其目录删除,
            */
           if(fileList[i].isDirectory()){                     
               dirPath = fileList[i].getPath();
               //递归删除指定目录下所有文件
               delAllFile(dirPath);
           }
       }
	}
}
