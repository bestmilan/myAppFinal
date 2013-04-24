package com.wonders.testcases.issueFields;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wonders.configuration.Config;
import com.wonders.service.base.LoginPageService;
import com.wonders.service.base.MainPageService;
import com.wonders.service.issueFields.CreateIssueFieldsService;
import com.wonders.service.issueFields.SearchIssueService;
import com.wonders.utils.Assertion;
import com.wonders.utils.BaseHome;
@Test(groups={"project", "normal", "add"})
public class TC_JIRA_ISSUE_001 {
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
	 * TODO:	新建一个问题issue
	 * @author:	bluce
	 * @serialData:	2013-03-21
	 * @point:	frame, span, div, addAttribute, file, date, js, table
	 * @memo:	
	 */
	@Parameters({"adminUser", "adminPW"})
	@Test(description = "新建一个问题issue")
	public void JIRA_ISSUE_001(String adminUser, String adminPW){		
		//login
		LoginPageService.login(adminUser, adminPW);	
		BaseHome.driver.switchToWindow(MainPageService.assertMainPage());
		//open create issue fields 
		MainPageService.showCreateIssuePage();
		String issueSummary = CreateIssueFieldsService.setIssueData();
		Assertion.AssertTrue(MainPageService.checkIssueCreate(issueSummary), "校验问题新增提示");
		//check create issue successfully
		MainPageService.quickSearch(issueSummary);
		BaseHome.driver.switchToDefaultWindow();
		Assertion.AssertTrue(SearchIssueService.checkSummary(issueSummary), "判断summary是否正确");
		//log out
		MainPageService.logout();
		BaseHome.driver.switchToDefaultWindow();
	}
}
