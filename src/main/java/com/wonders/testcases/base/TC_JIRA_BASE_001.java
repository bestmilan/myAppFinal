package com.wonders.testcases.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wonders.configuration.Config;
import com.wonders.core.Assertion;
import com.wonders.core.BaseHome;
import com.wonders.service.base.LoginPageService;
import com.wonders.service.base.MainPageService;
@Test(groups={"base", "easy", "checkVer"})
public class TC_JIRA_BASE_001 {
	private BaseHome home;
	private LoginPageService loginPageService;
	private MainPageService mainPageService;
	
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("Chrome")String browser) {
		home = new BaseHome();
		home.Launch(browser, Config.getLaunchUrl());	
		loginPageService = new LoginPageService(home.driver);
		mainPageService = new MainPageService(home.driver);
	}
	
	@AfterMethod()
	public void cleanup() {
		home.Quit();
	}
	/**
	 * TODO:	登录系统，校验jira版本
	 * @author:	bluce
	 * @serialData:	2013-03-20
	 * @point:	frame, span, div
	 * @point:	@Parameters
	 * @memo:	
	 */
	@Parameters({"jiraVer"})
	@Test(description = "登录系统，校验jira版本")
	public void JIRA_BASE_001(String jiraVer){		
		//login
		loginPageService.login();
		home.driver.switchToWindow(mainPageService.assertMainPage());
		//check jira version
		String ver = mainPageService.getVersion();
		Assertion.AssertEquals(ver.substring(1, ver.indexOf("#")), jiraVer);		
		//log out
		mainPageService.logout();
		home.driver.switchToDefaultWindow();
	}
}
