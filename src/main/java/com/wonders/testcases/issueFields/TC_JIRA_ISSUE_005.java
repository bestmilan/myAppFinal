package com.wonders.testcases.issueFields;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wonders.configuration.Config;
import com.wonders.service.base.LoginPageService;
import com.wonders.service.base.MainPageService;
import com.wonders.service.issueFields.SearchIssueResultService;
import com.wonders.service.issueFields.SearchIssueService;
import com.wonders.testData.ReadTestData;
import com.wonders.utils.AbstractSpringTest;
import com.wonders.utils.Assertion;
import com.wonders.utils.BaseHome;
@Test(groups = {"project", "hard", "search" })
public class TC_JIRA_ISSUE_005 extends AbstractSpringTest {
	@Autowired
	SearchIssueResultService searchIssueResultService;

	@Parameters({"browser"})
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("Chrome")String browser) {
		BaseHome.Launch(browser, Config.getLaunchUrl());		
	}

	@AfterMethod()
	public void cleanup() {
		BaseHome.Quit();
	}

	@DataProvider(name = "providerTestData")
	public Object[][] providerTestData() throws IOException {
		return ReadTestData.readData("searchIssue.xlsx", 0);
	}

	/**
	 * TODO: issue查询（通过页面和数据库两种方式进行校验）
	 * 
	 * @author: bluce
	 * @serialData: 2013-03-31
	 * @point: select, addAttribute, combox, radio, checkbox, open windows, data provide
	 *         @DataProvider, @Optional, sql, timeOut
	 * @memo:
	 */
	@Test(description = "issue查询", dataProvider = "providerTestData", timeOut = 30000)
	public void JIRA_ISSUE_005(String blockType, String block, String status, String reporter, String days) {
		// login
		LoginPageService.login(Config.getUser(), Config.getPassword());
		BaseHome.driver.switchToWindow(MainPageService.assertMainPage());
		// open create issue fields
		MainPageService.gotoIssueSearch();
		BaseHome.driver.switchToWindow("Issue Navigator - Your Company JIRA");
		// search issue
		SearchIssueService.setSearchFields(blockType, block, status, reporter, days);
		BaseHome.waitForComplete();
		Assertion.AssertTrue(searchIssueResultService.checkSearchResultCount(
				blockType, block, status, reporter, days));
		// log out
		MainPageService.logout();
		BaseHome.driver.switchToDefaultWindow();
	}
}
