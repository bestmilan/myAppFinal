package com.wonders.utils;

import java.io.File;

public class GetAccessory {
	public static String getFilePath(String fileName){
		return new File("testPic/" + fileName).getAbsolutePath();
	}
}
