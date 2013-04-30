package com.wonders.testcases.issueFields;
import com.wonders.configuration.Config;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wonders.core.Assertion;
import com.wonders.core.BaseHome;
import com.wonders.service.base.LoginPageService;
import com.wonders.service.base.MainPageService;
import com.wonders.service.issue.CreateIssueFieldsService;

@Test(groups={"project", "easy"})
public class TC_JIRA_ISSUE_002 {
	private BaseHome home;
	private LoginPageService loginPageService;
	private CreateIssueFieldsService createIssueFieldsService;
	private MainPageService mainPageService;
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("Chrome")String browser) {
		home = new BaseHome();
		home.Launch(browser, Config.getLaunchUrl());	
		loginPageService = new LoginPageService(home.driver);
		createIssueFieldsService = new CreateIssueFieldsService(home.driver);
		mainPageService = new MainPageService(home.driver);
	}
	
	@AfterMethod()
	public void cleanup() {
		home.Quit();
	}
	/**
	 * TODO:	关闭新建issue的窗口
	 * @author:	bluce
	 * @serialData:	2013-04-30 21:13:19.215
	 * @point:	
	 * @memo:	
	 */
	@Test(description = "关闭新建issue的窗口")
	public void JIRA_ISSUE_002(){		
		//login
		loginPageService.login();
		home.driver.switchToWindow(mainPageService.assertMainPage());
		//open create issue fields 
		mainPageService.showCreateIssuePage();
		//check close issue fields successfully
		Assertion.AssertFalse(createIssueFieldsService.checkCloseIssueFieldsSuccessFully());
		//log out
		mainPageService.logout();
		home.driver.switchToDefaultWindow();
	}
}
