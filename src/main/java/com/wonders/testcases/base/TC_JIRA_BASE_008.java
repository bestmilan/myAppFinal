package com.wonders.testcases.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wonders.configuration.Config;
import com.wonders.service.base.LoginPageService;
import com.wonders.service.base.MainPageService;
import com.wonders.service.issueFields.SearchIssueService;
import com.wonders.utils.BaseHome;

@Test(groups = { "base", "easy", "stay" })
public class TC_JIRA_BASE_008 {
	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("Chrome") String browser) {
		BaseHome.Launch(browser, Config.getLaunchUrl());
	}

	@AfterMethod()
	public void cleanup() {
		BaseHome.Quit();
	}

	/**
	 * TODO: 悬停，校验title
	 * 
	 * @author: bluce
	 * @serialData: 2013-04-18
	 * @point:
	 * @memo:
	 */
	@Test(description = "悬停，校验title")
	public void JIRA_BASE_008() {
		LoginPageService.login(Config.getUser(), Config.getPassword());
		BaseHome.driver.switchToWindow(MainPageService.assertMainPage());
		// open create issue fields
		MainPageService.gotoIssueSearch();
		BaseHome.driver.switchToWindow("Issue Navigator - Your Company JIRA");
		// search issue
		SearchIssueService.search();
		BaseHome.waitForComplete();
		SearchIssueService.stay();
		System.out.println("Avatar:" + SearchIssueService.getAvatar());
		// log out
		MainPageService.logout();
		BaseHome.driver.switchToDefaultWindow();

	}
}
