package com.wonders.testcases.issueFields;
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
import com.wonders.service.issue.CreateIssueFieldsService;
import com.wonders.service.issue.SearchIssueService;

@Test(groups={"project", "normal", "add"})
public class TC_JIRA_ISSUE_001 {
	private BaseHome home;
	private LoginPageService loginPageService;
	private MainPageService mainPageService;
	private CreateIssueFieldsService createIssueFieldsService;
	private SearchIssueService searchIssueService;
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("Chrome")String browser) {
		home = new BaseHome();
		home.Launch(browser, Config.getLaunchUrl());	
		loginPageService = new LoginPageService(home.driver);
		mainPageService = new MainPageService(home.driver);
		createIssueFieldsService = new CreateIssueFieldsService(home.driver);
		searchIssueService = new SearchIssueService(home.driver);
	}
	
	@AfterMethod()
	public void cleanup() {
		home.Quit();
	}
	/**
	 * TODO:	新建一个问题issue
	 * @author:	bluce
	 * @serialData:	2013-04-30 20:59:34.237
	 * @point:	frame, span, div, addAttribute, file, date, js, table
	 * @memo:	
	 */
	@Test(description = "新建一个问题issue")
	public void JIRA_ISSUE_001(){		
		//login
		loginPageService.login();
		home.driver.switchToWindow(mainPageService.assertMainPage());
		//open create issue fields 
		mainPageService.showCreateIssuePage();
		String issueSummary = createIssueFieldsService.setIssueData();
		Assertion.AssertTrue(mainPageService.checkIssueCreate(issueSummary), "校验问题新增提示");
		//check create issue successfully
		mainPageService.quickSearch(issueSummary);
		home.driver.switchToDefaultWindow();
		Assertion.AssertTrue(searchIssueService.checkSummary(issueSummary), "判断summary是否正确");
		//log out
		mainPageService.logout();
		home.driver.switchToDefaultWindow();
	}
}
