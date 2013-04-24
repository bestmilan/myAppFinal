package com.wonders.testcases.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wonders.configuration.Config;
import com.wonders.service.base.LoginPageService;
import com.wonders.service.base.SelfPageService;
import com.wonders.utils.Assertion;
import com.wonders.utils.BaseHome;
@Test(groups={"base", "easy", "frame"})
public class TC_JIRA_BASE_006 {
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("Chrome")String browser) {
		BaseHome.Launch(browser, Config.getLaunchUrl());		
	}
	
	@AfterMethod()
	public void cleanup() {
		BaseHome.Quit();
	}
	/**
	 * TODO:	验证alert,frame切换
	 * @author:	bluce
	 * @serialData:	2013-04-17
	 * @point:	alert
	 * @memo:	
	 */
	@Test(description = "验证alert,frame切换")
	public void JIRA_BASE_006(){		
		//into self page
		BaseHome.driver.switchToFrame("gadget-0");
		LoginPageService.clickSignUp();
		BaseHome.driver.switchToWindow("Sign up for JIRA - Your Company JIRA");
		BaseHome.driver.switchToFrame("iframeId");
		Assertion.AssertTrue(SelfPageService.checkFrame("frame"), "验证frame");
		BaseHome.driver.switchToDefaultWindow();
		Assertion.AssertTrue(SelfPageService.checkAlter(), "验证alter");
	} 
}
