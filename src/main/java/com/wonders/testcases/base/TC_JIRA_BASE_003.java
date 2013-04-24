package com.wonders.testcases.base;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wonders.configuration.Config;
import com.wonders.service.base.LoginPageService;
import com.wonders.service.base.SelfPageService;
import com.wonders.utils.BaseHome;
@Test(groups={"base", "normal", "test3"})
public class TC_JIRA_BASE_003 {
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("InternetExplorer")String browser) {
		BaseHome.Launch(browser, Config.getLaunchUrl());		
	}
	
	@AfterMethod()
	public void cleanup() { 
		BaseHome.Quit();
	}
	/**
	 * TODO:	验证ajax
	 * @author:	bluce
	 * @serialData:	2013-03-28
	 * @point:	ajax
	 * @memo:	
	 */
	@Test(description = "验证ajax")
	public void JIRA_BASE_003(){		
		//into self page
		BaseHome.driver.switchToFrame("gadget-0");
		LoginPageService.clickSignUp();
		BaseHome.driver.switchToWindow("Sign up for JIRA - Your Company JIRA");
		Assert.assertTrue(SelfPageService.checkAjax());
	} 
}
