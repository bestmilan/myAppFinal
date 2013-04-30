package com.wonders.testcases.issueFields;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wonders.configuration.Config;
import com.wonders.core.Assertion;
import com.wonders.core.BaseHome;
import com.wonders.service.base.LoginPageService;
import com.wonders.service.base.MainPageService;
import com.wonders.service.issue.SearchIssueResultService;
import com.wonders.testData.ReadTestData;

@Test(groups = {"project", "hard", "search" })
public class TC_JIRA_ISSUE_005 {
	private BaseHome home;
	private LoginPageService loginPageService;
	private MainPageService mainPageService;
	private SearchIssueResultService searchIssueResultService;
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("Chrome")String browser) {
		home = new BaseHome();
		home.Launch(browser, Config.getLaunchUrl());	
		loginPageService = new LoginPageService(home.driver);
		mainPageService = new MainPageService(home.driver);
		searchIssueResultService = new SearchIssueResultService(home.driver); 
	}
	
	@AfterMethod()
	public void cleanup() {
		home.Quit();
	}
	@DataProvider(name = "providerTestData")
	public Object[][] providerTestData() throws IOException {
		return ReadTestData.readData("searchIssue.xlsx", 0);
	}
	/**
	 * TODO:	issue查询（通过页面和数据库两种方式进行校验）
	 * @author:	bluce
	 * @serialData:	2013-04-30 21:23:44.948
	 * @point:	select, addAttribute, combox, radio, checkbox, open windows, data provide
	 *         @DataProvider, @Optional, sql, timeOut
	 * @memo:	
	 */
	@Test(description = "issue查询", dataProvider = "providerTestData", timeOut = 30000)
	public void JIRA_ISSUE_005(String blockType, String block, String status, String reporter, String days){		
		//login
		loginPageService.login();
		home.driver.switchToWindow(mainPageService.assertMainPage());
		// open create issue fields
		mainPageService.gotoIssueSearch();
		home.driver.switchToWindow("Issue Navigator - Your Company JIRA");
		// search issue
		/*searchIssueResultService.setSearchFields(blockType, block, status, reporter, days);
		home.driver.waitForComplete();
		Assertion.AssertTrue(searchIssueResultService.checkSearchResultCount(
				blockType, block, status, reporter, days));*/
		// log out
		mainPageService.logout();
		home.driver.switchToDefaultWindow();
	}
}
