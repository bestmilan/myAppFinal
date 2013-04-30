package com.wonders.testcases.base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wonders.configuration.Config;
import com.wonders.core.BaseHome;
import com.wonders.service.base.LoginPageService;
import com.wonders.service.base.MainPageService;
import com.wonders.service.issue.SearchIssueService;

@Test(groups = { "base", "easy", "stay" })
public class TC_JIRA_BASE_008 {
	private BaseHome home;
	private LoginPageService loginPageService;
	private MainPageService mainPageService;
	private SearchIssueService searchIssueService;
	
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("Chrome")String browser) {
		home = new BaseHome();
		home.Launch(browser, Config.getLaunchUrl());	
		loginPageService = new LoginPageService(home.driver);
		mainPageService = new MainPageService(home.driver);
		searchIssueService = new SearchIssueService(home.driver);
	}
	
	@AfterMethod()
	public void cleanup() {
		home.Quit();
	}
	/**
	 * TODO:	悬停，校验title
	 * @author:	bluce
	 * @serialData:	2013-04-30 20:39:02.870
	 * @point:	
	 * @memo:	
	 */
	@Test(description = "悬停，校验title")
	public void JIRA_BASE_008(){		
		loginPageService.login();
		home.driver.switchToWindow(mainPageService.assertMainPage());
		// open create issue fields
		mainPageService.gotoIssueSearch();
		home.driver.switchToWindow("Issue Navigator - Your Company JIRA");
		// search issue
		searchIssueService.search();
		home.driver.waitForComplete();
		searchIssueService.stay();
		// log out
		mainPageService.logout();
		home.driver.switchToDefaultWindow();
	}
}
