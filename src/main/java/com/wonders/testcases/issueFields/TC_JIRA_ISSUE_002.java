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
import com.wonders.utils.Assertion;
import com.wonders.utils.BaseHome;
@Test(groups={"project", "easy"})
public class TC_JIRA_ISSUE_002 {
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
	 * TODO:	关闭新建issue的窗口
	 * @author:	bluce
	 * @serialData:	2013-03-28
	 * @point:	
	 * @memo:	
	 */
	@Parameters({"adminUser", "adminPW"})
	@Test(description = "关闭新建issue的窗口")
	public void JIRA_ISSUE_002(String adminUser, String adminPW){		
		//login
		LoginPageService.login(adminUser, adminPW);	
		BaseHome.driver.switchToWindow(MainPageService.assertMainPage());
		//open create issue fields 
		MainPageService.showCreateIssuePage();
		//check close issue fields successfully
		Assertion.AssertFalse(CreateIssueFieldsService.checkCloseIssueFieldsSuccessFully());
		//log out
		MainPageService.logout();
		BaseHome.driver.switchToDefaultWindow();
	}
}
