package com.wonders.testcases.base;

import org.testng.annotations.BeforeSuite;

import com.wonders.configuration.Config;
import com.wonders.utils.ScreenShot;

public class PRE_ACTION {
	@BeforeSuite(alwaysRun = true)
	public void delOldFileData() {
		try{
			ScreenShot.delAllFile(Config.getScreenPath());	
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}
