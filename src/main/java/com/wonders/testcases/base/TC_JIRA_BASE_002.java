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
@Test(groups={"base", "easy", "test2"})
public class TC_JIRA_BASE_002 {
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
	 * TODO:	验证alert，confirm
	 * @author:	bluce
	 * @serialData:	2013-03-28
	 * @point:	alert
	 * @memo:	
	 */
	@Test(description = "验证alert，confirm")
	public void JIRA_BASE_002(){		
		//into self page
		BaseHome.driver.switchToFrame("gadget-0");
		LoginPageService.clickSignUp();
		BaseHome.driver.switchToWindow("Sign up for JIRA - Your Company JIRA");
		Assertion.AssertTrue(SelfPageService.checkAlter(), "验证alter");
		Assertion.AssertTrue(SelfPageService.checkConfirmAccept(), "验证confirm确定");
		Assertion.AssertTrue(SelfPageService.checkConfirmRefuse(), "验证confirm取消");
	} 
}
