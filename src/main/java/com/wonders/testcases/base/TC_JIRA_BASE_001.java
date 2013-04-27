package com.wonders.testcases.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wonders.configuration.Config;
import com.wonders.service.base.LoginPageService;
import com.wonders.service.base.MainPageService;
import com.wonders.utils.Assertion;
import com.wonders.utils.BaseHome;
@Test(groups={"base", "easy", "test1"})
public class TC_JIRA_BASE_001 {
	private BaseHome home;
	
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("FireFox")String browser) {
		home = new BaseHome();
		home.Launch(browser, Config.getLaunchUrl());		
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
	@Parameters({"jiraVer", "adminUser", "adminPW"})
	@Test(description = "登录系统，校验jira版本")
	public void JIRA_BASE_001(String jiraVer, String adminUser, String adminPW){		
		//login
		LoginPageService loginService = new LoginPageService(home.driver);
		loginService.login(adminUser, adminPW);
		home.driver.switchToWindow(MainPageService.assertMainPage());
		//check jira version
		String ver = MainPage.spnVersion().getText();
		Assertion.AssertEquals(ver.substring(1, ver.indexOf("#")), jiraVer);		
		//log out
		MainPageService.logout();
		home.driver.switchToDefaultWindow();
	}
}
