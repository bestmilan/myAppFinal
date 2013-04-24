package com.wonders.testcases.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wonders.configuration.Config;
import com.wonders.service.base.LoginPageService;
import com.wonders.service.base.SelfPageService;
import com.wonders.utils.BaseHome;
@Test(groups={"base", "easy", "drag"})
public class TC_JIRA_BASE_007 {
	@BeforeMethod(alwaysRun = true)
	@Parameters({"browser"})
	public void setup(@Optional("Chrome")String browser) {
		BaseHome.Launch(browser, Config.getLaunchUrl());		
	}
	
	@AfterMethod()
	public void cleanup() {
		BaseHome.Quit();
	}
	/**
	 * TODO:	拖拉(Drag andDrop)
	 * @author:	bluce
	 * @serialData:	2013-04-17
	 * @point:	alert
	 * @memo:	
	 */
	@Test(description = "拖拉(Drag and Drop)")
	public void JIRA_BASE_007(){	
		System.out.println(BaseHome.driver);
		//into self page
		BaseHome.driver.switchToFrame("gadget-0");
		LoginPageService.clickDragPage();
		BaseHome.driver.switchToWindow("Can't access your account? - Your Company JIRA");
		SelfPageService.drag();	
	} 
}
