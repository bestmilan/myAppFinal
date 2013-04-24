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
import com.wonders.service.issueFields.WikiHelpPageService;
import com.wonders.utils.Assertion;
import com.wonders.utils.BaseHome;
@Test(groups = {"project", "easy" })
public class TC_JIRA_ISSUE_003 {
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
	 * TODO: 验证新建issue的窗口中的帮助（wiki markup help）功能可以正常显示
	 * 
	 * @author: bluce
	 * @serialData: 2013-03-28
	 * @point: open windows, close windows,  
	 * @memo:
	 */
	@Parameters({"adminUser", "adminPW"})
	@Test(description = "验证新建issue的窗口中的帮助功能可以正常显示（wiki markup help）")
	public void JIRA_ISSUE_003(String adminUser, String adminPW) {
		// login
		LoginPageService.login(adminUser, adminPW);
		BaseHome.driver.switchToWindow(MainPageService.assertMainPage());
		// open create issue fields
		MainPageService.showCreateIssuePage();
		// open wiki help windows
		CreateIssueFieldsService.showWikiHelp();
		BaseHome.driver.switchToWindow("Text Formatting Notation Help - Your Company JIRA");
		Assertion.AssertTrue(WikiHelpPageService.checkLeftNavContent());
		BaseHome.driver.close();
		BaseHome.driver.switchToWindow("Create Issue - Your Company JIRA");
		CreateIssueFieldsService.closeIssueFields();
		// log out
		MainPageService.logout();
		BaseHome.driver.switchToDefaultWindow();
	}
}
