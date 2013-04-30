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
import com.wonders.service.issue.LocalHelpPageService;

@Test(groups = {"project", "easy" })
public class TC_JIRA_ISSUE_004 {
	private BaseHome home;
	private LoginPageService loginPageService;
	private CreateIssueFieldsService createIssueFieldsService;
	private MainPageService mainPageService;
	private LocalHelpPageService localHelpPageService;
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("Chrome")String browser) {
		home = new BaseHome();
		home.Launch(browser, Config.getLaunchUrl());	
		loginPageService = new LoginPageService(home.driver);
		createIssueFieldsService = new CreateIssueFieldsService(home.driver);
		mainPageService = new MainPageService(home.driver);
		localHelpPageService = new LocalHelpPageService(home.driver);
	}
	
	@AfterMethod()
	public void cleanup() {
		home.Quit();
	}
	/**
	 * TODO:	验证新建issue的窗口中的帮助（local help）功能可以正常显示
	 * @author:	bluce
	 * @serialData:	2013-04-30 21:20:58.818
	 * @point:	open windows, close windows, img, @Optional
	 * @memo:	
	 */
	@Test(description = "验证新建issue的窗口中的帮助（local help）功能可以正常显示")
	public void JIRA_ISSUE_004(){		
		//login
		loginPageService.login();
		home.driver.switchToWindow(mainPageService.assertMainPage());
		// open create issue fields
		mainPageService.showCreateIssuePage();
		// open wiki help windows
		createIssueFieldsService.showLocalHelp();
		home.driver.switchToWindow("JIRA - Time Tracking - Your Company JIRA");
		Assertion.AssertTrue(localHelpPageService.checkLocalHelpContent());
		home.driver.close();
		home.driver.switchToWindow("Create Issue - Your Company JIRA");
		createIssueFieldsService.closeIssueFields();
		// log out
		mainPageService.logout();
		home.driver.switchToDefaultWindow();
	}
}
