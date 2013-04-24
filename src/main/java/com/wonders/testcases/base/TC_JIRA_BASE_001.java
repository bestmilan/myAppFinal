package com.wonders.testcases.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wonders.configuration.Config;
import com.wonders.pagewrapper.base.LoginPage;
import com.wonders.pagewrapper.base.MainPage;
import com.wonders.service.base.LoginPageService;
import com.wonders.service.base.MainPageService;
import com.wonders.utils.Assertion;
import com.wonders.utils.BaseHome;
@Test(groups={"base", "easy", "test1"})
public class TC_JIRA_BASE_001 {
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("FireFox")String browser) {
		BaseHome.Launch(browser, Config.getLaunchUrl());		
	}
	
	@AfterMethod()
	public void cleanup() {
		BaseHome.Quit();
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
		LoginPageService.login(adminUser, adminPW);
		LoginPage.driver.switchToWindow(MainPageService.assertMainPage());
		//check jira version
		String ver = MainPage.spnVersion().getText();
		Assertion.AssertEquals(ver.substring(1, ver.indexOf("#")), jiraVer);		
		//log out
		MainPageService.logout();
		BaseHome.driver.switchToDefaultWindow();
	}
}
